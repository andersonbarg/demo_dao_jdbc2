package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	void main() {
		
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		IO.println("=== TEST 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		IO.println(seller);

		IO.println("\n=== TEST 2: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		IO.println("\n=== TEST 3: Seller findAll ===");
		list = sellerDao.findALL();
		list.forEach(System.out::println);

		IO.println("\n=== TEST 4: Seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);          
		sellerDao.insert(newSeller);
		IO.println("Inserted! New id = " + newSeller.getId());
		
		
		IO.println("\n=== TEST 5: Seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		seller.setEmail("marta@gmail.com");
		sellerDao.update(seller);
		IO.println("Update completed!");
		IO.println(seller);
		
		IO.println("\n=== TEST 6: Seller delete ===");
		IO.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		IO.println("Delete completed!");
		
		sc.close();
	}
}
