<h1 style="text-align: center">CompCheck || CS50X final project</h1>

#### Video-demo:  https://www.youtube.com/watch?v=wkEuotQ7A6g


### Description
This project is the final assignment of Harvards CS50X [Introduction to Computer Science course.](https://cs50.harvard.edu/x/2023/project/) The goal of this project is to take the learned programming skills out for a spin and develop my own piece of software.

**CompCheck - Why and what** 
As a former recruiter, I’ve noticed that it can be challenging to compare employer benefits in a good way. One employer offers you an okay salary, with a nice number of PTO days, but with a nice contribution to your retirement plan, while another company offers a really nice salary but with much worse secondary employment benefits. What is the best job offer down the line?

CompCheck normalizes every job offer to a 40-hour employment contract, selling all non-obligatory PTO days and giving you an overview of what your expected net salary will be.


**For this project I used the following tools:**
 - Java
 - PostgreSQL
 - Spring boot
 - Thymeleaf
 - HTML/CSS

**Constraints**
Because benefit packages can be different and (in the Netherlands) have a lot of different tax regulations. To keep the focus on building a web app and getting used to Spring, I chose to reduce the complexity of benefit packages and tax law. The tax calculations are a simplified representation of what it will be in reality. 

<h2> The plan before building </h2>
Before I started writing code, I wrote a plan of what I would build. During the process, the plan, give or take, stayed the same.  After writing all functionalities down in bullet points, I created basic wireframes to get an idea of what the web pages should look like.

Originally, I did want to have two forms on one page so you could compare two job offers at the same time. During the building process, it was hard to capture the right form of information for the right object, and I decided to remove this functionality for now.

Also, I created  a database schema. The database has the following tables

- users
- companies
- caos
- benefitpackages
- compensation

<h2>Functionalities</h2>

 - [x] Registration form that adds a new user to the database
 - [x] Hash generator for the users pasword so the actual password isn't stored in the DB
 - [x] Login page that checks if the user excists and the passwords-hash are a match
 - [x] After a succesful login placing a cookie so the browser know which user is using the application
 - [x] Forms to enter job offers
 - [x] Rendering thymeleaf templates
 - [x] Connecting company_id and showing the company name in Thymeleaf templates
 - [x] Ability to update user information
 - [x] Transforming data to currency and date
 - [x] Added a few really basic unit test


<h2>Learnings & things to improve in the future</h2>
During CS50x, we mostly worked with programming languages such as C and Python. Besides some online courses about Java. This was the first time building a real project in Java. Also, finding the right tools and frameworks to build dynamic webpages in an easy way took some time.  

During the development process, I encountered multiple roadblocks. This gave me the opportunity (and forced me ;) ) to watch a lot of YouTube tutorials, read documentation, and deep dive into Stackoverflow. 

For the coming time, I want to focus on the following points: 

 - [ ] Implementing Spring Security for Registration and login
 - [ ] Get a better understanding of OOP 
 - [ ] Learn more about WebApp Architecture
 - [ ] Learn how to do more complex unit test
 - [ ] Learn more about cookies and how to effectively use them
 - [ ] Take more time to think upfront about what kind of implications a functionality might have
 - [ ] Evaluate / Reconsider UI more 
 - [ ] Every takes longer than you think ;)
