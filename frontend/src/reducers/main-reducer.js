let initialState = {
  foodTruckList: []
};

const mainReducer = (state = initialState, action) => {
  switch (action.type) {
    case "SET_FOOD_TRUCK_LIST":
      return{
          ...state,
          foodTruckList: action.data.foodTruckList
      };
    case "CLEAR_ALL":
      return {
        testValue: "",
        foodTruckList: []
      };
    default:
      return state;
  }
};

export default mainReducer;