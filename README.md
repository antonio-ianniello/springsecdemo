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