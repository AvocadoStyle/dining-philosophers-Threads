public class Worker extends Thread
{
    private int threadNum;
    private Matrix m;

    public Worker(int threadNum, Matrix m)
    {
        this.threadNum = threadNum;
        this.m = m;
    }

    public void run()
    {
        int[] row = m.giveRowToWorker();
        int sumOfRow = 0;
        for(int i=0; i<row.length; i++)
            sumOfRow += row[i];
        m.bringSumOfLineFromWorker(sumOfRow);
    }

}
