import sys
import time
import RPi.GPIO as GPIO


GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

StepPins = [20,21,4,14]

for pin in range(26):
  GPIO.setup(pin,GPIO.OUT)
  GPIO.output(pin, False)

for pin in range(26):
  GPIO.output(pin, False)

	
  