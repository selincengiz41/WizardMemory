package com.selincengiz.wizardmemory.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.selincengiz.wizardmemory.R
import com.selincengiz.wizardmemory.databinding.FragmentRegisterBinding
import com.selincengiz.wizardmemory.model.User
import com.selincengiz.wizardmemory.viewmodel.RegisterViewModel

class RegisterFragment : Fragment(R.layout.fragment_register) {
    private var fragmentBinding: FragmentRegisterBinding? = null
    private lateinit var viewModel: RegisterViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentRegisterBinding.bind(view)
        fragmentBinding = binding

        binding.login.setOnClickListener {
            val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            Navigation.findNavController(it).navigate(action)
        }

        binding.registerButton.setOnClickListener {

            viewModel =
                ViewModelProvider(this@RegisterFragment)[RegisterViewModel::class.java]
            viewModel.controlForRegister(
                binding.nameEntrance.text.toString(),
                binding.emailEntrance.text.toString(),
                binding.passwordEntrance.text.toString(),
                binding.passwordControlEntrance.text.toString()
            ).apply {
                if (this !=null) {

                    val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment(this)
                    Navigation.findNavController(it).navigate(action)
                }
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentBinding = null
    }


}