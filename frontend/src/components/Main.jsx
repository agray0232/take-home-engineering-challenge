import React from "react";
import FoodTruckList from "./foodTruck/FoodTruckList";
import FoodTruckAPI from "../scripts/FoodTruckAPI";

class Main extends React.Component{

    constructor(){
        super();

        this.addFoodTruck = this.addFoodTruck.bind(this);
        this.getFoodTruckId = this.getFoodTruckId.bind(this);
    }

    addFoodTruck(e)
    {
        e.preventDefault();

        var name = e.target[0].value;
        var locId = e.target[1].value;
        var block = e.target[2].value;

        var foodTruckAPI = new FoodTruckAPI();

        foodTruckAPI.addFoodTruck(name, locId, block).then(data => {
            // do nothing
        })
        .catch(function(error){
            console.log("Error: " + error);
        })
    }

    getFoodTruckId(e)
    {
        e.preventDefault();

        var locId = e.target[0].value;

        var foodTruckAPI = new FoodTruckAPI();

        foodTruckAPI.getFoodTruckId(locId).then(data => {
            this.props.setFoodTruckList([data.foodTruckList])
        })
        .catch(function(error){
            console.log("Error: " + error);
        })
    }

    getFoodTruckBlock(e)
    {
        e.preventDefault();

        var block = e.target[0].value;

        var foodTruckAPI = new FoodTruckAPI();

        foodTruckAPI.getFoodTruckBlock(block).then(data => {
            this.props.setFoodTruckList(data.foodTruckList)
        })
        .catch(function(error){
            console.log("Error: " + error);
        })
    }

    render(){
        return(
            <div className="app-container">
            <form onSubmit={this.addFoodTruck}>
              <div className="row form-group">
                <div className="col form-group">
                  <div className="form-group">
                    <input className="form-control-lg" type="text" placeholder="Name"/>
                  </div>
                </div>
              </div>
              <div className="row form-group">
                <div className="col form-group">
                  <div className="form-group">
                    <input className="form-control-lg" type="text" placeholder="Location ID"/>
                  </div>
                </div>
              </div>
              <div className="row form-group">
                <div className="col form-group">
                  <div className="form-group">
                    <input className="form-control-lg" type="text" placeholder="Block"/>
                  </div>
                </div>
                <div className="form-group col-4">
                  <input className="btn form-control-lg" type="submit" value="Add Food Truck" />
                </div>
              </div>
            </form>

            <form onSubmit={this.getFoodTruckId}>
              <div className="row form-group">
                <div className="col form-group">
                  <div className="form-group">
                    <input className="form-control-lg" type="text" placeholder="Id"/>
                  </div>
                </div>
                <div className="form-group col-4">
                  <input className="btn form-control-lg" type="submit" value="Get Food Truck By ID" />
                </div>
              </div>
            </form>

            <form onSubmit={this.getFoodTruckBlock}>
              <div className="row form-group">
                <div className="col form-group">
                  <div className="form-group">
                    <input className="form-control-lg" type="text" placeholder="Block"/>
                  </div>
                </div>
                <div className="form-group col-4">
                  <input className="btn form-control-lg" type="submit" value="Get Food Truck By Block" />
                </div>
              </div>
            </form>

            <div>
            <button
                onClick={this.props.clearAll}
                className="btn btn-primary main-button">
                Clear
                </button>
            </div>
            <FoodTruckList 
                foodTruckList = {this.props.foodTruckList}>
            </FoodTruckList>
          </div>
        )
    }
}

export default Main;