package ljx.ashin.controller;

import ljx.ashin.bean.Student;
import ljx.ashin.service.StudentService;
import ljx.ashin.utils.PropertiesUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by AshinLiang on 2017/7/12.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    StudentService studentService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping("/getStudentInfo.controller")
    public String getStudentInfo(String id, Model model){
        Student student = new Student();
//        logger.debug("debug msg");
        id="1";
        logger.info("查询学生详细信息的controller");
//        logger.info("获取的jdbc.url为:{}", PropertiesUtils.getPropertiesValue("jdbc.url","jdbc.properties"));
        if(StringUtils.isNotEmpty(id)){
            student = studentService.findStudentById(Integer.valueOf(id));
            model.addAttribute("student",student);
        }
        return "index";
    }
}
