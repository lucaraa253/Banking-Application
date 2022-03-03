# Banking-Application

# Description
This is a console based banking application that simulates common banking operations. 

# Functionality
Customers are able to create an account, login, apply for a bank account and withdraw/deposit/transfer money.

Employees are able to create an account, login, view all accounts, approve or deny accounts as well as view all transactions.

Most of the functionality was achieved through DAOs, models and APPs
Inside the DAOImpl classes Callable, prepared and regular statements were utilized to communicate with the postgres database

The Login section was handled by using validations and registrations inside the Employee and Customer DAOs

# Technologies used
Maven
JUNIT
Postgres
Java
