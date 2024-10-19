import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class EmployeeBean {
    private List<Employee> employees;

    public EmployeeBean() {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "John", "HR"));
        employees.add(new Employee(2, "Jane", "Finance"));
        employees.add(new Employee(3, "Alice", "IT"));
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
