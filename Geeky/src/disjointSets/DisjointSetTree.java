package disjointSets;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetTree {

    List<DisjointSet> disjointSetList = new ArrayList<>();

    public DisjointSet find(DisjointSet set){
        if(set.parent != null)
            return find(set.parent);
        return set;
    }

    public void union(int s, int t){
        DisjointSet node1 = disjointSetList.get(s);
        DisjointSet node2 = disjointSetList.get(t);

        if(node1.parent == null)
            node1.parent = node2;
        else if(node2.parent == null)
            node2.parent = node1;
        else {
            DisjointSet parent1 = find(node1);
            DisjointSet parent2 = find(node2);

            if (parent1.parent != parent2.parent) {
                parent1.parent = parent2;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;

        DisjointSetTree tree = new DisjointSetTree();
        tree.makeSet(n);
        tree.union(1, 2);
        tree.union(3, 4);
        tree.union(0, 1);

        tree.print();
    }

    private void print() {
        for(DisjointSet set : disjointSetList){
            DisjointSet recur = set;
            while (recur.parent != null) {
                System.out.println(recur.value);
                recur = recur.parent;
            }
            System.out.println(recur.value);
            System.out.println();
        }
    }

    private void makeSet(int n) {
        for(int i = 0; i < n; i++){
            DisjointSet set = new DisjointSet(i);
            disjointSetList.add(set);
        }
    }
}
