package com.selincengiz.wizardmemory.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.selincengiz.wizardmemory.R
import com.selincengiz.wizardmemory.adapter.CardAdapter
import com.selincengiz.wizardmemory.databinding.FragmentGameBinding
import com.selincengiz.wizardmemory.viewmodel.GameViewModel
import com.selincengiz.wizardmemory.viewmodel.LoginViewModel
import com.selincengiz.wizardmemory.viewmodel.RegisterViewModel

class GameFragment :Fragment(R.layout.fragment_game)  {

    private val binding get() = fragmentBinding!!
    private var fragmentBinding :FragmentGameBinding? =null
    private var gameDifficulty: Long? = null
    private var numberOfPlayer: Int? = null
    private lateinit var viewModel: GameViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        fragmentBinding= FragmentGameBinding.bind(view)

        arguments?.let {
            gameDifficulty= GameFragmentArgs.fromBundle(it).gameDifficulty
            numberOfPlayer=  GameFragmentArgs.fromBundle(it).numberOfPlayer
        }
        viewModel =
            ViewModelProvider(this@GameFragment)[GameViewModel::class.java]


        val spanCount =gameDifficulty!!.toInt()*4

        binding.recyclerView.layoutManager= GridLayoutManager(context,spanCount)
        binding.recyclerView.adapter= viewModel.dataReceiver(gameDifficulty!!)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentBinding = null
    }

     fun onScoreChanged(score: Int, islem: Boolean) {

      /*  var current= binding.score.text.toString().toInt()
        var sum =0
        if(islem){
            sum =current+score
        }
        else{
            sum =current-score
        }


         binding.score.text=sum.toString()*/
    }
}