

import javax.jdo.Extent;

public class Test {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.addStudent(new Student("joao", "12345", "João Bertoti", 123));
		model.addStudent(new Student("lilian", "12345", "Lilian Bertoti", 321));
		
		
		System.out.println("--busca por ra");
		
		Student student = model.searchStudentByRA(123);
		
		if(student!=null){
			System.out.println(student.getName());
		}
		
		
		System.out.println("--show all students--");
		
		Extent<Student> allStudents = model.getAllStudents();
		System.out.println(allStudents);
		for(Student s : allStudents){
			System.out.println(s.getName());
		}
		
		
		
	}
	
}
