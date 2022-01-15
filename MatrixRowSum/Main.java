public class Main
{
    public static void main(String[] args) {
        Matrix m1 = new Matrix(new int[][]{{1, 2, 3, 4},{1, 2, 3, 4},{1, 2, 3, 4}});
        Worker w1 = new Worker(1, m1);
        Worker w2 = new Worker(2, m1);
        Worker w3 = new Worker(3, m1);
        w1.start();
        w2.start();
        w3.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m1.getTotalSum());

    }
}
