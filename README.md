# Take Home Engineering Challenge

Our San Francisco team loves to eat. They are also a team that loves variety, so they also like to discover new places to eat.

In fact, we have a particular affection for food trucks. One of the great things about Food Trucks in San Francisco is that the city releases a list of them as open data.

Your assignment is to make it possible for us to find a food truck no matter where our work takes us in the city.

## Approach

### Backend

-   I built a backend RESTful API with Java Spring Boot. A user can add new food trucks, return a single food truck from its location ID, or return a list of food trucks that are on a block. The backend's internal storage is prepopulated with a csv file of food trucks in San Francisco provided by the city.

-   The backend interally stores the food truck data using two maps. The first map holds every known food truck key'd on its unique location ID. There is a second map that contains list of unique location IDs key'd on blocks. This design choice was selected to optimize the search time of food trucks either by ID or block. The two maps can be used together to ensure that an GET request of food trucks has a time complexity of O(1). The trade off here is of course the memory requirements.

-   The map container can then be duplicated for each city that this service is expanded to. This could be implemented by created a list or map of maps for each city with an added attribute in the food truck map to identify which city it is for.

### Frontend

-    The front end is a very simple react-app that is intended to be used for testing or showing a proof-of-concept. 

-    The GET requests are currently not functioning, so please use Postman or a similar application for any testing of the backend

### Future Considerations

-    As mentioned above, the data storage architecture has been setup to allow for scalability in this future as this expands to other cities. 

-    The csv parser used has been hard-coded for the csv file currently being dealt with. Any change in the way the data being provided is formated would break the data loading. The csv parsing and data loading in general would need to be genericized in the future.

-    The unit testing of the backend could be greatly expanded on. I have only provided basic unit testing for the data storage class to ensure that basic functionality worked as intended.

-    If I had more time, I would go back and comment/document everything extensively. The code, regretfully is only partially commented.

-    If a frontend is desired, this could be greatly expanded upon

## Installing and Running

### Backend

#### Build
```
cd /<repo-root-dir>/backend
gradle build
// OR
./gradlew build
```

#### Test
```
cd /<repo-root-dir>/backend
gradle test
// OR
./gradlew test
```

#### Run
```
cd /<repo-root-dir>/backend
gradle bootRun
// OR
./gradlew bootRun
```

### Frontend

#### Install
```
cd /<repo-root-dir>/frontend
npm install
```

#### Run
```
cd /<repo-root-dir>/frontend
npm start
```

## API Calls Supported

### Add a new food truck

```
http://localhost:8080/foodtrucks

JSON Data:
{
    "locId": <int>,
    "name": <string>,
    "block": <string>
}
```

### Get a food truck by location ID

```
http://localhost:8080/foodtrucks/<location ID>
```

### Get all food truck on a block

```
http://localhost:8080/foodtrucks?block=<block>
```