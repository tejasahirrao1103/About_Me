package com.tejraj.aboutme

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.tejraj.aboutme.databinding.ActivityMainBinding

//⚠️ATTENTION {READ ME}:-
//🔴<-- use for denoting treditional way without binding
//🟢<-- use to denoting New Method with Binding
//🔵<<-- data binding
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    //🟢binding variable define with componant(ActivitymainBinding)
    private lateinit var binding: ActivityMainBinding

    private val bindingName : MyName = MyName()  //🔵


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // 🔴 old code without binding 👇👇
        // setContentView(R.layout.activity_main)

        //🟢 binding variable decleare 👇👇
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = bindingName//🔵 data binding always decler after layout bingdi
        binding.myName?.Heading=("Tejas Ahirrao")

        // 🔴 old code without binding 👇👇
        //   val enterButton: Button = findViewById(R.id.enterButton)
        //   enterButton.setOnClickListener {
        //  ChnageName(it)
        //   }

        //🟢 New code with binding 👇👇
        binding.enterButton.setOnClickListener {
            ChnageName(it)
        }

    }

    private fun ChnageName(view: View) {

        // 🔴 old code without binding 👇👇
        //val textIP: TextView=findViewById(R.id.NicknameIP)
        //val textOP: TextView=findViewById(R.id.NicknameOP)
        //textOP.text = textIP.text.toString()
        //textIP.visibility= View.GONE
        //textOP.visibility= View.VISIBLE
        //view.visibility= View.GONE

        //🟢 New code with binding 👇👇
        // binding.NicknameOP.text = binding.NicknameIP.text.toString()
        // binding.NicknameIP.visibility = View.GONE
        //  binding.NicknameOP.visibility = View.VISIBLE
        //  view.visibility= View.GONE

        //🟢 OR  New code with binding 👇👇

        binding.apply {
            myName?.NickNameOp = NicknameIP.text.toString()
            invalidateAll() // This method use for Remove all previous opration and refesh all binding
            NicknameIP.visibility = View.GONE
            NicknameOP.visibility = View.VISIBLE
            view.visibility = View.GONE
        }

    }
}