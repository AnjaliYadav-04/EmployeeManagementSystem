package com.example.employeemanagement

import android.app.Application
import com.example.employeemanagement.data.AppDatabase
import com.example.employeemanagement.data.EmployeeRepository

//@HiltAndroidApp
class EmployeeManagementApp : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { EmployeeRepository(database.employeeDao()) }
}