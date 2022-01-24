package com.foodtrucks;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Class to store all the local food truck data
public class FoodTruckMap 
{
    public FoodTruckMap()
    {
        this.init();
    }

    // Map of all of the food trucks, keyed by their location ID
    private HashMap<Integer, FoodTruck> foodTruckMap = new HashMap();

    // Map of all the food trucks location ID's keyed by block
    private HashMap<String, List<Integer>> blockMap = new HashMap();

    // Parser to parse the CSV data containing known food trucks
    private FoodTruckDataParser dataParser = new FoodTruckDataParser();

    /**
     * Initializes with saved data
     */
    public void init()
    {
        // Parse the CSV data
        List<FoodTruck> foodTruckList = dataParser.parseData();

        // Add each foodTruck to our map
        for (FoodTruck foodTruck : foodTruckList) 
        {
            if(foodTruck != null)
            {
                addFoodTruck(foodTruck);
            }
        }
    }

    /**
     * Adds a new food truck to both maps
     * 
     * @param foodTruck - A new food truck
     */
    public void addFoodTruck( FoodTruck foodTruck )
    {
        // Place the food truck on the foodTruckMap
        foodTruckMap.put( foodTruck.getLocId(), foodTruck );

        // Check if the block map already has an entry for this block
        if( blockMap.containsKey( foodTruck.getBlock() ))
        {
            // If the block map already contains a list for this block, 
            // add this food truck to the list
            blockMap.get( foodTruck.getBlock() ).add( foodTruck.getLocId() );
        }
        // Else this is the first food truck on this block
        else
        {
            // Create a new list for this block
            List<Integer> blockList = new ArrayList<>();

            // Add the current food truck ID to this list
            blockList.add( foodTruck.getLocId() );

            // Place the new block list on the block map
            blockMap.put( foodTruck.getBlock(), blockList );
        }
    }

    /**
     * Gets a food truck from a passed in location ID, if one exists
     * 
     * @param locId - Location Id of the food truck being returned
     * @return FoodTruck - the food truck that matches the location Id, 
     * or null if none exists
     */
    public FoodTruck getFoodTruck( Integer locId )
    {
        FoodTruck retVal = null;

        // If the food truck is on the map, return it
        if( foodTruckMap.containsKey( locId ) )
        {
            retVal = foodTruckMap.get( locId );
        }

        return retVal;
    }

    /**
     * Returns a list of food trucks located on a single block
     * 
     * @param block
     * @return
     */
    public List<FoodTruck> getFoodTruckByBlock( String block )
    {
        List<FoodTruck> foodTruckList = new ArrayList<>();

        // Check if the block contains a list of food trucks
        if( blockMap.containsKey( block ))
        {
            // If it does, get the idList of the food trucks
            List<Integer> idList = blockMap.get( block );

            // For each Id, retrieve the food truck from the food truck map
            for (Integer id : idList) 
            {
                // If the food truck map contains an entry for this id
                if( foodTruckMap.containsKey( id ))
                {
                    // Add the food truck to the list
                    foodTruckList.add( foodTruckMap.get(id));
                }
            }
        }

        // Return all the food trucks on the block
        return foodTruckList;
    }
}
