# bank
Bank management system with ATM , JAVA GUI project, mySQL, awt,swing
It provides a user-friendly graphical interface for various banking functionalities such as user registration, login, balance inquiry, deposit, withdrawal, PIN change, and mini statement. The project leverages Java's Swing and AWT libraries for the graphical user interface and MySQL for the backend database management.
Features

    User Registration: Users can sign up with their personal details and create an account.

    Login: Registered users can securely log in using their account credentials.

    Balance Inquiry: Users can check their account balance.

    Deposit: Users can make deposits into their accounts, and transaction records are maintained.

    Withdrawal: Users can make withdrawals from their accounts, and transaction records are updated.

    PIN Change: Users can change their account PIN for added security.

    Mini Statement: Users can view the latest 5 transactions made on their account.

Technologies Used

    Java: Core programming language for application logic.
    Swing and AWT: Java libraries for creating the graphical user interface.
    MySQL: Database management system for storing user account details and transaction history.

Getting Started

    Clone the repository to your local machine.
    Set up the database by running the provided SQL script to create the required tables.Add username and password
    Configure the database connection details in the application code.
    Compile and run the application.
    Tables-
    CREATE TABLE signup (
    formno INT PRIMARY KEY,
    name VARCHAR(50),
    fname VARCHAR(50),
    dob DATE,
    gender VARCHAR(10),
    email VARCHAR(100),
    marital VARCHAR(20),
    address VARCHAR(200),
    city VARCHAR(50),
    pincode VARCHAR(10),
    state VARCHAR(50)
  );
  CREATE TABLE signuptwo (
    formno INT PRIMARY KEY,
    religion VARCHAR(50),
    category VARCHAR(50),
    income VARCHAR(50),
    education VARCHAR(100),
    occupation VARCHAR(100),
    pan VARCHAR(50),
    aadhar VARCHAR(50),
    scitizen VARCHAR(10),
    eaccount VARCHAR(100)
   );
   CREATE TABLE signupthree (
    formno INT PRIMARY KEY,
    accountType VARCHAR(50),
    cardnumber VARCHAR(25),
    pin VARCHAR(10),
    facillity VARCHAR(200)
);
CREATE TABLE login (
    formno INT PRIMARY KEY,
    cardnumber VARCHAR(25),
    pin VARCHAR(10)
);
CREATE TABLE bank (
 cardnumber VARCHAR(25),
    pin VARCHAR(10),
    date DATE,
    type VARCHAR(20),
    amount DOUBLE
);
------



    

<br>

![image](https://github.com/adarshal/bank/assets/89533221/6fa9eadf-2e0a-43cb-9b9e-4108998405ee)
<br>
![image](https://github.com/adarshal/bank/assets/89533221/f1d375bd-eaf7-4b1b-a07c-7096572221de)

<br>

![image](https://github.com/adarshal/bank/assets/89533221/167c23dc-28f6-4cb0-9f62-890be082b213)

<br>
<h1>ATM</h1>

![image](https://github.com/adarshal/bank/assets/89533221/f7dd444d-b08f-48e2-b53c-85f7ce94974f)

<br>

![image](https://github.com/adarshal/bank/assets/89533221/4092a13e-ed94-446f-b576-35a76980951d)

<br>

![image](https://github.com/adarshal/bank/assets/89533221/d4282533-b8e9-4d3c-9f37-d5165594f2d6)

<br>


![image](https://github.com/adarshal/bank/assets/89533221/4da3412f-26ac-46e6-a3fb-bc2b3790955e)





