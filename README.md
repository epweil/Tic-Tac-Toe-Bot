# Tic-Tac-Toe-Bot
Ethan Weilheimer 
Epweil1282@gmail.com
(215) 837-9851



Controlling code for a 3 axis robotic arm run off of a raspberry pi. Takes in information on moves from a camera atop the board and then responds with its move using the arm to draw. Uses a Java GUI for user control of the game and as a scoreboard. 

How the bot determines where the lines are...
    Using the buffered image library, I can create a 2D array of the Pixels in the photo and then transverse the RGB      
    values of the picture to determine when there is a color to determine if there is a line there. 
    
    
How the bot determines where the person moved...
    Using the buffered image library, I can create a 2D array of the Pixels in the before photo and after photo and    
    then compare the RGB values of the two pictures to determine where the color has changed, and knowing where the lines are 
    based upon the information above, I can use if statements to figure out what box the person drew in. 
   
How the bot knows where to go...
   Impossible mode:
           For the first move, each move is hardcoded based upon where the person has moved. The second move is also hardcoded 
           except if the person can win and the bot must block it. The third move is solely based upon if the person can win 
           or if the robot can win, and of not, it picks a random square, and will not lose. 
   
   Easy mode:
           For each move, the program selects a square that has not been moved in at random.
           
           
How the robot draws...
    First, the bot determines the nearest border on each of the four sides of the box, and the x and y pixel values each side.    
    The bot determines the distance using how many pixels in the vertical and horizontal direction, in addition to how far 
    that is in mm using the proportion of how many pixels across equivocates to the 205mm the tic-tac-toe board is. Then using   
    Pythagorean theorem I can figure out the distance to the spot, and then using a TAN function, I can figure out the angle 
    to the spot.
    
    Then using the SIN and COS theorem, I can determine the necessary angles for the two parts of the arm to cover the 
    distance necessary to get to the spot, then the angle necessary to have the pen at the necessary angle to get to the spot.
    The arm then moves, lowers the pen, draws the circle, raises the pen, and returns home. 
    
    

    

    
