package com.example.billeteradigital

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.billeteradigital.Controller.IntroSlide

class SlideAdapter (private val introSlide: List<IntroSlide>) :
                    RecyclerView.Adapter<SlideAdapter.IntroSlideViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
       return IntroSlideViewHolder(
           LayoutInflater.from(parent.context).inflate(
               R.layout.slide_items,
               parent,
               false
           )
       )
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(introSlide[position])
    }

    override fun getItemCount(): Int {
        return introSlide.size
    }

    inner class IntroSlideViewHolder(view: View): RecyclerView.ViewHolder(view){

                            private val textTitle = view.findViewById<TextView>(R.id.textTitleSlide)
                            private val description = view.findViewById<TextView>(R.id.textDescriptionSlide)
                            private val image = view.findViewById<ImageView>(R.id.imageSlide)


                            fun bind(introSlide: IntroSlide){
                                Log.v("llego", introSlide.title)
                                textTitle.text = introSlide.title
                                description.text = introSlide.description
                                image.setImageResource(introSlide.image)
                            }
                        }

}