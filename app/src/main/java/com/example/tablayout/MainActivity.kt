package com.example.tablayout

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val model: ManViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainAct)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportFragmentManager.beginTransaction().replace(R.id.mainAct, MainFragment.newInstance()).commit()



//        binding.tabL.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.placeHolder, fragList[tab?.position!!]).commit()
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
////                Toast.makeText(this@MainActivity, "Tab unselected: ${tab?.text}", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                Toast.makeText(this@MainActivity, "Tab reselected: ${tab?.text}", Toast.LENGTH_SHORT).show()
//            }
//
//        })
    }
}