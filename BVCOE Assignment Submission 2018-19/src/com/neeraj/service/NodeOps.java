/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neeraj.service;

import com.neeraj.model.Node;
import java.util.HashMap;

/**
 *
 * @author mca
 */
public class NodeOps {
    private HashMap<String,Node> list;
    private static NodeOps no=null;
    private NodeOps(){
        list=new HashMap<>();
    }
    public static NodeOps getInstance(){
        synchronized(NodeOps.class){
            if(no==null){
                no=new NodeOps();
            }
        }
        return no;
    }
    public Node createGenesisNode(String Name,double val){
        Node nd=new Node(Name,val);
        list.put(nd.getNodeId(),nd);
        return nd;
    }
    public Node createNode(){
        Node nd= new Node();
        list.put(nd.getNodeId(),nd);
        return nd;
    }
    public int createNchildof(Node node,int n){
        int i=0;
        double val=node.getData()/n;
        for(;i<n;i++){
           Node nd=this.childOf(node);
           nd.setData(val);
        }
        if(i<n){
            return -1;
        }
        return 0;
    }
    public Node childOf(Node node){
        Node nd= new Node(node);
        list.put(nd.getNodeId(),nd);
        return nd;
    }
   
}
