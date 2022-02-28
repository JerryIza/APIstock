package com.example.composetdaapp.ui.fragments

import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.composetdaapp.databinding.ChartSettingsFragmentBinding

class ChartSettingsFragment :Fragment() {

    private lateinit var binding: ChartSettingsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ChartSettingsFragmentBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fun rotateText(canvas: Canvas){
            canvas.save();
            canvas.rotate(-90f);


            canvas.restore()

        }







    }



}
