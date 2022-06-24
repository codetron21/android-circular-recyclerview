package com.codetron.circularrecyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.list_name).apply {
            adapter = NameAdapter()
            LinearSnapHelper().attachToRecyclerView(this)
            addItemDecoration(NameItemDecoration {
                Log.d("MainAct", it)
                name = it
            })
            scrollToPosition(Integer.MAX_VALUE / 2)
        }

        findViewById<Button>(R.id.button_get).setOnClickListener {
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        }

    }
}