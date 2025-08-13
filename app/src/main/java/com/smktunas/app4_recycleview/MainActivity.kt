package com.smktunas.app4_recycleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smktunas.app4_recycleview.R

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BukuAdapter
    private lateinit var bukuList: MutableList<Buku>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        bukuList = mutableListOf(
            Buku("Laskar Pelangi", "Andrea Hirata", "2005"),
            Buku("Bumi Manusia", "Pramoedya Ananta Toer", "1980"),
            Buku("Negeri 5 Menara", "Ahmad Fuadi", "2009"),
            Buku("Perahu Kertas", "Dewi Lestari", "2009"),
            Buku("Cantik Itu Luka", "Eka Kurniawan", "2002")
        )

        adapter = BukuAdapter(this, bukuList)
        recyclerView.adapter = adapter
    }
}
