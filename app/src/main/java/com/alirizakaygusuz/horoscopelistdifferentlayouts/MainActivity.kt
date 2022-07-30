package com.alirizakaygusuz.horoscopelistdifferentlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.alirizakaygusuz.horoscopelistdifferentlayouts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private lateinit var horoscopeList: ArrayList<Horoscope>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setData()

        initalizeAdapter()
    }

    private fun initalizeAdapter(){
        val myAdapter = HoroscopeAdapter(horoscopeList)

        binding.recyclerViewMain.adapter = myAdapter

        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.recyclerViewMain.layoutManager = linearLayoutManager
    }

    private fun setData() {
        horoscopeList = ArrayList()

        val hArrayBigImage = this.resources.obtainTypedArray(
            R.array.horoscopeImages)

        val horoscopes = this.resources.getStringArray(R.array.horoscopes)

        val horoscopeEqualsElement = this.resources.getStringArray(R.array.horoscopeEqualsElement)


        for (i in 0 until horoscopeEqualsElement.size) {


            val horoscope =
                Horoscope(horoscopes.get(i),
                    horoscopeEqualsElement.get(i),
                    hArrayBigImage.getResourceId(i, 0))
            horoscopeList.add(horoscope)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when (id) {
            R.id.menuLinearViewHorizontal -> {
                val linearLayoutManagerHorizontal =
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

                binding.recyclerViewMain.layoutManager = linearLayoutManagerHorizontal
            }
            R.id.menuLinearViewVertical -> {
                val linearLayoutManagerVertical =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

                binding.recyclerViewMain.layoutManager = linearLayoutManagerVertical
            }
            R.id.menuStaggeredHorizontal -> {

                val staggeredGridLayoutManagerHorizontal = StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.HORIZONTAL)

                binding.recyclerViewMain.layoutManager = staggeredGridLayoutManagerHorizontal

            }

        }

        return  super.onOptionsItemSelected(item)
    }
}