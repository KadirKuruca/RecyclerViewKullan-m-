package com.kadirkuruca.candostlar

import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import kotlinx.android.synthetic.main.tek_uye.view.*

/**
 * Created by Kadir on 28.02.2018.
 */
class DostRecyclerViewAdapter(tumDostlar:ArrayList<Dost>) : RecyclerView.Adapter<DostRecyclerViewAdapter.DostViewHolder>(), Filterable {

    var dostlar = tumDostlar
    var myFilter = FilterHelper(dostlar,this)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DostViewHolder {

        var inflater = LayoutInflater.from(parent?.context)
        var tek_uye = inflater.inflate(R.layout.tek_uye,parent,false)

        return DostViewHolder(tek_uye)
    }

    override fun onBindViewHolder(holder: DostViewHolder?, position: Int) {

        var olusturulanDost = dostlar.get(position)
        holder?.setData(olusturulanDost,position)

    }

    override fun getItemCount(): Int {
        return dostlar.size
    }


    class DostViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var tek_uye = itemView as CardView

        var dostAd = tek_uye.tvDostAdi
        var dostResim = tek_uye.imgDost

        fun setData(olusturulanDost: Dost, position: Int) {

            dostAd.text = olusturulanDost.isim
            dostResim.setImageResource(olusturulanDost.resim)

            tek_uye.setOnClickListener { v -> // Contexte ulaşmak için diğer onClick metodundaki v view nesnesini kullanmak için yazdık.

                //Toast.makeText(tek_uye.context,"Tıklanılan Resim : "+position+" Adı "+olusturulanDost.isim,Toast.LENGTH_SHORT).show()
                var intent = Intent(v.context,DetayActivity::class.java)
                intent.putExtra("ad",olusturulanDost.isim)
                intent.putExtra("resim",olusturulanDost.resim)
                v.context.startActivity(intent)
            }
        }

    }

    fun setFilter(arrayList: ArrayList<Dost>) {

        dostlar = arrayList // Dostlar listesine aranan sonuçlar eklendi.
    }

    override fun getFilter(): Filter {

        return myFilter // Adapter sınıfı içerisinde oluşturulan filter tipindeki nesneyi döndürür.
    }

    /*fun setFilter(arananlar : ArrayList<Dost>){

        dostlar = ArrayList<Dost>() //Dostlar listesini boşalttık.
        dostlar.addAll(arananlar) // Parametre olarak gelen arananlar listesini dostlara ekledik.
        notifyDataSetChanged() // RecyclerView i bilgilendirdik.
    }*/

}