package com.ca.ss2018.view

import com.ca.ss2018.contract.MainContract
import com.ca.ss2018.presenter.MainViewPresenter
import java.awt.*
import java.awt.GridBagConstraints.*
import java.awt.event.ActionListener
import javax.swing.*

class MainView : JFrame(), MainContract.IMainView {

    private var presenter = MainViewPresenter()
    private val layout = GridBagLayout()
    private val panel = JPanel(layout)
    private val selectFileButton = JButton("Select xls file")
    private val startButton = JButton("START")
    private val filePathTextField = JTextField()

    init {
        presenter.onAttach(this)
        createUI()
    }

    private fun createUI() {
        this.title = "Secret Santa CA 2018"
        this.minimumSize = Dimension(500, 200)
        this.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        this.setLocationRelativeTo(null)
        this.add(panel)
        setComponents()
        placeComponents()
        this.pack()
    }

    private fun setComponents() {
        selectFileButton.size = Dimension(50, 20)
        selectFileButton.addActionListener {
            presenter.openSelectFileDialog()

        }
        startButton.size = Dimension(40, 20)
        startButton.addActionListener {
            presenter.process()

        }
        filePathTextField.size = Dimension(400, 20)
    }

    private fun placeComponents() {
        val border = BorderFactory.createRaisedBevelBorder()
        val constraints = GridBagConstraints()
        constraints.weightx = 0.5
        constraints.weighty = 0.5
        constraints.ipadx = 20
        constraints.ipady = 10
        constraints.anchor = CENTER
        constraints.insets = Insets(20,10,20,10)
        layout.setConstraints(selectFileButton, constraints)
        selectFileButton.border = border
        this.panel.add(selectFileButton)

        constraints.gridx = 0
        constraints.gridy = 1
        layout.setConstraints(startButton, constraints)
        startButton.border = border
        this.panel.add(startButton)

        constraints.gridy = 0
        constraints.gridx = 1
        constraints.gridwidth = 4
        constraints.weightx = 1.0
        constraints.fill = BOTH
        layout.setConstraints(filePathTextField, constraints)
        filePathTextField.border = border
        this.panel.add(filePathTextField)
    }

    override fun updateTextField(s: String) {
        filePathTextField.text = s
    }

    override fun updateMatchedParticipants(list: Map<Int, Int>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}