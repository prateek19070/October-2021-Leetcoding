// Unique Binary Search Trees II

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n > 0){
            List<TreeNode> trees = findTrees(1, n);
            return trees;
        }
        else{
            return new ArrayList<>();
        }
    }
    
    public List<TreeNode> findTrees(int start, int end){
        List<TreeNode> treeList = new ArrayList<>();
        
        if(start > end){
            treeList.add(null);
            return treeList;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> leftTree = findTrees(start, i-1);
            List<TreeNode> rightTree = findTrees(i+1, end);
            
            for(int j = 0; j < leftTree.size(); j++){
                TreeNode left = leftTree.get(j);
                
                for(int k = 0; k < rightTree.size(); k++){
                    TreeNode right = rightTree.get(k);
                    
                    TreeNode node = new TreeNode(i);  
					node.left=left;
					node.right=right;
					
					treeList.add(node);
                }
            }
        }
        return treeList;
    }
}