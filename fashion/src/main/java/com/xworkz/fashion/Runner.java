package com.xworkz.fashion;

import com.xworkz.fashion.dto.FashionDTO;
import com.xworkz.fashion.service.FashionService;
import com.xworkz.fashion.service.FashionServiceImpl;

public class Runner {
    public static void main(String[] args) {

        FashionService service = new FashionServiceImpl();

        FashionDTO dto = new FashionDTO();
        System.out.println(service.update(dto));
        service.update(dto);;
        dto.setClothName("BodyCon");
        dto.setClothBrand("HNM");
        dto.setClothPrice(1000.0);
        dto.setClothSize(30);
//
//        boolean saved = service.validateAndSave(dto);
//        if (saved) {
//            System.out.println("saved successfully");
//        }

    }
}
