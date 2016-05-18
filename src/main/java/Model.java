
import javax.jdo.Extent;
import javax.jdo.PersistenceManager;

import org.zoodb.jdo.ZooJdoHelper;

public class Model {
	
	private static final String DB_FILE = "bd\\studentsss.zdb";
	private PersistenceManager db;

	
	
	//recording Student you record all agregations and other attributes
	public void addStudent(Student student){
		db = ZooJdoHelper.openOrCreateDB(DB_FILE);
		db.currentTransaction().begin();
		
		db.makePersistent(student);
		
		db.currentTransaction().commit();
		db.close();
		db = null;
		
	}
	
	//Extent is faster
	public Extent<Student> getAllStudents(){
		db = ZooJdoHelper.openOrCreateDB(DB_FILE);
		db.currentTransaction().begin();
		
		Extent<Student> students = db.getExtent(Student.class);
		
		
		return students;
	}
	
	public Student searchStudentByRA(int ra){
		db = ZooJdoHelper.openOrCreateDB(DB_FILE);
		db.currentTransaction().begin();
		
		Extent<Student> students = db.getExtent(Student.class);
		for(Student student:students){
			if(student.getRa()==ra){
				closeDB();
				
				return student;
			}
		}
		return null;
	}
	
    private void closeDB() {
        if (db.currentTransaction().isActive()) {
            db.currentTransaction().rollback();
        }
        db.close();
        db.getPersistenceManagerFactory().close();
    }
	
}
