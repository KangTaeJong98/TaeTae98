package com.taetae98.scal

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.ssomai.android.scalablelayout.ScalableLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ScalableLayout>(R.id.layout).apply {
            val view = TextView(this.context).apply {
                text = "Hello World"
                measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
            }

            addView(view, 0.0F, 0.0F, 10F, 10F)
        }
    }
}