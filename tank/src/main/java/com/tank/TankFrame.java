package com.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    public   static final int  FRAME_WIDTH=800;
    public   static final  int FRAME_HIEGHT=800;
    //默认坦克的方向向下
    List<Bullet> bulletList=new ArrayList<Bullet>();
    //敌方坦克
    List<Tank> etankList =new ArrayList<Tank>();
   //我方坦克
    Tank Tank=new Tank(250,250,Dira.UP,Group.GOOD,this);
    //爆炸图片
    List<Explode> explodes=new ArrayList<Explode>();
   // Explode explode=new Explode(50,50,this);
    public TankFrame(){
        setSize(FRAME_WIDTH,FRAME_HIEGHT);
        setResizable(false);//不能改变窗口大小
        setTitle("坦克大战");
        setVisible(true);
        //添加键盘监听器
        addKeyListener(new MyKeyListener());
        //窗口添加监听
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }

        });
    }
    Image image=null;
    @Override
    public void update(Graphics g){
        if(image==null){
            image=this.createImage(FRAME_WIDTH,FRAME_HIEGHT);
        }
        Graphics graphics=image.getGraphics();
        Color c=graphics.getColor();
        graphics.setColor(Color.black);
        graphics.fillRect(0,0,FRAME_WIDTH,FRAME_HIEGHT);
        graphics.setColor(c);
        paint(graphics);
        g.drawImage(image,0,0,null);


    }
    //该方法系统自动调用，比如窗口大小改动等窗口需要重新绘制的时候调用
    //Graphics 相当于画笔
    @Override
    public  void paint(Graphics g){
        Color c=g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量:"+bulletList.size(),10,60);
        g.drawString("敌人数量:"+etankList.size(),10,80);
        g.setColor(c);
        Tank.paint(g);
       // for(Bullet b:bulletList){
        for (int i = 0; i <bulletList.size() ; i++) {
            bulletList.get(i).paint(g);
        }
       // bullet.paint(g);
        //敌人坦克
        for (int i = 0; i < etankList.size() ; i++) {
            etankList.get(i).paint(g);
        }
        for (int i = 0; i < explodes.size() ; i++) {
            explodes.get(i).paint(g);
        }
        //如果敌人的坦克和子弹相撞，移除子弹和敌人
        for (int i = 0; i <bulletList.size() ; i++) {
            for(int j=0;j<etankList.size();j++){
                bulletList.get(i).collideWith(etankList.get(j));
            }

        }
        //画出爆炸的图片
       // explode.paint(g);
    }

    //键盘监听处理类
    class MyKeyListener extends KeyAdapter{
        //用于标记坦克的方向
        boolean bL=false;
        boolean bR=false;
        boolean bU=false;
        boolean bD=false;
        //键盘收到请求:敲击键盘
        @Override
        public void keyPressed(KeyEvent key){
            //拿到key的code
            int keyCode =key.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                   // x-=10;
                    bL=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    //x+=10;
                    bR=true;
                    break;
                case KeyEvent.VK_UP:
                   // y-=10;
                    bU=true;
                    break;
                case KeyEvent.VK_DOWN:
                   // y+=10;
                    bD=true;
                    break;
            }
            setMainTankDir();
        }

        @Override//键盘被释放
        public void keyReleased(KeyEvent key){
         //   System.out.println("release key");
            int keyCode =key.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    // x-=10;
                    bL=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    //x+=10;
                    bR=false;
                    break;
                case KeyEvent.VK_UP:
                    // y-=10;
                    bU=false;
                    break;
                case KeyEvent.VK_DOWN:
                    // y+=10;
                    bD=false;
                    break;
                case KeyEvent.VK_CONTROL:
                    //抬起ctrl键开火
                    Tank.fire();
            }
            if(!bL && !bR && !bU && !bD){
                Tank.setMoving(false);
            }else {
                Tank.setMoving(true);
            }
        }

        private void setMainTankDir(){
            if(!bL && !bR && !bU && !bD){
                Tank.setMoving(false);
            }else {
                Tank.setMoving(true);
            }
            if(bL) Tank.setDir(Dira.LEFT);
            if(bR) Tank.setDir(Dira.RIGHT);
            if(bU)Tank.setDir(Dira.UP);
            if(bD) Tank.setDir(Dira.DOWN);

        }

    }
}
