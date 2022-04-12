package gui.managers

import calculation.SequentialAnalysis
import calculation.args.InitArgs
import gui.frames.SaFrame
import gui.managers.listeners.*
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent

class SaFrameManager {
    private val frame = SaFrame(300, 250)
    private var sa: SequentialAnalysis? = null
    private val listeners = ArrayList<BaseListener>()

    init {
        handleEvents()
    }

    fun initSequentialAnalysis(args: InitArgs){
        sa = SequentialAnalysis(args)
        updateFrameView()
    }

    private fun updateFrameView(){
        if(sa != null){
            val n = sa!!.S.keys.count() - 1
            if(n >= sa!!.args.N){
                frame.increaseButton.isEnabled = false
                frame.reduceButton.isEnabled = false
                frame.nValue.text = n.toString()
                frame.totalNValue.text = sa!!.args.N.toString()
                frame.sLabel.text = "S$n"
                frame.bLabel.text = "B$n"
                frame.sValue.text = (sa!!.S[n]!!.value).toString()
                frame.bValue.text = (sa!!.getB(n)).toString()
                frame.gammaLabel.text = "Gamma ${n + 1}"
                frame.betaLabel.text = "Beta ${n + 1}"
                frame.gammaValue.text = "???"
                frame.betaValue.text = "???"
            }else{
                frame.increaseButton.isEnabled = true
                frame.reduceButton.isEnabled = true
                frame.nValue.text = n.toString()
                frame.totalNValue.text = sa!!.args.N.toString()
                frame.sLabel.text = "S$n"
                frame.bLabel.text = "B$n"
                frame.sValue.text = (sa!!.S[n]!!.value).toString()
                frame.bValue.text = (sa!!.getB(n)).toString()
                frame.gammaLabel.text = "Gamma ${n + 1}"
                frame.betaLabel.text = "Beta ${n + 1}"
                frame.gammaValue.text = sa!!.gammaN(n + 1).toString()
                frame.betaValue.text = sa!!.betaN(n + 1).toString()
            }
            frame.repaint()
        }
    }

    fun setFrameVisible(isVisible: Boolean){
        frame.isVisible = isVisible
    }

    private fun handleEvents(){
        frame.increaseButton.addActionListener {
            increaseEvent()
        }

        frame.reduceButton.addActionListener {
            reduceEvent()
        }

        frame.historyButton.addActionListener {
            historyEvent()
        }

        frame.endButton.addActionListener {
            endEvent()
        }

        frame.addComponentListener(object : ComponentAdapter(){
            override fun componentHidden(e: ComponentEvent?) {
                super.componentHidden(e)
                hideEvent()
            }
        })
    }

    fun addListener(l: BaseListener){
        listeners.add(l)
    }

    private fun increaseEvent(){
        listeners.forEach { l ->
            if (l is IncreaseListener){
                l.increase()
            }
        }
        if(sa != null){
            val n = sa!!.S.keys.count() - 1
            sa!!.addS(n + 1, true)
            updateFrameView()
        }
    }

    private fun reduceEvent(){
        listeners.forEach { l ->
            if (l is ReduceListener){
                l.reduce()
            }
        }
        if(sa != null){
            val n = sa!!.S.keys.count() - 1
            sa!!.addS(n + 1, false)
            updateFrameView()
        }
    }

    private fun historyEvent(){
        listeners.forEach { l ->
            if (l is HistoryListener){
                l.openHistory()
            }
        }
    }

    private fun endEvent(){
        listeners.forEach { l ->
            if (l is EndListener){
                l.finish()
            }
        }
    }

    private fun hideEvent(){
        listeners.forEach { l ->
            if (l is SaHideListener){
                l.hide()
            }
        }
    }
}