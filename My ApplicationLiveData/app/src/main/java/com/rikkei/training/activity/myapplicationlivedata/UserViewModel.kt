package com.rikkei.training.activity.myapplicationlivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class UserViewModel(): ViewModel() {


     val liveData = MutableLiveData<User>()
    init {
        liveData.value = User("abc", "abc", "abc")
    }

    fun clickButton(){
        liveData.value = User("123", "123", "123")
    }


}