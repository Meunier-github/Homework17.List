package pro.sky.HomeworkList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/employee")

public class HWListController {
    private final HWListInterface EmployeeService;


    public HWListController(HWListInterface EmployeeService) {
        this.EmployeeService = EmployeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam(value = "firstName") String firstName,
                        @RequestParam(value = "lastName") String lastName) {

        return EmployeeService.add(firstName, lastName);

    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam(value = "firstName") String firstName,
                           @RequestParam(value = "lastName") String lastName) {
        return EmployeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam(value = "firstName") String firstName,
                         @RequestParam(value = "lastName") String lastName) {
        return EmployeeService.find(firstName, lastName);
    }

    @GetMapping(path = "/print")
    public List print() {
        return EmployeeService.print();
    }


}
