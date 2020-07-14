## Estimate API
This API realise for save informafion about Restaurant, Users and Vote
It has two Role: ADMIN and USER
### ADMIN can 
1. Authificate 
2. Save dish and restaurant
3. Save price
4. Get all dishes, restaurants and prices
5. Get dish, restaurant and price by ID

### USER can
1. Authificate
2. Vote for restaurant
3. Change vote until 11:00
4. Get all restaurant in a day  for voting.


-------------------------------------------
- ***All Roles ENDPOINT***

**Get authorization token:**

curl -d '{"email": "user@yandex.ru", "password": "password"}' -H "Content-Type: application/json" -X POST http://localhost:8080/login
Response: JSON AuthetificationResponseTo
From response take authorization token. And put into the header with key "Authorization" and value token with prefix "Bearer_"

-------------------------------------------
- ***User ENDPOINTS***

**View all restaurants with dishes and prices and vote statistic:**

curl -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQHlhbmRleC5ydSIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE1OTM1OTExOTAsImV4cCI6MTU5NzE5MTE5MH0.pZ7ZJ5RN1KorKzZ82jBkEEJyiTduudbVjw7obYTYGUQ" -X GET http://localhost:8080/restaurants
Response: JSON List<RestaurantTo>

**Voting for choosen restaurant:**

curl -d '{"id": 100000004}' -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQHlhbmRleC5ydSIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE1OTM1OTExOTAsImV4cCI6MTU5NzE5MTE5MH0.pZ7ZJ5RN1KorKzZ82jBkEEJyiTduudbVjw7obYTYGUQ" -H "Content-Type: application/json" -X POST http://localhost:8080/vote
Response: String

-------------------------------------------
- ***Admins ENDPOINT RESTAURANT***curl -d '{"id": 100000004}' -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQHlhbmRleC5ydSIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE1OTM1OTExOTAsImV4cCI6MTU5NzE5MTE5MH0.pZ7ZJ5RN1KorKzZ82jBkEEJyiTduudbVjw7obYTYGUQ" -H "Content-Type: application/json" -X POST http://localhost:8080/restaurants

**Get restaurant:**

curl -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImlhdCI6MTU5MzU5MDk1MywiZXhwIjoxNTk3MTkwOTUzfQ.tDg-X4fCLj1KoAqKF8aosiv0Svc2tYNmbhkH9cMZGn4" -X GET http://localhost:8080/admin/restaurants/100000002
Response: JSON RestaurantTo

**GetAll restaurants:**

curl -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImlhdCI6MTU5MzU5MDk1MywiZXhwIjoxNTk3MTkwOTUzfQ.tDg-X4fCLj1KoAqKF8aosiv0Svc2tYNmbhkH9cMZGn4" -X GET http://localhost:8080/admin/restaurants
Response: JSON List<RestaurantTo>

**Delete restaurant:**

curl -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImlhdCI6MTU5MzU5MDk1MywiZXhwIjoxNTk3MTkwOTUzfQ.tDg-X4fCLj1KoAqKF8aosiv0Svc2tYNmbhkH9cMZGn4" -X DELETE http://localhost:8080/admin/restaurants/100000002
Response: HttpStatus.NO_CONTENT

**Save or update (if "id" exists or notNull) restaurant:**

curl -d '{"id": 100000004, "name": "Baku"}' -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImlhdCI6MTU5MzU5MDk1MywiZXhwIjoxNTk3MTkwOTUzfQ.tDg-X4fCLj1KoAqKF8aosiv0Svc2tYNmbhkH9cMZGn4" -H "Content-Type: application/json" -X POST http://localhost:8080/admin/restaurants
Response: HttpStatus.NO_CONTENT

-------------------------------------------
- ***Admins ENDPOINT DISH***

**Get dish:**

curl -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImlhdCI6MTU5MzU5MDk1MywiZXhwIjoxNTk3MTkwOTUzfQ.tDg-X4fCLj1KoAqKF8aosiv0Svc2tYNmbhkH9cMZGn4" -X GET http://localhost:8080/admin/dish/100000018
Response: JSON NamedTo

**GetAll dishes:**

curl -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImlhdCI6MTU5MzU5MDk1MywiZXhwIjoxNTk3MTkwOTUzfQ.tDg-X4fCLj1KoAqKF8aosiv0Svc2tYNmbhkH9cMZGn4" -X GET http://localhost:8080/admin/dishes
Response: JSON List<NamedTo>

**Delete dish:**

curl -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImlhdCI6MTU5MzU5MDk1MywiZXhwIjoxNTk3MTkwOTUzfQ.tDg-X4fCLj1KoAqKF8aosiv0Svc2tYNmbhkH9cMZGn4" -X DELETE http://localhost:8080/admin/dishes/100000018
Response: HttpStatus.NO_CONTENT

**Save or update (if "id" exists or notNull) dish:**

curl -d '{"id": 100000018, "name": "Borsch"}' -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImlhdCI6MTU5MzU5MDk1MywiZXhwIjoxNTk3MTkwOTUzfQ.tDg-X4fCLj1KoAqKF8aosiv0Svc2tYNmbhkH9cMZGn4" -H "Content-Type: application/json" -X POST http://localhost:8080/admin/dishes
Response: HttpStatus.NO_CONTENT

-------------------------------------------
- ***Admins ENDPOINT PRICE***

**Get price**

curl -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImlhdCI6MTU5MzU5MDk1MywiZXhwIjoxNTk3MTkwOTUzfQ.tDg-X4fCLj1KoAqKF8aosiv0Svc2tYNmbhkH9cMZGn4" -X GET http://localhost:8080/admin/pices/100000024
Response: JSON AdminPriceTo

**GetAll prices:**

curl -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImlhdCI6MTU5MzU5MDk1MywiZXhwIjoxNTk3MTkwOTUzfQ.tDg-X4fCLj1KoAqKF8aosiv0Svc2tYNmbhkH9cMZGn4" -X GET http://localhost:8080/admin/prices
Response: JSON List<AdminPriceTo>

**Delete price:**

curl -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImlhdCI6MTU5MzU5MDk1MywiZXhwIjoxNTk3MTkwOTUzfQ.tDg-X4fCLj1KoAqKF8aosiv0Svc2tYNmbhkH9cMZGn4" -X DELETE http://localhost:8080/admin/prices/100000024
Response: HttpStatus.NO_CONTENT

**Save or update (if "id" exists or notNull) price:**

curl -d '{"id": 100000024, "name": "Borsch"}' -H "Authorization:Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImlhdCI6MTU5MzU5MDk1MywiZXhwIjoxNTk3MTkwOTUzfQ.tDg-X4fCLj1KoAqKF8aosiv0Svc2tYNmbhkH9cMZGn4" -H "Content-Type: application/json" -X POST http://localhost:8080/admin/prices
Response: HttpStatus.NO_CONTENT

