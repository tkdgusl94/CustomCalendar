package com.leveloper.infinitecalendar

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.joda.time.DateTime

class CalendarAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

	/* 달의 첫 번째 Day timeInMillis*/
	private var firstDayOfMonth: Long = DateTime().withDayOfMonth(1).withTimeAtStartOfDay().millis

	override fun getItemCount(): Int = Int.MAX_VALUE

	override fun createFragment(position: Int): CalendarFragment {
		val millis = getItemId(position)
		return CalendarFragment.newInstance(millis)
	}

	override fun getItemId(position: Int): Long
			= DateTime(firstDayOfMonth).plusMonths(position - START_POSITION).millis

	override fun containsItem(itemId: Long): Boolean {
		val date = DateTime(itemId)
		return date.dayOfMonth == 1
				&& date.hourOfDay == 0
				&& date.minuteOfHour == 0
				&& date.secondOfMinute == 0
	}

	companion object {
		const val START_POSITION = Int.MAX_VALUE / 2
	}
}