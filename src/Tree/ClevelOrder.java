package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree{3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7


 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]


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
public class ClevelOrder {



    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<TreeNode>> treeNodeLists=new ArrayList<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();

        ArrayList<TreeNode> t=new ArrayList<>();
        t.add(root);
        treeNodeLists.add(t);

        int n=0;
        while (!treeNodeLists.get(n).isEmpty()){
            List<TreeNode>  nodesNow=treeNodeLists.get(n);

            int len=nodesNow.size();
            ArrayList<TreeNode> newList=new ArrayList<>();
            for (int i=0;i<len;i++){
                if (nodesNow.get(i).left!=null){
                    newList.add(nodesNow.get(i).left);
                }
                if (nodesNow.get(i).right!=null){
                    newList.add(nodesNow.get(i).right);
                }
            }
            if (!newList.isEmpty()){
                treeNodeLists.add(newList);
            }
            n++;
            if(n==treeNodeLists.size()){
                break;
            }
        }

        int nn=treeNodeLists.size();
        for (int i=0;i<nn;i++){
            int n1=treeNodeLists.get(i).size();
            ArrayList<Integer> list=new ArrayList<>();
            for (int j=0;j<n1;j++){
                if (treeNodeLists.get(i).get(j)!=null){
                    list.add(treeNodeLists.get(i).get(j).val);
                }
            }
            result.add(list);
        }

        return result;

    }




}
