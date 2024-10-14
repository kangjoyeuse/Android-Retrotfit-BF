package com.kangjoyeuse.submissionbfaa2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kangjoyeuse.submissionbfaa2.adapter.EventAdapter
import com.kangjoyeuse.submissionbfaa2.databinding.FragmentHomeBinding
import com.kangjoyeuse.submissionbfaa2.viewmodel.EventViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var eventViewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)

        binding.rvEvents.layoutManager = LinearLayoutManager(context)

        eventViewModel.events.observe(viewLifecycleOwner) { events ->
            binding.rvEvents.adapter = EventAdapter(events)
        }

        eventViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        eventViewModel.error.observe(viewLifecycleOwner) { error ->
            if (error.isNotEmpty()) {
                Toast.makeText(context, error, Toast.LENGTH_LONG).show()
            }
        }

        eventViewModel.getEvents(1) // 1 untuk event aktif
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}