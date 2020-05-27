package tank.dp.singleton;

import java.util.Date;

/**
 *
 *
 *  既可以解决线程安全也可以防止反序列化
 *
 *  *
 *
 **/
public enum Singleton8 {
    INSTANCE;
    public static void main(String[] args) {
       // System.out.println(new SimpleDateFormat(new Date(),"yyyyMMdd"));
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Singleton8.INSTANCE.hashCode());
            }).start();
        }
        System.out.println(new Date());




    }
}
