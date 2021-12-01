package com.example.tesschatapp.View.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.commit

import com.example.tesschatapp.R
import com.example.tesschatapp.databinding.ActivityLoginBinding

import com.google.firebase.auth.FirebaseUser


class Login : Fragment() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       //chuyen man hinh
        binding.loginBtn.setOnClickListener{
            parentFragmentManager.commit {
                replace(R.id.nav_host_fragment, SignUp.Instance())
            }
        }
        binding.loginBtn
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    companion object{
        fun Instance() = Login()
    }

}