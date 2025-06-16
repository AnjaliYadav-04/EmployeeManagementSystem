📱 Employee Management System – Android App
GitHub Repository
🔗 github.com/AnjaliYadav-04/EmployeeManagementSystem

📖 Overview
Employee Management System is a simple Android application developed using Kotlin that enables users to manage employee records locally. The application provides a user-friendly interface to add and view employee details efficiently.

✅ Features
Add new employee details:
Name
Email
Phone Number
Designation
Department

View a list of all saved employees
Real-time input validation
Data persistence using Room local database
MVVM (Model-View-ViewModel) Architecture
Repository pattern for data handling

🧱 Technical Stack
Component	Technology
Language	Kotlin
IDE	Android Studio (Latest)
Architecture	MVVM
UI	XML with ViewBinding
Database	Room (Local DB)
Min SDK	21 (Android 5.0 - Lollipop)
Target SDK	Latest available version

🔧 Setup Instructions
Clone the Repository

bash
Copy
Edit
git clone https://github.com/AnjaliYadav-04/EmployeeManagementSystem.git
Open in Android Studio

Launch Android Studio.
Select "Open an existing project".
Choose the cloned project folder.
Build the Project
Let Gradle sync automatically.
Resolve any dependencies if prompted.
Run the App
Connect a device or open an emulator.

Click on the green Run ▶️ button.
📲 How to Use the App
➕ Add Employee
Click on the “Add Employee” button (Floating Action Button).
Fill out all required fields:
Name
Email
Phone Number
Designation
Department
Click Save.

Validation will show errors for invalid or incomplete fields.

📋 View Employee List
The home screen displays all saved employees.

Employees are shown in a RecyclerView with basic information.

✅ Validation Rules
Field	Rule
Name	Required, minimum 2 characters
Email	Required, valid email format
Phone	Required, exactly 10 digits
Designation	Required
Department	Required

🗄️ Database Schema
The app uses the Room Database with the following table structure:

kotlin
Copy
Edit
@Entity
data class Employee(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val email: String,
    val phone: String,
    val designation: String,
    val department: String
)
🖼️ Screenshots
Add screenshots in the README or GitHub images/ folder if available:

Employee List Screen
Add Employee Form with Validation

📂 App Screens
1. Employee List Screen
Displays all employees using RecyclerView.

Floating Action Button to open Add Employee screen.

2. Add Employee Screen
Form using TextInputLayout fields.

Save button to validate and store data.

Real-time error messages for validation.

🧪 Testing Instructions
To verify the app functionality:

Try submitting the form with:

Empty fields

Invalid email (e.g., missing '@')

Phone number less than 10 digits

Add multiple employees and verify their appearance in the list.

Rotate the screen to test data persistence.

📌 Future Enhancements (Optional)
(Add this section only if you're planning to extend features later)

Export employee list as PDF/CSV

Edit/Delete employee records

Cloud sync support using Firebase

Search and filter functionality

