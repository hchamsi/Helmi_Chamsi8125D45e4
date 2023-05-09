package tn.myapplication.spring;

import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.myapplication.spring.entity.Class;
import tn.myapplication.spring.entity.Student;
import tn.myapplication.spring.entity.Teacher;
import tn.myapplication.spring.repository.StudentRepository;
import tn.myapplication.spring.utils.BaseJUnit49TestCase;


public class StudentTest extends BaseJUnit49TestCase{
	private static final Logger LOG = LogManager.getLogger(StudentTest.class);

	@Autowired
	StudentRepository stdRepoistory;
	
	private Student student;
	private Class classe; 
	private Teacher teacher;

	
	@Override
    public void setUp() throws Exception {
        super.setUp();
        this.student = new Student();
        
        this.student.setFirstName("Helmi");
        this.student.setLastName("Chamsi");
       
        this.classe = new Class();
        this.classe.setName("4éme");
        
        this.teacher= new Teacher();
        this.teacher.setFirstName("Majd");
        this.teacher.setLastName("Chaieb");
        
        this.classe.setTeacher(teacher);

        this.student.setStudentClass(this.classe);

   
    }
	
	@Test
    public void tests() throws ParseException {
		getallStudentTest();

        LOG.info("TEST OF STUDENT FINISHED SUCCESSFULY");
    }


	
	public void getallStudentTest() {
		LOG.info("--------------------- Start Method GET Students ------------------------");
		LOG.debug(this.student);
		Assert.assertTrue(!stdRepoistory.findAll().isEmpty());
		LOG.info("get all Students has been Added successfly");
		LOG.info("--------------------- End Method GET Students --------------------------");
	}
	
	public void addStudentTest() {
	}
	
	public void deleteStudentTest() {
	}

}
