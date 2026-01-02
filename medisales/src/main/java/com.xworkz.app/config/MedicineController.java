package com.xworkz.app.config;

import com.xworkz.app.dto.MedicineDTO;
import com.xworkz.app.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

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
 med

    @GetMapping("/search")
    public String searchByMedicineName(@RequestParam("medicineName") String medicineName ,
                                       Model model) throws Exception {


        Optional<MedicineDTO> dto = medicineService.getMedicineName(medicineName);
        model.addAttribute("med", dto.get());
        return "searchMedicineName.jsp";
    }
    @GetMapping("/getMedicine")
    public String getMedicine(@RequestParam("medicineId") int id , Model model) throws SQLException, ClassNotFoundException {
        Optional<MedicineDTO> medicineDTO = medicineService.getMedicineById(id);
        System.out.println(medicineDTO);
        model.addAttribute("medicineById" , medicineDTO.get());
        return "searchById.jsp";
    }

    @GetMapping("/getMedicineInfo/{medicineId}")
    public String getMedicineInfo(@PathVariable("medicineId")String medicineId , Model model) throws SQLException, ClassNotFoundException {
        Optional<MedicineDTO> medicineDTO = medicineService.getMedicineById(Integer.parseInt(medicineId));
        model.addAttribute("medicineByIdinfo" , medicineDTO.get());
        return "/updateMedicine.jsp";
    }
    @PostMapping("/updateMedicine")
    public String updateMedicine(MedicineDTO dto, Model model) throws Exception {

        boolean updated = medicineService.updateMedicine(dto);

        if (updated) {
            model.addAttribute("successMessage", "Data updated successfully");
        } else {
            model.addAttribute("errorMessage", "Update failed, please try again");
        }
        return "updateMedicine.jsp";
    }

}










}
 main
