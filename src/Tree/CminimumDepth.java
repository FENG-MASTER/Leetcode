package Tree;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest
 * path from the root node down to the nearest leaf node.
 */
public class CminimumDepth {

    public int run(TreeNode root) {
        if(root==null){
            return 0;
        }

        int depth=1;
        int LD=0;
        int RD=0;
        if (root.left==null&&root.right==null){
            return 1;
        }else if (root.left!=null&&root.right==null){
            LD=run(root.left);
            depth+=LD;
        }else if (root.right!=null&&root.left==null){
            RD=run(root.right);
            depth+=RD;
        }else {
            //都不空
            LD=run(root.left);
            RD=run(root.right);
            if (LD<=RD){
                depth+=LD;
            }else {
                depth+=RD;
            }

        }

        return depth;

    }
}
