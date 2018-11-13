import socket
from threading import Thread
import time
import Constants
from board import SCL, SDA
import busio
from adafruit_pca9685 import PCA9685
from adafruit_motor import servo


class Servo(Thread):
    def __init__(self, port, channel):
        self.channel = channel
        self.port = port
        Thread.__init__(self)
        i2c = busio.I2C(SCL, SDA)
        pca = PCA9685(i2c)
        pca.frequency = 50
        self.servo1 = servo.Servo(pca.channels[channel])

    def run(self):
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        try:
            s.bind(("127.0.0.1", self.port))
            s.listen(10)
        except socket.error as msg:
            print("bind failed", msg)

        while Constants.walking:

            connection, address = s.accept()
            angleFromJava = int(connection.recv(1024))
            print("Connected with" , address[0], ":", str(address[1]))
            print(angleFromJava)

            self.servo1.angle = angleFromJava


if __name__ == '__main__':
    servos = []
    for i in range(6):
        port = 8011 + i
        channel = i
        servos.append(Servo(port=port, channel=channel))
        servos[i].setName("Servo " + str(i))

    for i in range(len(servos) - 1):
        servos[i].start()

