package com.kadirkuruca.candostlar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() /*, android.widget.SearchView.OnQueryTextListener*/ {


    var tumDostlar = ArrayList<Dost>()
    lateinit var myAdapter : DostRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynagi()

        myAdapter = DostRecyclerViewAdapter(tumDostlar)
        recyclerDostlar.adapter = myAdapter

        var myLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerDostlar.layoutManager = myLayoutManager

        searchViewDost.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                myAdapter.filter.filter(newText)
                return false
            }

        })

    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.filtre_menu,menu)

        var searchBar = menu?.findItem(R.id.app_bar_search)

        var searchView = searchBar?.actionView as android.widget.SearchView

        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(newText: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {

        var girilen = newText?.toLowerCase()
        var arananlar = ArrayList<Dost>()

        for(dost in tumDostlar){

            var adi = dost.isim.toLowerCase()

            if(adi.contains(girilen.toString())){
                arananlar.add(dost)
            }
        }

        myAdapter.setFilter(arananlar)
        return  true
    }*/

    private fun veriKaynagi() {

        var resimler = arrayOf(R.drawable.ba1,R.drawable.ba2,R.drawable.ba3,R.drawable.ba4,R.drawable.ba5,
                R.drawable.ke1,R.drawable.ke2,R.drawable.ke3,R.drawable.ke4,R.drawable.ke6,R.drawable.ke7,R.drawable.ke8,R.drawable.ke9,R.drawable.ke10,
                R.drawable.ko1,R.drawable.ko2,R.drawable.ko3,R.drawable.ko4,R.drawable.ko5,
                R.drawable.ku1,R.drawable.ku2,R.drawable.ku3,R.drawable.ku4,R.drawable.ku5)

        var isimler = arrayOf("Balık 1","Balık 2","Balık 3","Balık 4","Balık 5",
                "Kedi 1","Kedi 2","Kedi 3","Kedi 4","Kedi 5","Kedi 6","Kedi 7","Kedi 8","Kedi 9","Kedi 10",
                "Köpek 1","Köpek 2","Köpek 3","Köpek 4","Köpek 5",
                "Kuş 1","Kuş 2","Kuş 3","Kuş 4","Kuş 5")

        for (i in 0..resimler.size-1){

            var ekle = Dost(isimler[i],resimler[i])
            tumDostlar.add(ekle)
        }

    }
}
