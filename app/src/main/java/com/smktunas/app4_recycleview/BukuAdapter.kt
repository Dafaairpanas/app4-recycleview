package com.smktunas.app4_recycleview


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smktunas.app4_recycleview.R

class BukuAdapter(private val context: Context, private val bukuList: List<Buku>) :
    RecyclerView.Adapter<BukuAdapter.BukuViewHolder>() {

    inner class BukuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvJudul: TextView = view.findViewById(R.id.tvJudul)
        val tvPenulis: TextView = view.findViewById(R.id.tvPenulis)
        val tvTahun: TextView = view.findViewById(R.id.tvTahun)
        val iconBuku: ImageView = view.findViewById(R.id.iconBuku)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_buku, parent, false)
        return BukuViewHolder(view)
    }

    override fun onBindViewHolder(holder: BukuViewHolder, position: Int) {
        val buku = bukuList[position]
        holder.tvJudul.text = buku.judul
        holder.tvPenulis.text = buku.penulis
        holder.tvTahun.text = buku.tahun
        holder.iconBuku.setImageResource(R.drawable.city_of_evil)
    }

    override fun getItemCount(): Int = bukuList.size
}
