public class Clock {
  private long elapsedTime;
  private long lastTimeCheck;

  Clock() { 
    lastTimeCheck=System.nanoTime();
    elapsedTime=0;
  }
  
  public void update() {
  long currentTime = System.nanoTime();
  elapsedTime = currentTime - lastTimeCheck;
  lastTimeCheck = currentTime;
  }
  
  public double getElapsedTime() {
    return elapsedTime/1.0E9;
  }
}