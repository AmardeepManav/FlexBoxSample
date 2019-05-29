package com.flexboxsample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import com.flexboxsample.R
import com.flexboxsample.adapters.ChooseMoodAdapter
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import kotlinx.android.synthetic.main.activity_mood_choose.*

class MoodChooseActivity : AppCompatActivity(), ChooseMoodAdapter.ClickListener {

    private lateinit var listItems: List<String>
    private lateinit var selectedItemList: ArrayList<String>
    private lateinit var adapter: ChooseMoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood_choose)
        listItems = getList()
        selectedItemList = ArrayList()
        adapter = ChooseMoodAdapter(listItems, this)
        choose_mood_recycler_view.layoutManager = FlexboxLayoutManager(applicationContext, FlexDirection.ROW)
        choose_mood_recycler_view.adapter = adapter

        next_btn.setOnClickListener {
            var list = ""
            for (i in selectedItemList.indices) list += selectedItemList[i] + " "
            if (selectedItemList.size >= 3) {
                Toast.makeText(this, list, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, getString(R.string.select_more_than_three), Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onItemClickLister(name: CheckBox, postion: Int) {
        if (name.isChecked) {
            selectedItemList.add(listItems[postion])
        } else {
            selectedItemList.remove(listItems[postion])
        }
    }


    private fun getList(): List<String> {
        return listOf(
            "Hindi", "English ", "Cheerful", "Good", "Peaceful ", "Sad", "Stressed",
            "Bad ", "Cranky", "Flirty", "Energetic ", "Joyful", "Loving"
        )
    }
}
