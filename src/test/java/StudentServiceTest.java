import ljx.ashin.bean.Student;
import ljx.ashin.service.StudentService;
import org.junit.Test;

import javax.annotation.Resource;

public class StudentServiceTest extends BaseTest{
	
	@Resource
	StudentService studentServiceImpl;
	
	@Test
	public void test01(){
		Student student = new Student();
		student.setId(1);
		System.out.println(studentServiceImpl.findStudentById(1));
	}

}
