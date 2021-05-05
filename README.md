# Link Social Media

## Project Description
Link is the second iteration of a social media application created by Team Avatar as part of the Revature Full Stack Angular training program in April 2021. Developed with a microservice architecture, this web application allows every user to follow each other and view each other's posts. Each user has their own account that they can customize with their own information. Within this network, users can interact with each other through comments, likes, and a global chatroom. This social media application is meant to ease the transition of becoming a Revature employee.

PostService allows users to create view, and interact with posts. Users can like and comment on other posts. Users can also link YouTube urls and attach images to posts. User information is managed in its own DAO service and must also be updated whenever the UserService is updated.

## Technologies Used

- Spring Boot
	- Euereka Discovery Client
	- Spring Boot Actuator
	- Spring Web MVC
	- Lombok
	- Java Persistence API
- Java - version 1.8
- PostgrSQL - version 13.2
- AWS Java S3 SDK
- JUnit
- Log4J
- H2 Database Testing

## Features

- Create posts with text, images, and YouTube url links.
- Like other posts in a feed.
- Comment on other posts.
- Images are uploaded to an S3 bucket.

## Getting Started
   
> Clone this repository
```
git clone https://github.com/LinkSocialNetwork/PostService.git
```

> Clone Eureka, Gateway, and UserService services
```
git clone https://github.com/LinkSocialNetwork/Eureka.git
git clone https://github.com/LinkSocialNetwork/Gateway.git
git clone https://github.com/LinkSocialNetwork/UserService.git
```

> Clone FrontendClient
```
git clone https://github.com/LinkSocialNetwork/FrontendClient.git
```

> npm install in angular project folder
```
npm i FrontendClient/Angular
```

## **Usage**

> Run the services together, sequentially in an IDE
```
Eureka > Gateway > UserService > PostService
```

> Visit the Eureka url and confirm Eureka can see the Gateway, UserService, and PostService
```
http://localhost:9999/Eureka
```

> Run angular project
```
cd FrontendClient/Angular
npm run start
```

> Visit the frontend url
```
http://localhost:4200
```

## **License**

This project uses the following license: [<The MIT License>](https://www.mit.edu/~amini/LICENSE.md).
