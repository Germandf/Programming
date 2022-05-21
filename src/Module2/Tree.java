package Module2;

import java.util.ArrayList;

public class Tree {

    private Integer value;
    private Tree left;
    private Tree right;

    public Tree(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // O(1)
    public int getRoot(){
        return value;
    }

    // O(1)
    public boolean isEmpty(){
        return value == null;
    }

    // O(h)
    public void add(Integer newValue) {
        if (this.value == null)
            this.value = newValue;
        else {
            if (this.value > newValue) {
                if (this.left == null)
                    this.left = new Tree(newValue);
                else
                    this.left.add(newValue);
            } else if (this.value < newValue) {
                if (this.right == null)
                    this.right = new Tree(newValue);
                else
                    this.right.add(newValue);
            }
        }
    }

    // O(n)
    public int getHeight(){
        if(left == null && right == null)
            return 0;
        var leftCount = 0;
        var rightCount = 0;
        if(left != null)
            leftCount = left.getHeight() + 1;
        if(right != null)
            rightCount = right.getHeight() + 1;
        return Math.max(leftCount, rightCount);
    }

    // O(n)
    public ArrayList<Integer> getLongestBranch(){
        if(left == null && right == null)
            return new ArrayList<Integer>(value);
        var leftList = new ArrayList<Integer>();
        var rightList = new ArrayList<Integer>();
        if(left != null){
            leftList.add(left.value);
            leftList.addAll(left.getLongestBranch());
        }
        if(right != null){
            rightList.add(right.value);
            rightList.addAll(right.getLongestBranch());
        }
        if(leftList.size() > rightList.size())
            return leftList;
        else
            return rightList;
    }

    // O(n)
    public ArrayList<Integer> getLeaves(){
        if(left == null && right == null)
            return new ArrayList<Integer>(value);
        var leaves = new ArrayList<Integer>();
        if(left != null)
            leaves.addAll(left.getLeaves());
        if(right != null)
            leaves.addAll(right.getLeaves());
        return leaves;
    }

    // O(n)
    public boolean hasElement(int element){
        if(value == element)
            return true;
        var found = false;
        if(left != null)
            found = left.hasElement(element);
        if(right != null && !found)
            found = right.hasElement(element);
        return found;
    }

    // O(h)
    public boolean hasElementBST(int element){
        if(value == element)
            return true;
        var found = false;
        if(value > element && left != null)
            found = left.hasElementBST(element);
        if(value < element && right != null && !found)
            found = right.hasElementBST(element);
        return found;
    }

    // O(n)
    public int getMax(){
        if(left == null && right == null)
            return value;
        var currentMax = value;
        if(left != null)
            currentMax = Math.max(currentMax, left.getMax());
        if(right != null)
            currentMax = Math.max(currentMax, right.getMax());
        return currentMax;
    }

    public ArrayList<Integer> getElementsAtLevel(int level){
        return getElementsAtLevel(level, 0);
    }

    // O(n)
    protected ArrayList<Integer> getElementsAtLevel(int level, int currentLevel){
        if(level == currentLevel)
            return new ArrayList<Integer>(value);
        var elements = new ArrayList<Integer>();
        if(left != null)
            elements.addAll(left.getElementsAtLevel(level, currentLevel + 1));
        if(right != null)
            elements.addAll(right.getElementsAtLevel(level, currentLevel + 1));
        return elements;
    }

    public boolean delete(Integer element){
        if(!hasElement(element))
            return false;
        deleteTree(element);
        return true;
    }

    // O(h)
    public Tree deleteTree(int element) {
        if(value > element && left != null)
            left = left.deleteTree(element);
        else if(value < element && right != null)
            right = right.deleteTree(element);
        else{
            if(left == null && right == null)
                return null;
            else if(right != null){
                value = right.value;
                right = deleteTree(value);
            }else{
                value = left.value;
                left = deleteTree(value);
            }
        }
        return this;
    }

}
