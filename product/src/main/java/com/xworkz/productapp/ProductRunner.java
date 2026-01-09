package com.xworkz.productapp;

import com.xworkz.productapp.dto.ProductDTO;
import com.xworkz.productapp.service.ProductService;
import com.xworkz.productapp.service.ProductServiceImpl;

public class ProductRunner {

    public static void main(String[] args) {

        ProductService service = new ProductServiceImpl();

        // SAVE
        ProductDTO saveDTO = new ProductDTO();
        saveDTO.setProductName("Laptop");
        saveDTO.setPrice(55000);
        saveDTO.setQuantity(10);
        saveDTO.setCategory("Electronics");
        service.save(saveDTO);
        System.out.println("Product saved");

        // UPDATE
        ProductDTO updateDTO = new ProductDTO();
        updateDTO.setId(1); // existing DB id
        updateDTO.setProductName("Gaming Laptop");
        updateDTO.setPrice(75000);
        updateDTO.setQuantity(8);
        updateDTO.setCategory("Electronics");
        service.update(updateDTO);
        System.out.println("Product updated");

        // READ
        ProductDTO readDTO = service.findById(1);
        System.out.println("Product found: " + readDTO);

        // DELETE
        ProductDTO deleteDTO = new ProductDTO();
        deleteDTO.setId(1);
        service.delete(deleteDTO);
        System.out.println("Product deleted");
    }
}
