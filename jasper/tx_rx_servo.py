import serial
import time
import RPi.GPIO as GPIO
import numpy as np


motorInterval = 30

GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.OUT)        #6th pin on the rightside of gpio headers
pwm = GPIO.PWM(18, 50)
pwm.start(2.5)

duty_cycle_forward = np.arange(2.5, 12.6, 1.0)
duty_cycle_reverse = np.arange(12.5, 2.4, -1.0)

def run_servo(motor_interval):
        '''
        Function to run servo motor once forward and backward
        '''
        if motor_interval < 1:
                return
        for i in range(motor_interval, 0, -1):
                print 'countdown ', i
                time.sleep(1)
        for i in duty_cycle_forward:
                pwm.ChangeDutyCycle(i)
                time.sleep(0.05)
        for i in duty_cycle_reverse:
                pwm.ChangeDutyCycle(i)
                time.sleep(0.05)

ser = serial.Serial(
               port='/dev/ttyS0',
               baudrate = 9600,
               parity=serial.PARITY_NONE,
               stopbits=serial.STOPBITS_ONE,
               bytesize=serial.EIGHTBITS,
               timeout=1
           )
counter = 0

print counter

while True:
        line = ser.readline() 
	print line
	if ("FEED NOW" in line ):
		run_servo(1)
		print "SUCCESS"
