import java.util.Random;

public class CoinSimulator extends Thread
{
    private boolean coin;
    private Random rand;
    private int numOfTheSpecificAllowedThreadId = 0;

    public CoinSimulator()
    {
        rand = new Random();
    }

    public synchronized boolean coinFlip(int threadNumber)
    {
        while(threadNumber > this.numOfTheSpecificAllowedThreadId)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.coin = rand.nextBoolean();
//        this.coin = !this.coin;
    }

    public synchronized void Done()
    {
        this.numOfTheSpecificAllowedThreadId++;
        notifyAll();
    }
    public synchronized void isDone(int limitThreads)
    {
        while(!(this.numOfTheSpecificAllowedThreadId == limitThreads))
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
