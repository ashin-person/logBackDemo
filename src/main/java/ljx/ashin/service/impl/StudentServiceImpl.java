package ljx.ashin.service.impl;

import ljx.ashin.bean.Student;
import ljx.ashin.dao.StudentDao;
import ljx.ashin.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by AshinLiang on 2017/7/10.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    public Student findStudentById(int id) {
        logger.debug("debug级别需要查询的学生Id为:{}",id);
        logger.info("info级别需要查询的学生Id为:{}",id);
        logger.error("erro级别需要查询的学生Id为:{}",id);
        Student student = studentDao.findStudentById(id);
        logger.info("查询出来的学生信息为:{}",student);
        return student;
    }
}
