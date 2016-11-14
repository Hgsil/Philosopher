/**
 * Created by Administrator on 2016/11/13 0013.
 */
public class Fork {
    private boolean[] used={false,false,false,false,false};

    public synchronized void takeFork(){
        String name = Thread.currentThread().getName();
        int i =Integer.parseInt(name);
        while (used[i]||used[(i+1)%5]){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        used[i] =true;
        used[(i+1)%5] =true;

    }
    public synchronized void putFork(){
        String name =Thread.currentThread().getName();
        int i = Integer.parseInt(name);

        used[i]=false;
        used[(i+1)%5]=false;
        notifyAll();

    }

    public static void main(String[] args) {
        Fork fork =new Fork();
        new Philosopher("0",fork).start();
        new Philosopher("1",fork).start();
        new Philosopher("2",fork).start();
        new Philosopher("3",fork).start();
        new Philosopher("4",fork).start();
    }
}
