package com.example.tesschatapp.View.view

import android.app.Application
import android.widget.Toast

import com.google.firebase.auth.AuthResult

import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnCompleteListener

import com.google.firebase.auth.FirebaseAuth

import androidx.lifecycle.MutableLiveData

import com.google.firebase.auth.FirebaseUser




class AuthenticationRepository {
    private var application: Application? = null
    private var firebaseUserMutableLiveData: MutableLiveData<FirebaseUser?>? = null
    private var userLoggedMutableLiveData: MutableLiveData<Boolean?>? = null
    private var auth: FirebaseAuth? = null

    fun getFirebaseUserMutableLiveData(): MutableLiveData<FirebaseUser?>? {
        return firebaseUserMutableLiveData
    }

    fun getUserLoggedMutableLiveData(): MutableLiveData<Boolean?>? {
        return userLoggedMutableLiveData
    }

    fun AuthenticationRepository(application: Application?) {
        this.application = application
        firebaseUserMutableLiveData = MutableLiveData()
        userLoggedMutableLiveData = MutableLiveData()
        auth = FirebaseAuth.getInstance()
        if (auth!!.currentUser != null) {
            firebaseUserMutableLiveData!!.postValue(auth!!.currentUser)
        }
    }

    fun register(email: String?, pass: String?) {
        auth!!.createUserWithEmailAndPassword(email!!, pass!!).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                firebaseUserMutableLiveData!!.postValue(auth!!.currentUser)
            } else {
                Toast.makeText(application,"" , Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun login(email: String?, pass: String?) {
        auth!!.signInWithEmailAndPassword(email!!, pass!!).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                firebaseUserMutableLiveData!!.postValue(auth!!.currentUser)
            } else {
                Toast.makeText(application, "", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun signOut() {
        auth!!.signOut()
        userLoggedMutableLiveData!!.postValue(true)
    }


}