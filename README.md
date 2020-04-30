# Tic-Tac-Toe-Bot
Controlling code for a 3 axis robotic arm run off of a raspberry pi. Takes in information on moves from a camera atop the board and then responds with its move using the arm to draw. Uses a java GUI to for user control of the game and as a score board. 

How the bot determines where the lines are...
    Using the buffered image library, I am able to create a 2D array of the Pixels in the photo and then transverse the RGB      
    values of the picture to determine when there is a color to determine if there is a line there. 
    
    
How the bot determines where the peron moved...
    Using the buffered image library, I am able to create a 2D array of the Pixels in the before photo and after photo and    
    then compare the RGB values of the two picture to determine where the color has changed, and knowing where the lines are 
    based upon the infomation above, the I am able to use if statements to figure out what box the person drew in. 
   
How the bot knows where to go...
   For the first move, each move is hard coded based upon where the person has moved. The second move is also hard coded with   
   the excepion of if the person can win and the bot must block it. The third move is solely based upon if the person can win or if the robot can win, and of not, it goes 
    
