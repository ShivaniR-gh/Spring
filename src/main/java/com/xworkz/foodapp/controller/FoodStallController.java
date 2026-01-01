package com.xworkz.foodapp.controller;

import com.xworkz.foodapp.dto.FoodStallDTO;
import com.xworkz.foodapp.service.FoodStallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class FoodStallController {
    @Autowired
    FoodStallService foodStallService;
    public FoodStallController(){
        System.out.println("The object has been created for FoodStallController");
    }

@PostMapping("addFoodStall")
    public String addFood(FoodStallDTO foodStallDTO){
        boolean saved = foodStallService.validateAndSave(foodStallDTO);
        if(saved){
            return "Response";
        }
        else {
            return "error";
        }
}
}
