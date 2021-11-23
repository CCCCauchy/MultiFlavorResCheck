package com.github.ccccauchy.multiflavorrescheck.services

import com.intellij.openapi.ui.DialogWrapper
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel

class SampleDialogWrapper(val content: String) : DialogWrapper(true) {

    init {
        title = "Test DialogWrapper"
        init()
    }

    override fun createCenterPanel(): JComponent {
        val dialogPanel = JPanel(BorderLayout())
        val label = JLabel(content)
        label.preferredSize = Dimension(100, 100)
        dialogPanel.add(label, BorderLayout.CENTER)

        return dialogPanel
    }
}