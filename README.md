## Prerequisites
- Java JDK (version 8 or higher)
- Maven
- MongoDB installed and running

### Running the Application
1. Clone this repository to your local machine.
2. Navigate to the project directory.
3. Build the project using Maven: `mvn clean install
4. Run the application

## API Documentation

### Add Employee
- **Endpoint:** `/employees`
- **Method:** POST
- **Request Body:** JSON representing the new employee.

### Get All Employees
- **Endpoint:** `/employees`
- **Method:** GET

### Delete Employee by ID
- **Endpoint:** `/employees/{id}`
- **Method:** DELETE

### Update Employee by ID
- **Endpoint:** `/employees/{id}`
- **Method:** PUT
- **Request Body:** JSON representing the updated employee details.

### Get nth Level Manager
- **Endpoint:** `/employees/{employeeId}/manager`
- **Method:** GET
- **Query Parameter:**
  - `level` - Specify the level of the manager.

### Get Employees with Pagination and Sorting
- **Endpoint:** `/employees/paged`
- **Method:** GET
- **Query Parameters:**
  - `page` - Page number
  - `size` - Page size
  - `sortBy` - Field to sort by
