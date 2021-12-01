package com.example.calculator

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate

import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.theme.*


class ThemeDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.theme, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        close_opt.setOnClickListener {
            dismiss()
        }

        apply_opt.setOnClickListener {
            when {
                light_theme_button.isChecked -> {
                    setTheme("light")
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    dismiss()

                }
                dark_theme_button.isChecked -> {
                    setTheme("dark")
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    dismiss()
                }
                system_theme_button.isChecked -> {
                    setTheme("system")
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    dismiss()
                }
            }
        }
    }

    private fun setTheme(theme: String) {
        val prefs = context?.getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val editor = prefs?.edit()
        editor?.apply {
            putString("Theme", theme)
        }?.apply()
    }
}