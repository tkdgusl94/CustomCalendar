package com.leveloper.infinitecalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var calendarAdapter: CalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calendarAdapter = CalendarAdapter(this)

        calendar.adapter = calendarAdapter
        calendar.setCurrentItem(CalendarAdapter.START_POSITION, false)
    }
}