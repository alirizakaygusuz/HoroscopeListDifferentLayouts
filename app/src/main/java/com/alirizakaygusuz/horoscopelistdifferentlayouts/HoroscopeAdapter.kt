package com.alirizakaygusuz.horoscopelistdifferentlayouts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class HoroscopeAdapter(var horoscopeList: ArrayList<Horoscope>):RecyclerView.Adapter<HoroscopeAdapter.HoroscopeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val horoscopeRow: View = inflater.inflate(R.layout.horoscope_row, parent, false)


        return HoroscopeViewHolder(horoscopeRow)

    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        var oanOlusturulanManzara = horoscopeList.get(position)

        holder.setData(oanOlusturulanManzara, position)
    }

    override fun getItemCount(): Int {
        return horoscopeList.size
    }

    inner class HoroscopeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val horoscopeRow = itemView as CardView

        var horoscopeImage = horoscopeRow.findViewById<ImageView>(R.id.imvHoroscope)
        var horoscopeTitle = horoscopeRow.findViewById<TextView>(R.id.txtHoroscopeTitle)
        var horoscopeDecription = horoscopeRow.findViewById<TextView>(R.id.txtHoroscopeDescription)

        var imvAdd = horoscopeRow.findViewById<ImageView>(R.id.imvAdd)
        var imvDelete = horoscopeRow.findViewById<ImageView>(R.id.imvDelete)


        fun setData(
            currentHoroscope: Horoscope,
            position: Int,
        ) {
            horoscopeImage.setImageResource(currentHoroscope.image)
            horoscopeTitle.text = currentHoroscope.title
            horoscopeDecription.text = currentHoroscope.description

            imvAdd.setOnClickListener {

                horoscopeList.add(position, currentHoroscope)
                notifyItemInserted(position+1)

                notifyItemRangeChanged(position , horoscopeList.size)


            }

            imvDelete.setOnClickListener {

                horoscopeList.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position , horoscopeList.size)

            }
        }
    }
}