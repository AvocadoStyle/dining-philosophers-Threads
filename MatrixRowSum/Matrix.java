public class Matrix extends Thread
{
    private int[][] mat;
    private int currentRow = 0; //starts from line 0
    private int sum = 0;
    private int done = 0;
    public Matrix(int[][] mat)
    {
        this.mat = mat;
    }

    public synchronized int[] giveRowToWorker()
    {
        if(currentRow < mat.length)
        {
            int cr = currentRow;
            currentRow++;
            return mat[cr];
        }
        return null;
    }

    public synchronized void bringSumOfLineFromWorker(int sumOfRow)
    {
        sum += sumOfRow;
        done++;
        if(done == mat.length)
        {
            notifyAll();
        }
    }

    public synchronized int getTotalSum()
    {
        if(done < mat.length)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sum;
    }
}
