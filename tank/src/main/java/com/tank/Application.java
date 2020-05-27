package com.tank;


import com.tank.*;
import com.tank.prop.PropertMgr;

public class Application {
    public static void main(String []args) throws InterruptedException {
        //Frame 窗口类
      TankFrame frame=new TankFrame();
      int etankNum=Integer.parseInt(PropertMgr.getPro("etanknum").toString());
      //初始化敌方坦克
        for (int i = 0; i <etankNum ; i++) {
            frame.etankList.add(new Tank(ResourceManager.etankD.getWidth()+i*50+30,ResourceManager.etankD.getHeight()+100,Dira.DOWN,Group.BAD,frame));
        }

      while (true){
          //当前线程挂起50秒后自动调用repaint方法重画窗口，repaint方法
          //调用paint方法
          Thread.sleep(50);
          frame.repaint();
      }

    }

}
