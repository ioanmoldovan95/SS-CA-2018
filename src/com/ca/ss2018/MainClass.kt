package com.ca.ss2018

import com.ca.ss2018.view.MainView
import java.awt.EventQueue

fun main(args: Array<String>) {
    EventQueue.invokeLater(::startApp)
}

private fun startApp() {
    val mainView = MainView()
    mainView.isVisible = true
}