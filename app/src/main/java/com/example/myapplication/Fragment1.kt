package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.Models.WeatherDetails
import com.example.myapplication.weatherVM.WeatherViewModel
import kotlinx.coroutines.launch


class Fragment1 : Fragment() {


    private val weatherViewModel: WeatherViewModel by viewModels()
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View= inflater.inflate(R.layout.fragment_1, container, false)

        val locateText = view.findViewById<TextView>(R.id.locateText)
        val tempText = view.findViewById<TextView>(R.id.Temp)
        val dateTextView = view.findViewById<TextView>(R.id.DateText)
        val conditionText = view.findViewById<TextView>(R.id.ConditionText)
        val weatherObserver = Observer<WeatherDetails>{ newName->
            locateText.text = newName.location.name
            tempText.text = newName.current.temp_c.toString()
            dateTextView.text = newName.location.localtime
            conditionText.text = newName.current.condition.text
        }
        weatherViewModel.weatherData.observe(viewLifecycleOwner,weatherObserver)
        val bundle = arguments
        val message = bundle!!.getString("mText")
        lifecycleScope.launch {
            if (message != null) {
                weatherViewModel.refreshWD(message)
            }
        }
        return view
    }


}