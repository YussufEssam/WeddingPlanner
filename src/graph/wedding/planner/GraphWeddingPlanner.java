/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.wedding.planner;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author Dell
 */
public class GraphWeddingPlanner {

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        
        guestsForm GuestsForm = new guestsForm();
        GuestsForm.setSize(600, 450);
        GuestsForm.setLocationRelativeTo(null);
        GuestsForm.setResizable(false);
        GuestsForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GuestsForm.setVisible(true);
                
    }
    
}

class Graph<T> {

    private Map<T, List<T> > map = new HashMap<>();

    public void addVertex(T s) {
        map.put(s, new LinkedList<T>()); 
    }

    public void addEdge(T source, T destination) {
                
        if (!map.containsKey(source)) 
            addVertex(source);
        else {
            for (T n : map.get(source)) {
                if (!map.get(n).contains(destination)) 
                    map.get(n).add(destination);
            }
        }

        if (!map.containsKey(destination)) 
            addVertex(destination);

        if (!map.get(source).contains(destination)) 
            map.get(source).add(destination); 
        if (!map.get(destination).contains(source)) 
            map.get(destination).add(source); 
        
    }

    //Function to Compute the number of tables
    public int numOfTables () {
        int num = 0;
        int s = 0;
        ArrayList<String> temp = new ArrayList<String>();
        
        for (T v : map.keySet()) {
            if (!temp.contains(v.toString())) {
                for (T w : map.get(v)) {
                    if (!temp.contains(w.toString())) {
                        for (T x : map.get(w)) {
                            if (!temp.contains(x.toString())) {
                                temp.add(x.toString());
                            } else {
                                s += 1;
                            }
                        }
                        temp.add(w.toString());
                        if (s < 1) {
                            num += 1;
                        }
                        s = 0;
                    }
                }
                temp.add(v.toString());
            }
        }
        return num;
    }
    
}
