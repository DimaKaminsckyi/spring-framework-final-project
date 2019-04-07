
# Spring Fremework Final Project

Final project on BaseCamp is based on StarWarsAPI. The aim of the project was to show the fastest or most expensive starship or vehicle that person was driving ever.
To begin with, we must take from the API the name of the character we want and then compare his starship or vehicle to the fastest or most expensive machine and save to database.

In project added swagger documentation 
```bash
http://localhost:8080/swagger-ui.html#/
```

### Example compare and  save to database
### POST
```bash
http://localhost:8080/save/starship/fastest/Luke Skywalker
```
In this example we compare all Luke starships to the fastest and save

```bash
http://localhost:8080/save/vehicle/expensive/Luke Skywalker
```
But in this example we compare Luke vehicle to the most expensive

After saving, the method gives us uuid

For example :
```bash
"id": "0a482409-8ac1-4672-8b60-e6496ea557e3"
```

### GET Compare Result
### GET 
```bash
http://localhost:8080/result/{uuid}
```
```bash
http://localhost:8080/result/0a482409-8ac1-4672-8b60-e6496ea557e3
```
After this method the server will give us the response in the form of json

```bash
{
    "uuid": "0a482409-8ac1-4672-8b60-e6496ea557e3",
    "result": "Luke Skywalker(1) was driving (starship)Imperial shuttle(22) and it cost 240000"
}
```

### GET All "fastest" results
If you have forgotten uuid results

```bash
http://localhost:8080/fastest/result
```
and we see

```bash
    [
        "4ea14410-e17c-47aa-9520-d5e81bd5a633",
        "Luke Skywalker"
    ],
    [
        "2250d292-33df-4a14-a789-558970ecf860",
        "Anakin Skywalker"
    ]
```
### GET All "expensive" results

```bash
http://localhost:8080/expensive/result
```

```bash
    [
        "2aebde6e-b4d6-4e5d-af68-71c05bed2a47",
        "Anakin Skywalker"
    ],
    [
        "3d97054e-0ae5-4891-b73a-a24ab05fc42a",
        "Darth Maul"
    ]
```    
