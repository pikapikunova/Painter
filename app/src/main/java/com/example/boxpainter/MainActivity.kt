package com.example.boxpainter

import android.graphics.Canvas
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.boxpainter.ui.main.BoxDrawingView
import com.example.boxpainter.ui.main.MainFragment
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_fragment.*


class MainActivity : AppCompatActivity() {
    val dbHelper = DBHelper(this)



    override fun onCreate(savedInstanceState: Bundle?) {
        //dbHelper.writableDatabase.delete("rectangles", null, null)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, MainFragment.newInstance())
                    .commitNow()

        }

        button2.setOnClickListener {
            val list = dbHelper.getAllValues()

            for(i in list)
                textView2.append(i.pointLeftBottom.toString()+ ' ' + i.pointRightTop.toString()+ ' ' +i.pointLeftTop.toString()+ ' ' +i.pointRightBottom.toString())
                textView2.minLines


        }

    }

    override fun onDestroy() {
        val list = box.giveCurRect()
        for(i in list)
            dbHelper.addRow(i.retPoint()[0], i.retPoint()[1], i.retPoint()[2], i.retPoint()[3])
        super.onDestroy()
    }



}