package gui.frames.bases

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField

abstract class BaseEnterFrame(width: Int, height: Int) : BaseFrame(width, height) {
    val nLabel = JLabel("N")
    val aLabel = JLabel("a")
    val bLabel = JLabel("b")
    val rLabel = JLabel("r")
    val tLabel = JLabel("T")
    val s0Label = JLabel("S0")
    val b0Label = JLabel("B0")
    val nText = JTextField()
    val aText = JTextField()
    val bText = JTextField()
    val rText = JTextField()
    val tText = JTextField()
    val s0Text = JTextField()
    val b0Text = JTextField()
    val enterButton = JButton("Ввод")
    val clearButton = JButton("Очистить")
}