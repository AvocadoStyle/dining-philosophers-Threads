public class Main
{
    public static void main(String[] args)
    {
    Monitor m1 = new Monitor();

    Worker[] w = new Worker[20];

    for(int i=0; i<20; i++)
    {
        w[i] = new Worker(i+1, m1);
    }

    for(int i=0; i<20; i++)
    {
        w[i].start();
    }


    }

}
