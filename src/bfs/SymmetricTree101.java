package bfs;

import java.util.LinkedList;
import java.util.List;

/**
 * 几乎完全忘记dfs是怎么做的了
 * 7ms，快
 */
public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        List<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();//长度
            for(int i=0;i<size/2;i++){//遍历本次元素
                if(queue.get(i)==queue.get(size-1-i) && queue.get(i)==null ){
                    continue;
                }
                if(queue.get(i)!=null && queue.get(size-1-i)!=null && queue.get(i).val== queue.get(size-1-i).val){
                    continue;
                }else{
                    return false;
                }

            }
            for(int i=0;i<size;i++){//遍历本次元素
                TreeNode node = queue.remove(0);
                if(node!=null){
                    //添加子节点
                    queue.add(node.left);
                    queue.add(node.right);
                }

            }
        }
        return true;
    }


    /**
     * 递归版本
     * 13ms，慢
     * @param root
     * @return
     */
    public boolean isSymmetricV2(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }
    private boolean isSymmetric(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null) return true;
        if(node1==null && node2!=null || node2==null && node1!=null) return false;
        if(node1.val!=node2.val) return false;
        return isSymmetric(node1.left,node2.right) && isSymmetric(node1.right,node2.left);
    }


}
