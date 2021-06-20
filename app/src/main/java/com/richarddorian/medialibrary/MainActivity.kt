package com.richarddorian.medialibrary

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.richarddorian.medialibrary.fragments.CategoriesFragment
import com.richarddorian.medialibrary.fragments.MediaFragment
import com.richarddorian.medialibrary.fragments.SettingsFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(!isPackageInstalled("org.videolan.vlc", this.packageManager)) {
            Toast.makeText(this, this.getString(R.string.vlc_not_installed), Toast.LENGTH_SHORT).show()
        }

        setContentView(R.layout.activity_main)

        loadFragment(CategoriesFragment(this), R.string.categories)

        val categoryRepo = CategoryRepository(this)

        categoryRepo.updateData()

        val navigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.categories_page -> {
                    loadFragment(CategoriesFragment(this), R.string.categories)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.media_page -> {
                    loadFragment(MediaFragment(this), R.string.content)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.settings_page -> {
                    loadFragment(SettingsFragment(this), R.string.settings)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }

    }

    public fun loadFragment(fragment: Fragment, tabTitle: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        findViewById<TextView>(R.id.tab_title).text = resources.getString(tabTitle)
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun isPackageInstalled(
        packageName: String?,
        packageManager: PackageManager
    ): Boolean {
        return try {
            packageManager.getApplicationInfo(packageName!!, 0).enabled
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}