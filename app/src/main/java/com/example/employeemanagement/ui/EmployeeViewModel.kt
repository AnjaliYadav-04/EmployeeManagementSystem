package com.example.employeemanagement.ui
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.employeemanagement.data.Employee
import com.example.employeemanagement.data.EmployeeRepository
import kotlinx.coroutines.launch


class EmployeeViewModel(private val repository: EmployeeRepository) : ViewModel() {

    val allEmployees = repository.allEmployees.asLiveData()

    fun insert(employee: Employee) = viewModelScope.launch {
        repository.insert(employee)
    }
}

class EmployeeViewModelFactory(private val repository: EmployeeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EmployeeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EmployeeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}