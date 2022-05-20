# Spring final project #
## Alexander Lee ##
### ITSE-1908R (variant #2) ###


# **_Contents of an application:_**

| Module                | Functionality                                                                                                                                                                                                              | Amount Of Endpoints |
|-----------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------|
| Administration Module | Able to add new students via CSV file<br/>Has full access to endpoints with CRUD operations<br/>Can access any module via his JWT token                                                                                    | 38                  |
| Staff Module          | Able to grade, view, create tasks for students (via groups)<br/>If needed, can assign tasks for different groups<br/>Has ability to download assessments, provided by students for each individual task                    | 6                   |
| Student Module        | The most low-powered module in application<br/>Uploads assessmentss/passes tests that are provided in task, assigned to his group<br/>Able to look through his grades details<br/>Easy to find tasks assigned to his group | 7                   |


 All controllers divided for 3 sections: "Modules", "CRUD", and "Functional controllers".

![file:///home/ai/Pictures/Screenshot_20220520_161340.png](file:///home/ai/Pictures/Screenshot_20220520_161340.png)

# **_Database properties:_**

In total, this project has 11 entities, which use all of the possible relations
in Hibernate **(@OneToMany, @ManyToMany, @ManyToOne, @OneToOne)**

Entities:
* **Assesment** - assessment that user provides for each individual task
* **User** - base user model
* **UsersGradeDetails** - details about user's performance and grades
* **Group** - base group model that users are related to 
* **Role** - base role model that grants authenticated users authorities and permissions to work in some module
* **Task** - model that represents task, that staff user assigned to student users
* **Task_Group** - ManyToMany representative model between tasks assigned to groups
* **Notification** - model that is used in jms service
* **RequestLog** - model that is used in AOP code, capturing every request to a CRUD controllers (to look which admin is using crud panel)
* **Test** - type of assignment that shows users that they are restricted to pass the test
* **TestQuestion** - question in test

# _MVC configuration:_

Database connection is implemented through 4 layers in this application:

### Entity -> Repository(Implemented from base CRUDRepository) -> Service -> Controllers

Entities:

![file:///home/ai/Pictures/Screenshot_20220520_162252.png](file:///home/ai/Pictures/Screenshot_20220520_162252.png)

Repositories:

![file:///home/ai/Pictures/Screenshot_20220520_162313.png](file:///home/ai/Pictures/Screenshot_20220520_162313.png)

Services:

![file:///home/ai/Pictures/Screenshot_20220520_162347.png](file:///home/ai/Pictures/Screenshot_20220520_162347.png)

-----------

# **_Utils:_**

Also, there is one directory that is not represented in base spring-boot packaging: **Utils**

There are some Utilities that I have used to make this project easier to implement.

![file:///home/ai/Pictures/Screenshot_20220520_162845.png](file:///home/ai/Pictures/Screenshot_20220520_162845.png)


-----------

# **_Additional components:_**

1. [X] Swagger2 and swaggerUI.
2. [X] JMS using Apache Kafka.
3. [X] AOP configuration with real business logic within.
4. [X] Spring security using JWT token (custom implementation).
5. [X] Caching using EhCache.
6. [X] Batch operations.
7. [X] Transactions inside queries.
8. [X] Scheduling.
9. [X] Junit tests (TestMe plugin).
10. [ ] WebSockets using RabbitMQ.

