package pro.sky.HomeworkList;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface HWListInterface {
    Employee add(@RequestParam(value = "firstName") String firstName,
                 @RequestParam(value = "lastName") String lastName);

    Employee remove(@RequestParam(value = "firstName") String firstName,
                    @RequestParam(value = "lastName") String lastName);

    Employee find(@RequestParam(value = "firstName") String firstName,
                  @RequestParam(value = "lastName") String lastName);

    List print();
}
