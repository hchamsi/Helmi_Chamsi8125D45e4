package tn.myapplication.spring.dto;

public class StudentDTO {

	private Long id;

	private String firstName;

	private String lastName;

	private String className;

	private String teacherFullName;

	public StudentDTO() {
		super();
	}

	public StudentDTO(Long id, String firstName, String lastName, String className, String teacherFullName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.className = className;
		this.teacherFullName = teacherFullName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTeacherFullName() {
		return teacherFullName;
	}

	public void setTeacherFullName(String teacherFullName) {
		this.teacherFullName = teacherFullName;
	}

}