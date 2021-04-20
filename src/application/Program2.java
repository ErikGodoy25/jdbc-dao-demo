package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: Department findById ===");
		System.out.print("Enter With Department Id: ");
		Integer id = sc.nextInt();
		Department department = departmentDao.findById(id);
		System.out.println("Search Id: " + department.getId() + " - " + department.getName());
		
		
		System.out.println("=== Test 2: Department findAll ===");
		List<Department> list = new ArrayList<Department>();
		list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}

}
