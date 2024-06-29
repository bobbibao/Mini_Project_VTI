# Mini_Project_VTI
- This project for practicing spring, postman and Jira foundation with creating restfull api in VTI academy - trainee developer

## Project Structure:
```java
Mini_Project_VTI
├─ .gitignore
├─ pom.xml
├─ README.md
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ com
│  │  │     └─ vti
│  │  │        ├─ controllers: REST controllers
│  │  │        │  ├─ GroupController.java
│  │  │        │  └─ UserController.java
│  │  │        ├─ models: Domain models
│  │  │        │  ├─ Group.java
│  │  │        │  └─ User.java
│  │  │        ├─ repositories: JPA repositories
│  │  │        │  ├─ IGroupRepository.java
│  │  │        │  └─ IUserRepository.java
│  │  │        └─ services: Service interfaces and implementations
│  │  │           ├─ interfaces: Service interfaces
│  │  │           │  ├─ IService.java
│  │  │           │  ├─ IGroupService.java
│  │  │           │  └─ IUserService.java
│  │  │           └─ implement: Service implementations
│  │  │              ├─ GroupService.java
│  │  │              └─ UserService.java
│  │  └─ resources: Configuration files
│  │     └─ application.properties
│  └─ test
│     └─ java: Test source code
└─ target: Build artifacts
```

## API Documentation

### Users API

- `GET /api/users`: Get a list of all users.
- `GET /api/users/{userId}`: Get user information by ID.
- `GET /api/users/{userId}/groups`: Get groups infomation for user by ID.
- `POST /api/users`: Add a new user.
- `PUT /api/users/{userId}`: Update user information by ID.
- `PATCH /api/users/{userId}`: Partially update user information by ID.
- `DELETE /api/users/{userId}`: Delete a user by ID.

### Groups API

- `GET /api/groups`: Get a list of all groups.
- `GET /api/groups/{groupId}`: Get group information by ID.
- `GET /api/groups/{groupId}/users`: Get users information for group by ID.
- `POST /api/groups`: Add a new group.
- `PUT /api/groups/{groupId}`: Update group information by ID.
- `PATCH /api/groups/{groupId}`: Partially update group information by ID.
- `DELETE /api/groups/{groupId}`: Delete a group by ID.

### User-Group Relationship API

- `PATCH /api/groups/{groupId}/users/{userId}`: Add a user to a group by group ID and user ID.
- `DELETE /api/groups/{groupId}/users/{userId}`: Remove a user from a group by group ID and user ID.

## Demo

### API

<img width="1034" alt="Screen Shot 2024-04-20 at 02 30 56" src="https://github.com/bobbibao/Mini_Project_VTI/assets/88239380/c7c504f6-0baa-4a2b-b062-25c7d0bbad00">
<img width="1069" alt="Screen Shot 2024-04-20 at 02 36 06" src="https://github.com/bobbibao/Mini_Project_VTI/assets/88239380/bfa18315-fbd5-4eb8-8dae-a2280b0bbf6e">
<img width="1003" alt="Screen Shot 2024-04-20 at 02 38 24" src="https://github.com/bobbibao/Mini_Project_VTI/assets/88239380/4d17af47-12ee-4d2e-9dc9-217ed6fdb5f8">

### Jira

<img width="1427" alt="Screen Shot 2024-04-20 at 09 58 51" src="https://github.com/bobbibao/Mini_Project_VTI/assets/88239380/dcd64361-7ad2-45e8-8036-efadd87161a6">
<img width="1189" alt="Screen Shot 2024-04-20 at 09 59 45" src="https://github.com/bobbibao/Mini_Project_VTI/assets/88239380/c894fd0a-6c7f-4fdc-857b-27a763761169">


### Database

<img width="526" alt="Screen Shot 2024-04-20 at 02 42 15" src="https://github.com/bobbibao/Mini_Project_VTI/assets/88239380/a6427d64-6810-4458-837a-f89b84124054">
