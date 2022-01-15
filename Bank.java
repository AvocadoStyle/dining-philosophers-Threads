import java.util.ArrayList;
import java.util.Vector;

public class Bank extends Thread
{
    private ArrayList<Integer> free = new ArrayList<>();

    public Bank(int size)
    {
        for(int i=0; i<size; i++)
        {
            free.add(i);
        }
    }

/*    public synchronized int service()
    {
        if(free.size() == 0)
            return -1;
        else
            return free.remove(0);
    }

    public synchronized void release(int teller)
    {
        free.add(teller);
    }*/

    public synchronized int toGetFreeTeller()
    {
        /*if there is no free teller, the costumer will sleep*/
        while(free.size() == 0) //todo: isFree
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return free.remove(0);
    }

    public synchronized void endTheTellerServices(int tellerNum)
    {
        free.add(tellerNum);
        notifyAll();
    }


}
