package com.taetae98.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.arch.core.executor.ArchTaskExecutor
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import com.taetae98.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val liveData by lazy { MutableLiveData(0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        liveData.observe(this) {
            Log.d("PASS", "Before Lambda : $it")
        }
        liveData.observe(this) {
            Log.d("PASS", "After Lambda : $it")
        }


        binding.setOnClick {
            liveData.postValue((liveData.value ?: 0) + 1)
        }
    }
}