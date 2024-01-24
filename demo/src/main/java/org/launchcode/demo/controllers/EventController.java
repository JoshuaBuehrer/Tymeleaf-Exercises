package org.launchcode.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("events")
public class EventController {

    public static HashMap<String, String> events = new HashMap<>();
    static {
        events.put("Menteaship "," A fun meetup for connecting with mentors ");
        events.put("Code With Pride "," A fun meetup sponsored by LaunchCode ");
        events.put("Javascripty ", " An imaginary meetup for Javascript developers ");
    }
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription) {
        events.put(eventName, eventDescription);
        return "redirect:/events";
    }

}