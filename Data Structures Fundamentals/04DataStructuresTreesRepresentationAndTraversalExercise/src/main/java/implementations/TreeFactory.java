package implementations;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TreeFactory {
    private Map<Integer, Tree<Integer>> nodesByKeys;

    public TreeFactory() {
        this.nodesByKeys = new LinkedHashMap<>();
    }

    public Tree<Integer> createTreeFromStrings(String[] input) {
        for (String str : input) {
            int[] numbers = Arrays.stream(str.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int parentKey = numbers[0];
            int childKey = numbers[1];

            Tree<Integer> parent = createNodeByKey(parentKey);
            Tree<Integer> child = createNodeByKey(childKey);
            addEdge(parent, child);
        }

        return this.getRoot();
    }

    private Tree<Integer> getRoot() {
        for (Tree<Integer> value : nodesByKeys.values()) {
            if (value.getParent() == null){
                return value;
            }
        }
        return null;
    }

    public Tree<Integer> createNodeByKey(int key) {
        Tree<Integer> node = new Tree<>(key, null);
        this.nodesByKeys.putIfAbsent(key, node);
        return this.nodesByKeys.get(key);
    }

    public void addEdge(Tree<Integer> parent, Tree<Integer> child) {
        parent.addChild(child);
        child.setParent(parent);
    }
}



