package oneday;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交替输出1a2b3c4d5f...
 */
public class ThreadTest {
    static Thread t1,t2=null;
    static String s="";
    public static void main(String []qrgs){

        char[] num="12345678".toCharArray();
        char [] str="ABCDEFGHIJG".toCharArray();
        t1=new Thread(()->{
            for(char n:num){
                s+=n;
                System.out.println(n);
                LockSupport.unpark(t2);//t2线程唤醒
                LockSupport.park();//当前线程阻塞
            }
        },"t1");
        t2=new Thread(()->{
            int i=0;
            for(char c:str){
                i++;
                LockSupport.park();//阻塞等待线程t1执行完后唤醒t2在执行
                System.out.println(c);
                s+=c;
                if(i<num.length){
                    LockSupport.unpark(t1);//唤醒t1继续执行
                }else{
                    LockSupport.unpark(t2);
                }

            }
        },"t2");
        t1.start();
        t2.start();
       // System.out.println(s);
    }

}
