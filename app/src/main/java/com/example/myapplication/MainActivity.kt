package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.remove
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.Models.WeatherDetails
import com.example.myapplication.weatherVM.WeatherViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    //@SuppressLint("MissingInflatedId")
    private val weatherViewModel: WeatherViewModel by viewModels()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mEditText = findViewById<EditText>(R.id.editText)
        val mButton = findViewById<Button>(R.id.button)

        val mFragmentManager = supportFragmentManager



        mButton.setOnClickListener {
            val mFragmentTransaction = mFragmentManager.beginTransaction()
            val mFragment = Fragment1()
            val mBundle = Bundle()
            mBundle.putString("mText",mEditText.text.toString())
            mFragment.arguments = mBundle
            mFragmentTransaction.replace(R.id.Framer, mFragment).commit()
        }

    }
}
