package com.example.mvvm_pattern_example.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LoginDataModelTest {

    lateinit var loginModel: LoginDataModel

    @Before
    fun setUp() {
        loginModel = LoginDataModel()
    }

    @Test
    fun `test empty username and password returns false`() {
        val result = loginModel.validateLoginDetails("", "")
        Assert.assertFalse(result)
    }

    @Test
    fun `test special chars in username returns false`() {
        val result = loginModel.validateLoginDetails("abcd@", "12345")
        Assert.assertFalse(result)
    }

    @Test
    fun `test small username length returns false`() {
        val result = loginModel.validateLoginDetails("abcd", "12345")
        Assert.assertFalse(result)
    }

    @Test
    fun `test small password length returns false`() {
        val result = loginModel.validateLoginDetails("abcde", "123")
        Assert.assertFalse(result)
    }

    @Test
    fun `test correct username password returns true`() {
        val result = loginModel.validateLoginDetails("abcde", "12345")
        Assert.assertTrue(result)
    }
}