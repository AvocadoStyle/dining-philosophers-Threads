public class Worker extends Thread
{
    private int threadNum;
    private Monitor m;
    public Worker(int threadNum, Monitor m)
    {
        this.threadNum = threadNum;
        this.m = m;
    }

    public void run()
    {
        m.waitForMyTurn(threadNum);
        System.out.println("working " + this.threadNum);
        m.nextTurn();
    }


}
