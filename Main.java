public class Main
{
    public static void main(String[] args)
    {
        Bank b1 = new Bank(10);

        Costumer[] costumers = new Costumer[5000];

        for(int i=0; i<5000; i++)
        {
            costumers[i] = new Costumer(i+1, b1);
        }

        for(int i=0; i<5000; i++)
        {
            costumers[i].start();
        }




    }
}
