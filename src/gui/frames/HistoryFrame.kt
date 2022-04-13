package gui.frames

import gui.frames.bases.BaseHistoryFrame
import java.util.*
import javax.swing.GroupLayout
import javax.swing.JScrollPane

class HistoryFrame(width: Int, height: Int) : BaseHistoryFrame(width, height) {

    private val pane: JScrollPane = JScrollPane(table)

    init {
        setupComponents()
    }

    fun appendData(data: Vector<String>){
        val index = table.rowCount
        model.insertRow(index, data)
        repaint()
    }

    override fun setupComponents() {
        val gl = GroupLayout(contentPane)

        gl.setHorizontalGroup(gl.createSequentialGroup()
            .addGap(5)
            .addComponent(pane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
            .addGap(5)
        )

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGap(5)
            .addComponent(pane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
            .addGap(5)
        )

        layout = gl
        pack()
    }
}