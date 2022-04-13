package gui.frames.bases

import java.util.*
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

abstract class BaseHistoryFrame(width: Int, height: Int) : BaseFrame(width, height) {

    protected val table: JTable
    protected val model: DefaultTableModel

    init{
        title = "История"
        defaultCloseOperation = HIDE_ON_CLOSE
        val header = Vector(listOf("N", "n", "S", "B", "Gamma", "Beta", "Cn"))
        model = DefaultTableModel()
        model.setColumnIdentifiers(header)
        table = JTable(model)
    }

    fun clearTable(){
        model.dataVector.clear()
    }
}