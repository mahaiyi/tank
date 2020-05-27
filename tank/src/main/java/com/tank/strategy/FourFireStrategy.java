package com.tank.strategy;

import com.tank.Bullet;
import com.tank.Dira;
import com.tank.ResourceManager;
import com.tank.Tank;

/**
 * 开火策略模式
 */
public class FourFireStrategy implements FireStrategy{

    public void fire(Tank tank) {
        Dira[] dirs=Dira.values();
        //拿到该窗口，然后给该窗口绘制子弹和坦克
        int bx=tank.getX()+ResourceManager.tankD.getWidth()/2-Bullet.WIGHT/2;
        int by=tank.getY()+ResourceManager.tankD.getHeight()/2-Bullet.HEIGHT/2;
        //在坦克的位置打出子弹 让坦克在四个方向都打子弹
        for(Dira dira:dirs){
            new Bullet(bx,by,dira,tank.getTf(),tank.getGroup());

        }


    }
}
