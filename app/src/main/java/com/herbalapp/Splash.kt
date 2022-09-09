package com.herbalapp

import androidx.appcompat.app.AppCompatActivity
import android.content.*
import android.os.Handler
import android.os.Bundle

public class Splash : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.splash_activity)
		
		supportActionBar?.hide()
		
		Handler().postDelayed({
			val intent = Intent(this@Splash, MainActivity::class.java)
			startActivity(intent)
			finish()
		}, 3000)
	}
}