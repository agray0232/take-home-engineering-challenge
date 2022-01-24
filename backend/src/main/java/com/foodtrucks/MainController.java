package com.foodtrucks;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController 
{
    @Autowired
    private FoodTruckMapDAO foodTruckDAO;

    @GetMapping
    public ResponseEntity<String> test() {
       return ResponseEntity.ok().body("Helloworld");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/foodtrucks", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addFoodTruck(@RequestBody FoodTruck foodTruck)
    {
        foodTruckDAO.addFoodTruck(foodTruck);

        return ResponseEntity.ok().body("Food truck added");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/foodtrucks/{id}", produces = "application/json")
    public FoodTruck getFoodTruck(@PathVariable Integer id)
    {
        return foodTruckDAO.getMap().getFoodTruck(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/foodtrucks", produces = "application/json")
    public List<FoodTruck> getFoodTruck(@RequestParam(value="block") String block)
    {
        return foodTruckDAO.getMap().getFoodTruckByBlock(block);
    }
}
