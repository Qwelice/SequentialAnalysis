package gui.managers

import gui.managers.listeners.*
import java.util.*

class MainManager {
    private val enterManager = EnterFrameManager()
    private val saManager = SaFrameManager()
    private val historyManager = HistoryFrameManager()

    init {
        handleEvents()
    }

    private fun handleEvents(){
        enterManager.addListener(object : EnterListener{
            override fun enter(isEmpty: Boolean) {
                if(!isEmpty){
                    val args = enterManager.getInitArgs()
                    if(args != null){
                        enterManager.setFrameVisible(false)
                        saManager.setFrameVisible(true)
                        saManager.initSequentialAnalysis(args)
                    }
                }
            }
        })

        saManager.addListener(object : SaHideListener{
            override fun hide() {
                enterManager.setFrameVisible(true)
                historyManager.clearHistory()
            }
        })

        saManager.addListener(object : EndListener{
            override fun finish() {
                saManager.setFrameVisible(false)
                enterManager.setFrameVisible(true)
            }
        })

        saManager.addListener(object : IncreaseListener{
            override fun increase() {
            }
        })

        saManager.addListener(object : ReduceListener{
            override fun reduce() {
            }
        })

        saManager.addListener(object : HistoryListener{
            override fun openHistory() {
                historyManager.setFrameVisible(true)
            }
        })

        historyManager.addListener(object : HistoryHideListener{
            override fun hide() {

            }
        })

        saManager.addListener(object : UpdateHistoryListener{
            override fun appendData(data: Vector<String>) {
                historyManager.appendData(data)
            }
        })

        saManager.addListener(object : InitAnalysisListener{
            override fun init(data: Vector<String>) {
                if(data.isNotEmpty()){
                    historyManager.appendData(data)
                }
            }
        })
    }
}