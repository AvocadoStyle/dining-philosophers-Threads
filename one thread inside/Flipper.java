import java.util.Vector;

public class Flipper extends Thread
{
    private int threadId;
    private CoinSimulator cs;
    private Vector<Boolean> simulationResult;
    private int pali = 0;
    private int etz = 0;
    public Flipper(int threadId, CoinSimulator cs)
    {
        this.threadId = threadId;
        this.cs = cs;
        this.simulationResult = new Vector<Boolean>();
    }

    public void run()
    {
        /*will flip the coin for 100 times*/
        for(int i=0; i < 100; i++)
        {
            this.simulationResult.add(cs.coinFlip(threadId));
        }
        resOfSimulation();
        cs.Done();
        // do other things...
        // ...
        // ...

    }

    public void resOfSimulation()
    {
        System.out.println("Thread number: " + this.threadId);
        for (boolean res: this.simulationResult) {
            if(res) {
                pali++;
            }
            else {
                etz++;
            }
        }
        System.out.println("total pali: " + pali + " total etz: " + etz);
    }



}
