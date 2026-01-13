[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/jUhpgoi-)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22207069)
# AP CSA Project: Weekly Data Analyzer  

---

## 📌 Project Overview

In this project, you will design and build a **Weekly Data Analyzer** in Java. Your program will allow a user to enter **7 days of data** for something meaningful to them—such as steps taken, hours of sleep, money spent, mood ratings, screen time, or another approved idea.

Your program will store this data in an **array**, analyze it using **array algorithms**, and present useful results to the user. You will apply **object-oriented programming (OOP)** principles by creating a custom data class that encapsulates both the data and the logic used to analyze it.

This project simulates how developers build **reusable, well-structured code** that separates:
- Data storage  
- Data processing  
- User interaction  

---

## 🎯 Learning Goals

By completing this project, you will demonstrate that you can:

- Declare and use arrays to store related data  
- Develop array algorithms (total, average, minimum, maximum, etc.)  
- Apply encapsulation using private instance variables and public methods    
- Write clean, readable Java code with clear method responsibilities  
- Format output for readability  

---

## 🧠 Choose Your Data Theme

You may choose **any type of weekly data**, as long as it meets the project requirements.

### Example Ideas  
(You may use these or create your own)

- Step Counter (steps per day)  
- Sleep Tracker (hours of sleep per night)  
- Budget Analyzer (money spent per day)  
- Study Time Tracker (minutes studied per day)  
- Mood Tracker (ratings 1–10)  
- Screen Time Tracker (hours per day)  
- etc

---

## 🧩 Program Structure & Requirements

Your project must include **two main classes**.

---

## 📦 Data Class (Your Custom Class)

You may name this class based on your project theme  
(e.g., `StepData`, `SleepData`, `BudgetData`, etc.)

### 🔒 Instance Variables (private)

- An array representing **7 days of data**
- Additional instance variables as needed (e.g., total, min, max)

---

### 🏗 Constructor

- Accepts an array as a parameter  
- Creates an internal array of the same size  
- Copies values into the internal array  

⚠️ **Do NOT use reference aliasing**  
(The internal array must be a deep copy.)

---

### ✅ Required Methods

Your class **must** include methods that calculate:

- `getTotal()`  
- `getAverage()`  
- `getHighest()` (maximum)  
- `getLowest()` (minimum)  

You may include additional methods if they make sense for your data.

---

### 🖨 `toString()` Method

- Returns a **multi-line `String`**
- Displays all **7 days of data**
- Values should be formatted **clearly and consistently**

---

## 🧪 Main Class (User Interaction & Testing)

The `Main` class is responsible for:

- Creating an array for **7 days of data**
- Prompting the user for input using a `for` loop  
- Validating input using a `while` loop (no invalid values allowed)  
- Creating an object of your Data class  
- Calling methods to display results clearly  

---

## 📋 Required Output

Your program must display:

- Total for the week  
- Average per day  
- Highest value  
- Lowest value  
- All daily values (using `toString()`)
- Valuable insights the user would want about their data

All numeric output should be **formatted appropriately**  
(e.g., two decimal places if needed).

---

## ✅ Project Checklist

Before submitting, confirm that:

- [ ] You used an array to store 7 days of data  
- [ ] The array is private and encapsulated in a class  
- [ ] All calculations use loops (no hard-coded math)  
- [ ] Input is validated using a `while` loop 
- [ ] Methods return correct results for typical and edge cases  
- [ ] Output is clean, readable, and clearly labeled  
- [ ] Code compiles and runs without errors
- [ ] Code is appriately commented with JavaDoc comments 

---

## 🛠 How to Run the Project

1. Accept the assignment in GitHub classroom
2. Open the project codespaces or clone repository using GitHub Deskopt / VS Code
3. Complete your **Data class** first  
4. Implement the **Main class** to test your logic  
5. Run the program and verify correct output  

---

## 🧪 Sample Output  
### Example: Step Tracker
Enter steps for day 1: 8500
Enter steps for day 2: 10000
Enter steps for day 3: 9200
Enter steps for day 4: 11000
Enter steps for day 5: 7000
Enter steps for day 6: 12000
Enter steps for day 7: 9800

Weekly Summary:
Total Steps: 66,500
Average Steps: 9,500.00
Highest Day: 12,000
Lowest Day: 7,000

All Daily Values:
Day 1: 8,500
Day 2: 10,000
Day 3: 9,200
Day 4: 11,000
Day 5: 7,000
Day 6: 12,000
Day 7: 9,800

Results:
You met your goal 3 days this week!
Next week, try to go for a walk after school

---

## 🌟 Optional Extensions (Extra Challenge)

- Add a method like `getMedian()` or `getDayOfHighest()`  
- Allow the user to choose the number of days  
- Label days by name (Mon–Sun)  
- Track multiple weeks using a **2D array**  
- Add a simple menu system  

---

## 📄 Submission Instructions

You must:

- Push your completed code to this GitHub repository  
- Update this README to include:
  - Your name  
  - Your chosen project theme  
  - A short description of your program



