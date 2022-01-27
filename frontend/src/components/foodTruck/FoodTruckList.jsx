import React from 'react';
import FoodTruck from './FoodTruck';

class FoodTruckList extends React.Component{

    render(){
        var foodTruckList = this.props.foodTruckList.map(foodTruck =>
            {
                return(
                    <FoodTruck 
                        name = {foodTruck.name}
                        locId = {foodTruck.locId}
                        block = {foodTruck.block}>
                    </FoodTruck>
                )
            });
        
        return(
            <div>
                <div className="container">
                    <h4>Food Trucks</h4>
                </div>
                <ul className="list-group">
                    {foodTruckList}
                </ul>
            </div>
        )
    }
}

export default FoodTruckList;