package com.maxie.gootax_test

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.maxie.gootax_test.data.repositories.NavRepository
import com.maxie.gootax_test.databinding.ActivityMainBinding
import com.maxie.gootax_test.recyclers.MainAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setNavRecycler()

    }

    @SuppressLint("SetTextI18n")
    private fun setNavRecycler() {
        binding.headerView.headerLayout.setOnClickListener {
            Toast.makeText(this,
                binding.headerView.headerUsesrname.text, Toast.LENGTH_SHORT).show()
        }

        val navItems = NavRepository().fetchNavData()

        binding.navRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.navRecyclerView.adapter = MainAdapter(navItems) { item ->
            Toast.makeText(this, "Нажали: ${item.title}", Toast.LENGTH_SHORT).show()
        }

        binding.footerView.footerLayout.setOnClickListener {
            Toast.makeText(this, "Прием...", Toast.LENGTH_SHORT).show()
        }

    }
}