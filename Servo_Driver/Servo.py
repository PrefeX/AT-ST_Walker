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
        self.servo = servo.Servo(pca.channels[channel], min_pulse=500, max_pulse=2000)

    def run(self):
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        try:
            s.bind(("0.0.0.0", self.port))
            s.listen(10)
        except socket.error as msg:
            print("bind failed", msg)


        connection, address = s.accept()
        print("connected with " , address[0], ":", str(address[1]))
        while Constants.walking:

            fromJava = connection.recv(3)
            print(fromJava)
            
            angleFromJava = int(fromJava)

            if ((angleFromJava >= 0) and (angleFromJava <=180)):
                print(angleFromJava, "over port:" , self.port , " on channel " , self.channel, "....fml")
                self.servo.angle = angleFromJava
            else:
                print("Angle is out of bounds? it is: ", angleFromJava)


if __name__ == '__main__':
    servos = []
    for i in range(11):
        port = 8011 + i
        channel = i
        print(port, channel)
        servos.append(Servo(port, channel))
        servos[i].setName("Servo " + str(i))

    for i in range(len(servos) - 1):
        servos[i].start()
