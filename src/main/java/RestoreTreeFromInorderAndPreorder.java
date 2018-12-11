import java.util.ArrayList;
import java.util.Stack;

public class RestoreTreeFromInorderAndPreorder {
    
    private class Tree {
        int value;
        Tree left;
        Tree right;
        
        private Tree (int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public int find(int value, int[] array, int start) {
        for (int i = start; i < array.length; i++) {
            if (array[i] == value ) {
                return i;
            }
        }
        return -1;
    }

    public Tree restoreRecursiveHelper(int prel, int prer, int inl, int inr, int[] preorder, int[] inorder) {
        if (prer - prel >= 0 && inr - inl >= 0) {
            int root = preorder[prel];
            int inorderIndex = find(root, inorder, inl);
            Tree left = restoreRecursiveHelper(prel + 1, prel + inorderIndex - inl, inl, inorderIndex - 1, preorder, inorder);
            Tree right = restoreRecursiveHelper(prel + inorderIndex - inl + 1, prer,inorderIndex + 1, inr, preorder, inorder);
            return new Tree(root, left, right);
        } else {
            return null;
        }
    }

    public Tree restore (int[] preorder, int[] inorder) {
        return restoreRecursiveHelper(0, preorder.length - 1, 0, inorder.length - 1 , preorder, inorder);
    }

}
