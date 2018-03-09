from urllib2 import Request, urlopen, URLError
import json 
import RPi.GPIO as GPIO
import time
import numpy as np

request = Request('http://foofish1-env.us-east-1.elasticbeanstalk.com/webapi/myresource/getDeviceConfig')

motorInterval = 30
cameraInterval = 30

GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.OUT)	#6th pin on the rightside of gpio headers 
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

def main():
	global motorInterval, cameraInterval 
	while(1):
		time.sleep(1)
		response = json.load(urlopen(request))
		if motorInterval != response['motorInterval']:
			motorInterval = response['motorInterval']
			print "motorInterval: ", motorInterval
			run_servo(motorInterval)
                	print '------------------------------------------'
   
		if cameraInterval != response['cameraScreenshotInterval']:
			cameraInterval = response['cameraScreenshotInterval']
        		print "cameraInterval: ", cameraInterval
			print '------------------------------------------'

##################
# MAIN STARTS HERE
##################
main()


