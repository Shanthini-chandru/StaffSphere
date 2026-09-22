import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


/* To Do Methods:


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

    //2.Remove employee by id
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
     void searchEmployee(int id){
        Employee found = employeeMap.get(id);
        if(found != null){
            System.out.println("Found Employee: "+found.getName());
        }else {
            System.out.println("No employee found with ID: "+id);
        }
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
    void getEmployeesByDepartment(){
        Map<String , List<Employee>> group = new HashMap<>();
        for (Employee e:employees){
            group.computeIfAbsent(e.getDepartment().toString(), k -> new ArrayList<>()).add(e);
        }
        for( Map.Entry<String, List<Employee>> entry: group.entrySet()){
            System.out.println("Department: "+entry.getKey()+"--> "+entry.getValue());
        }

    }

    //7. Sort by salary
    void sortBySalary(){
      employees.sort(Comparator.comparing(Employee::getSalary));

    }

    //8. Sort by name
    void  sortByName(){
        System.out.println("8. Name Sorting : ");
        System.out.println("-----------------");
        employees.sort(Comparator.comparing(Employee::getName));
        for(Employee e: employees){
            System.out.println(e.getName() +" --> "+e.getDepartment()+" --> "+e.getSalary()+" --> "+e.getId());
        }
    }

    //9. Find highest-paid employee
    void getHighpaidEmployee(){
       Optional<Employee> maxSalary =  employees.stream()
               .filter(e-> e.getSalary()!=null)
                .max(Comparator.comparing(Employee::getSalary));

        maxSalary.ifPresent(employee -> System.out.println("Highest Paid Employee: " + employee.getName() + " with the salary of " + employee.getSalary()));

    }

    //10. Find duplicate names
    void findDuplicateNames(){
        Map<String, Integer> nameCounter = new HashMap<>();

        for(Employee e:employees){
                nameCounter.put(e.getName(),nameCounter.getOrDefault(e.getName(),0)+1);
        }

        nameCounter.entrySet().stream()
                .filter(entry -> entry.getValue() >1)
                .forEach(entry->System.out.println("Duplicate: "+entry.getKey()));


    }

    //11. Count employees by department
    void countEmployeeByDepartment() {
        Map<Department,Integer> deptCount= new HashMap<>();

        for(Employee e:employees){
            deptCount.put(e.getDepartment(), deptCount.getOrDefault(e.getDepartment(),0)+1);
        }
        for( Map.Entry<Department, Integer> e: deptCount.entrySet()){
            System.out.println(e.getKey()+ " has count of: "+e.getValue()+"  Employee(s).");
        }
    }

    //12. Find top 3 highest-paid employees
    void find3MostPaidEmployee(){
        employees.stream()
                .sorted((e1,e2)->e2.getSalary().compareTo(e1.getSalary()))
                .limit(3)
                .forEach(System.out::println);
    }

    //13. Find employees earning between X and Y
    void getEmployeeFromSalaryRange(BigDecimal min, BigDecimal max){
        employees.stream()
                .filter(e -> e.getSalary() != null
                        && e.getSalary().compareTo(min) >= 0
                        && e.getSalary().compareTo(max) <= 0)
                .forEach(e ->System.out.println("From the range: "+min+" "+max+" Employees "+e.getName()+ "Found & Salary is "+e.getSalary()));

    }

    //14. Group employees by department
    Map<Department, List<Employee>> groupByDepartment(){
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                ;
    }

    //15. Display employees in alphabetical order
    void sortName(){
        employees.
                stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName()))
                .forEach(System.out::println);

    }







}

