package gui.managers.listeners

import java.util.*

interface InitAnalysisListener : BaseListener {
    fun init(data: Vector<String>)
}