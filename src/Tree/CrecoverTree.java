package Tree;

/**
 *

 Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.
 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?


 confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.

 */


public class CrecoverTree {



    public void recoverTree(TreeNode root) {
        if (root==null){
            return;
        }
    }

    public boolean isBST(TreeNode treeNode,Integer integer[]){
        if (treeNode==null){
            return true;
        }
        int val=treeNode.val;
        integer[0]=val;

        if (treeNode.left!=null&&isBST(treeNode.left,integer)){
            if (integer[0]>=val){
                return false;
            }
        }

        if (treeNode.right!=null&&isBST(treeNode.right,integer)){
            if (integer[0]<=val){
                return false;
            }
        }

        return true;
    }





    public static void main(String args[]){

    }
}
