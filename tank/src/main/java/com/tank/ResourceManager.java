package com.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 加载静态资源
 */
public class ResourceManager {
    //坦克不同方向的图片
    public  static BufferedImage tankL,tankR,tankU,tankD;
    //敌人坦克不同方向的图片
    public  static BufferedImage etankL,etankR,etankU,etankD;
    //子弹不同方向的图片
    public  static BufferedImage bulletL,bulletR,bulletU,bulletD;
    //爆炸状态的图片
    public static BufferedImage[] explodes=new BufferedImage[16];

     static{
         try {
             tankL=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/tankL.png"));
             tankR=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/tankR.png"));
             tankU=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/tankU.png"));
             tankD=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/tankD.png"));
             bulletL=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/bulletL.gif"));
             bulletR=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/bulletR.gif"));
             bulletU=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/bulletU.gif"));
             bulletD=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/bulletD.gif"));
             etankL=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/etankL.png"));
             etankR=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/etankR.png"));
             etankU=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/etankU.png"));
             etankD=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/etankD.png"));

             for (int i = 0; i <16 ; i++) {
                 explodes[i]=ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("static/images/e"+(i+1)+".gif"));


             }

         }catch (IOException e) {
             e.printStackTrace();
         }
     }
}
