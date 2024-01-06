package com.example.fragmentstudy.changeActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fragmentstudy.R
import com.example.fragmentstudy.changeFrag.MainActivity
import com.example.fragmentstudy.databinding.ActivityMainBinding
import com.example.fragmentstudy.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var welcomeFrag: WelcomeFrag

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        welcomeFrag = WelcomeFrag()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView2, welcomeFrag)
            commit()
        }

    }

}