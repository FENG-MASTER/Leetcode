package Tree;

import java.util.Stack;

/**
 *

 Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class CisSameTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }

        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        stack1.push(p);
        stack2.push(q);

        while (!stack1.isEmpty()&&!stack2.isEmpty()){

            TreeNode node1=stack1.pop();
            TreeNode node2=stack2.pop();

            if (node1==null&&node2==null){
                continue;
            }else if(node1==null||node2==null){
                return false;
            }

            if (node1.val!=node2.val){
                return false;
            }else {
                stack1.push(node1.left);
                stack1.push(node1.right);

                stack2.push(node2.left);
                stack2.push(node2.right);
            }


        }

        return true;

    }


}
