package com.smktunas.app4_recycleview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smktunas.app4_recycleview.DetailActivity
import com.smktunas.app4_recycleview.R
import com.smktunas.app4_recycleview.model.Buku

class BukuAdapter(
    private val listBuku: List<Buku>
) : RecyclerView.Adapter<BukuAdapter.BukuViewHolder>() {

    class BukuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvJudul: TextView = view.findViewById(R.id.tvJudul)
        val tvPenulis: TextView = view.findViewById(R.id.tvPenulis)
        val ivCover: ImageView = itemView.findViewById(R.id.ivCover)
        val tvTahun: TextView = itemView.findViewById(R.id.tvTahun)
        val btnHapus: Button = view.findViewById(R.id.btnHapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_buku, parent, false)
        return BukuViewHolder(view)
    }

    override fun onBindViewHolder(holder: BukuViewHolder, position: Int) {
        val buku = listBuku[position]
        holder.tvJudul.text = buku.judul
        holder.tvPenulis.text = buku.penulis
        holder.tvTahun.text = buku.tahun

        Glide.with(holder.itemView.context)
            .load(buku.cover)
            .into(holder.ivCover)

        // Klik item → buka detail + Toast
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            AlertDialog.Builder(context)
                .setTitle("Pilih Buku?")
                .setMessage("Apakah kamu ingin membuka detail buku \"${buku.judul}\"?")
                .setPositiveButton("Ya"){ dialog, _ ->
                    Toast.makeText(context, "Kamu Membuka: ${buku.judul}", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra("judul", buku.judul)
                        putExtra("penulis", buku.penulis)
                        putExtra("tahun", buku.tahun)
                    }
                    context.startActivity(intent)
                    dialog.dismiss()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
            }
//        holder.btnHapus.setOnClickListener {
//            val context = holder.itemView.context
//            AlertDialog.Builder(context)
//                .setTitle("Konfirmasi Hapus")
//                .setMessage("Yakin ingin menghapus '${buku.judul}'?")
//                .setPositiveButton("Ya") { _, _ ->
//                    listBuku.removeAt(position)
//                    notifyItemRemoved(position)
//                    notifyItemRangeChanged(position, listBuku.size)
//                    Toast.makeText(context, "Buku dihapus", Toast.LENGTH_SHORT).show()
//                }
//                .setNegativeButton("Batal", null)
//                .show()
//            }
        }
    override fun getItemCount(): Int = listBuku.size
    }
