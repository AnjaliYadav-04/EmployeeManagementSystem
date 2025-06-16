package com.example.employeemanagement.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employeemanagement.R
import com.example.employeemanagement.databinding.FragmentEmployeeListBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.employeemanagement.adapter.EmployeeAdapter
@AndroidEntryPoint
class EmployeeListFragment : Fragment() {

    private var _binding: FragmentEmployeeListBinding? = null
    private val binding get() = _binding!!
    private val employeeViewModel: EmployeeViewModel by viewModels()
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupClickListeners()
        observeEmployees()
    }

    private fun setupRecyclerView() {
        employeeAdapter = EmployeeAdapter()
        binding.employeeRecyclerView.apply {
            adapter = employeeAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupClickListeners() {
        binding.addEmployeeFab.setOnClickListener {
            findNavController().navigate(R.id.action_employeeListFragment_to_addEmployeeFragment)
        }
    }

    private fun observeEmployees() {
        employeeViewModel.allEmployees.observe(viewLifecycleOwner) { employees ->
            employeeAdapter.submitList(employees)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}