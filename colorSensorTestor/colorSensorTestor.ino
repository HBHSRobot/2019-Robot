int inputPin;
int input;
void setup() {
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  input = analogRead(inputPin);
  input = map(input,0,1023,0,255);
  Serial.println(input);
  delay(1000);
}
