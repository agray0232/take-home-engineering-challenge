package com.foodtrucks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodTruckMapTest {

	@Test
	void testAddFoodTruck() 
	{
		FoodTruckMap map = new FoodTruckMap();

		// Create a test food truck
		FoodTruck foodTruck = new FoodTruck(1, "testName", "block");

		// Add the test food truck on the map
		map.addFoodTruck(foodTruck);
		
		// Ensure the food truck was placed on the map and can be retrieved
		assertEquals(foodTruck, map.getFoodTruck(1));
	}

	@Test
	void testGetFoodTruckBlock() 
	{
		FoodTruckMap map = new FoodTruckMap();

		// Create multiple test food trucks
		FoodTruck foodTruck1 = new FoodTruck(1, "testName", "block A");
		FoodTruck foodTruck2 = new FoodTruck(1, "testName", "block A");
		FoodTruck foodTruck3 = new FoodTruck(1, "testName", "block B");

		// Add the test food trucks on the map
		map.addFoodTruck(foodTruck1);
		map.addFoodTruck(foodTruck2);
		map.addFoodTruck(foodTruck3);
		
		// Ensure the food truck was placed on the map and can be retrieved
		assertEquals(2, map.getFoodTruckByBlock("block A").size());
		assertEquals(1, map.getFoodTruckByBlock("block B").size());
	}

}
