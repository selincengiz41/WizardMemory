package com.selincengiz.wizardmemory.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.selincengiz.wizardmemory.R
import com.selincengiz.wizardmemory.databinding.FragmentGameSettingsBinding

class GameSettingsFragment : Fragment(R.layout.fragment_game_settings) {

    private var fragmentBinding: FragmentGameSettingsBinding? = null
    private var gameDifficulty: Long? = null
    private var numberOfPlayer: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentGameSettingsBinding.bind(view)
        fragmentBinding = binding

        binding.singlePlayer.setOnClickListener {
            binding.singlePlayer.visibility = View.GONE
            binding.multiplePlayer.visibility = View.GONE
            binding.easy.visibility = View.VISIBLE
            binding.middle.visibility = View.VISIBLE
            binding.hard.visibility = View.VISIBLE
            numberOfPlayer=1

        }

        binding.multiplePlayer.setOnClickListener {
            binding.singlePlayer.visibility = View.GONE
            binding.multiplePlayer.visibility = View.GONE
            binding.easy.visibility = View.VISIBLE
            binding.middle.visibility = View.VISIBLE
            binding.hard.visibility = View.VISIBLE
            numberOfPlayer=2

        }

        binding.easy.setOnClickListener {
            gameDifficulty=1

            val action =GameSettingsFragmentDirections.actionGameSettingsFragmentToGameFragment(numberOfPlayer!!,gameDifficulty!!)
            Navigation.findNavController(it).navigate(action)
        }
        binding.middle.setOnClickListener {
            gameDifficulty=4
            val action =GameSettingsFragmentDirections.actionGameSettingsFragmentToGameFragment(numberOfPlayer!!,gameDifficulty!!)
            Navigation.findNavController(it).navigate(action)
        }
        binding.hard.setOnClickListener {
            gameDifficulty=9
            val action =GameSettingsFragmentDirections.actionGameSettingsFragmentToGameFragment(numberOfPlayer!!,gameDifficulty!!)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentBinding = null
    }


}