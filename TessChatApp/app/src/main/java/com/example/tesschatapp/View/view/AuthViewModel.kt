package com.example.tesschatapp.View.view

import androidx.lifecycle.AndroidViewModel
import android.app.Application

import androidx.annotation.NonNull

import androidx.lifecycle.MutableLiveData

import com.google.firebase.auth.FirebaseUser




class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: AuthenticationRepository? = null
    private var userData: MutableLiveData<FirebaseUser?>? = null
    private var loggedStatus: MutableLiveData<Boolean?>? = null

    fun getUserData(): MutableLiveData<FirebaseUser?>? {
        return userData
    }

    fun getLoggedStatus(): MutableLiveData<Boolean?>? {
        return loggedStatus
    }

    fun AuthViewModel(application: Application) {
        userData = repository!!.getFirebaseUserMutableLiveData()
        loggedStatus = repository!!.getUserLoggedMutableLiveData()
    }

    fun register(email: String?, pass: String?) {
        repository!!.register(email, pass)
    }

    fun signIn(email: String?, pass: String?) {
        repository!!.login(email, pass)
    }

    fun signOut() {
        repository!!.signOut()
    }
}