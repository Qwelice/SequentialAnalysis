package gui.managers

import gui.frames.HistoryFrame
import gui.managers.listeners.BaseListener
import gui.managers.listeners.HistoryHideListener
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import java.util.*
import kotlin.collections.ArrayList

class HistoryFrameManager {
    private val frame = HistoryFrame(500, 250)

    private val listeners = ArrayList<BaseListener>()

    init{
        handleEvents()
    }

    fun setFrameVisible(isVisible: Boolean){
        frame.isVisible = isVisible
    }

    fun appendData(data: Vector<String>){
        frame.appendData(data)
    }

    fun addListener(l: BaseListener){
        listeners.add(l)
    }

    fun clearHistory(){
        frame.clearTable()
    }

    private fun handleEvents(){
        frame.addComponentListener(object : ComponentAdapter(){
            override fun componentHidden(e: ComponentEvent?) {
                super.componentHidden(e)
                listeners.forEach { l ->
                    if(l is HistoryHideListener){
                        l.hide()
                    }
                }
            }
        })
    }
}