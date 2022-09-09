package com.herbalapp

import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.content.Intent
import androidx.recyclerview.widget.*
import android.os.Bundle

public class MainActivity : AppCompatActivity() {
	private lateinit var rvHerbals: RecyclerView
	private var list: ArrayList<Herbal> = arrayListOf()
	private var listHerbalAdapter = ListHerbalAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
		 
		 rvHerbals = findViewById(R.id.rv_herbals)
		 rvHerbals.setHasFixedSize(true)
		 
		 
		 list.addAll(HerbalsData.listData)
		 showRecyclerList()
    }
	
	private fun showRecyclerList() {
		rvHerbals.layoutManager = LinearLayoutManager(this)
		val listHerbalAdapter = ListHerbalAdapter(list)
		rvHerbals.adapter = listHerbalAdapter
		
	}
	
	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.profile_menu, menu)
		return super.onCreateOptionsMenu(menu)
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		setMode(item.itemId)
		return super.onOptionsItemSelected(item)
	}
	
	private fun setMode(selectedMode: Int) {
		when (selectedMode) {
			R.id.my_profile -> {
				val intent = Intent(this@MainActivity, ProfileActivity::class.java)
				startActivity(intent)
			}
		}
	}
}