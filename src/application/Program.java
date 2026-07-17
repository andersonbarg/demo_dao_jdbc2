package application;

import model.entities.Department;

public class Program {
	
	void main() {
		
		Department obj = new Department(1, "Books");
		
		IO.println(obj);
	}
}
