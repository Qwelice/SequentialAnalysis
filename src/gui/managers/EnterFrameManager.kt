package gui.managers

import calculation.args.InitArgs
import gui.frames.EnterFrame
import gui.managers.listeners.BaseListener
import gui.managers.listeners.EnterListener
import java.lang.Exception

class EnterFrameManager {
    private val frame: EnterFrame = EnterFrame(500, 250)

    private val listeners = ArrayList<BaseListener>()

    private fun isEmptyStrings() : Boolean{
        return frame.nText.text.trim().isEmpty() &&
                frame.aText.text.trim().isEmpty() &&
                frame.bText.text.trim().isEmpty() &&
                frame.tText.text.trim().isEmpty() &&
                frame.rText.text.trim().isEmpty() &&
                frame.bText.text.trim().isEmpty() &&
                frame.s0Text.text.trim().isEmpty()
    }

    init {
        val empty = ""
        frame.aText.text = empty
        frame.bText.text = empty
        frame.nText.text = empty
        frame.tText.text = empty
        frame.rText.text = empty
        frame.b0Text.text = empty
        frame.s0Text.text = empty

        handleEvents()
    }

    fun setFrameVisible(isVisible: Boolean){
        frame.isVisible = isVisible
    }

    fun addListener(l: BaseListener){
        listeners.add(l)
    }

    fun getInitArgs() : InitArgs?{
        var args: InitArgs? = null

        try{
            val N = frame.nText.text.trim().toInt()
            val a = frame.aText.text.trim().toDouble()
            val b = frame.bText.text.trim().toDouble()
            val T = frame.tText.text.trim().toDouble()
            val r = frame.rText.text.trim().toDouble()
            val b0 = frame.b0Text.text.trim().toDouble()
            val s0 = frame.s0Text.text.trim().toDouble()
            args = InitArgs(N, a, b, r, T, s0, b0)
        }catch (e: Exception){
            println(e.message)
        }
        return args
    }

    private fun handleEvents(){
        frame.enterButton.addActionListener {
            enterEvent()
        }

        frame.clearButton.addActionListener {
            clearEvent()
        }
    }

    private fun enterEvent(){
        listeners.forEach { l ->
            if (l is EnterListener){
                l.enter(isEmptyStrings())
            }
        }
    }

    private fun clearEvent(){
        val empty = ""
        frame.aText.text = empty
        frame.bText.text = empty
        frame.nText.text = empty
        frame.tText.text = empty
        frame.rText.text = empty
        frame.b0Text.text = empty
        frame.s0Text.text = empty
    }
}