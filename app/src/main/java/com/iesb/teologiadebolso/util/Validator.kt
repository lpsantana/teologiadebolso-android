package com.iesb.teologiadebolso.util

import android.util.Patterns

class Validator {

    companion object {
        private val MIN_PASSWORD = 6

        fun validateValues(email: String, password: String): Boolean {
            var isValid = true
            if (!Validator.validateEmail(email) || !Validator.validatePassword(password)){
                isValid = false
            }
            return isValid
        }

        fun validatePassword(password: String): Boolean {
            return password.length >= MIN_PASSWORD
        }

        fun validateEmail(email: String):Boolean {
            return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.toRegex().matches(email)
        }
    }
}