package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	void main() {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		IO.println("=== TEST 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		IO.println(seller);

		IO.println("\n=== TEST 1: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
	}
}
