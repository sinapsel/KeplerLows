package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * Created by student6 on 10.11.17.
 */;

public class CtrlRocket extends Rocket {
    private float toX, toY;
    CtrlRocket(Bitmap pic){
        super(pic);
        toX = this.getX();
        toY = this.getY();
        this.setVX(0);
        this.setVY(0);
    }
    public void setTarget(float toX, float toY){
        this.toX = toX;
        this.toY = toY;
        float d = (float) Math.pow( (Math.pow(this.toX - this.getX(), 2) + Math.pow(this.toY - this.getY(), 2)), 0.5);
        this.setVX((this.toX - this.getX()) * 15 / d);
        this.setVY((this.toY - this.getY()) * 15 / d);
    }
    @Override
    void move(){
        super.move();
        this.isNeedToStop();
    }
    void isNeedToStop(){
        if ( Math.sqrt((this.getX() - this.toX)*(this.getX() - this.toX) + (this.getY() - this.toY)*(this.getY() - this.toY)) < 50){
            this.setVX(0);
            this.setVY(0);
        }
    }
}
