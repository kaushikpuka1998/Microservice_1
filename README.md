# microservice_1
POST localhost:8080/save

Body: 
  {
    "name" : "Kaushik Ghosh",
    "username" : "kgstrivers",
    "email" : "kaushikghosh199832@gmail.com",
    "password" : "Kbc@1998"
}

GET localhost:8080/user/kgstrivers

POST localhost:8080/login

Body : 

{
    "username" : "kgstrivers",
    "password" : "Kbc@1998"
}
