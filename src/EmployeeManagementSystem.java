import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

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
            System.out.println("Employee Not Found");
            return false;
        }




    }
     List<Employee> getEmployee(){
         System.out.println("Retrieving Employees!");

        return employees;
    }

}