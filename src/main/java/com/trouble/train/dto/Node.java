package com.trouble.train.dto;

/**
 * @author troubleMan
 * @description node demo
 * @Date 2022/7/20 23:19
 * @Version 1.0
 **/
public class Node {

  int val;

  Node next;

  Node(){}

  Node(int val){
    this.val = val;
  }

  public void addNode(Node newNode) {
    if (this.next == null) {
      this.next = newNode;
    } else {
      this.next.addNode(newNode);
    }

  }
  public void addData(int val) {
    Node newNode = new Node(val);
    if(this.next == null){
      this.next = newNode;
    } else {
      this.addNode(newNode);
    }

  }
  static class NodeOperate{
    public Node rootNode;


  }

  public static void main(String[] args) {
    Node node = new Node();
    node.addData(1);
    node.addData(2);
    while(node != null){
      System.out.println(node.val);
      node = node.next;
    }

  }
}
