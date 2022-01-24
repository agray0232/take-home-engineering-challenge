package com.foodtrucks;

import org.springframework.stereotype.Repository;

@Repository
public class FoodTruckMapDAO 
{
    private static FoodTruckMap map = new FoodTruckMap();

    public FoodTruckMap getMap()
    {
        return this.map;
    }

    public void addFoodTruck(FoodTruck foodTruck)
    {
        this.map.addFoodTruck(foodTruck);
    }
}
