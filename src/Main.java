import com.company.Node;
import com.company.TreeIterator;

public class Main {

    public static void main(String[] args) {
        Node a = new Node(1);
        a.setLeft(new Node(2));
        a.setRight(new Node(3));
        a.getLeft().setLeft(new Node(4));
        a.getLeft().setRight(new Node(5));
        a.getRight().setLeft(new Node(6));
        a.getRight().setRight(new Node(7));

        final TreeIterator iterator = new TreeIterator(a);

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            iterator.next();
        }).start();

        a.getLeft().setValue(3);
    }
}