package com.xworkz.app.controller;

import com.xworkz.app.dto.ClothesDTO;
import com.xworkz.app.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ClothesController {


    @Autowired
    ClothesService clothesService;
    public ClothesController(){
        System.out.println("The WEB init is invoked");
    }

    @PostMapping("/Clothes")
    public String clothes(ClothesDTO clothesDTO) throws Exception {
        System.out.println(clothesDTO);
        boolean saveClothes = clothesService.validateAndSave(clothesDTO);
        if(saveClothes)
            return "Response.jsp";
        else
            return "Error.jsp";
    }
}
