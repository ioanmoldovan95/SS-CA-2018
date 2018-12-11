package com.ca.ss2018.view

import com.ca.ss2018.contract.MainContract
import java.awt.Container
import java.awt.Dimension
import javax.swing.*

class MainView : JFrame(), MainContract.IMainView {

    private var presenter: MainContract.IMainPresenter? = null
    private lateinit var container: Container
    private val layout = SpringLayout()
    private val selectFileButton = JButton("Select xls file")
    private val startButton = JButton("START")
    private val filePathTextField = JTextField()

    init {
        createUI()
    }

    private fun createUI() {
        this.title = "Secret Santa CA 2018"
        this.size = Dimension(500, 300)
        this.setLocationRelativeTo(null)
        this.container = this.contentPane
        container.layout = layout
        setComponents()
        placeComponents()
        this.pack()
    }

    private fun setComponents() {
        selectFileButton.size = Dimension(50, 20)
        startButton.size = Dimension(40, 20)
        filePathTextField.size = Dimension(100, 20)
    }

    private fun placeComponents() {
        container.add(selectFileButton)
        container.add(startButton)
        val constraints = layout.getConstraints(startButton)
        constraints.x = Spring.constant(450)
        constraints.y = Spring.constant(250)
        container.add(filePathTextField)
    }

    override fun onDettach() {
        presenter = null
    }

    override fun onAttach(presenter: MainContract.IMainPresenter) {
        this.presenter = presenter
    }


}