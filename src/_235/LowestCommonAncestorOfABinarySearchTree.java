package _235;
/*
 * Created by Rebecca Dsouza on 5/14/20
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode t = new TreeNode(23);
        t.left = new TreeNode(22);
        t.right = new TreeNode(24);
        System.out.println(sol.lowestCommonAncestor(t,t.left,t.right));
    }
}
class TreeNode{
    TreeNode left, right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
class Solution {
    TreeNode ans;
    public boolean function(TreeNode node, int pval, int qval){
        if(node!=null){
            int count = 0;
            if(node.val==pval || node.val==qval) count++;
            if(function(node.left, pval, qval)) count++;
            if(function(node.right, pval, qval)) count++;
            if(count>1) ans = node;
            if(count>0) return true;
            else return false;
        }
        else return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        function(root,p.val,q.val);
        return ans;
    }

    // public String function(TreeNode node, int val, String path){
    //     if(node!=null){
    //         if(node.val==val) return path;
    //         else if(node.left==null && node.right==null) return "";
    //         else{
    //             String lPath = function(node.left,val,path+"l");
    //             String rPath = function(node.right,val,path+"r");
    //             return (lPath.equals(""))?rPath:lPath;
    //         }
    //     }
    //     return "";
    // }
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
    //     String pPath = function(root,p.val,"");
    //     String qPath = function(root,q.val,"");
    //     TreeNode pAncestor = root, qAncestor = root, pNext, qNext;
    //     while(pPath.length()>=1 && qPath.length()>=1){
    //         pNext = (pPath.charAt(0)=='l')?pAncestor.left:pAncestor.right;
    //         qNext = (qPath.charAt(0)=='l')?qAncestor.left:qAncestor.right;
    //         if(pNext.val==qNext.val){
    //             pAncestor = pNext;
    //             qAncestor = qNext;
    //             pPath = pPath.substring(1);
    //             qPath = qPath.substring(1);
    //         }
    //         else return pAncestor;
    //     }
    //     return pAncestor;
    // }
}