package com.ca.ss2018.contract

interface MainContract {

    interface IMainPresenter {
        fun onAttach(view: IMainView)

        fun onDettach()

        fun openSelectFileDialog()

        fun process()
    }

    interface IMainView {
        fun updateTextField(s:String)

        fun updateMatchedParticipants(list : Map<Int,Int>)
    }
}