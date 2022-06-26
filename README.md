# CS360

I have attached Git to my Android Studio version control and submitted the project.
I will also add a .zip of my prject three as described in the guidelines for submission



**Briefly summarize the requirements and goals of the app you developed. What user needs was this app designed to address?**

I was to create an app that could perform basic inventory calculations. Because of my limited experience with android app 
development I tried to come up with a basic proof of concept that could be scaled later. In other words, I started with
a spreadsheet that could calcuate the inventory cost for only three items, but could easily scale to many more later.

**What screens and features were necessary to support user needs and produce a user-centered UI for the app? How did your 
UI designs keep users in mind? Why were your designs successful?**

I specifically needed a log-in page and a main activity page where the inventory spreadsheet would live. I added a menu 
at the botton for navigation and the main functions a user would expect, like 'save', 'logout', etc.

**How did you approach the process of coding your app? What techniques or strategies did you use? How could those be 
applied in the future?**

I realized halfway into my project that I needed to start completely over. Android studio comes with a list of templates
that already contain much of the code necessary to do familiar functions. It would be unwise for a person to start from zero. 
Instead, I used the login template and modified to the code to direct to my main activity after login was complete. 

I added the necessary class for SQLite as well, to keep these functions sorted. 

**How did you test to ensure your code was functional? Why is this process important and what did it reveal?**

I should have added some Java tests for SQLite but I ran out of time in development and was unable to complete this funciton. 
I feel like we spent too much time in the UI portion of Android development and we should have spent more time on the code itself.
Instead of adding Java tests I tested each function on my own personal phone. I found quite a few bugs and worked them out as they
appeared. 

**Considering the full app design and development process, from initial planning to finalization, where did you have 
to innovate to overcome a challenge?**

I had to go back and start over completely because I wanted to seperate each function by a seperate class. For example, 
I didn't want the login function to be a part of MainActivity. Instead, I wanted the login function to be a class on it's own. 
It was much easier to utilize a template join it to my main activity.

I also learned how to call a different activity in the manifest, so I readirected my app to begin in the Login activity rather than the Main activity.




In what specific component from your mobile app were you particularly successful in demonstrating your knowledge, skills, and experience?

