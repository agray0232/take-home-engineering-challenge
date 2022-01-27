import axios from "axios";

export default class FoodTruckAPI 
{
    getFoodTruckId(locId)
    {
        // Set the request URL
        var requestURL = "http://localhost:8080/foodtrucks/" + locId;

        return new Promise(function(resolve, reject) {
        // Send an axios GET request to the server
        axios
            .get(requestURL)
            .then(response => {
            // Decode and send the response
            resolve(response.data);
            })
            .catch(error => {
            console.log(
                "ERROR: Unable to get response from the server\n User input may be formatted incorrectly" +
                error.response
            );
            reject(error);
            });
        });
    }

    getFoodTruckBlock(block)
    {
        // Set the request URL
        var requestURL = "http://localhost:8080/foodtrucks?block=" + block;

        return new Promise(function(resolve, reject) {
        // Send an axios GET request to the server
        axios
            .get(requestURL)
            .then(response => {
            // Decode and send the response
            resolve(response.data);
            })
            .catch(error => {
            console.log(
                "ERROR: Unable to get response from the server\n User input may be formatted incorrectly" +
                error.response
            );
            reject(error);
            });
        });
    }

    addFoodTruck(name, locId, block)
    {
        var postURL = "http://localhost:8080/foodtrucks";

        return new Promise(function(resolve, reject) {
            axios.post(postURL, 
                {locId: locId, name: name, block: block}
                
            ).then(response => {resolve(response.data);
            })
            .catch(error => {
                console.log(
                    "ERROR: Unable to get response from the server\n User input may be formatted incorrectly"
                );
                reject(error);
            });
        })
    }
}