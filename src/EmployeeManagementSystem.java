import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* To Do Methods:

4. Update employee
5. List all employees
6. List employees by department
7. Sort by salary
8. Sort by name
9. Find highest-paid employee
10. Find duplicate names
11. Count employees by department
12. Find top 3 highest-paid employees
13. Find employees earning between X and Y
14. Group employees by department
15. Display employees in alphabetical order

*/
public class EmployeeManagementSystem{

    private final List<Employee> employees;
    private final Map<Integer, Employee> employeeMap;

    EmployeeManagementSystem(){
        this.employees = new ArrayList<>();
        this.employeeMap = new HashMap<>();
    }

     void addEmployee(Employee e){
        employees.add(e);
        employeeMap.put(e.getId(),e);
        System.out.println("Employee ("+e.getName()+") added!");
    }

     boolean removeEmployee(int id){

       //boolean remove = employees.removeIf(e -> e.getId() == id);
       //if (!remove) System.out.println("Employee not found"); else System.out.println("Employee got removed!");
        Employee removed = employeeMap.remove(id);
        if(removed!=null){
            String name = removed.getName();
            employees.remove(removed);
            System.out.println("Employee "+name+" got removed!");
            return true;
        }else {
            System.out.println("Employee Not Found, ID : "+id+" doesn't exist");
            return false;
        }
     }

      List<Employee> getEmployee(){
        System.out.println("Retrieving Employees!");
        return employees;
     }

     //3. Search employee
    public Employee searchEmployee(int id){
        Employee found = employeeMap.get(id);
        if(found != null){
            System.out.println("Found Employee: "+found.getName());
        }else {
            System.out.println("No employee found with ID: "+id);
        }
        return found;
    }


}

