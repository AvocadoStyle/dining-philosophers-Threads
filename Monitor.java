public class Monitor extends Thread
{
    public int nextThreadTurn = 3; // begin from 1

    public Monitor()
    {
    }

    public synchronized void waitForMyTurn(int threadNumber)
    {
        while(threadNumber >= this.nextThreadTurn) { /*not my turn*/
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void nextTurn()
    {
        this.nextThreadTurn++;
        notifyAll();
    }



}
