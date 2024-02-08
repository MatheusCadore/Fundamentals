package com.example.fragmentstudy.changeFrag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentstudy.R
import com.example.fragmentstudy.databinding.FragmentUserBinding
import java.util.Calendar
import kotlin.properties.Delegates


class UserFrag : Fragment(R.layout.fragment_user) {

    private var _userBinding: FragmentUserBinding? = null
    private val userBinding get() = _userBinding!!

    private lateinit var userName: String
    private var userAge by Delegates.notNull<Int>()
    private lateinit var userDescription: String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _userBinding = FragmentUserBinding.inflate(inflater,container,false)
        val view = userBinding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userBinding.saveUserBtn.setOnClickListener{

            userName = userBinding.userNameEt.text.toString()
            userDescription = userBinding.userDescriptionEt.text.toString()
            val birthYear = userBinding.birthDayEt.text.toString()
            userAge = Calendar.getInstance().get(Calendar.YEAR) - birthYear.toInt()

            setUpUserInfo(userName,userAge,userDescription)
        }
    }


    private fun setUpUserInfo(name: String, age: Int, description: String){
        userBinding.userNameTv.text = "My Name is :  $name "
        userBinding.userAgeTv.text = "My Age is : $age"
        userBinding.userDescriptionTv.text = "A little about myself: $description "
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _userBinding = null
    }

}