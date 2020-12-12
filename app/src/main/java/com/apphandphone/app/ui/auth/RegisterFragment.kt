package com.apphandphone.app.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.apphandphone.app.R
import com.apphandphone.app.data.repository.AuthRepository
import com.apphandphone.app.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    val parent: AuthActivity by lazy { activity as AuthActivity }
    val viewModel: AuthViewModel by lazy { AuthViewModel(AuthRepository(parent)) }
    lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragment2ToLoginFragment3())
        }
    }

    private fun observe() {
        viewModel.authRegister.observe(viewLifecycleOwner){
            if (it.isConsumed){
                Log.i("Register",  "isConsumed")
            } else if (!it.isSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(parent, it.message, Toast.LENGTH_LONG).show()
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragment2ToLoginFragment3())
            }
            it.isConsumed = true
        }
    }


}