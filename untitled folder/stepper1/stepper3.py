
import sys
import time
import RPi.GPIO as GPIO


GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

StepPins = [15,18,17,27]

for pin in StepPins:
  GPIO.setup(pin,GPIO.OUT)
  GPIO.output(pin, False)

Seq = [[1,0,0,1],
       [1,0,0,0],
       [1,1,0,0],
       [0,1,0,0],
       [0,1,1,0],
       [0,0,1,0],
       [0,0,1,1],
       [0,0,0,1]]
      
DEG = int(sys.argv[1])
# Start main loop
DEG = ((int)((float(DEG) / 360) *512))
if(DEG<0):
	StepPins = [27,17,18,15]
	DEG*=-1
for i in range(DEG):
	for stepper in range(8):
		  for pin in range(4):
		    	xpin = StepPins[pin]
		    	if (Seq[stepper][pin]!=0):
		      		GPIO.output(xpin, True)
		   	else:
	     			GPIO.output(xpin, False)
	
  
  		  time.sleep(0.005)
