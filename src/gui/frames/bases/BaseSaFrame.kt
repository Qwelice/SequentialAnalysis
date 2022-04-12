package gui.frames.bases

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel

abstract class BaseSaFrame(width: Int, height: Int) : BaseFrame(width, height) {
    protected val totalNLabel = JLabel("N")
    protected val nLabel = JLabel("n")
    protected val sLabel = JLabel("S0")
    protected val bLabel = JLabel("B0")
    protected val gammaLabel = JLabel("Gamma 1")
    protected val betaLabel = JLabel("Beta 1")
    protected val totalNValue = JLabel()
    protected val sValue = JLabel()
    protected val nValue = JLabel()
    protected val bValue = JLabel()
    protected val gammaValue = JLabel()
    protected val betaValue = JLabel()
    protected val increaseButton = JButton("Повышение")
    protected val reduceButton = JButton("Понижение")
    protected val historyButton = JButton("История")
    protected val endButton = JButton("Завершить")
}