# Capstone: Analyzing (Social) Network Data
````text
In this capstone project we’ll combine  all of the skills from all four specialization courses 
to do something really fun: analyze social networks!  

The opportunities for learning are practically endless in a social network.  
Who are the “influential” members of the network?  
What are the sub-communities in the network?   
Who is connected to whom, and by how many links?   
These are just some of the questions you can explore in this project.

We will provide you with a real-world data set and some infrastructure for getting started, 
as well as some warm up tasks and basic project requirements, 
but then it’ll be up to you where you want to take the project.  
If you’re running short on ideas, we’ll have several suggested directions 
that can help get your creativity and imagination going.  
Finally, to integrate the skills you acquired in course 4 (and to show off your project!) 
you will be asked to create a video showcase of your final product.
````

#### After completing the capstone, you will be able to...
````text
    - Independently implement a Java project of significant size.
    - Pose questions that can be answered with social network data.
    - Develop or find/select algorithms to answer these questions.
    - Make software design decisions. 
    - Describe a technical project both through written reports and oral presentations.
    - Review others’ code design and oral presentation.
    - Analyze algorithms to assess their appropriateness for solving a given problem on real-world data.
    - Iterate a design to improve style and efficiency.
````

#### Project Components and Checkpoints

**Week 1: Warm up assignment (required, auto-graded)**  In this first assignment you will start to work with some real-world social network data and implement some graph algorithms to help you warm up and dive back into data structures and Java programming.
**Week 2: Project scope and definition (required, peer-graded)**  In this second week you will define the scope of your project.  This assignment will involve selecting a data set, determining what questions you will ask about your data, finding or developing the data structures and algorithms to answer those questions, and doing a preliminary analysis of the running time of these algorithms.
**Week 3: Mini-project and report (optional, peer graded)**  One of the questions you will pick in Week 2 to ask about your data set is required to be relatively easy to answer.  This will allow you to go through the "full cycle" of the capstone project from question formulation to implementation to report and get some early feedback on each of these components, before you repeat the process on a more challenging question and algorithm.  In this week, you'll do this first "full cycle".
**Week 4: Main project checkpoint (optional, peer graded)**  In week 4 you should be well into the investigations of the questions you laid out in week 2, and you should have already gotten some feedback from your peers about the scope of your projects which you will be using to guide and refine your work.  This week you have the option to report on your progress and again get guidance from your peers to ensure that you will pass the main report assignment in week 5.
**Week 5: Main project report (required, peer graded)**  In week 5 you will complete the implementation of your project and submit your code and a final written report (including an analysis of your algorithm(s)) for peer review.   You will also perform peer review on your peers' submitted project reports.
**Week 6: Oral project report (required, peer graded)**  In week 6 you will complete an assignment very similar to the assignment you completed in week 3 of our course on Mastering the Software Engineering Interview.  We will ask you to submit a video in which you give an oral presentation addressing specific aspects of your project.  You will also perform peer review on your peers' submitted oral presentations.

#### Project Requirements
```text
    1. You must work with real-world social network data.  It does not have to be extremely large, but it must have enough data to make it interesting (usually at least a hundred nodes or more).  You may use any of the data sources we provide with the starter code, or you may use any datasource you legally obtain online.  This github “awesome list” is a great place to look:  https://github.com/caesar0301/awesome-public-datasets#social-networks
    2. You must propose at least two questions that you will explore via the code you write.  One of these questions must be relatively easy to answer (e.g. you should be able to write the code to answer it in less than a week) while the other should be more complex.  Examples of the types of questions we expect will be given in week 2.
    3. You must implement code to explore the questions you propose on your data set.  It is not enough to simply explore the data in a program like excel.  We are looking for a sophisticated program that implements at least a graph and at least one (though probably many more) graph algorithms (see next requirement).
    4. To answer your "harder" question, you must implement at least one new graph algorithm that you have not previously implemented in this specialization.  As a reminder, the algorithms you have previously implemented include breadth-first search, Dijkstra’s Algorithm, and A* search, though for the purpose of the capstone, DFS doesn’t count as a new graph algorithm either.
    5. Your overall grade on the capstone project will be based on a combination of: (1) the scope of your project--the more ambitious the project, the more points you can earn here, (2) the quality of your code and implementation--your peers will be reviewing your code, (3) how well you were able to answer the questions you posed, or how well your program allows someone to explore the answers, including the appropriateness of your algorithm and data structures that you chose to implement (4) the correctness of your analysis of the running time of your algorithm, (5) your oral presentation in week 6. 
    6. Your grade on this project will be used, along with your performance in the rest of the specialization, when we select learners who will get invited to "perks" associated with the class, for example invitations to be community mentors and invitations to participate in sessions with Google engineers.

# CREDITS
````text
/-------------------------------------------------------------------------
/ Starter Code for Capstone Project in the
/ Java Programming: Object Oriented Design of 
/ Data Structures Specialization:
/
/ Capstone: Analyzing (Social) Network Data
/ https://www.coursera.org/learn/intermediate-programming-capstone
/
/ Authored by UCSD MOOC Team:
/ Mia Minnes, Christine Alvarado, Leo Porter, Alec Brickner
/ and Adam Setters
/
/ Date: 3/21/2016
/-------------------------------------------------------------------------

---------------------------------------------------------[ DESCRIPTION ]--

The files provided are skeleton code, as well as grading previews and 
testing files to be used in completing the course programming 
assignments. No code will be provided for the capstone project.

---------------------------------------------------------------[ FILES ]--

Below are the files provided for the warm-up assignment in week 1:

graph.Graph.java
graph.CapGraph.java
util.GraphLoader.java
graph.grader.Grader.java
graph.grader.EgoGrader.java
graph.grader.SCCGrader.java

Data files and information about them can be found in the 
data/ directory.

---------------------------------------------------------------[ SETUP ]-- 

Importing Project into eclipse:
	1. Create a new Java Project in your workspace
	2. Import the starter files:
	  File -> Import -> Select "File System" -> Next -> Browse and set 
	  root directory to folder contents of zip were extracted to -> Finish

Feel free to use another IDE or manually compile and run your programs.
If you need help, Google is your friend.
````
