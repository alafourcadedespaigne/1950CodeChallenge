#  Sotware Engineering Chanllenge

## Solution to the Marble Collection problem

The solution is  published on Github at the following link [Marble Solution](https://github.com/alafourcadedespaigne/1950CodeChallenge).


### Solution Details

The **solution** is responsible for solving the problem raised in the Code Challenge. To do this, it relies on the benefits of Java in its version 8+ Such as: **Stream, Comparable, Comparator**.
The **most significant** methods are as follows:

**static boolean isPalindromeIgnoringCapitalizationAndPunctuation(String text)**  
This method, using regular expressions given a string, returns true or false if the string is a palindrome, ignoring capitalization and punctuation.

**static List<Marbles> orderedListOfMarbles(List<Marbles> exampleList)** This method using custom Comparator given a list of **Marbles** returns a list of the same type but ordered by color in the following order: ** Red, Orange, Yellow, Green, Blue, Indigo, Violet (ROYGBIV).**

### Extra information

The complexity of the algorithm is O(n).

For the deployment of the solution we can use an A/B Deployment or Blue Green strategy, which will allow us to have two parallel production environments (Blue & Green) in which the new versions of the application are deployed in this case the algorithm alternatively. This will give us the advantage of facilitating a rollback to the previous version, in case there is a failure in the new version, simply by routing to the previous environment.

The Algorithm can be deployed on Amazon Web Services **(AWS)** , making use of serverless . This gives me many advantages since I would not have to worry about anything related to the infrastructure necessary to make my algorithm public, AWS itself takes care of it.
In the case of this algorithm, the solution would be BaaS, that is, Backend as a service; where I will rely on the **Api Gateway** and **AWS lambda** services of the Amazon cloud to finally build a serverless REST API.

The relationship between the components that give life to the Rest API that my algorithm will show would be the following.

- AWS Lambda: It is where the code of our algorithm will be implemented. Since lambdas in AWS are managed under the FaaS or Function as a Service scheme, so we will create a lambda for each function. For this reason we split our application into several granular functions (**isPalindromeIgnoringCapitalizationAndPunctuation, orderedListOfMarbles, etc...** )
- Api Gateway: It is the component that we will use to link a request to an implemented function. So when that particular request comes in, the function is called. We handle this this way because lambdas are event based and an event can be an HTTP request to our REST API

For automation and deployment we can make use of GitHub Actions, since our code is hosted on Github. GitHub Actions offer native capabilities directly in the GitHub flow and we can automate that once a push has been made to our master branch in Github, an action is triggered that makes it possible, through the integration of Github with **CodeDeploy**, to automate the deployment of our lambda(s) in the amazon cloud.

In the event that the order of the data is of millions of records to be processed, it is not advisable to use the memory for it, so the most convenient would be some tool for processing large amounts of data (Big Data Tools), in this case case we can work with Apache Spark since it is specially designed for processing large volumes of data.
