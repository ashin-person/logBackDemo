package ljx.ashin.service;

import ljx.ashin.bean.Student;
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
/*
	@Test
	public void test02(){
		List<Student> list = new ArrayList<Student>();
		Student s1 = new Student();
		s1.setId(298);
		s1.setName("test249");
		s1.setSal(439D);
		
		Student s2 = new Student();
		s2.setId(299);
		s2.setName("test299");
		s2.setSal(489D);
		
		list.add(s1);
		list.add(s2);
		
		System.out.println(studentServiceImpl.addStudents(list));

	}*/

}
