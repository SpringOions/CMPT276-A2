package rectangledatabase.rectangledatabase.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import rectangledatabase.rectangledatabase.models.Rectangle;
import rectangledatabase.rectangledatabase.models.RectangleRepository;




@Controller
public class RectanglesController {

    @Autowired
    private RectangleRepository rectangleRepo;

    @GetMapping("/rectangle/view")
    public String getAllRectangles(Model model) {
        System.out.println("Getting all rectangles");

        /* get all users from database*/
        List<Rectangle> rectangles = rectangleRepo.findAll();
    
        //end of database call
        model.addAttribute("rec", rectangles);
        return "rectangle/showAll";
    }

    @GetMapping(value = "/rectangle/viewone/{id}")
    public String getById(@PathVariable("id") int rid, Model model) {
        System.out.println(rid);
        List<Rectangle> rectangle = rectangleRepo.findByrid(rid);

        model.addAttribute("rec",rectangle);
        return "rectangle/one";
    }

    
    

    @PostMapping("/rectangle/add")
    public String addRectangle(@RequestParam Map<String, String> newrectangle, HttpServletResponse response) {
        System.out.println("ADD rectangle");
        String newName = newrectangle.get("name");
        String newColor = newrectangle.get("color");
        int newHeight = Integer.parseInt(newrectangle.get("height"));
        int newWeight = Integer.parseInt(newrectangle.get("weight"));
        String newChiikawa = newrectangle.get("chiikawa");
        String newPattern = newrectangle.get("pattern");
        rectangleRepo.save(new Rectangle(newChiikawa, newColor, newHeight, newName, newPattern, newWeight));
        response.setStatus(201);
        return "rectangle/addedRectangle";
    }
    
    @GetMapping("/rectangle/del/{id}")
    public String deleteRectangle(@PathVariable("id") int rid){

        rectangleRepo.deleteById(rid);
        return "rectangle/gone";
    }
    
    
}
