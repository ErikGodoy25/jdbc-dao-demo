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
		
		System.out.println();
		System.out.println("=== Test 2: Department findAll ===");
		List<Department> list = new ArrayList<Department>();
		list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		System.out.println();
		System.out.println("=== Test 3: Department Insert ===");
		Department newDepartment = new Department(7, "Secretary");
		departmentDao.insert(newDepartment);
		System.out.println("New Department " + newDepartment);
		
		System.out.println();
		System.out.println("=== Test 4: Department Update ===");
		System.out.print("Id: ");
		int updateId = sc.nextInt();
		System.out.print("Name: ");
		String name = sc.next();
		Department dep = new Department(updateId, name);
		departmentDao.update(dep);
		System.out.println("Done !" + dep);
		
		
		System.out.println();
		System.out.println("=== Test 5: Department Delete ===");
		System.out.print("Enter With Id: ");
		int deleteId = sc.nextInt();
		departmentDao.deleteById(deleteId);
		System.out.println("Delete Done !");
		sc.close();
	}

}
