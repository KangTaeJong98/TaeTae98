package com.taetae98.widget.ui.activity

import android.os.Bundle
import androidx.navigation.ui.setupWithNavController
import com.taetae98.modules.library.navigation.NavigationActivity
import com.taetae98.widget.R
import com.taetae98.widget.databinding.ActivityMemoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemoActivity : NavigationActivity<ActivityMemoBinding>(R.layout.activity_memo, R.id.nav_host) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateToolbar()
    }

    private fun onCreateToolbar() {
        with(binding.toolbar) {
            setupWithNavController(navController, appBarConfiguration)
            setSupportActionBar(this)
        }
    }
}