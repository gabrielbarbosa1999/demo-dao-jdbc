package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("==== Test 1: Department findById =====");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n==== Test 2: Department findAll =====");
        List<Department> list  = departmentDao.findAll();

        for(Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n==== Test 3: Department insert =====");
        Department newDepartment = new Department(null, "Computador");
        departmentDao.insert(newDepartment);

        System.out.println("\n==== Test 4: Department update =====");
        department = departmentDao.findById(1);
        department.setName("Teste");
        departmentDao.update(department);
        System.out.println("Atualizado com sucesso!");

        System.out.println("\n==== Test 5: Department Delete =====");
        System.out.print("Digite o id para ser deletado: ");
        int deleteId = sc.nextInt();

        departmentDao.deleteById(deleteId);
        System.out.println("Deletado com sucesso");

        sc.close();
    }

}
