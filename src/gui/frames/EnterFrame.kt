package gui

import java.awt.Dimension
import javax.swing.GroupLayout
import javax.swing.JFrame

class EnterFrame(width: Int, height: Int) : JFrame() {

    init {
        val minFrameSize = Dimension(width, height)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
        minimumSize = minFrameSize
        title = "Ввод данных"
    }

    private fun setupComponents(){
        val gl = GroupLayout(contentPane)

        

        layout = gl
    }
}