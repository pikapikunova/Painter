package com.example.boxpainter.ui.main

import android.graphics.Point
import android.graphics.PointF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.boxpainter.MainActivity
import com.example.boxpainter.R
import com.example.boxpainter.data
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment()
{
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {


        return inflater.inflate(R.layout.main_fragment, container, false)



    }

    /*override fun onSaveInstanceState(outState: Bundle, dbHelper: DBHelper, rectangles: MutableList<Rectangle>) {
        dbHelper.addRow(rectangles.last().left, rectangles.last().right, rectangles.last().top, rectangles.last().bottom)
        outState.putFloat(rectangles.last().left, dbHelper.)

        super.onSaveInstanceState(outState);
    }*/

    /*override fun onSaveInstanceState(outState: Bundle) {

        //val t = box.giveCurRect().retPoint()[0]

        val list = (activity as MainActivity).dbHelper.getAllValues()
        for(i in 1..list.size step 4) {
            val t = Rectangle(PointF(list[i].pointLeftBottom, list[i + 1].pointLeftTop))
            box.rectangles.add(t)
        }

        /*val list = box.giveCurRect()
        for(i in list)
            (activity as MainActivity).dbHelper.addRow(i.retPoint()[0], i.retPoint()[1], i.retPoint()[2], i.retPoint()[3])
        outState.putBundle(tt, outState)
*/
        /*outState.putFloat( box.giveCurRect().left.toString(), left)
        outState.putFloat( box.giveCurRect().right.toString(), right)
        outState.putFloat( box.giveCurRect().top.toString(), Top)
        outState.putFloat( box.giveCurRect().bottom.toString(), Bottom)
*/

        //button2.text = left.toString()
        super.onSaveInstanceState(outState);

    }
*/




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}