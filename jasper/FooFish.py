# -*- coding: utf-8-*-
import random
import re
import serial
import time

ser = serial.Serial(
               port='/dev/ttyUSB0',
               baudrate = 9600,
               parity=serial.PARITY_NONE,
               stopbits=serial.STOPBITS_ONE,
               bytesize=serial.EIGHTBITS,
               timeout=1
           )
counter = 0

def init_conn():
        ser.write('AT')
        time.sleep(1)
        ser.write('AT+CONNL')
        time.sleep(1)
        ser.write('AT+CONNL')
        time.sleep(1)



WORDS = ["FISH", "AQUARIUM",  "FEED", "HUNGRY"]


def handle(text, mic, profile):
    """
        Responds to user-input, typically speech text.

        Arguments:
        text -- user-input, typically transcribed speech
        mic -- used to interact with the user (for both input and output)
        profile -- contains information related to the user (e.g., phone
                   number)
    """
    messages = ["Feeding the fish now, Geethanjali",
                "Wow, Fish is happy now",
                "Fish says yummy yummy in my tummy"]

    init_conn()
    ser.write('FEED NOW\n')

    message = random.choice(messages)
    print message

    mic.say(message)

def isValid(text):
    """
        Returns True if the input is related to the FooFish.

        Arguments:
        text -- user-input, typically transcribed speech
    """
    return bool(re.search(r'\bfish\b', text, re.IGNORECASE))

