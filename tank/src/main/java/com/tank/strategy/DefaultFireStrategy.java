package com.tank.strategy;

import com.tank.Bullet;
import com.tank.ResourceManager;
import com.tank.Tank;

/**
 * 开火策略模式
 */
public class DefaultFireStrategy implements FireStrategy{

    public void fire(Tank tank) {
        //拿到该窗口，然后给该窗口绘制子弹和坦克
        int bx=tank.getX()+ResourceManager.tankD.getWidth()/2-Bullet.WIGHT/2;
        int by=tank.getY()+ResourceManager.tankD.getHeight()/2-Bullet.HEIGHT/2;
        //在坦克的位置打出子弹
         new Bullet(bx,by,tank.getDir(),tank.getTf(),tank.getGroup());


    }
}
