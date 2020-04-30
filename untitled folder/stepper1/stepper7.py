
import sys
import time
import RPi.GPIO as GPIO


GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

StepPins = [11,9,25,10]
StepPins2 = [19,13,6,5]
StepPins3 = [0,1,7,8]

for pin in StepPins:
  GPIO.setup(pin,GPIO.OUT)
  GPIO.output(pin, False)
for pin in StepPins2:
  GPIO.setup(pin,GPIO.OUT)
  GPIO.output(pin, False)
for pin in StepPins3:
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
      
DEG = (sys.argv[1])
index = DEG.index('L')
DEG1 = (int)(DEG[0:index])
DEG2 = (int)(DEG[index+1:])
print(DEG1)
print(DEG2)
DEG1 = ((int)((float(DEG1) / 360) *512))
DEG2 = ((int)((float(DEG2) / 360) *512))
if(DEG1 < 0):
	StepPins = [10,25,9,11]
	DEG1 *=-1
if(DEG2 < 0):
	StepPins2 = [5,6,13,19]
	StepPins3 = [8,7,1,0]
	DEG2 *=-1
if(DEG1 > DEG2):
	DEG = DEG1
else:
	DEG = DEG2
print(DEG1)
print(DEG2)
for i in range(DEG):
	other = 8
	for stepper in range(8):
		  other = other -1
		  for pin in range(4):
		    	xpin = StepPins[pin]
			xpin2 = StepPins2[pin]
			xpin3 = StepPins3[pin]
		    	if (Seq[stepper][pin]!=0):
				if(i < DEG1):
		      			GPIO.output(xpin, True)
				if(i < DEG2):
					GPIO.output(xpin2, True)

		   	else:
				if(i < DEG1):
	     				GPIO.output(xpin, False)
				if(i < DEG2):
					GPIO.output(xpin2, False)
			if (Seq[other][pin]!=0):
				if(i < DEG2):
					GPIO.output(xpin3, True)
			else:
	     			if(i < DEG2):
					GPIO.output(xpin3, False)
  		  time.sleep(0.005)