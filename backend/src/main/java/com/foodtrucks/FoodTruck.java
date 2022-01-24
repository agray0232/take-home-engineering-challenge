package com.foodtrucks;

public class FoodTruck 
{
    private Integer locId;

    private String name;

    private String block;

    FoodTruck(Integer locId, String name, String block)
    {
        this.locId = locId;
        this.name = name;
        this.block = block;
    }

    public Integer getLocId()
    {
        return this.locId;
    }

    public void setLocId(Integer id)
    {
        this.locId = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBlock()
    {
        return this.block;
    }

    public void setBlock(String block)
    {
        this.block = block;
    }
}
