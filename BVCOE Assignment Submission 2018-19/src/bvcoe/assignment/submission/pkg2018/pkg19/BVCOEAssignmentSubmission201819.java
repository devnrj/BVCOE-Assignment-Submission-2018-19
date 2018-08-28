/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bvcoe.assignment.submission.pkg2018.pkg19;

import com.neeraj.service.NodeOps;

/**
 *
 * @author mca
 */
public class BVCOEAssignmentSubmission201819 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NodeOps no = NodeOps.getInstance();
        System.out.println(no.createGenesisNode("A", 32.5));
        
    }
}
