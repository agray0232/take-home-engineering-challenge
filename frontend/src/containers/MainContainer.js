import Main from "../components/Main";
import { connect } from "react-redux";

let matchStateToProps = state => {
  return { ...state };
};

let matchDispatchToProps = dispatch => {
    return {
        setFoodTruckList: foodTruckList =>
            dispatch({
                type: "SET_FOOD_TRUCK_LIST",
                data: {
                    foodTruckList: foodTruckList
                }
            }),
        clearAll: () =>
            dispatch({
                type: "CLEAR_ALL"
            })
    }
}

export default connect(matchStateToProps, matchDispatchToProps)(Main);