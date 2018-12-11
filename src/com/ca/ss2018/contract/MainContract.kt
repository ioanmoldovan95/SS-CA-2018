package com.ca.ss2018.contract

interface MainContract {

    interface IMainPresenter {

    }

    interface IMainView {
        fun onAttach(presenter: IMainPresenter)

        fun onDettach()
    }
}