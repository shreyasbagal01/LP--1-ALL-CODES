
import Adafruit_DHT
import time 
from urllib.request import urlopen
import sys

WRITE_API = "JL2BDUBGRIQE956W" # Replace your ThingSpeak API key here
BASE_URL = "https://api.thingspeak.com/update?api_key={}".format(WRITE_API)



SENSOR_PIN = 5
SENSOR_TYPE = Adafruit_DHT.DHT11

try:
    while True:
        humidity, temperature = Adafruit_DHT.read_retry(SENSOR_TYPE, SENSOR_PIN)
        print("Humidity = {:.2f}%\tTemperature = {:.2f}C".format(humidity, temperature))
        thingspeakHttp = BASE_URL + "&field1={:.2f}&field2={:.2f}".format(temperature, humidity)
        print(thingspeakHttp)
        conn = urlopen(thingspeakHttp)
        print("Response: {}".format(conn.read()))
        conn.close()
        time.sleep(15)
            
except KeyboardInterrupt:
    conn.close()
