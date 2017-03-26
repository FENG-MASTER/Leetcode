package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree{3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7


 return its zigzag level order traversal as:

 [
 [3],
 [20,9],
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
public class CzigzagLevelOrder {




    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<TreeNode>> lists=new ArrayList<>();
        List<TreeNode> l=new ArrayList<>();
        l.add(root);
        lists.add(l);
        foo(lists);

        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        int n=lists.size();
        for (int i=0;i<n;i++){
            int n1=lists.get(i).size();
            ArrayList<Integer> list=new ArrayList<>();
            for (int j=0;j<n1;j++){
                if (lists.get(i).get(j)!=null){
                    list.add(lists.get(i).get(j).val);
                }
            }
            result.add(list);
        }
        return result;

    }

    private static void foo(List<List<TreeNode>> lists){
        if (lists==null){
            return;
        }

        int h=lists.size()-1;

        boolean L2R= !(h % 2 == 0);//左右标记位

        int n=lists.get(h).size();
        List<TreeNode> lastList=lists.get(h);


        List<TreeNode> newList=new ArrayList<>();

            for (int i =n-1;i>=0;i--){
                if (L2R){
                    if (lastList.get(i)!=null){
                        if (lastList.get(i).right!=null){
                            newList.add(lastList.get(i).right);
                        }
                        if (lastList.get(i).left!=null){
                            newList.add(lastList.get(i).left);
                        }
                    }
                }else {
                    if (lastList.get(i)!=null){
                        if (lastList.get(i).left!=null){
                            newList.add(lastList.get(i).left);
                        }
                        if (lastList.get(i).right!=null){
                            newList.add(lastList.get(i).right);
                        }
                    }
                }

            }


        if (newList.isEmpty()){
            return;
        }
        lists.add(newList);
        foo(lists);

    }

    public static void main(String arg[]){
        TreeNode treeNode=new TreeNode(1);
        zigzagLevelOrder(treeNode);

        System.out.println("11");
    }


}
