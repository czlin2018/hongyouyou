package com.czl.business.算法练习;

import lombok.Data;

import java.util.*;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2021-01-24
 * @创建时间: 16:27
 */
public class 树 {

    @Data
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode2.setLeft(treeNode1);
        treeNode2.setRight(treeNode3);
        treeNode1.setLeft(treeNode0);
        treeNode3.setRight(treeNode4);
        List<Integer> s = new ArrayList<>();
        前序(treeNode2, s);
        System.out.println(s);

         s = new ArrayList<>();
        中序(treeNode2, s);
        System.out.println(s);

         s = new ArrayList<>();
        后序(treeNode2, s);
        System.out.println(s);

        s = new ArrayList<>();
        广度(treeNode2, s);
        System.out.println(s);

        s = new ArrayList<>();
        深度(treeNode2, s);
        System.out.println(s);

        s = new ArrayList<>();
        TreeNode 反转1 = 反转1(treeNode2);
        中序(反转1,s);
        System.out.println(s);

        s = new ArrayList<>();
        TreeNode 反转2 = 反转2(treeNode2);
        中序(反转2,s);
        System.out.println(s);

    }

    /**
     * 根结点 —> 左子树 —> 右子树
     * @param node
     * @param s
     */
    public static void 前序(TreeNode node,List<Integer> s) {
        if (node == null)
            return;
        s.add(node.val);
        前序(node.left,s);
        前序(node.right,s);
    }

    /**
     *左子树—> 根结点 —> 右子树
     * @param node
     * @param s
     */
    public static void 中序(TreeNode node,List<Integer> s) {
        if (node == null)
            return;
        中序(node.left,s);
        s.add(node.val);
        中序(node.right,s);
    }

    /**
     * 左子树 —> 右子树 —> 根结点
     * @param node
     * @param s
     */
    public static void 后序(TreeNode node,List<Integer> s) {
        if (node == null)
            return;
        后序(node.left,s);
        后序(node.right,s);
        s.add(node.val);
    }

    public static void 广度(TreeNode node,List<Integer> s) {
            if(node==null)
                return ;
            Queue<TreeNode> queue=new LinkedList<TreeNode>();
            queue.offer(node);
            while(!queue.isEmpty()){
                TreeNode tree=queue.poll();
                if(tree.left!=null)
                    queue.offer(tree.left);
                if(tree.right!=null)
                    queue.offer(tree.right);
                s.add(tree.val);
            }
            return ;
    }

    /**
     * 同前序遍历
     * @param node
     * @param s
     */
    public static void 深度(TreeNode node,List<Integer> s) {
        if(node==null)
            return ;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode tree=stack.pop();
            if(tree.right!=null)
                stack.push(tree.right);
            if(tree.left!=null)
                stack.push(tree.left);
            s.add(tree.val);
        }
        return ;
    }

    public static TreeNode 反转1(TreeNode root) {
        if (root == null) {
            return null;
        }

        //递归反转左右子树
        TreeNode temp = root.left;
        root.left = 反转1(root.right);
        root.right = 反转1(temp);
        return root;

    }

    public static TreeNode 反转2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(root);

        while (queue.size()>0){
            TreeNode poll = queue.poll();
            TreeNode them = poll.left;
            poll.left= poll.right;
            poll.right= them;

            if (poll.right!=null) {
                queue.offer(poll.right);
            }
            if (poll.left!=null) {
                queue.offer(poll.left);
            }

        }
        return root;
        }



}
