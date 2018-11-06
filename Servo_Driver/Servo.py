import socket
from threading import Thread
import time
import Constants
from board import SCL, SDA
import busio
from adafruit_pca9685 import PCA9685
from adafruit_motor import servo


class Servo(Thread):
    def __init__(self):
        Thread.__init__(self)
        i2c = busio.I2C(SCL, SDA)
        pca = PCA9685(i2c)
        pca.frequency = 50
        servo1 = servo.Servo(pca.channels[1])

    def run(self):
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        try:
            s.bind(("127.0.0.1", 8001))
        except socket.error as msg:
            print("bind failed", msg)
            s.listen(10)
        while(Constants.walking):

            connection, address = s.accept()
            print("Connected with" , address[0], ":", str(address[1]))
            print(connection.recv(1024))
            servo1.angle = connection.recv(1024)


if __name__ == '__main__':
    servo1 = Servo()
    servo1.setName("Servo 1")
    servo2 = Servo()
    servo2.setName("Servo 2")

    servo1.start()
    servo2.start()
