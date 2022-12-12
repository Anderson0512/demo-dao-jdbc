package org.example;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.SellerDao;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== Test1: sellerById ===");
        Seller seller = sellerDao.findById(2);
        System.out.println(seller);


        System.out.println("\n=== Test2: sellerByDepartment ===");
        List<Seller> list = sellerDao.findByDepartment(new Department(2, null));

        for (Seller seller1 : list) {
            System.out.println(seller1);
        }

        System.out.println("\n=== Test3: findAll() ===");
        list = sellerDao.findAll();

        for (Seller sel : list) {
            System.out.println(sel);
        }

        System.out.println("\n=== Test4: insertSeller ===");

        Seller newSeller = new Seller(null, "Greg Bulls", "greg@gmail.com", new Date(), 4000.0, new Department(2, null));
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Id is " + newSeller.getId());

    }
}