
void main() {
    EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();
    employeeManagementSystem.addEmployee(new Employee(1, "Chan", Department.ENGINEERING, new BigDecimal(80000)));
    employeeManagementSystem.addEmployee(new Employee(2, "Vijay", Department.FINANCE, new BigDecimal(180000)));
    employeeManagementSystem.addEmployee(new Employee(3, "Geetha", Department.SALES, new BigDecimal(90000)));
    employeeManagementSystem.addEmployee(new Employee(4, " Gokul ", Department.MARKETING, new BigDecimal(190000)));
    employeeManagementSystem.removeEmployee(2);
}
