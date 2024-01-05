package com.example.fragmentstudy.changeFrag

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentstudy.R
import com.example.fragmentstudy.changeActivity.SecondActivity
import com.example.fragmentstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, firstFragment)
            commit()
        }

        binding.BtnFrag1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, firstFragment)
                commit()
            }
        }
        binding.BtnFrag2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, secondFragment)
                commit()
            }
        }
        binding.BtnNext.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}