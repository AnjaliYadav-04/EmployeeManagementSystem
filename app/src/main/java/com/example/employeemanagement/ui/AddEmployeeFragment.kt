package com.example.employeemanagement.ui

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.employeemanagement.R
import com.example.employeemanagement.data.Employee
import com.example.employeemanagement.databinding.FragmentAddEmployeeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEmployeeFragment : Fragment() {

    private var _binding: FragmentAddEmployeeBinding? = null
    private val binding get() = _binding!!
    private val employeeViewModel: EmployeeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddEmployeeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {
            if (validateInputs()) {
                saveEmployee()
            }
        }
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        // Name validation
        if (binding.nameEditText.text.isNullOrEmpty()) {
            binding.nameInputLayout.error = getString(R.string.error_name_required)
            isValid = false
        } else {
            binding.nameInputLayout.error = null
        }

        // Email validation
        val email = binding.emailEditText.text.toString()
        if (email.isEmpty()) {
            binding.emailInputLayout.error = getString(R.string.error_email_required)
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailInputLayout.error = getString(R.string.error_invalid_email)
            isValid = false
        } else {
            binding.emailInputLayout.error = null
        }

        // Phone validation
        val phone = binding.phoneEditText.text.toString()
        if (phone.isEmpty()) {
            binding.phoneInputLayout.error = getString(R.string.error_phone_required)
            isValid = false
        } else if (!TextUtils.isDigitsOnly(phone) || phone.length < 10) {
            binding.phoneInputLayout.error = getString(R.string.error_invalid_phone)
            isValid = false
        } else {
            binding.phoneInputLayout.error = null
        }

        // Designation validation
        if (binding.designationEditText.text.isNullOrEmpty()) {
            binding.designationInputLayout.error = getString(R.string.error_designation_required)
            isValid = false
        } else {
            binding.designationInputLayout.error = null
        }

        // Department validation
        if (binding.departmentEditText.text.isNullOrEmpty()) {
            binding.departmentInputLayout.error = getString(R.string.error_department_required)
            isValid = false
        } else {
            binding.departmentInputLayout.error = null
        }

        return isValid
    }

    private fun saveEmployee() {
        val employee = Employee(
            name = binding.nameEditText.text.toString(),
            email = binding.emailEditText.text.toString(),
            phone = binding.phoneEditText.text.toString(),
            designation = binding.designationEditText.text.toString(),
            department = binding.departmentEditText.text.toString()
        )

        employeeViewModel.insert(employee)
        Toast.makeText(requireContext(), getString(R.string.employee_saved), Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}