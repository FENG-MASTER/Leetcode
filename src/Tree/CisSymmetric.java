package Tree;

import java.util.*;

/**
 *  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3


 But the following is not:

 1
 / \
 2   2
 \   \
 3    3


 Note:
 Bonus points if you could solve it both recursively and iteratively.

 confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.

 OJ's Binary Tree Serialization:

 The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

 Here's an example:

 1
 / \
 2   3
 /
 4
 \
 5

 The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".
 */
public class CisSymmetric {




    public static boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>() ;

        stack1.push(root.left);
        stack2.push(root.right);


        while (!stack1.isEmpty()&&!stack2.isEmpty()){


            TreeNode f=stack1.pop();
            TreeNode e=stack2.pop();
            if (f==null&&e==null){
                continue;//!!!
            }else if(f==null||e==null){
                return false;
            }

            if (f.val!=e.val){
                return false;
            }else {
                stack1.push(f.right);
                stack1.push(f.left);
                stack2.push(e.left);
                stack2.push(e.right);
            }

        }

        return true;



    }


    public static void main(String arg[]){

    }








}
