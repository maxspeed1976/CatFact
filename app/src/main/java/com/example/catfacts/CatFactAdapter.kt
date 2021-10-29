package com.example.catfacts

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catfacts.model.Data
import kotlinx.android.synthetic.main.catfact_item.view.*

class CatFactAdapter(private val catResult: List<Data>) :
    RecyclerView.Adapter<CatFactAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(layoutInflater.inflate(R.layout.catfact_item, parent, false))
    }


    override fun getItemCount(): Int {
        return catResult.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val catFact = catResult.get(position)
        println(catFact.toString())
        Log.d("CatFact", catFact.toString())
        holder.view.fact.text = catFact.fact.toString()

    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


    }

}

