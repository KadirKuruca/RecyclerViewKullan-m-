package com.kadirkuruca.candostlar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //window.statusBarColor =
    }

    override fun onResume() {
        super.onResume()

        object : CountDownTimer(3000,1000){
            override fun onFinish() {

                var intent = Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)
            }

            override fun onTick(p0: Long) {

            }

        }.start()
    }
}
