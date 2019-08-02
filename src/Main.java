public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {

        MyTree<Integer,String> tree = new MyTree<>();
        int min = -100;
        int max = 100;
        int lvl=0;

        while (lvl!=6){
            int rand = min + (int) (Math.random()*max);
            tree.put( rand,""+rand);
            if (tree.isLeftNull() | tree.isRightNull()){
                lvl++;
            }
        }

        System.out.println(tree);
    }

        }

}
