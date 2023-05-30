package com.selincengiz.wizardmemory.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.selincengiz.wizardmemory.R
import com.selincengiz.wizardmemory.databinding.FragmentLoginBinding
import com.selincengiz.wizardmemory.model.User
import com.selincengiz.wizardmemory.viewmodel.LoginViewModel
import com.selincengiz.wizardmemory.viewmodel.RegisterViewModel


class LoginFragment : Fragment(R.layout.fragment_login) {
    private var fragmentBinding: FragmentLoginBinding? = null
    private var user : User?=null
    private lateinit var viewModel: LoginViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentLoginBinding.bind(view)
        fragmentBinding = binding

        arguments?.let {
            user= LoginFragmentArgs.fromBundle(it).user
        }
        binding.registeredUser=user

        binding.loginButton.setOnClickListener {
            viewModel =
                ViewModelProvider(this@LoginFragment)[LoginViewModel::class.java]
            viewModel.loginControl(binding.emailEntrance.text.toString(),
            binding.passwordEntrance.text.toString()).apply {
                if(this)
                {
                    val action = LoginFragmentDirections.actionLoginFragmentToGameSettingsFragment()
                    Navigation.findNavController(it).navigate(action)
                }
            }

        }

        binding.register.setOnClickListener{
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        fragmentBinding=null
    }
}