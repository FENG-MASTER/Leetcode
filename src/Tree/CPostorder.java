package Tree;

import java.util.ArrayList;

/**
 *  Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree{1,#,2,3},

 1
 \
 2
 /
 3


 return[3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class CPostorder {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if (root==null){
            return arrayList;
        }

        LRC(arrayList,root);
        return arrayList;

    }


    public void LRC(ArrayList<Integer> result,TreeNode root){
        if (root==null){
            return;
        }

        LRC(result,root.left);
        LRC(result,root.right);
        result.add(root.val);

    }







    public static void main(String args[]){

    }

}
