package com.example.mvp_pattern_example.model

import com.example.mvvm_pattern_example.model.LoginDataModel
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class LoginDataModelMockitoTest {

    lateinit var model: LoginDataModel

    @Before
    fun setUp() {
        model = LoginDataModel()
    }

    @Test
    fun testValidateLoginDetails_returnsFalse() {
        val result = model.validateLoginDetails("", "")
        assertFalse(result)
    }

    @Test
    fun testValidateLoginDetails_returnsTrue() {
        val result = model.validateLoginDetails("abcde", "12345")
        assertTrue(result)
    }


}