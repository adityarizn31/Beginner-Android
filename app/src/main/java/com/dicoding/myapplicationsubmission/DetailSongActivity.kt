package com.dicoding.myapplicationsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailSongActivity : AppCompatActivity() {

    lateinit var mShare : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_song)


        val dataSong = intent.getParcelableExtra<Song>("key_song")
        val tvDetailName = findViewById<TextView>(R.id.tv_item_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_item_description)
        val tvDetailPhoto = findViewById<ImageView>(R.id.img_item_photo)

        tvDetailName.text = dataSong?.name
        tvDetailDescription.text = dataSong?.description
        dataSong?.photo?.let { tvDetailPhoto.setImageResource(it) }






    }
}