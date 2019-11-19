# College_Management_System
Made GUI with bags ,to hold students, faculty, Classrooms, and Textbooks. 
------------------------------------------------------------------------------

1. Implement a BorderPane as the root pane for the scene.
2. Set a HBox in the bottom region of the BorderPane. In the HBox, you will build the following
buttons:

A. Student: When clicked, a student pane, comprised of a set of nested HBox and VBox, will
show up in the central region of the BorderPane. These boxes contain TextFields that be
used to obtain input such as first name, last name, ID, major, phone, etc, from the user for a
student. These same TextFields will also be used to display such information from the
Student object to be found by ID number from the person bag in the future. In addition to
these TextFields, the set of nested HBox and VBox contains four buttons: Insert, Remove,
Find, and Update. Insert will allow the user to insert a student object using the information
collected from the TextFields into the person Bag. Remove will somehow (your choice)
obtain an ID number from the user and remove the corresponding object from the bag.
Similarly, Find will find the object and display the information of that object by using an ID
number from the user, and Update will allow the user to make changes to the Student
object found and then save it back to the bag without deleting it.

B. Faculty: When clicked, a set of nested HBox and VBox will show up in the central region of
the BorderPane. These boxes contain TextFields that be used to obtain input such as first
name, last name, ID, salary, phone, etc., from the user for a faculty member. These same
TextFields will also be used to display such information from the Faculty object to be found
by ID number from the person bag in the future. In addition to these TextFields, the set of
nested HBox and VBox contains four buttons: Insert, Remove, Find, and Update. Insert will
allow the user to insert a Faculty object using the information collected from the TextFields
into the person Bag. Remove will somehow (your choice) obtain an ID number from the user
and remove the corresponding faculty object from the bag. Similarly, Find will find the
faculty object and display the information of that object by using an ID number from the
user, and Update will allow the user to make changes to the Faculty object found and then
save it back to the bag without deleting it.

C. Textbook: When clicked, a set of nested HBox and VBox will show up in the central region of
the BorderPane. These boxes contain TextFields that be used to obtain input such as title,
author, description, ISBN, price, etc., from the user for a textbook. These same TextFields
will also be used to display such information from the Textbook object to be found by the
ISBN number from the textbook bag in the future. In addition to these TextFields, the set of
nested HBox and VBox contains four buttons: Insert, Remove, Find, and Update. Insert will
allow the user to insert a Textbook object using the information collected from the
TextFields into the Textbook Bag. Remove will somehow (your choice) obtain an ISBN
number from the user and remove the corresponding Textbook object from the bag.
Similarly, Find will find the Textbook object and display the information of that object by
using an ISBN number from the user, and Update will allow the user to make changes to the
Textbook object found and then save it back to the bag without deleting it.

D. Classroom: When clicked, a set of nested HBox and VBox will show up in the central region
of the BorderPane. These boxes contain TextFields that be used to obtain input such as
building name, room number, capacity, projector or not, etc., from the user for a classroom.
These same TextFields will also be used to display such information from the Classroom
object to be found by the room number from the classroom bag in the future. In addition to
these TextFields, the set of nested HBox and VBox contains four buttons: Insert, Remove,
Find, and Update. Insert will allow the user to insert a Classroom object using the
information collected from the TextFields into the Classroom Bag. Remove will somehow
(your choice) obtain an room number from the user and remove the corresponding
Classroom object from the bag. Similarly, Find will find the Classroom object and display the
information of that object by using an room number from the user, and Update will allow
the user to make changes to the Classroom object found and then save it back to the bag
without deleting it.

E. Backup: When clicked, the program will backup all the bags into individual binary files.
F. Restore: When clicked, the program will restore all the bags from individual binary files.
G. Exit: When clicked, the program will do backup and then quit.
