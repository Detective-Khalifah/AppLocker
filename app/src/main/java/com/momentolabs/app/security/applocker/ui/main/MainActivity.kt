package com.momentolabs.app.security.applocker.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.momentolabs.app.security.applocker.R
import com.momentolabs.app.security.applocker.databinding.ActivityMainBinding
import com.momentolabs.app.security.applocker.ui.BaseActivity
import com.momentolabs.app.security.applocker.ui.newpattern.CreateNewPatternActivity
import com.momentolabs.app.security.applocker.ui.overlay.activity.OverlayValidationActivity
import com.momentolabs.app.security.applocker.util.helper.NavigationIntentHelper

class MainActivity : BaseActivity<MainViewModel>(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewPager.adapter = MainPagerAdapter(this, supportFragmentManager)
        binding.tablayout.setupWithViewPager(binding.viewPager)

        binding.imageViewMenu.setOnClickListener { binding.drawerLayout.openDrawer(GravityCompat.START) }

        binding.navView.setNavigationItemSelectedListener(this)

        viewModel.getPatternCreationNeedLiveData().observe(this, Observer { isPatternCreateNeed ->
            when {
                isPatternCreateNeed -> {
                    startActivityForResult(
                        CreateNewPatternActivity.newIntent(this),
                        RC_CREATE_PATTERN
                    )
                }
                viewModel.isAppLaunchValidated().not() -> {
                    startActivityForResult(
                        OverlayValidationActivity.newIntent(this, this.packageName),
                        RC_VALIDATE_PATTERN
                    )
                }
            }
        })
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_feedback -> startActivity(NavigationIntentHelper.getFeedbackIntent())
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            RC_CREATE_PATTERN -> {
                viewModel.onAppLaunchValidated()
                if (resultCode != Activity.RESULT_OK) {
                    finish()
                }
            }
            RC_VALIDATE_PATTERN -> {
                if (resultCode == Activity.RESULT_OK) {
                    viewModel.onAppLaunchValidated()
                } else {
                    finish()
                }
            }
        }
    }

    companion object {
        private const val RC_CREATE_PATTERN = 2002
        private const val RC_VALIDATE_PATTERN = 2003
    }
}
