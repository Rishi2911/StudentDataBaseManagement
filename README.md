# Student Database Management System

## Overview

This Java program implements a simple Student Database Management System. It allows users to perform various operations related to student information, including adding students, viewing the list of students, searching for a specific student, calculating the average marks of all students, and exiting the program.

## Features

1. **Add Student**
   - Users can input details such as name, roll number, age, and marks for a new student.
   - Roll numbers are validated to ensure uniqueness within the database.
   - Negative marks are not allowed, and a custom exception (`NegativeMarksException`) is thrown if encountered.

2. **View Students**
   - Displays a list of all students in the database with their details.

3. **Search Student**
   - Allows users to search for a specific student by entering their roll number.
   - If found, displays the details of the student; otherwise, notifies the user that the student was not found.

4. **Calculate Average Marks**
   - Computes and displays the average marks of all students in the database.

5. **Exit**
   - Allows users to exit the program.

## Usage

1. Compile the program using a Java compiler:

   ```bash
   javac StudentDatabase.java
   
