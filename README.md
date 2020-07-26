# Kids Game - Final Project for UCSC Extension
### Project Proposal:
#### Student: 
Sergey Odintsov, 
#### Course No: 
CMPR.X413.(818), 
#### Course Title: 
Java Programming Comprehensive Course Date: 2020 Spring.

### Project Overview:
My project is a Game. The game will help 3 - 4 years old kids (actually my son) to learn how to read and pronouns words in Russian and English by syllables. It will:
1.   The application will be available on the Play Store for download and install on Android smartphones.
2.  Pull image and syllables data from a JSON file AND/OR from the web storage.
3.  Users can select the preferred language: Russian OR English.
4.  Users can select different topics: Animals, Transport (so far).
5.  User will select by clicking on buttons with random different syllables to create the whole word of the displayed image.
6.  Users can select the option: Click the button with sound or without. It will read a corresponding *.mp3 file of the syllable or letter on the button.
7.  Allow users to see the hint (help) in case if stuck with the answer.
8.  User can turn sound OFF and ON
9.  App UI contains a manual in the Settings-> Help, which will locate on the online web-page.

<img src="https://github.com/mobilotest/Kids_Game_Final_Project/blob/master/images/zero.jpg" width = 600>

### Implementation Details:
Interfaces:
LoaderManager

#### Data: 
Images (*.png), Audio (*.mp3), JSON 

#### GUI: 
Android vertical screen.

#### Classes:
MainActivity
Screen
ScreenLoader
QueryUtils

#### Fields:
Buttons, TextFields, Menu Elements

#### Languages: 
JAVA, XML, JSON
Packages:
KidsGame 

#### Databases: 
All JSONs and Images uploaded to Google's Firebase server

### Project Plan:
1. Project Proposal 6/27 
2. Project Approval - 6/30 
3. UML Diagrams - 7/1 
4. Class Definitions - 7/3 
5. API Code - 7/5
6. Database Code - 7/7 
7. Visualization Code - 7/10 
8. Unit Testing - 7/15 
9. System Testing - 7/17 
10. Project Feedback - 7/20 
11. Project Submission - 7/27

### Tasks:
1.  Create a UML diagram
2.  Download images
3.  Record .mp3 files
4.  Create a UI
5.  Learn and somehow connect a JSON file with all related data
6.  Create a JSON file(s)
7.  Upload Images/JSONs to server
8.  Create a code with multithredding for images and audio
9.  Upload documentation
10. Upload app to the Play Store
11.  Implement Dimensions for all text fields (https://developer.android.com/guide/topics/resources/more-resources.html#Dimension) (TBD)
12.  Integrating Espeak or meSpeak into the project to support the reading of syllables in Russian. Espeak is a speech synthesizer and it supports many languages including Russian: http://espeak.sourceforge.net (TBD)
13.  Reduce the size of your images by using the WebP format. WebP images are typically 25-34% smaller than comparable JPGs: https://developer.android.com/topic/performance/network-xfer#webp (TBD)
14.  Add monetizing commercial banner on the bottom of the screens (TBD)

### UML diagram:
<img src="https://github.com/mobilotest/Kids_Game_Final_Project/blob/master/images/uml.png" width = 600>

### Kids Game's Screenshots:
<img src="https://github.com/mobilotest/Kids_Game_Final_Project/blob/master/images/one.png" width = 200> -> <img src="https://github.com/mobilotest/Kids_Game_Final_Project/blob/master/images/two.png" width = 200> -> <img src="https://github.com/mobilotest/Kids_Game_Final_Project/blob/master/images/three.png" width = 200>
<img src="https://github.com/mobilotest/Kids_Game_Final_Project/blob/master/images/four.png" width = 200> -> <img src="https://github.com/mobilotest/Kids_Game_Final_Project/blob/master/images/five.png" width = 200> -> <img src="https://github.com/mobilotest/Kids_Game_Final_Project/blob/master/images/six.png" width = 200>

### Resources:
1.  https://console.firebase.google.com/
2.  https://commons.wikimedia.org/
3.  https://github.com/
4.  https://stackoverflow.com/
5.  https://developer.android.com/
6.  https://jsonformatter.curiousconcept.com/
7.  https://www.w3schools.com/
8.   https://classroom.ucsc-extension.edu/
9.  https://www.udacity.com/
10.  https://www.youtube.com/
11.  http://www.fromtexttospeech.com/
12.  https://www.google.com/
13.  https://www.freepngs.com/
14.  https://www.flaticon.com/free-icon/
15.  https://ttsmp3.com/
16.  https://online.visual-paradigm.com/
