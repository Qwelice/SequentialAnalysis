package gui.managers.listeners

import java.util.*

interface UpdateHistoryListener : BaseListener {
    fun appendData(data: Vector<String>)
}