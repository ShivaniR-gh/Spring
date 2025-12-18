package com.xworkz.app.config;

import com.xworkz.app.dto.MedicineDTO;
import com.xworkz.app.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MedicineController {

@Autowired
    MedicineService medicineService;
    public MedicineController(){
        System.out.println("The Medicine controller object is invoked");
    }
    @PostMapping("/addMedicine")
    public String addMedicine(MedicineDTO medicineDTO) throws Exception {
        System.out.println(medicineDTO);

       boolean medicineSaved = medicineService.validateAndSave(medicineDTO);

       if(medicineSaved) {
           return "Response.jsp";
       }
       else {
           return "error.jsp";
       }
    }
}
