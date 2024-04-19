# Mini_Project_VTI
trainee dev in VTI academy - JIRA + API

### Project Structure:
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
│  │  │        ├─ services: Service interfaces and implementations
│  │  │        │  ├─ interfaces: Service interfaces
│  │  │        │  │  ├─ IService.java
│  │  │        │  │  ├─ IGroupService.java
│  │  │        │  │  └─ IUserService.java
│  │  │        │  └─ implement: Service implementations
│  │  │        │     ├─ GroupService.java
│  │  │        │     └─ UserService.java
│  │  └─ resources: Configuration files
│  │     └─ application.properties
│  └─ test
│     └─ java: Test source code
└─ target: Build artifacts
```