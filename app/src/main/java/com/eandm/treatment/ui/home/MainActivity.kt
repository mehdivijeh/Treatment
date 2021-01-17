package com.eandm.treatment.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.eandm.treatment.R
import com.eandm.treatment.utils.Constants.ARG_FULLSCREEN_PAGE
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        val navController =
            Navigation.findNavController(this, R.id.main_nav_host_fragment)
        main_bottom_navigation.inflateMenu(R.menu.bottom_navigation_menu)
        main_bottom_navigation.selectedItemId = R.id.treatmentFragment
        main_bottom_navigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.treatmentFragment -> {
                    navController.navigate(R.id.action_to_treatment_fragment)
                }
                R.id.dashboardFragment -> {
                    navController.navigate(R.id.action_to_dashboard_fragment)
                }
            }
            true
        }

        navController.addOnDestinationChangedListener { _, _, arguments ->
            updateBottomNavigation(arguments?.getBoolean(ARG_FULLSCREEN_PAGE, false) ?: false)
        }
    }

    private fun updateBottomNavigation(isFullScreenPage: Boolean) {
        main_bottom_navigation.visibility = if (isFullScreenPage) View.GONE else View.VISIBLE
    }

}