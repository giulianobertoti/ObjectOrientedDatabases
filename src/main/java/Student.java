import org.zoodb.api.impl.ZooPC;

public class Student extends ZooPC{
	
	private String userName;
	private String password;
	private String name;
	private int ra;
	
	public Student(){
		
	}
	
	public Student(String userName, String password, String name, int ra) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.ra = ra;
	}

	public String getUserName() {
		zooActivateRead();
		return userName;
	}

	public void setUserName(String userName) {
		zooActivateWrite();
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}
	
	

}
