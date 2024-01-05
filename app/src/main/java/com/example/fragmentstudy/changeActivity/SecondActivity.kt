package com.example.fragmentstudy.changeActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentstudy.R
import com.example.fragmentstudy.changeFrag.MainActivity
import com.example.fragmentstudy.databinding.ActivityMainBinding
import com.example.fragmentstudy.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goBack()
        saveUserData()

    }

    private fun goBack(){
        binding.btnBack.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun saveUserData() : List<String>{
        var data = listOf<String>()
        binding.BtnSingUpRegister.setOnClickListener {
            val username : String = binding.EdtSingUpUsername.text.toString()
            val password : String = binding.EdtSingUpPassword.text.toString()
            data = listOf(username, password)
        }
        return data
    }

}