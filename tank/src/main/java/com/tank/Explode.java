package com.tank;

import java.awt.*;

public class Explode {
    private int x,y;
    private boolean living =true;//定义子弹是否打出
    TankFrame tf=null;
    public static int WIGHT=ResourceManager.explodes[0].getWidth();
    public  static  int HEIGHT=ResourceManager.explodes[0].getHeight();

    //碰撞了几次
    private int step=0;
     public Explode(int x, int y,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }



    public void paint(Graphics g){
       g.drawImage(ResourceManager.explodes[step++],x,y,null);
       if(step>=ResourceManager.explodes.length){
           //移除爆炸的图片
           tf.explodes.remove(this);
       }
     }

}
