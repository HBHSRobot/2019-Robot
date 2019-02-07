int inputPinOne;
int input;
#include <Wire.h>
void setup() {
  Serial.begin(9600);
  Wire.begin(0);
}

void loop() {
  input = analogRead(inputPinOne);
  input = map(input,0,1023,0,255);
  
}
