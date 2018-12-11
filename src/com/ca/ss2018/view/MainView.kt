package com.ca.ss2018.view

import com.ca.ss2018.contract.MainContract
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField

class MainView : JFrame(), MainContract.IMainView {

    private var presenter: MainContract.IMainPresenter? = null
    private var panel = JPanel()
    private val selectFileButton = JButton("Select xls file")
    private val startButton = JButton("START")
    private val JTextField = JTextField()

    init {
        createUI()
    }

    private fun createUI() {
        this.title = "Secret Santa CA 2018"
        this.size = Dimension(300, 200)
        this.setLocationRelativeTo(null)
        panel.layout = null
        setComponents()
        placeComponents()
    }

    private fun setComponents() {
        selectFileButton.size = Dimension(50, 20)
    }

    private fun placeComponents(){
        selectFileButton.location = Point(5,5)
        panel.add(selectFileButton)
    }

    override fun onDettach() {
        presenter =null
    }

    override fun onAttach(presenter: MainContract.IMainPresenter) {
        this.presenter = presenter
    }


}