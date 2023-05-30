package com.selincengiz.wizardmemory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.selincengiz.wizardmemory.R
import com.selincengiz.wizardmemory.databinding.ItemBinding
import com.selincengiz.wizardmemory.model.Card

class CardAdapter (val cardList :ArrayList<Card> ,private val listener: Listener): RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    var List2: ArrayList<Card> = ArrayList()
    var sayac :Int =0
    var Listpoz :ArrayList<Int> = ArrayList()

    interface Listener {
        fun onScoreChanged(score : Int, islem :Boolean)

    }

    class CardViewHolder(val binding : ItemBinding): RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {

        val binding =
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.binding.house.text=cardList.get(position).House
        holder.binding.name.text=cardList.get(position).Name
        holder.binding.point.text=cardList.get(position).Point

        if(!cardList.get(position).isOpen!!){
            holder.binding.imageView2.setImageResource(R.drawable.back)
            holder.binding.house.visibility= View.GONE
            holder.binding.name.visibility= View.GONE
            holder.binding.point.visibility= View.GONE

        }
        else{
            holder.binding.imageView2.setImageResource(R.color.white)
            holder.binding.house.visibility= View.VISIBLE
            holder.binding.name.visibility= View.VISIBLE
            holder.binding.point.visibility= View.VISIBLE


        }

        holder.binding.root.setOnClickListener {



            cardList.get(position).apply {
                isOpen = true
            }

            notifyItemChanged(position)

            sayac++

            List2.add(cardList.get(position))

            Listpoz.add(position)

            if(sayac==2){
                notifyItemChanged(position)

                if(List2.get(0).Name!!.equals(List2.get(1).Name)){

                    if(List2.get(0).House=="GRYFFİNDOR" || List2.get(0).House=="SLYTHERİN")
                    {
                        var addScore= 2*(List2.get(0).Point!!.toInt())*2
                        //  score =  score + addScore
                        println(addScore)

                        listener.onScoreChanged(addScore,true)


                    }
                    else
                    {
                        var addScore= 2*(List2.get(0).Point!!.toInt())
                        //score =  score + addScore
                        println(addScore)

                        listener.onScoreChanged(addScore,true)

                    }


                }
                else{

                    cardList.get(Listpoz.get(0)).apply {
                        isOpen=false
                    }
                    cardList.get(Listpoz.get(1)).apply {
                        isOpen=false
                    }
                    if(List2.get(0).House!!.equals(List2.get(1).House)) {
                        if (List2.get(0).House == "GRYFFİNDOR" || List2.get(0).House == "SLYTHERİN") {
                            var minusScore =
                                (List2.get(0).Point!!.toInt() + List2.get(1).Point!!.toInt()) / 2
                            println(minusScore)

                            listener.onScoreChanged(minusScore, false)
                        } else {
                            var minusScore =
                                List2.get(0).Point!!.toInt() + List2.get(1).Point!!.toInt()
                            println(minusScore)

                            listener.onScoreChanged(minusScore, false)
                        }
                    }

                    if(List2.get(0).House=="GRYFFİNDOR" || List2.get(0).House=="SLYTHERİN" && List2.get(1).House=="RAVENCLAW" ||List2.get(1).House=="HUFFLEPUFF")
                    {
                        var minusScore= List2.get(0).Point!!.toInt() + List2.get(1).Point!!.toInt()
                        //  score = score- minusScore
                        println(minusScore)
                        listener.onScoreChanged(minusScore,false)

                    }
                    else if(List2.get(1).House=="GRYFFİNDOR" || List2.get(1).House=="SLYTHERİN" && List2.get(0).House=="RAVENCLAW" ||List2.get(0).House=="HUFFLEPUFF")
                    {
                        var minusScore= List2.get(0).Point!!.toInt() + List2.get(1).Point!!.toInt()
                        //  score = score- minusScore
                        println(minusScore)

                        listener.onScoreChanged(minusScore,false)


                    }

                    else if(List2.get(0).House=="RAVENCLAW" && List2.get(1).House=="HUFFLEPUFF")
                    {
                        var minusScore= (List2.get(0).Point!!.toInt() + List2.get(1).Point!!.toInt())/2
                        //score = score- minusScore
                        println(minusScore)

                        listener.onScoreChanged(minusScore,false)



                    }
                    else if(List2.get(0).House=="HUFFLEPUFF" && List2.get(1).House=="RAVENCLAW")
                    {
                        var minusScore= (List2.get(0).Point!!.toInt() + List2.get(1).Point!!.toInt())/2
                        // score = score- minusScore
                        println(minusScore)

                        listener.onScoreChanged(minusScore,false)


                    }
                    else if(List2.get(0).House=="GRYFFİNDOR" && List2.get(1).House=="SLYTHERİN")
                    {
                        var minusScore= (List2.get(0).Point!!.toInt() + List2.get(1).Point!!.toInt())*2
                        // score = score- minusScore
                        println(minusScore)

                        listener.onScoreChanged(minusScore,false)


                    }
                    else if(List2.get(0).House=="SLYTHERİN" && List2.get(1).House=="GRYFFİNDOR")
                    {
                        var minusScore= (List2.get(0).Point!!.toInt() + List2.get(1).Point!!.toInt())*2
                        //  score = score- minusScore
                        println(minusScore)

                        listener.onScoreChanged(minusScore,false)


                    }



                    println(cardList.get(Listpoz.get(1)))
                    println(cardList.get(Listpoz.get(0)))

                    notifyItemChanged(Listpoz.get(0))
                    notifyItemChanged(Listpoz.get(1))


                }

                List2.clear()

                Listpoz.clear()
                sayac=0
                notifyDataSetChanged()

            }


            //  notifyDataSetChanged()





        }
    }

    override fun getItemCount(): Int {

        return cardList.size
    }
}