package com.dicoding.myapplicationsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rvsong: RecyclerView
    private val list = ArrayList<Song>()

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvsong = findViewById(R.id.rv_songs)
        rvsong.setHasFixedSize(true)

        list.addAll(getListSong())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.action_sharee -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra("Share this", "https://open.spotify.com/playlist/37i9dQZF1DWXRqgorJj26U?si=8d2e4b596050428c" )
                val chooser = Intent.createChooser(intent, "Share Using ... ")
                startActivity(chooser)

            }

            R.id.profile -> {
                val moveIntent = Intent (this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListSong(): ArrayList<Song> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listSong = ArrayList<Song>()
        for (i in dataName.indices) {
            val song = Song(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listSong.add(song)
        }
        return listSong
    }

    private fun showRecyclerList() {
        rvsong.layoutManager = LinearLayoutManager(this)
        val listSongAdapter = ListSongAdapter(list)
        rvsong.adapter = listSongAdapter
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.action_sharee  -> {
                val moveIntent = Intent (this@MainActivity, DetailSongActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }


}