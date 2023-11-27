package data.structures.trees;

import com.sun.source.tree.Tree;

import java.util.Arrays;

public class BinaryTree {
    private TreeNode node;

//    public TreeNode traverse(TreeNode node){
//        if(node.getLeft() != null) {
//            return traverse(node.getLeft());
//        } else if(node.getRight() != null) {
//            return traverse(node.getRight());
//        } else {
//            System.out.println(node.getValue());
//            return traverse(node.getParent());
//        }
//    }

    /**
     * Gets leftmost leaf AKA first in traversal order
     * @param node
     * @return
     */
    public TreeNode getFirstSubtree(TreeNode node){
        if(node.getLeft() == null) return node;
        else {
            return getFirstSubtree(node.getLeft());
        }
    }

//    public TreeNode getSuccessor(TreeNode node){
//        if(node.getRight() != null){
//            return getFirstSubtree(node.getRight());
//        } else {
//            return node.getParent().getLeft() == node ? return getSuccessor(node.getParent()) : return node;
//        }
//    }

//    public TreeNode insertAfter(TreeNode nodeToInsert, TreeNode node){
//        if(node == null){
//
//        }
//    }


//    public TreeNode createTree(char[] traversalOrder){
//        for (int i = 0; i < traversalOrder.length; i++) {
//            TreeNode node = new TreeNode();
//            node.setValue(traversalOrder[i]);
//            if(i - 1 >= 0){
//
//            } else {
//                node.setLeft(null);
//            }
//            if(i + 1 < traversalOrder.length){
//                node.setParent();
//            }
//        }
//    }
}
