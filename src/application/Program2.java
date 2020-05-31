package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department findById ===");
		Department department = departmentDao.findById(3);		
		System.out.println(department);

		System.out.println("=== TEST 2: Department findAll ===");
		List<Department> departments = departmentDao.findAll();
		for(Department d: departments) {
			System.out.println(d);
		}
		
		System.out.println("=== TEST 3: Department insert ===");
		Department newDepartment = new Department(5, "Books");
		departmentDao.insert(newDepartment);
		System.out.println("Insert! New id = " + newDepartment.getId());
		
		System.out.println("=== TEST 4: Department update ===");
		department = departmentDao.findById(8);
		department.setName("Toys");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("=== TEST 5: Seller delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}
}
