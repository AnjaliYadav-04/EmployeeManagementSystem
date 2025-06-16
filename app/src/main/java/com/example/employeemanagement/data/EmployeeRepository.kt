package com.example.employeemanagement.data

class EmployeeRepository(private val employeeDao: EmployeeDao) {
    val allEmployees = employeeDao.getAllEmployees()

    suspend fun insert(employee: Employee) {
        employeeDao.insertEmployee(employee)
    }
}