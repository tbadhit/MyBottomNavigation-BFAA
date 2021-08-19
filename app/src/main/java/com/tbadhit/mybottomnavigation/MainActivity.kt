package com.tbadhit.mybottomnavigation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tbadhit.mybottomnavigation.databinding.ActivityMainBinding

// BottomNavigationView menjadi bagian dari material design library
// How to add bottom navbar :
// 1. Create new fragment "ProfileFragment"
// 2. update "fragment_profile"
// 3. Create icon for bottom navbar
// 4. Add new menu on "bottom_nav_menu.xml"
// 5. Add fragment to navigation
// 6. Add the id that was previously added on "bottom_nav_menu.xml (R.id.navigation_profile)" to appBarConfiguration (MainActivity)
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*
        (AppBarConfiguration) = berisi kumpulan id yang ada di dalam menu BottomNavigation,
        khususnya yang ingin dikonfigurasi AppBar-nya supaya berbentuk Menu. Jika id tidak Anda
        tambahkan di sini, maka AppBar akan menampilkan tanda panah kembali
         */
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_profile
            )
        )
        /*
        (setupActionBarWithNavController) = digunakan untuk mengatur judul AppBar agar sesuai dengan
        Fragment yang ditampilkan
         */
        setupActionBarWithNavController(navController, appBarConfiguration)
        /*
        (setupWithNavController) = digunakan supaya Bottom Navigation menampilkan Fragment yang
        sesuai ketika menu dipilih.
         */
        navView.setupWithNavController(navController)
    }
}