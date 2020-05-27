package com.tank;

import java.awt.*;

public class Bullet {
    private static  final int SPEED=5;
    private int x,y;
    private Dira dir ;
    private boolean living =true;//定义子弹是否打出
    TankFrame tf=null;
    public static int WIGHT=10;
    public  static  int HEIGHT=10;
    private Group group;//子弹的属性  敌人打出的还是我方打出的
    Rectangle rect =new Rectangle();

     public Bullet(int x, int y, Dira dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIGHT;
        rect.height=HEIGHT;
        //每次new出来就放到list中
        tf.bulletList.add(this);
    }



    public void paint(Graphics g){
        //子弹和敌人相撞或出边界后就删除
        if(!living){
            tf.bulletList.remove(this);
        }
      /*  Color c=g.getColor();
        g.setColor(Color.gray);
        g.fillOval(x,y,WIGHT,HEIGHT);
        g.setColor(c);*/
        //根据坦克方向画出不同方向的子弹图片 无图片
        switch (dir){
            case LEFT:
                g.drawImage(ResourceManager.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceManager.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD,x,y,null);
                break;
        }
        move();
    }

    public  void move() {
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
        //更新碰撞后的值
        rect.x=this.x;
        rect.y=this.y;
        if(x<0 || y<0 || x >tf.FRAME_WIDTH || y>tf.FRAME_HIEGHT){
            living =false;
        }



    }

    public  void collideWith(Tank Tank){
         //自己人不打自己人
         if(this.group==Tank.getGroup()){
             return ;

         }
        //子弹的所在的矩形位置
      //  Rectangle rect1=new Rectangle(this.x,this.y,WIGHT,HEIGHT);
        //坦克所在的矩形的位置
      //   Rectangle rect2=new Rectangle(Tank.getX(),Tank.getY(),Tank.WIGHT,Tank.HEIGHT);
        if(this.rect.intersects(Tank.rect)){
            Tank.die();
            this.die();
            //相撞的时候发生爆炸的图片
            tf.explodes.add(new Explode(Tank.getX()+Tank.WIGHT/2-Explode.WIGHT/2,
                    Tank.getY()+Tank.HEIGHT/2-Explode.HEIGHT/2,tf));
        }
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
}
