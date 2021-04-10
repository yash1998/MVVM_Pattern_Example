package com.example.mvvm_pattern_example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_pattern_example.model.LoginDataModel

class LoginViewModel : ViewModel() {

    var loginStatus = MutableLiveData<Boolean>()
    var model = LoginDataModel()

    fun startLogin(username: String?, password: String?) {
        loginStatus.postValue(model.validateLoginDetails(username, password))
    }
}