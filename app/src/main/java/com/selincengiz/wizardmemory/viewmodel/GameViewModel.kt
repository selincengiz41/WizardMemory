package com.selincengiz.wizardmemory.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.selincengiz.wizardmemory.adapter.CardAdapter
import com.selincengiz.wizardmemory.model.Card
import com.selincengiz.wizardmemory.view.GameFragment

class GameViewModel(application: Application) : BaseViewModel(application), CardAdapter.Listener {
    private lateinit var db : FirebaseFirestore
    private val cardAdapter = CardAdapter(arrayListOf(), this@GameViewModel)
    val rastgele:ArrayList<Int> =ArrayList()

    fun dataReceiver(number :Long) :CardAdapter{

        rastgele.add(1)
        rastgele.add(2)
        rastgele.add(3)
        rastgele.add(4)
        rastgele.shuffle()
        db = FirebaseFirestore.getInstance()
        db = Firebase.firestore

        when(number.toInt()){

            4 -> {
                when (rastgele[0].toInt()) {
                    1 -> getGryffindorCard(1)
                    2 -> getSlyhterinCard(1)
                    3 -> getRavenclawCard(1)
                    4 -> getHufflepuffCard(1)

                }

                when (rastgele[1].toInt()) {
                    1 -> getGryffindorCard(1)
                    2 -> getSlyhterinCard(1)
                    3 -> getRavenclawCard(1)
                    4 -> getHufflepuffCard(1)

                }


            }
            16 -> {
                getGryffindorCard(2)
                getHufflepuffCard(2)
                getRavenclawCard(2)
                getSlyhterinCard(2)


            }




            36 -> {
                getGryffindorCard(5)
                getHufflepuffCard(4)
                getRavenclawCard(4)
                getSlyhterinCard(5  )
            }

        }





        cardAdapter.cardList.shuffle()
        cardAdapter.notifyDataSetChanged()
        return cardAdapter
    }

    fun getGryffindorCard(number:Long){

        db.collection("GryffindorCards").orderBy("House",
            Query.Direction.DESCENDING).limit(number).addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Toast.makeText(
                    getApplication(),
                    exception.localizedMessage,
                    Toast.LENGTH_LONG
                ).show()
            } else {

                if (snapshot != null) {
                    if (!snapshot.isEmpty) {



                        val documents = snapshot.documents
                        for (document in documents) {
                            val house = document.get("House") as String
                            val name = document.get("Name") as String
                            val point = document.get("Point") as String

                            val card = Card(house, name,point,false)
                            println(card.Name+" "+card.House+" "+card.Point)
                            cardAdapter.cardList.add(card)
                            cardAdapter.cardList.add(card)
                            cardAdapter.cardList.shuffle()
                            cardAdapter.notifyDataSetChanged()


                        }


                    }
                }


            }
        }
    }

    fun getSlyhterinCard(number:Long){
        db.collection("SlytherinCards").orderBy("House",
            Query.Direction.DESCENDING).limit(number).addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Toast.makeText(
                    getApplication(),
                    exception.localizedMessage,
                    Toast.LENGTH_LONG
                ).show()
            } else {

                if (snapshot != null) {
                    if (!snapshot.isEmpty) {



                        val documents = snapshot.documents
                        for (document in documents) {
                            val house = document.get("House") as String
                            val name = document.get("Name") as String
                            val point = document.get("Point") as String

                            val card = Card(house, name,point,false)
                            println(card.Name+" "+card.House+" "+card.Point)
                            cardAdapter.cardList.add(card)
                            cardAdapter.cardList.add(card)
                            cardAdapter.cardList.shuffle()
                            cardAdapter.notifyDataSetChanged()


                        }


                    }
                }


            }
        }
    }
    fun getHufflepuffCard(number:Long){
        db.collection("HufflePuffCards").orderBy("House",
            Query.Direction.DESCENDING).limit(number).addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Toast.makeText(
                    getApplication(),
                    exception.localizedMessage,
                    Toast.LENGTH_LONG
                ).show()
            } else {

                if (snapshot != null) {
                    if (!snapshot.isEmpty) {



                        val documents = snapshot.documents
                        for (document in documents) {
                            val house = document.get("House") as String
                            val name = document.get("Name") as String
                            val point = document.get("Point") as String

                            val card = Card(house, name,point,false)
                            println(card.Name+" "+card.House+" "+card.Point)
                            cardAdapter.cardList.add(card)
                            cardAdapter.cardList.add(card)
                            cardAdapter.cardList.shuffle()
                            cardAdapter.notifyDataSetChanged()


                        }


                    }
                }


            }
        }
    }
    fun getRavenclawCard(number:Long){
        db.collection("RavenclawCards").orderBy("House",
            Query.Direction.DESCENDING).limit(number).addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Toast.makeText(
                    getApplication(),
                    exception.localizedMessage,
                    Toast.LENGTH_LONG
                ).show()
            } else {

                if (snapshot != null) {
                    if (!snapshot.isEmpty) {



                        val documents = snapshot.documents
                        for (document in documents) {
                            val house = document.get("House") as String
                            val name = document.get("Name") as String
                            val point = document.get("Point") as String

                            val card = Card(house, name,point,false)
                            println(card.Name+" "+card.House+" "+card.Point)
                            cardAdapter.cardList.add(card)
                            cardAdapter.cardList.add(card)
                            cardAdapter.cardList.shuffle()
                            cardAdapter.notifyDataSetChanged()


                        }


                    }
                }


            }
        }
    }
    override fun onScoreChanged(score: Int, islem: Boolean) {
        GameFragment().onScoreChanged(score,islem)
    }


}