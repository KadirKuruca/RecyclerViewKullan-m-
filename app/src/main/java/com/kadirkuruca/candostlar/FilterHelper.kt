package com.kadirkuruca.candostlar

import android.widget.Filter
import java.security.AlgorithmConstraints

/**
 * Created by Kadir on 2.03.2018.
 */
class FilterHelper(tumDostlar : ArrayList<Dost>,adapter: DostRecyclerViewAdapter) : Filter() {

    var suankiListe = tumDostlar
    var suankiAdapter = adapter

    override fun performFiltering(constraints: CharSequence?): FilterResults {

        var sonuc = FilterResults()

        if(constraints != null && constraints.length > 0){

            var aranan = constraints.toString().toLowerCase()
            var eslesenler = ArrayList<Dost>()

            for (dost in suankiListe){

                var ad = dost.isim.toLowerCase()
                if(ad.contains(aranan)){
                    eslesenler.add(dost)
                }
            }

            sonuc.values = eslesenler
            sonuc.count = eslesenler.size
        }
        else{
            sonuc.count = suankiListe.size
            sonuc.values = suankiListe
        }

        return sonuc
    }

    override fun publishResults(constraints: CharSequence?, results: FilterResults?) {

        suankiAdapter.setFilter(results?.values as ArrayList<Dost>)
        suankiAdapter.notifyDataSetChanged()
    }
}