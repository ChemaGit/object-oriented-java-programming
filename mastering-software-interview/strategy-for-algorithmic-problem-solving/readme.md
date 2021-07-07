# A strategy for algorithmic problem solving
````text
- Describe a strategy for solving new problems 
- Give an example of an algorithmic problem and apply our problem solving strategy to this example
- List evaluation criteria for effective algorithmic problem solving sessions
- Critique others and yourself in solving algorithmic problems on the fly
````

## Your experience

#### What do you like about solving algorithmic questions?
````text
I mainly like to decompose the problem in little pieces and solve these little pieces 
and afterward rejoin all the pieces together again.
````

#### What are your concerns about solving algorithmic problems on the fly during the interview? 
````text
My main concern would be if I cannot have  a pencil, a rubber and a paper.
````

## Data structures, algorithms and code constructs you'll need for your interview
````text
Throughout this course we've talked about several data structures and algorithms 
you'll need to have in your toolbox as you approach an interview.  
Here we're providing a list of the most important ones.  
You should probably know how to (1) use, (2) implement, and (3) analyze the running time 
of all of the data structures and algorithms listed below.  
This is not an exhaustive list by any means, and if you know of more, please post them in the forum.  
If the post gains enough momentum, we'll pin it to the top.

Most of these concepts are covered to some degree in the previous courses in our specialization, 
but it never hurts to find other sources and study them as much as possible.  
And don't try to "just memorize" anything.  
If your understanding of these concepts is solid, you'll be much better off in a high-stress situation!
````

#### Data Structures and Abstract Data Types
````text
- Arrays
- Linked Lists: single and double, with and without sentinel nodes
- The List ADT
- Trees: Binary and otherwise, BSTs
- The Set ADT
- Tries
- Heaps
- Stack, Queue and Priority Queue ADTs
- Graphs: directed and undirected, different representations and their trade-offs 
- Hashtables: collision resolution strategies, hash functions and their trade-offs
- The Map ADT
````

#### Algorithms
````text
- Binary search
- Sorting algorithms: Selection Sort, Insertion Sort, Bubble Sort, Quicksort, Mergesort, Heapsort
- Search algorithms: Depth-first search, Breadth-first search, Dijkstra's algorithm
- Tree traversal: pre-order, post-order, in-order, level-order (which is BFS)
- Algorithm techniques: Brute force, Divide and conquer (e.g. Mergesort), Greedy, Dynamic Programming (more advanced, OK not to know if you are at an intermediate level)
- NP-hard problems
````

#### Basic Java Programming Constructs
````text
- All the very basics of course (loops, conditionals, functions, etc)
- Input and output: from files and command line
- The String and Character class
- Converting between data types
- Object oriented design and concepts: Inheritance and Polymorphism, Classes and Objects, static and non static, access level modifiers (public, private, protected)
- The java.util library (including all of the container classes)
- The Iterator pattern (more advanced, probably OK not to know if you are at an intermediate level)
- Exception generation and handling
- Event-driven programming
- Inner classes and anonymous classes (slightly more advanced, but good to know about)
- Lambda expressions (more advanced)
````

#### Classes of problems to study
````text
Several kinds of questions are standard in an interview setting.  
Make sure you seek practice with each of these different kinds of problems.

- Object oriented design, using given data structures.
- Bitwise manipulation of integer representations.
- Game theory puzzles: "muddy children", volcano eruptions.
- Estimating bounds: "how many chickens are there in Chicago?"
````

#### Evaluation questions
````text    
We've worked through several examples of the 6-step process for solving technical problems 
in an interactive setting.  
To prepare for the assignment this week, 
which will ask you to critique both the mock interviews we provide as well as your own interview 
which you will record, this reading summarizes the main questions 
that interviewers will ask themselves to evaluate your execution of the 6-step process.  
We will ask you to apply some of these questions to the mock interviews and then to your own interview. 

 1. How did the candidate analyze the problem?
 2. Did the candidate miss any special or edge cases?
 3. Did the candidate approach the problem methodically and logically? 
 4. Did the candidate ask clarifying questions when they were stuck?
 5. Does the candidate have a strong foundation in basic computer science concepts?
 6. Did the candidate produce working code? Did the candidate test the code?
 7. Is the candidate’s code clean and easy to read and maintain? 
 8. Can the candidate explain their ideas clearly?
 9. Is the candidate pleasant to work with? 

Remember, an interviewer is trying to understand how you approach and solve a problem. 
The answer doesn’t always need to be right.
````

## Solving algorithmic problems on the fly: Part 1

#### Compare and contrast how the candidates *analyzed the problem*? What did the candidate do in the good interview that the one in the bad interview did not, and vice versa?
````text
The good interview candidate starts making questions about the problem, in contrast
the bad interview candidate starts coding what indeed is very bad.
````

#### What edge cases did the candidate in the bad interview miss?  How could he have avoided missing these?
````text
For example, how to manage duplicates. He could avoid this making a high level analysis.
````

#### Give an example of where the candidate in the good interview approached the problem methodically and logically.
````text
He starts making a high level analysis of the problem and not starting coding at the beginning.
He asks for edge cases as for example, how to handle duplicates.
````

#### Give at least one example that indicates that the candidate in the bad interview does not have a strong foundation in basic computer science concepts?
````text
He has a lot of doubts about data structures. A hashmap cannot be sorted for example or he doesn't know very 
much about trees, the interviewer had to explain him what a balanced tree is.
````

#### Reflect on the code produced in the two interviews.  Does the code in the bad interview work?  Why not?  In what ways is the candidate's code in the good interview easier to maintain than the code in the bad interview?
````text
I don't think so, because it wouldn't produce the expected results. 
He isn't applying the same probability to all nodes in the tree.
I think because the good interview candidate encapsulates all the code in a class.
````

#### Give examples from the two interviews that indicate how the candidates would or would not be pleasant to work with?  Be specific and justify why you think a particular action or statement indicates that the candidate would or would not be a pleasant and productive person to have on a team. 
````text
The bad interview candidate seems very nervous, he doesn't ask questions and starts coding very fast, without 
making a good thinking about the problem first, he has communication problems. 
At the end of the interview he doesn't ask any question what indeed is a bad signal.

On the contrary the good interview
candidate has very good soft skills, he looks very confident, 
and he keeps making questions throught the whole process.
````

#### The mock bad interview
````text
- He looks very nervous.
- He doesn't keep eye contact, and maintains large pauses without talking.
- He started coding from the beginning instead of asking questions.
- He didn't understand "high level approach"
- He presupposes things that do not have to be that way. He should ask the interviewer. 
- The interviewer ask him for a high level approach over and over again.
- The interviewer gives him a lot of hints.
- He should ask for edge cases and constraints to the interviewer instead of assuming everything.
- He didn't have any questions. It's always good to have some questions to do to the interviewer.
````

#### The mock good interview
````text
- He starts making questions about the problem, what indeed is very good.
- He starts doing a high level analysis of the problem asking for edge cases.
````

#### My mock interview
````text
- is it storing in any particular type of data?
- can I assume insert just takes an integer?
- Remove will take in an int, and then do they return anything?
- How are duplicates handle?
- So, could insert and remove return a boolean?
- getRandom, How exactly is that working?
- can I assume I have some kind of random number generator?
- can I assume that the random generator works in constant time?
- Do you have any questions for me?
- Yeah! What is it like being an engineer here? 

- Given a list of numbers between 0 and n, with exactly one number removed, find the missing number.
- can I assume that the type is an ArrayList of Integers?
- Sure! the type of the numbers is integers.
- Is this list of numbers ordered?
- It could be ordered but couldn't be too.
- Ok!
- I would build a function that take an ArrayList of Integers and the number (n) 
  that returns the missing number, so an Integer
- Great! You can do that.
- If I go through the list from the start the next number in the list will be current + 1.
- The size of the list will be n-1, so I would declare a variable index starting at 0 
  in order to iterate through the list.
- In the worst case will be in linear time O(n)
- Could you this better than linear time?
- Well, let me think for a while, please.
- I think a better approach would be doing the sum between 0 until n with the function: n*(n+1)/2
- Yeah! could you probe that function?
- Sure! for example: n = 4 so we have 1+2+3+4 = 10 --> 4*(4 + 1)/2 = (16+4)/2=10
  another example: n = 5 so we have 1+2+3+4+5 = 15 --> 5*(5 + 1)/2 = (25+5)/2=15
- Could be the sum a big number? a long or bigInt number?
- No! you can assume the the sum will be an integer, never a long or bigInt.
- Ok!
- So, I can calculate the sum, afterward I could iterate through the list doing the sum of the list,
  then subtract (sum of n) - (sum of the list) and the result will be the missing number.
- The sum of the list will be always in linear time, and the sum of n will be constant.
- Can I code the function now?
- Yeah! if you are sure with the solution.
````
````java
private int sumList(ArrayList<Integer> lst) {
    sum = 0;
    lst.forEach(n -> sum += n);
    return sum;
}

public int findMissingNumber(ArrayList<Integer> lst, int n) {
    int missing = 0;
    int sum = (n * n + n) / 2;
    return sum - sumList(lst);    
}
````

**What was the biggest strength in your interview?  What did you do particularly well?**
**What was the biggest weakness in your interview?  What do you most need more practice with and how will you get the practice you need?**
````text
I believe that my biggest strength was that I could make out the solution quickly 
and find out a way in order to write code clean and maintainable.
My biggest weakness in general is that I usually get nervous very quickly. 
I have to cope with that and improve my soft skills.
````




