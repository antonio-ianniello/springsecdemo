# Spring Security Demo

## Running Demo


* This project was built with below configuration - [Spring Init Link](https://start.spring.io/)

    ![intiProject.png](doc_init_project.png)


* project will be runned on -> [localhost:80](http://localhost:80/)


* login credentials
  * user: `user` 
  * pwd: `Retrived from Using generated security password` in app initialization


## Commands
* compile from terminal `mvn compile`
* running from terminal `mvn spring-boot:run`
* clean `mvn clean`
# spring Security 6 (differences from 5.7.x)
* Deprecated WebSecurityConfigurerAdapter
* Deprecated EnableGlobalMethodSecurity
* Deprecated antMatchers
* Deprecated authorizeRequests
* Java xx migration to Jakarta
# Notes

## Application 
### version 1.0
* Exception Handler added
* Basic Rest Controller for Student added
* Basic Dtos added
* favicon.ico added
* Basic Business logic for StudentService added
* Static Json and Random creation of student added

## version 1.0.1
* MonitoringUtils added
* FirstSecurityConfig with Basic auth
* credentials on yaml file
* Monitoring enabled at PATH: /random/students

## version 1.0.2
* BCryptPasswordEncoder added
* InMemoryUserDetailsManager added
* REMOVED credentials from YAML file, user stored in UserDetailsService Bean.
Application is now accessible only by user `pippo` and not by `demo`
* Basic authentication has header `authorization` with value `Basic user:pwd` inbase64Format

##  version 1.0.3
* PATH /random accessible by ADMIN
  * 403 Forbidden in case of USER without correct permissions
  * 401 Unathorized without basic authentication


* /triggered,/error, /ko and / accessible _**without**_ authentication 
* other PATH like /students need basic authentication

  Path: **_/triggered_** HttpStatus: **500**

  `curl --location 'localhost:80/triggered' \
  --header 'Cookie: JSESSIONID=numberofsessioncalculated'`
  ```
  {
    "status": "KO",
    "data": null,
    "error": {
        "code": 500,
        "message": "/triggered"
      }
  }
  ```
  
  Path: **_/error_** HttpStatus: **500**

  `curl --location 'localhost:80/error' \
  --header 'Cookie: JSESSIONID=numberofsessioncalculated'`
  ```
  {
    "status": "KO",
    "data": null,
    "error": {
        "code": 500,
        "message": "error page called"
      }
  }
  ```

  Path: **_/ko_** HttpStatus: **200**

` curl --location 'localhost:80/ko' \
  --header 'Cookie: JSESSIONID=numberofsessioncalculated'`
  ```
  {
    "status": "KO",
    "data": null,
    "error": null
  }
  ```
  Path: **_/ok_** HttpStatus: **401** (page requires basic auth also if resource not exists)

  ` curl --location 'localhost:80/ok' \
  --header 'Cookie: JSESSIONID=numberofsessioncalculated'`
  ```
  {
    "status": "KO",
    "data": null,
    "error": {
        "code": 401,
        "message": "Unauthorized"
    }
  }  
  ```

Path: **_/ok_** HttpStatus: **500** (resource not exists,basic auth used)

` curl --location 'localhost:80/ok' \
--header 'Authorization: ••••••' \
--header 'Cookie: JSESSIONID=numberofsessioncalculated'`

  ```
  {
    "status": "KO",
    "data": null,
    "error": {
        "code": -500,
        "message": "No static resource ok."
    }
  }
  ```
Path: **_/random/students_** HttpStatus: **401** (get without auth)

` curl --location 'localhost:80/random/students' \
--header 'Cookie: JSESSIONID=numberofsessioncalculated'`
  ```
  {
    "status": "KO",
    "data": null,
    "error": {
        "code": 401,
        "message": "Unauthorized"
    }
}
  ```

Path: **_/random/students_** HttpStatus: **403** (get with Basic auth and user not admin)

` curl --location 'localhost:80/random/students' \
--header 'Authorization: ••••••' \
--header 'Cookie: JSESSIONID=numberofsessioncalculated'`
  ```
  {
    "status": "KO",
    "data": null,
    "error": {
        "code": 403,
        "message": "Access Denied"
    }
}
  ```

* Spring security managed 401 Unathorized with AuthenticationEntryPoint , CustomAuthenticationEntryPoint added
* Spring security managed 403 Forbidden with AccessDeniedHandler, CustomAccessDeniedHandler added
* There are two-way for managing errors, ExceptionHandler and method handleError in IndexController.