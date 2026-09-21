
void main() {
    EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();
    employeeManagementSystem.addEmployee(new Employee(1, "Chan", Department.ENGINEERING, new BigDecimal(11180000)));
    employeeManagementSystem.addEmployee(new Employee(2, "Vijay", Department.FINANCE, new BigDecimal(180000)));
    employeeManagementSystem.addEmployee(new Employee(3, "Geetha", Department.SALES, new BigDecimal(90000)));
    employeeManagementSystem.addEmployee(new Employee(15, "Sham", Department.SALES, new BigDecimal(90000)));
    employeeManagementSystem.addEmployee(new Employee(16, "Sham", Department.SALES, new BigDecimal(90000)));
    employeeManagementSystem.addEmployee(new Employee(4, "Gokul ", Department.MARKETING, new BigDecimal(190000)));
    employeeManagementSystem.removeEmployee(2);
    System.out.println(employeeManagementSystem.removeEmployee(5));
    System.out.println("List of Employees: "+employeeManagementSystem.getEmployee());
    employeeManagementSystem.searchEmployee(4);
    employeeManagementSystem.searchEmployee(14);
    employeeManagementSystem.updateEmployee(3, BigDecimal.valueOf(2000));
    System.out.println(employeeManagementSystem.updateEmployee(4, BigDecimal.valueOf(2000)));
    System.out.println("List of Employees: "+employeeManagementSystem.getEmployee());
    employeeManagementSystem.getEmployeesByDepartment();
    employeeManagementSystem.sortBySalary();
    employeeManagementSystem.sortByName();
    employeeManagementSystem.getHighpaidEmployee();
    employeeManagementSystem.findDuplicateNames();
    employeeManagementSystem.countEmployeeByDepartment();
    employeeManagementSystem.find3MostPaidEmployee();

}
