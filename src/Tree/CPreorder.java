package Tree;

import java.util.ArrayList;

/**
 *

 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree{1,#,2,3},

 1
 \
 2
 /
 3


 return[1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class CPreorder {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
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
        result.add(root.val);
        LRC(result,root.left);
        LRC(result,root.right);


    }
}
