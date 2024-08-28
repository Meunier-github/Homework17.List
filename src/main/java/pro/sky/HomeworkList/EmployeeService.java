package pro.sky.HomeworkList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.HomeworkList.Exception.EmployeeAlreadyAddedException;
import pro.sky.HomeworkList.Exception.EmployeeNotFoundException;
import pro.sky.HomeworkList.Exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements HWListInterface {
    List<Employee> employees = new ArrayList<>();
    final int MAX_COUNT_EMPLOYEES = 5;

    public Employee add(@RequestParam(value = "firstName") String firstName,
                        @RequestParam(value = "lastName") String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {

        if (employees.size() > MAX_COUNT_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee remove(@RequestParam(value = "firstName") String firstName,
                           @RequestParam(value = "lastName") String lastName) {


        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee find(@RequestParam(value = "firstName") String firstName,
                         @RequestParam(value = "lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List print() {
        return employees;
    }

}
