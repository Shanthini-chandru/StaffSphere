import java.math.BigDecimal;
import java.util.*;

/* To Do Methods:

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

    //1. Add new Employee
     void addEmployee(Employee e){
        employees.add(e);
        employeeMap.put(e.getId(),e);
        System.out.println("Employee ("+e.getName()+") added!");
    }

    //2.Remove emloyee by id
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

     //3. Search employee
     Employee searchEmployee(int id){
        Employee found = employeeMap.get(id);
        if(found != null){
            System.out.println("Found Employee: "+found.getName());
        }else {
            System.out.println("No employee found with ID: "+id);
        }
        return found;
    }


    //4. Update employee
    Employee updateEmployee(int id,BigDecimal salary){
        Employee found = employeeMap.get(id);
        if(found != null){
            //removing old entry from the list
            employees.remove(found);
            //updating the HashMap
            found.setSalary( new BigDecimal(found.getSalary().intValue()+salary.intValue()));
            //adding new list entry with updates salary
            employees.add(found);
            System.out.println("The Employee "+found.getName()+"got salary apprisal, current salary: "+found.getSalary());
            return found;
        }else {
            System.out.println("Update Failed");
            return null;
        }
    }

    //5. List all employees
    List<Employee> getEmployee(){
            System.out.println("Retrieving Employees!");
            return employees;
    }

    //6. List employees by department
    Map<String , List<Employee>> getEmployeesByDepartment(){
        Map<String , List<Employee>> group = new HashMap<>();
        for (Employee e:employees){
            group.computeIfAbsent(e.getDepartment().toString(), k -> new ArrayList<>()).add(e);
        }
        for( Map.Entry<String, List<Employee>> entry: group.entrySet()){
            System.out.println("Department: "+entry.getKey()+"--> "+entry.getValue());
        }

        return group;

    }





}

