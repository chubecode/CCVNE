package com.chubecode.ccvne.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.chubecode.ccvne.R
import com.chubecode.ccvne.data.model.News

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model = ViewModelProviders.of(this)[MainViewModel::class.java]
        model.getNews().observe(this, Observer<List<News>>{ news ->
            // update UI
        })
    }
}
