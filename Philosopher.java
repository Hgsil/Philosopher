/**
 * Created by Administrator on 2016/11/13 0013.
 */
public class Philosopher extends Thread{
    private String name;
    private Fork fork;
    public Philosopher(String name,Fork fork){
        super(name);
        this.name=name;
        this.fork=fork;
    }
    public void run(){
        for (int i = 0;i<10;i++){
            thinking();
            fork.takeFork();
            eating();
            fork.putFork();
        }
    }
    public void thinking(){
        System.out.println(name+"在思考");
        try{
            sleep(1000);//模拟思考，占用一段时间资源
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public void eating(){
        System.out.println(name+"在吃饭");
        try{
            sleep(1000);//模拟吃饭，占用一段时间资源
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
