Team I Readme - Sprint 2

Billy Sargent
Jack Nevill
Jack Littleworth
George Higgins
Ollie Chauncy


To run the program, compile every java file in the folder using "javac *.java" and run "SimoriON.java" with all of the other java and image files in the same directory.

SPRINT 1
- Press 'ON' button in order to switch on Performance mode and be able to make sounds using the sound board. Press 'ON' again to clear the matrix and to stop all currently playing sounds.
- The 'L', 'R' and 'OK' buttons have no functionality, as well as the Text Box at the bottom. They are simply there for functionality to be added in during a later sprint.
- No JUnit testing has been supplied at this stage. In later sprints we will be doing JUnit testing, but at this point because of the way we have written our code we felt it was not necessary. This is due to the fact that if our code is not working it will either not be visible, or inaudible, and these outcomes are more easily tested by humans rather than testing classes.

SPRINT 2 
-L1, L2, L3 have complete functionality. L4 and R1 do not have functionality but they have been coded to give the appearance that they work (ie will select the horiztonal row/ vertical column of the grid button selected). We have not yet found a way to write the instrument name to the text box but this will be sorted out next sprint. 
-JUnit testing has been supplied now. We were unable to get it to run on the blue room machines but our testing code will be included with our submission.
-We have changed a fair amount of our code, primarily in the CustomButton and CustomToggle. In CustomButton we have now coded it so that it calls a number of different classes, one for each side button. These classes are all newly made in an attempt to neaten our code and make it easier to understand. In Custom Toggle we have now added more to our onclick action to cope with the different situations that arise when the side buttons are pressed.
