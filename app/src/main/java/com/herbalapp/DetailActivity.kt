package com.herbalapp

import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import android.os.Bundle

public class DetailActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		
		setContentView(R.layout.detail_activity)
		
		val tvNama = findViewById<TextView>(R.id.tv_nama)
		val tvDetail = findViewById<TextView>(R.id.tv_detail)
		val imgDetail = findViewById<ImageView>(R.id.img_detail)
		
		// menangkap hasil putExtra
		val title = intent.getStringExtra("nama")
		val detail = intent.getStringExtra("detail")
		val image = intent.getIntExtra("photo",1)
		
		// set dengan id
		tvNama.text = title
		tvDetail.text = detail
		imgDetail.setImageResource(image)
		
	}
}