from board import SCL, SDA
import busio
from adafruit_pca9685 import PCA9685
from adafruit_motor import servo


if __name__ == '__main__':
    i2c = busio.I2C(SCL, SDA)
    pca = PCA9685(i2c)
    pca.frequency =
    servo1 = servo.Servo(pca.channels[1])
    servo1.angle = 20
