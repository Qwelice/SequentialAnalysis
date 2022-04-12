package gui.frames.bases

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField

abstract class BaseEnterFrame(width: Int, height: Int) : BaseFrame(width, height) {
    protected val nLabel = JLabel("N")
    protected val aLabel = JLabel("a")
    protected val bLabel = JLabel("b")
    protected val rLabel = JLabel("r")
    protected val tLabel = JLabel("T")
    protected val s0Label = JLabel("S0")
    protected val b0Label = JLabel("B0")
    protected val nText = JTextField()
    protected val aText = JTextField()
    protected val bText = JTextField()
    protected val rText = JTextField()
    protected val tText = JTextField()
    protected val s0Text = JTextField()
    protected val b0Text = JTextField()
    protected val enterButton = JButton("Ввод")
    protected val clearButton = JButton("Очистить")
}