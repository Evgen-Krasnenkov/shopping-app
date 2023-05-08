# SpringBoot with JPA
### End-points are on 
   /swagger-ui/index.html
1. Run this command to download docker SQL and run it.
```bash

docker run --name my-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_DATABASE=mydb -p 3306:3306 -d mysql
```

2. Then to start app 
```bash 
./gradlew run
 ```
