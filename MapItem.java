import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class MapItem {
  
  private double x, y, w, h;
  Rectangle boundingBox;
  
  MapItem(double x, double y, double w, double h){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    boundingBox = new Rectangle((int)x, (int)y, (int)w, (int)h);    
  }
  
  public double returnW(){
    return this.w;
  }
  public double returnDamage(){
    return 2;
  }
  public double returnH(){
    return this.h;
  }
  public double returnX(){
    return this.x;
  }
  public void changeX(double change){
    this.x = change;
    boundingBox.x = (int)change;
  }
  public double returnY(){
    return this.y;
  }
  public void changeY(double change){
    this.y = change;
    boundingBox.y = (int)change;
  }
  
  public void loseHealth(double damage){
    
  }
  
  
  public void addHealth(double health){
  }
  public boolean checkCollision(MapItem m){
    if (boundingBox.intersects(m.boundingBox)){
      return true;
    }
    else{
      return false;
    }
  }
  public void addFuel(double fuel){
  }
  public void faceCharacter(MapItem m){
    if ((m.returnX() > returnX()) && (m.returnY() > returnY()) ){
      double tempAngle = Math.toDegrees(Math.atan(Math.abs(m.returnX() -  returnX())/Math.abs(m.returnY() - returnY()))); 
      changeRotation(180-tempAngle);
    }
    else if ((m.returnX() > returnX()) && (m.returnY() < returnY()) ){
      double tempAngle = Math.toDegrees(Math.atan(Math.abs(m.returnY() -  returnY())/Math.abs(m.returnX() - returnX()))); 
      changeRotation(90-tempAngle);
    }
    else if ((m.returnX() < returnX()) && (m.returnY() < returnY()) ){
      double tempAngle = Math.toDegrees(Math.atan(Math.abs(m.returnY() -  returnY())/Math.abs(m.returnX() - returnX()))); 
      changeRotation(270+tempAngle);
    }
    else if ((m.returnX() < returnX()) && (m.returnY() > returnY()) ){
      double tempAngle = Math.toDegrees(Math.atan(Math.abs(m.returnY() -  returnY())/Math.abs(m.returnX() - returnX()))); 
      changeRotation(270-tempAngle);
    }
  }
  
  public void move(double elapsedTime){
    changeX(returnX() + getSpeed()*Math.sin(Math.toRadians(getRotation()))*elapsedTime*100);
    changeY(returnY() - getSpeed()*Math.cos(Math.toRadians(getRotation()))*elapsedTime*100);
  }
  
  public void update(double elapsedTime, MapItem m){
    faceCharacter(m);
    move(elapsedTime);
  }
  public void update(double elapsedTime){
    move(elapsedTime);
  }
  
  public void draw (Graphics g, BufferedImage image) {
    
    double locationX = image.getWidth() / 2;
    double locationY = image.getHeight() / 2;
    
    double diff = Math.pow(Math.pow(image.getWidth(), 2) + Math.pow(image.getHeight(), 2), 0.5) /2;
    
//To correct the set of origin point and the overflow
    double rotationRequired = Math.toRadians(getRotation());
    double unitX = Math.abs(Math.cos(rotationRequired));
    double unitY = Math.abs(Math.sin(rotationRequired));
    
    double correctUx, correctUy;
    
    if (image.getWidth() >= image.getHeight())
    {
      correctUx = unitX;
      correctUy = unitY;
    }
    else //if the height is greater than the width, you have to change the axis to correct the overflow
    {
      correctUx = unitY;
      correctUy = unitX;
    }
    
    int posAffineTransformOpX = (int)returnX()-(int)(locationX)-(int)(correctUx*diff);
    int posAffineTransformOpY = (int)returnY()-(int)(locationY)-(int)(correctUy*diff);
    
//translate the image center to same diff that dislocates the origin, to correct its point set
    AffineTransform objTrans = new AffineTransform();
    objTrans.translate(correctUx*diff, correctUy*diff);
    objTrans.rotate(rotationRequired, locationX, locationY);
    
    AffineTransformOp op = new AffineTransformOp(objTrans, AffineTransformOp.TYPE_BILINEAR);
    
// Drawing the rotated image at the required drawing locations
    g.drawImage(op.filter(image, null), posAffineTransformOpX, posAffineTransformOpY, null);
  }
  
  public void changeRotation(double change){
    
  }
  public double getSpeed() {
    return 1;
  }
  
  public double getAngularSpeed() {
    return 1;
  }
  
  public double getEnergy() {
    return 1;
  }
  
  public void setEnergy(double input) {
    
  }
  
  public void loseHealth(int damage){
    
  }
  public double returnHealth(){
    return 1;
  }
  public double returnFatigue(){
    return 1;
  }
  public double returnFood(){
    return 1;
  }
  public double returnWater(){
    return 1;
  }
  public double returnFuel(){
    return 1;
  }
  public void changeSpeed(double change){
    
  }
  public double returnSpeed(){
    return 1;
  }
  public double getRotation(){
    return 1;
  }

  
  public void accelerateRight(double elapsedTime) {

  }
  
  public void accelerateLeft(double elapsedTime) {

  }
  
  public void slowDownAngularSpeed(double elapsedTime) {
    
  }
  
  public void accelerate(double elapsedTime) {

  }
  
  public void decelerate(double elapsedTime) {

  }
  
  public void slowDown(double elapsedTime) {

  }
  public void attack(){


  } 
  public double getAmmo(){
    return 1;
  }
  public void shoot(){

  }
  public void addAmmo(double change){

  }
  public double getCoolDown(){
    return 1;
  }
  public void changeCoolDown(double change){

  }
  public void resetCoolDown(){

  }
  public Weapon returnWeapon(){
    return new Knife(1, 2, 3, 4);
  }
  public void changeWeapon(Weapon p){

  }
  public void changeValue(double change){
  }
  public double returnValue(){
    return 1;
  }
  public void rest(double recover){
    
  }
  public void eat(double food){

  }
  public void drink(double water){

  }
  public void loseHunger(){

  }
  public void loseThirst(){

  }
  public void addFatigue(){

  }


}
