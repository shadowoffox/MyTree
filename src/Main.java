public class Main {
    public static void main(String[] args) {
        MyTree<Integer,String> tree = new MyTree<>();

        tree.put(8,"eight");
        tree.put(1,"one");
        tree.put(4,"four");
        tree.put(5,"five");

        System.out.println(tree);
        System.out.println(tree.get(9));

        System.out.println(tree.findMinKey());
        System.out.println(tree.findMaxKey());

        tree.delete(5);
        System.out.println(tree);
    }


}
