package pro.sky.HomeworkList;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface HWListInterface {
    Employee add(String firstName,String lastName);

    Employee remove(String firstName,String lastName);

    Employee find(String firstName,String lastName);

    List print();
}
