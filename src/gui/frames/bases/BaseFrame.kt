package gui.frames.bases

import java.awt.Dimension
import javax.swing.JFrame

abstract class BaseFrame(width: Int, height: Int) : JFrame() {

    init {
        val minFrameSize = Dimension(width, height)
        minimumSize = minFrameSize
    }

    protected abstract fun setupComponents()
}