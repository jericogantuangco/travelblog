package com.example.travelblog

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.travelblog.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener { onLoginClicked() }
        binding.textUsernameLayout.editText?.addTextChangedListener(createTextWatcher(binding.textUsernameLayout))
        binding.textPasswordInput.editText?.addTextChangedListener(createTextWatcher(binding.textPasswordInput))
    }

    private fun onLoginClicked(){
        val username : String = binding.textUsernameLayout.editText?.text.toString()
        val password : String = binding.textPasswordInput.editText?.text.toString()

        if ( username.isEmpty() ) {
            binding.textUsernameLayout.error = "Username must not be empty."
        }

        if ( password.isEmpty() ) {
            binding.textPasswordInput.error = "Password must not be empty."
        }

        if (username != "admin" || password != "admin") {
            showErrorDialog()
        }


    }

    private fun createTextWatcher(textInputLayout : TextInputLayout) : TextWatcher {
        return object : TextWatcher {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textInputLayout.error = null
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Meant to be blank since implementation not needed
            }

            override fun afterTextChanged(p0: Editable?) {
                // Meant to be blank since implementation not needed
            }
        }
    }

    private fun showErrorDialog(){
        AlertDialog.Builder(this)
            .setTitle("Login Failed")
            .setMessage("Username or Password is incorrect. Please try again.")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }

}