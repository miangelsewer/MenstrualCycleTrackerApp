package com.example.menstrualcycleapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Define a data class to hold your cycle entry data
data class CycleEntry(val date: Date)

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private lateinit var entryCountText: TextView
    private lateinit var lastPeriodText: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        entryCountText = view.findViewById(R.id.entry_count)
        lastPeriodText = view.findViewById(R.id.last_period)

        val entries = getCycleEntries() // Replace with your actual data source
        entryCountText.text = "Total Entries: ${entries.size}"

        val lastDate = entries.maxByOrNull { it.date }?.date
        if (lastDate != null) {
            val formattedDate = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(lastDate)
            lastPeriodText.text = "Last Period: $formattedDate"
        } else {
            lastPeriodText.text = "Last Period: N/A"
        }
    }

    // Replace this with your actual data source logic
    private fun getCycleEntries(): List<CycleEntry> {
        // For demonstration, returning a list of sample entries
        return listOf(
            CycleEntry(Date(1672531200000)), // Jan 1, 2023
            CycleEntry(Date(1675209600000)), // Feb 1, 2023
            CycleEntry(Date(1677628800000))  // Mar 1, 2023
        )
    }
}