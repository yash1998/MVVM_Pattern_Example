package com.example.mvvm_pattern_example.model

class LoginDataModel {
    fun validateLoginDetails(username: String? = "", password: String? = ""): Boolean {
        return when {
            username.isNullOrEmpty() || password.isNullOrEmpty() -> false
            username.any { !it.isLetterOrDigit() } -> false
            username.length < 5 -> return false
            password.length < 5 -> return false
            else -> true
        }
    }
}