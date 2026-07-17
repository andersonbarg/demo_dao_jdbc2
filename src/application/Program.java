package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {
	
	void main() {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		IO.println("=== TEST 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		
		IO.println(seller);
		
	}
}
