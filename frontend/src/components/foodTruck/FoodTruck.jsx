import React from 'react';

class FoodTruck extends React.Component{
    constructor(){
        super();
    }

    render(){
        return(
            <li className="list-group-item">
                <div className="row">
                    <div className="col">
                        <p>Name: {this.props.name}</p>
                        <p>Location ID: {this.props.locId}</p>
                        <p>Block: {this.props.block}</p>
                    </div>
                </div>
            </li>
        )
    }
}

export default FoodTruck;