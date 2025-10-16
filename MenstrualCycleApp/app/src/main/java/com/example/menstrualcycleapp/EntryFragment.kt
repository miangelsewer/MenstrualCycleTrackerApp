package com.example.menstrualcycleapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EntryFragment : Fragment(R.layout.fragment_entry) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CycleAdapter
    private lateinit var dao: CycleDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = CycleAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        dao = AppDatabase.getDatabase(requireContext()).cycleDao()
        dao.getAllEntries().observe(viewLifecycleOwner, Observer { entries ->
            adapter.submitList(entries)
        })
    }
}