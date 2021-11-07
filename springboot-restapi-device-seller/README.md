
## End Points

### 1. Sign-up
````
POST /api/authentication/sign-up HTTP/1.1
Host: localhost:8083
Content-Type: application/json
{
    "name":"Selin Yıldız",
    "username":"selin",
    "password":"selin"
}

````

### 2. Sign-in
````
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8083
Content-Type: application/json
{
    "username":"admin",
    "password":"admin"
}
````


### 3. Change-role
````
PUT /api/user/change/ADMIN HTTP/1.1
Host: localhost:8083
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzZWxpbiIsInJvbGVzIjoiUk9MRV9VU0VSIiwidXNlcklkIjo0LCJleHAiOjE2MzYzNzY3MDN9.5Uokrtg3zVhTvjLD1VAH3tYdDFHS7gVf-yOY7tRefZ-g6V2YJWBByTqPb7oZR2htVqEDr4kzjsAwbZU5lvMhDw
````

### 4. Save-device
````
POST /api/device HTTP/1.1
Host: localhost:8083
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MywiZXhwIjoxNjM2MzcxNzYwfQ.4mXkEvrHr_8roynJMzgLD4TumyurPBz7rDb66x0mrokeue__hsr9aKVo3ywwPYnHdUfDbqZnqi73LVTJfoZY_A
Content-Type: application/json
{
    "name":"a-device",
    "description":"lorem ipsum dolar sit amet",
    "price":516.55,
    "deviceType":"PHONE"
}

````


### 5. Get All Devices
````
GET /api/device/all-devices HTTP/1.1
Host: localhost:8083

````

### 6. Delete Device
````
DELETE /api/device/1 HTTP/1.1
Host: localhost:8083
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MywiZXhwIjoxNjM2MzcxNzYwfQ.4mXkEvrHr_8roynJMzgLD4TumyurPBz7rDb66x0mrokeue__hsr9aKVo3ywwPYnHdUfDbqZnqi73LVTJfoZY_A
````

### 7. Save Purchase
````
POST /api/purchase HTTP/1.1
Host: localhost:8083
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MywiZXhwIjoxNjM2MzcxNzYwfQ.4mXkEvrHr_8roynJMzgLD4TumyurPBz7rDb66x0mrokeue__hsr9aKVo3ywwPYnHdUfDbqZnqi73LVTJfoZY_A
Content-Type: application/json
 {
     "userId":"3",
     "deviceId":"2",
     "price":6000,
     "color":"yellow"
 }
````

### 8. Get All Purchases
````
GET /api/device/all-devices HTTP/1.1
Host: localhost:8083
````


