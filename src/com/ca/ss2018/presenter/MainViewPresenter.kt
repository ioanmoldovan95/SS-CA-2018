package com.ca.ss2018.presenter

import com.ca.ss2018.contract.MainContract
import com.ca.ss2018.model.Participant
import com.ca.ss2018.util.FileUtil
import com.ca.ss2018.util.MatchUtil
import java.io.File
import java.util.*
import javax.swing.JFileChooser
import javax.swing.JFileChooser.APPROVE_OPTION
import javax.swing.JFrame

class MainViewPresenter : MainContract.IMainPresenter {

    var view: MainContract.IMainView? = null
    private val fileUtil = FileUtil()
    private val matchUtil = MatchUtil()
    private var file: File? = null
    var participantsList: MutableList<Participant>? = null

    override fun onDettach() {
        view = null
    }

    override fun onAttach(view: MainContract.IMainView) {
        this.view = view
    }

    override fun process() {
        participantsList = if (file != null) fileUtil.getParticipantsList(file!!) else Collections.emptyList()
        if (participantsList!!.isNotEmpty()) {
            val matchedMap = matchUtil.match(participantsList!!)
            view?.updateMatchedParticipants(matchedMap)
        }
    }

    override fun openSelectFileDialog() {
        val fileChooser = JFileChooser()
        val returnVal = fileChooser.showDialog(view as JFrame, "OK")
        if (returnVal == APPROVE_OPTION) {
            val file = fileChooser.selectedFile
            this.file = file
            view?.updateTextField(file.absolutePath)
        }
    }
}