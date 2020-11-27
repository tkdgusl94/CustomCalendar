package com.leveloper.infinitecalendar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leveloper.infinitecalendar.utils.CalendarUtils.Companion.getMonthList
import kotlinx.android.synthetic.main.fragment_calendar.view.*
import org.joda.time.DateTime

class CalendarFragment : Fragment() {

    private var millis: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            millis = it.getLong(MILLIS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)

        view.millis.text = DateTime(millis).toString("yyyy-MM")
        view.calendarView.initCalendar(DateTime(millis), getMonthList(DateTime(millis)))

        return view
    }

    companion object {

        private const val MILLIS = "MILLIS"

        fun newInstance(millis: Long) = CalendarFragment().apply {
            arguments = Bundle().apply {
                putLong(MILLIS, millis)
            }
        }
    }
}