package com.tank;

import com.tank.prop.PropertMgr;
import com.tank.strategy.DefaultFireStrategy;
import com.tank.strategy.FireStrategy;
import com.tank.strategy.FourFireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * 坦克类
 */
public class Tank {
    public static int WIGHT=ResourceManager.tankD.getWidth();
    public  static  int HEIGHT=ResourceManager.tankD.getHeight();
    private int x,y;
    private Dira dir ;
    private static final int SPEED=2;
    private boolean moving =true;//坦克是否静止 --让坦克自己动起来
    private  boolean living =true;//坦克是否活着
    Random random=new Random();
    private com.tank.Group group;//坦克的属性 敌方坦克还是我方坦克

    private com.tank.TankFrame tf;
    Rectangle rect=new Rectangle();

    FireStrategy fs;
    public Tank(int x, int y, Dira dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir=dir;
        this.group = group;
        this.tf = tf;
        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIGHT;
        rect.height=HEIGHT;
       // fs=(group==Group.BAD ? new DefaultFireStrategy(): new FourFireStrategy());
        try {
          if(group==Group.BAD){
             fs=(FireStrategy) Class.forName(PropertMgr.getPro("badFs").toString()).newInstance();
           }else{
              fs=(FireStrategy)Class.forName(PropertMgr.getPro("goodFs").toString()).newInstance();

          }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    //画敌人和我方坦克
    public void paint(Graphics g){
        //敌人坦克和子弹相撞后移除
        if(!living){
            tf.etankList.remove(this);
        }
       //根据坦克方向画出不同方向的坦克图片
        switch (dir){
            case LEFT:
                g.drawImage(this.group==Group.GOOD?ResourceManager.tankL:ResourceManager.etankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group==Group.GOOD?ResourceManager.tankR:ResourceManager.etankR,x,y,null);
                break;
            case UP:
                g.drawImage(this.group==Group.GOOD?ResourceManager.tankU:ResourceManager.etankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group==Group.GOOD?ResourceManager.tankD:ResourceManager.etankD,x,y,null);
                break;
        }

        //根据按键的方向决定坦克移动的方向
        move();
    }

    public  void move() {
        if(!moving){
            return;
        }
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
            default:
                break;
        }
        //敌方坦克移动时随机打子弹 百分之10的机会
        if(this.group==Group.BAD && random.nextInt(100) >95){
            this.fire();
        }
        //敌方坦克随机变化方向
        if(this.group==Group.BAD && random.nextInt(100) >95){
            setRandomDir();
        }
        //边界检测
        boundsCheck();
        //更新碰撞后的值
        rect.x=this.x;
        rect.y=this.y;

    }
    private void boundsCheck(){
        //上边界 2是留出两个像素
        if(this.x <0 ) {
            x=Tank.WIGHT+10;
        }
        //左边界
        if (this.y < 28) {
            y=Tank.HEIGHT+28;
        }
        if(this.x>tf.FRAME_WIDTH - Tank.WIGHT){
            x=tf.FRAME_WIDTH-Tank.WIGHT-20;
        }
        if(this.y>tf.FRAME_HIEGHT - Tank.HEIGHT){
            y=tf.FRAME_HIEGHT - Tank.HEIGHT-20;
        }
    }
    private void setRandomDir(){
       this.dir= Dira.values() [random.nextInt(4)];
    }

    public void fire(){
        /*//拿到该窗口，然后给该窗口绘制子弹和坦克
        int bx=this.x+ResourceManager.tankD.getWidth()/2-Bullet.WIGHT/2;
        int by=this.y+ResourceManager.tankD.getHeight()/2-Bullet.HEIGHT/2;
       //在坦克的位置打出子弹
        tf.bulletList.add(new Bullet(bx,by,this.dir,tf,this.group));*/
        //使用策略模式
        fs.fire(this);
    }
    public  void  die(){
        //子弹已和敌人相撞
        living=false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setDir(Dira dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public Dira getDir() {
        return dir;
    }

    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }
}
