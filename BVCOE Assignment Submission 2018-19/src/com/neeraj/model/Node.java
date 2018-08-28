/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neeraj.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/**
 *
 * @author mca
 */
public class Node {
    private Date timeStamp;
    private String data;
    private static Integer nodeNumber;
    private String nodeId;
    private String referenceNodeId;
    private ArrayList<String> childReferenceNodeId;
    private static String genesisReferenceNodeId;
    private String hashValue;
    private String name;
    static{
        nodeNumber=0;
        genesisReferenceNodeId=null;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    //called only when genesis node is created;
    public Node(String name,double val){
        timeStamp=new Date();
        nodeNumber++;
        this.setData(val);
        referenceNodeId=null;
        this.nodeId=Integer.toBinaryString(nodeNumber).toString();
        genesisReferenceNodeId=nodeId;
    }
    public Node(){
        timeStamp=new Date();
        nodeNumber++;
        referenceNodeId=null;
        this.nodeId=Integer.toBinaryString(nodeNumber).toString();
    }
    public Node(Node parent){
        timeStamp=new Date();
        nodeNumber++;
        referenceNodeId=parent.getNodeId();
        this.nodeId=Integer.toBinaryString(nodeNumber).toString();
    }

    public ArrayList<String> getChildReferenceNodeId() {
        return childReferenceNodeId;
    }

    public void setChildReferenceNodeId(ArrayList<String> childReferenceNodeId) {
        this.childReferenceNodeId = childReferenceNodeId;
    }
    //decryption of data
    public Double getData() {
        Double val=Double.parseDouble(data);
        return val;
    }
    //encryption of data
    public void setData(double data) {
        this.data = nodeId+":"+data+":"+name+":"+this.hashCode();
    }

    public static String getGenesisReferenceNodeId() {
        return genesisReferenceNodeId;
    }

    public static void setGenesisReferenceNodeId(String genesisReferenceNodeId) {
        Node.genesisReferenceNodeId = genesisReferenceNodeId;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public static Integer getNodeNumber() {
        return nodeNumber;
    }

    public static void setNodeNumber(Integer nodeNumber) {
        Node.nodeNumber = nodeNumber;
    }

    public String getReferenceNodeId() {
        return referenceNodeId;
    }

    public void setReferenceNodeId(String referenceNodeId) {
        this.referenceNodeId = referenceNodeId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Node{" + "timeStamp=" + timeStamp + ", data=" + data + ", nodeId=" + nodeId + ", referenceNodeId=" + referenceNodeId + ", childReferenceNodeId=" + childReferenceNodeId + ", hashValue=" + hashValue  + ", name=" + name + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.timeStamp);
        hash = 17 * hash + Objects.hashCode(this.data);
        hash = 17 * hash + Objects.hashCode(this.nodeNumber);
        hash = 17 * hash + Objects.hashCode(this.nodeId);
        hash = 17 * hash + Objects.hashCode(this.referenceNodeId);
        hash = 17 * hash + Objects.hashCode(this.childReferenceNodeId);
        hash = 17 * hash + Objects.hashCode(this.genesisReferenceNodeId);
        this.setHashValue(""+hash);
        return hash;
    }
    
    
    
    
}
