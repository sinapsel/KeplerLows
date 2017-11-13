package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Rocket {
    private float x, y, vx, vy;
    Bitmap pic;

    protected float getX(){return x;}
    protected float getY(){return y;}
    protected float getVX(){return vx;}
    protected float getVY(){return vy;}
    protected void setX(float x){this.x = x;}
    protected void setY(float y){this.y = y;}
    protected void setVX(float vx){this.vx = vx;}
    protected void setVY(float vy){this.vy = vy;}

    Rocket(Bitmap pic){
        this.x = (float)(Math.random()*500);
        this.y = (float)(Math.random()*500);
        this.vx = (float)(Math.random()*11)-5;
        this.vy = (float)(Math.random()*11)-5;
        this.pic = pic;
    }
    void move(){
        this.x += this.vx;
        this.y += this.vy;
    }

    Paint paint = new Paint();
    Matrix matrix = new Matrix();
    void draw(Canvas canvas){
        matrix.setScale(0.2f, 0.2f);
        //Study mathematics, dear young programmer :)
        matrix.postRotate((float)Math.toDegrees(Math.atan2(vy, vx)) + 45);
        matrix.postTranslate(x, y);
        paint.setAlpha(255);
        canvas.drawBitmap(pic, matrix, paint);
    }
}
