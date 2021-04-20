package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Test 1: Seller findById ===");
		Seller seller = sellerDao.findById(1);
		System.out.println(seller);

		System.out.println("=== Test 2: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list1 = sellerDao.findByDepartment(department);
		for(Seller obj1 : list1) {
			System.out.println(obj1);
		}

		System.out.println("=== Test 3: Seller findByAll ===");
		List<Seller> list = new ArrayList<Seller>();
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== Test 4: Seller Insert ===");
		Seller newSeller = new Seller(null, "Greh", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Done !" + newSeller );
		
		System.out.println("=== Test 5: Seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		seller.setEmail("marthaWaine@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update data: " + seller);
		
	}

}
