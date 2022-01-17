public class Main {
    public static void main(String[] args) {
        CoinSimulator cs1 = new CoinSimulator();
        Flipper[] flippers = new Flipper[10];
        for(int i=0; i < flippers.length; i++)
        {
            flippers[i] = new Flipper(i, cs1);
        }
        for(int i=flippers.length-1; i >= 0; i--)
        {
            flippers[i].start();
        }
        cs1.isDone(10);
        System.out.println("Done!");
    }
}
