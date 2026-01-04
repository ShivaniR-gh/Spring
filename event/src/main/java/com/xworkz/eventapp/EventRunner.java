package com.xworkz.eventapp;

import com.xworkz.eventapp.dto.EventDTO;
import com.xworkz.eventapp.service.EventService;
import com.xworkz.eventapp.service.EventServiceImpl;

public class EventRunner {
    public static void main(String[] args) {

        EventService eventService = new EventServiceImpl();
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(8);
        eventDTO.setEventName("birthdaypart");
        eventDTO.setEventManager("SomeOne");
        eventDTO.setLocation("Banglore");
        eventDTO.setEventType("Music");

        System.out.println(eventDTO);
        boolean saved = eventService.validateAndSave(eventDTO);
        if(saved){
            System.out.println("Event saved successfully");
        }else
            System.out.println("The event did not saved");

        boolean saved1 = eventService.update(eventDTO);
        if (saved1){
            System.out.println("The event has been updated");
        }else
            System.out.println("The event has not been updated");

        EventDTO saved3 = eventService.findById(eventDTO.getId());

        if (saved3 != null) {
            System.out.println("Event found: " + saved3);
        } else {
            System.out.println("Event not found");
        }

        boolean saved2 = eventService.delete(eventDTO);
        if (saved2){
            System.out.println("The event has been deleted");
        }else
            System.out.println("The event has not been updated");



    }

}
