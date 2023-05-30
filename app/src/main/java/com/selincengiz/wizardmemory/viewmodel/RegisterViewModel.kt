package com.selincengiz.wizardmemory.viewmodel

import android.app.Application
import android.widget.Toast
import com.selincengiz.wizardmemory.model.User
import com.selincengiz.wizardmemory.roomDb.UserDatabase

import kotlinx.coroutines.launch


class RegisterViewModel(application: Application) : BaseViewModel(application) {


    fun insertUserToRoom(user: User) {
        launch {
            val dao = UserDatabase(getApplication()).userDao()
            dao.insertUser(user)
        }.invokeOnCompletion {
            Toast.makeText(getApplication(), "Succesfully registered", Toast.LENGTH_LONG).show()
        }
    }

    fun controlForRegister(name: String, email: String, password: String, controlPassword: String):User? {
        if (!name.isNullOrEmpty()) {

            if (!email.isNullOrEmpty()) {

                if (email.contains("@gmail.com")) {

                    if (!password.isNullOrEmpty()) {

                        if (!controlPassword.isNullOrEmpty()) {


                            if (password
                                    .equals(controlPassword)
                            ) {

                                val user = User(
                                    name,
                                    email,
                                    password
                                )


                                insertUserToRoom(user)
                                return user

                            } else {
                                Toast.makeText(
                                    getApplication(),
                                    "Password fields is not maching",
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                        } else {
                            Toast.makeText(
                                getApplication(),
                                "Fill the password control field",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            getApplication(),
                            "Fill the password field",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                } else {
                    Toast.makeText(getApplication(), "Enter a proper email", Toast.LENGTH_SHORT)
                        .show()

                }
            } else {
                Toast.makeText(getApplication(), "Fill the email space", Toast.LENGTH_SHORT).show()

            }
        } else {
            Toast.makeText(getApplication(), "Fill the name space", Toast.LENGTH_SHORT).show()
        }

return null
    }
}