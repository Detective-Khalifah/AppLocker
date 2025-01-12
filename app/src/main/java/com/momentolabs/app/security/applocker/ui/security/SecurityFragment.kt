package com.momentolabs.app.security.applocker.ui.security

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.momentolabs.app.security.applocker.R
import com.momentolabs.app.security.applocker.databinding.FragmentSecurityBinding
import com.momentolabs.app.security.applocker.ui.BaseFragment
import com.momentolabs.app.security.applocker.ui.background.BackgroundsActivity
import com.momentolabs.app.security.applocker.ui.permissiondialog.UsageAccessPermissionDialog
import com.momentolabs.app.security.applocker.ui.permissions.PermissionChecker
import com.momentolabs.app.security.applocker.util.delegate.inflate

class SecurityFragment : BaseFragment<SecurityViewModel>() {

    private val binding: FragmentSecurityBinding by inflate(R.layout.fragment_security)

    private val adapter: AppLockListAdapter = AppLockListAdapter()

    override fun getViewModel(): Class<SecurityViewModel> = SecurityViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.recyclerViewAppLockList.adapter = adapter

        binding.recyclerViewAppLockList.addOnScrollListener(
            MainActionsShowHideScrollListener(
                binding.layoutMainActions.root,
                resources.getDimension(R.dimen.main_actions_size) + resources.getDimension(R.dimen.margin_16dp)
            )
        )
        binding.layoutMainActions.layoutTheme.setOnClickListener {
            activity?.let {
                startActivity(BackgroundsActivity.newIntent(it))
            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getAppDataListLiveData().observe(this, Observer {
            adapter.setAppDataList(it)
        })

        adapter.appItemClicked = this@SecurityFragment::onAppSelected
    }

    private fun onAppSelected(selectedApp: AppLockItemItemViewState) {
        activity?.let {
            if (PermissionChecker.checkUsageAccessPermission(it).not()) {
                UsageAccessPermissionDialog.newInstance().show(it.supportFragmentManager, "")
            } else {
                if (selectedApp.isLocked) {
                    viewModel.unlockApp(selectedApp)
                } else {
                    viewModel.lockApp(selectedApp)
                }
            }
        }
    }

    companion object {
        fun newInstance() = SecurityFragment()
    }
}