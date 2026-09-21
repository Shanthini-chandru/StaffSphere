import java.math.BigDecimal;

public  enum Department{
    HR,
    FINANCE,
    ENGINEERING,
    SALES,
    MARKETING,
    OPERATIONS
}

class Employee {
    private int id;
    private String name;
    private Department department;
    private BigDecimal salary;

    public Employee(int id, String name, String department, BigDecimal salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    //Getter and Setter
    public int getId{ return id; }
    public String getName() { return name; }
    public Department getDepartment() { return department; }
    public BigDecimal getSalary() {return salary; }

    public void setName(String name){this.name = name;}
    public void setDepartment(Department department){ this.department = department; }
    public void setSalary(BigDecimal salary){ this.salary = salary; }

    public String toString(){
        return id+ " _ " + name + " ( "+ department + " ) "+ salary;
    }
}