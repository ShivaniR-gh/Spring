package com.xworkz.clothingcompany.runner;

import com.xworkz.clothingcompany.dto.ClothDto;
import com.xworkz.clothingcompany.service.ClothService;
import com.xworkz.clothingcompany.service.ClothServiceImpl;

public class ClothRunner {

    public static void main(String[] args) {

        ClothService service = new ClothServiceImpl();

        service.validateAndSave(new ClothDto(
                "Denim Shirt", "Shirt", "Levis", "Blue", "M",
                2499, "Denim", "Men"));

        service.validateAndSave(new ClothDto(
                "Cotton Kurti", "Kurti", "Biba", "Red", "L",
                1899, "Cotton", "Women"));

        service.validateAndSave(new ClothDto(
                "Formal Trouser", "Trouser", "Arrow", "Black", "32",
                3299, "PolyCotton", "Men"));


        System.out.println("1. Cloth Type : " +
                service.getClothTypeByClothName("Denim Shirt"));

        System.out.println("2. Price : " +
                service.getClothPriceByClothName("Denim Shirt"));

        System.out.println("3. Brand : " +
                service.getBrandByClothName("Denim Shirt"));

        System.out.println("4. Color : " +
                service.getColorByClothName("Denim Shirt"));

        System.out.println("5. Size : " +
                service.getSizeByClothName("Denim Shirt"));

        System.out.println("6. Material : " +
                service.getMaterialByClothName("Denim Shirt"));

        System.out.println("7. Gender : " +
                service.getGenderByClothName("Denim Shirt"));

        System.out.println("8. All Cloth Names : " +
                service.getAllClothNames());

        System.out.println("9. All Brands : " +
                service.getAllBrands());

        System.out.println("10. Cloths by Brand : " +
                service.getClothsByBrand("Levis"));

        System.out.println("11. Cloths by Color : " +
                service.getClothsByColor("Blue"));

        System.out.println("12. Cloths by Gender : " +
                service.getClothsByGender("Men"));

        System.out.println("13. Cloths by Type : " +
                service.getClothsByType("Shirt"));

        System.out.println("14. Count by Brand : " +
                service.countByBrand("Levis"));

        System.out.println("15. Max Price : " +
                service.getMaxPrice());

        System.out.println("16. Min Price : " +
                service.getMinPrice());

        System.out.println("17. Average Price : " +
                service.getAveragePrice());

        System.out.println("18. Update Price : " +
                service.updatePriceByName("Denim Shirt", 2799));

        System.out.println("19. Updated Price : " +
                service.getClothPriceByClothName("Denim Shirt"));

        System.out.println("20. Delete Cloth : " +
                service.deleteByName("Cotton Kurti"));

        System.out.println("Execution Completed Successfully");
    }
}
