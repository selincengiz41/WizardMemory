package com.selincengiz.wizardmemory.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.navigation.Navigation
import com.selincengiz.wizardmemory.model.User
import com.selincengiz.wizardmemory.roomDb.UserDatabase
import com.selincengiz.wizardmemory.view.LoginFragmentDirections
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : BaseViewModel(application) {
private var isLogined:Boolean =false
    fun loginControl(email: String, password: String):Boolean {
        launch {
            val dao = UserDatabase(getApplication()).userDao()
            dao.LoginUser(email, password).apply {
                if (this != null) {
                    Toast.makeText(getApplication(), "Succesfully logined", Toast.LENGTH_LONG)
                        .show()
                    isLogined=true



                } else {
                    isLogined=false
                    Toast.makeText(getApplication(), "Failed to login", Toast.LENGTH_LONG).show()

                }
            }

        }
return isLogined

    }


}