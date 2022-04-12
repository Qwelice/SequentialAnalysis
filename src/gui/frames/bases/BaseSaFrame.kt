package gui.frames.bases

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel

abstract class BaseSaFrame(width: Int, height: Int) : BaseFrame(width, height) {
    val totalNLabel = JLabel("N")
    val nLabel = JLabel("n")
    val sLabel = JLabel("S0")
    val bLabel = JLabel("B0")
    val gammaLabel = JLabel("Gamma 1")
    val betaLabel = JLabel("Beta 1")
    val totalNValue = JLabel()
    val sValue = JLabel()
    val nValue = JLabel()
    val bValue = JLabel()
    val gammaValue = JLabel()
    val betaValue = JLabel()
    val increaseButton = JButton("Повышение")
    val reduceButton = JButton("Понижение")
    val historyButton = JButton("История")
    val endButton = JButton("Завершить")
}