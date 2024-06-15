package rectangledatabase.rectangledatabase.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/rectangle/editRectangle/{id}")
    public String editRectangle(@PathVariable("id") int rid, Model model){
        Optional<Rectangle> rectangle = rectangleRepo.findById(rid);

        if( rectangle.isPresent() ){
            model.addAttribute("rec", rectangle.get());
        }


        return "rectangle/edit";
    }

    @PutMapping("/rectangle/{id}")
    public String updateRectangle(@PathVariable int id, @RequestParam Map<String, String> newRectangle, HttpServletResponse response, Model model) {
        //process PUT request
        Optional<Rectangle> updateRectangle = rectangleRepo.findById(id);
        try{
            if(updateRectangle.isPresent()){
                Rectangle rectangle = updateRectangle.get();

                String newName = newRectangle.get("name");
                String newColor = newRectangle.get("color");
                int newHeight = Integer.parseInt(newRectangle.get("height"));
                int newWeight = Integer.parseInt(newRectangle.get("weight"));
                String newChiikawa = newRectangle.get("chiikawa");
                String newPattern = newRectangle.get("pattern");

                rectangle.setName(newName);
                rectangle.setColor(newColor);
                rectangle.setHeight(newHeight);
                rectangle.setWidth(newWeight);
                rectangle.setChiikawa(newChiikawa);
                rectangle.setPattern(newPattern);

                rectangleRepo.save(rectangle);
                }
            }
        catch (NumberFormatException error){
            model.addAttribute("error", "Empty or invalid inputs");
            response.setStatus(400);

            return "rectangle/errorpage";
        }
        response.setStatus(201);
        return "rectangle/viewone/{id}";
    }


    @GetMapping(value = "/rectangle/viewone/{id}")
    public String getById(@PathVariable("id") int rid, Model model) {
        System.out.println(rid);
        List<Rectangle> rectangle = rectangleRepo.findByrid(rid);

        model.addAttribute("rec",rectangle);
        return "rectangle/one";
    }

    @PostMapping("/rectangle/add")
    public String addRectangle(@RequestParam Map<String, String> newrectangle, HttpServletResponse response, Model model) {
        try{
            String newName = newrectangle.get("name");
            String newColor = newrectangle.get("color");
            int newHeight = Integer.parseInt(newrectangle.get("height"));
            int newWeight = Integer.parseInt(newrectangle.get("weight"));
            String newChiikawa = newrectangle.get("chiikawa");
            String newPattern = newrectangle.get("pattern");

            Rectangle newRectangle = new Rectangle(newChiikawa, newColor, newHeight, newName, newPattern, newWeight);
            rectangleRepo.save(newRectangle);

            response.setStatus(201);

        }
        catch(Exception error){
            model.addAttribute("error", "Blank or invalid inputs");
            response.setStatus(500);

            return "rectangle/error";
        }
        return "rectangle/addedRectangle";
    }
    
    @GetMapping("/rectangle/del/{id}")
    public String deleteRectangle(@PathVariable("id") int rid){

        rectangleRepo.deleteById(rid);
        return "rectangle/gone";
    }
    
    
}
