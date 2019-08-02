import java.util.NoSuchElementException;

public class MyTree<Key extends Comparable<Key>, Value> {
        private Dot root;
    private class Dot{
        Key key;
        Value value;
        Dot left;
        Dot right;
        int size;

        public Dot(Key key, Value value) {
            this.key = key;
            this.value = value;
            size=1;
        }
    }

    public boolean isLeftNull(){
        return root.left != null;
    }

    public boolean isRightNull(){
        return root.right != null;
    }

    public int size(){
        return size(root);
    }

    private int size(Dot dot){
        if (dot == null){
            return 0;
        }
        return dot.size;
    }

    public boolean isEmpty(){
        return root == null;
    }

    private boolean isKeyMotNull(Key key){
        if (key == null){
            throw new IllegalArgumentException("Нелья что бы ключ был null");
        }
        return true;
    }

    public boolean contains(Key key){
        isKeyMotNull(key);
        return get(key) != null;
    }

    public Value get (Key key){
        return get(root,key);
    }

    private Value get(Dot dot, Key key){
        isKeyMotNull(key);
        if (dot == null){
            return null;
        }

        int cmpt = key.compareTo(dot.key);

        if (cmpt == 0) {
             return dot.value;
        } else if (cmpt <0) {
             return get(dot.left,key);
        } else {
             return get(dot.right,key);
        }


    }

    public void put(Key key, Value value){
        isKeyMotNull(key);
        if (value == null){
            //delete(key)
        return;
        }
        root = put(root, key, value);

    }

    private Dot put (Dot dot, Key key, Value value){
        if (dot == null) {
            return new Dot(key,value);
        }

        int cmpt = key.compareTo(dot.key);

        if (cmpt == 0){
            dot.value=value;
        } else if (cmpt < 0){
            dot.left = put(dot.left,key,value);
        } else {
            dot.right = put(dot.right,key,value);
        }
        dot.size = size(dot.left)+size(dot.right)+1;
        return dot;
    }

    private Dot findMinimal(Dot dot){
        if (dot.left == null){
            return dot;
        }
        return findMinimal(dot.left);
    }

    public Key findMinKey(){
        return findMinimal(root).key;
    }

    private Dot findMaximum(Dot dot){
        if (dot.right == null){
            return dot;
        }
        return findMinimal(dot.right);
    }

    public Key findMaxKey(){
        return findMaximum(root).key;
    }

    public void deleteMin(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        root=deleteMin(root);
    }
    public Dot deleteMin(Dot dot){
        if (dot.left == null) {
            return dot.right;
        }
        dot.left = deleteMin(dot.left);
        dot.size = size(dot.left)+size(dot.right)+1;
        return dot;
    }

    public void delete(Key key){
        isKeyMotNull(key);

        root = delete(root,key);
    }

    private Dot delete(Dot dot, Key key){
        if (dot == null){
            return null;
        }
        int cmpt = key.compareTo(dot.key);

        if (cmpt<0){
            dot.left = delete(dot.left,key);
        } else if(cmpt>0){
            dot.right = delete(dot.right,key);
        } else {
            if (dot.left == null){
                return dot.right;
            }
            if (dot.right == null){
                return dot.left;
            }
            Dot temp = dot;
            dot = findMinimal(dot.right);
            dot.right = deleteMin(temp.right);
            dot.left = temp.left;
        }
        dot.size = size(dot.left)+size(dot.right)+1;
        return dot;
    }

    @Override
    public String toString() {
        return "tree{" +
                toString(root) + '}';
    }
    private String toString(Dot dot){
        if (dot == null){
            return "";
        }
        return toString(dot.left) + " " + dot.value.toString() + " " + toString(dot.right);
    }

}
