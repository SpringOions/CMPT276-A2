package rectangledatabase.rectangledatabase.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import rectangledatabase.rectangledatabase.models.Rectangles;


@Controller
public class RectanglesController {
    @GetMapping("/rectangle/view")
    public String getAllRectangles(Model model) {
        System.out.println("Getting all rectangles");
        //TODO: get all users from database
        List<Rectangles> rectangles = new ArrayList<>();
        rectangles.add(new Rectangles("Bob","#FFFFFF", 40, 20));
        rectangles.add(new Rectangles("Steve","#FFFFFF", 40, 20));
        rectangles.add(new Rectangles("Geoff","#FFFFFF", 40, 20));
        rectangles.add(new Rectangles("Phoebe","#5H3A90", 40, 20));
        //end of database call
        model.addAttribute("rec", rectangles);
        return "rectangle/showAll";
    }
    
}
