package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
	void main() {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		IO.println("=== TEST 1: Department findById ===");
		Department department = departmentDao.findById(3);
		IO.println(department);

		IO.println("\n=== TEST 2: Department findAll ===");
		List<Department> list = departmentDao.findALL();
		list.forEach(System.out::println);

		IO.println("\n=== TEST 3: Department insert ===");
		Department newDepartment = new Department(null, "Music");          
		departmentDao.insert(newDepartment);
		IO.println("Inserted! New id = " + newDepartment.getId());
		
		IO.println("\n=== TEST 4: Department update ===");
		department = departmentDao.findById(1);
		department.setName("Food");
		departmentDao.update(department);
		IO.println("Update completed!");
		IO.println(department);
		
		IO.println("\n=== TEST 5: Department delete ===");
		IO.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		IO.println("Delete completed!");
		
		sc.close();
	}
}
