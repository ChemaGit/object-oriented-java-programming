package roadgraph;

import geography.GeographicPoint;

import java.util.PriorityQueue;

public class MainPruebas {

    public static void main(String [] args) {
        GeographicPoint g = new GeographicPoint(1.0, 1.0);
        GeographicPoint g1 = new GeographicPoint(5.0, 0.0);
        GeographicPoint g2 = new GeographicPoint(6.0, 3.0);
        GeographicPoint g3 = new GeographicPoint(3.0, 7.0);
        GeographicPoint g4 = new GeographicPoint(5.0, 6.0);
        GeographicPoint g5 = new GeographicPoint(15.0, 16.0);

        GraphNode n = new GraphNode(g);
        n.setToGoal(5);
        GraphNode n1 = new GraphNode(g1);
        n1.setToGoal(10);
        GraphNode n2 = new GraphNode(g2);
        n2.setToGoal(15);
        GraphNode n3 = new GraphNode(g3);
        n3.setToGoal(20);
        GraphNode n4 = new GraphNode(g4);
        n4.setToGoal(25);
        GraphNode n5 = new GraphNode(g5);
        n5.setToGoal(4);

        PriorityQueue<GraphNode> pq = new PriorityQueue<>();
        pq.add(n);
        pq.add(n1);
        pq.add(n2);
        pq.add(n3);
        pq.add(n4);
        pq.add(n5);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
