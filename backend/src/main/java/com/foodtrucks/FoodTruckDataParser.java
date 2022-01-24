package com.foodtrucks;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.nio.file.Paths;

public class FoodTruckDataParser 
{
    
    public List<FoodTruck> parseData()
    {
        List<FoodTruck> foodTruckList = new ArrayList<>();

        try 
        {
            Scanner scanner = new Scanner(new File("./data/Mobile_Food_Facility_Permit.csv"));
            while(scanner.hasNextLine())
            {
                foodTruckList.add( getFoodTruckFromLine(scanner.nextLine()));
            }
        } 
        catch (Exception e) 
        {
            //TODO: handle exception
        }

        return foodTruckList;
    }

    private FoodTruck getFoodTruckFromLine(String line)
    {
        FoodTruck foodTruck = null;

        Integer locId;
        String name;
        String block;

        try 
        {
           Scanner rowScanner = new Scanner(line);
           rowScanner.useDelimiter(","); 

           locId = Integer.parseInt(rowScanner.next());
           name = rowScanner.next();
           String tempName = rowScanner.next();
           if(tempName == "LLC" || tempName == "LLC." || tempName == "Inc" || tempName == "inc")
           {
               name = name + " " + tempName;
               rowScanner.next();
           }
           rowScanner.next();
           rowScanner.next();
           rowScanner.next();
           rowScanner.next();
           block = rowScanner.next();

           foodTruck = new FoodTruck(locId, name, block);
        } 
        catch (Exception e) 
        {
            //TODO: handle exception
        }

        return foodTruck;
    }
}
