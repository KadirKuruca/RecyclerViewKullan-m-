package com.kadirkuruca.candostlar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var gelenIntent = intent

        if(gelenIntent != null){

            tvDetay.text = gelenIntent.getStringExtra("ad")
            imgDetay.setImageResource(gelenIntent.getIntExtra("resim",0))
        }
    }
}
