
import sys
import time
import RPi.GPIO as GPIO


GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
StepPins = [19,13,6,5]
StepPins2 = [0,1,7,8]
for pin in StepPins:
  GPIO.setup(pin,GPIO.OUT)
  GPIO.output(pin, False)
for pin in StepPins2:
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
if(DEG < 0):
	DEG*=-1
	StepPins = [5,6,13,19]
	StepPins2 = [8,7,1,0]
for i in range(DEG):
	other = 8
	for stepper in range(8):
		  other = other -1
		  for pin in range(4):
		    	xpin = StepPins[pin]
			xpin2 = StepPins2[pin]
		    	if (Seq[stepper][pin]!=0):
		      		GPIO.output(xpin, True)
			else:
	     			GPIO.output(xpin, False)
			if (Seq[other][pin]!=0):
				GPIO.output(xpin2, True)
			else:
	     			GPIO.output(xpin2, False)
		   	
	
  
  		  time.sleep(0.005)
