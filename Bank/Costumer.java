public class Costumer extends Thread
{
    private int cosNum;
    private int tellerNum;
    private Bank b;

    public Costumer(int cosNum, Bank b)
    {
        this.b = b;
        this.cosNum = cosNum;
    }

    public void run()
    {
        tellerNum = b.toGetFreeTeller();



        /*if it's free teller we'll do the code here with the fuucking teller*/
        {
            System.out.println("Costumer: " + this.cosNum + " goes to Teller: " + this.tellerNum);
            // ...
            // ...
            // ...
        }



        b.endTheTellerServices(tellerNum);


    }



}
