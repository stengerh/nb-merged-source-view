package stengerh.netbeans.modules.mergedsourceview.nodes;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author Holger Stenger
 */
public class MergeChildren extends Children.Keys<String> {
    private final java.util.Map<String, List<Node>> keyMap;

    private final Children[] childrens;

    public MergeChildren(Children[] childrens) {
        this.keyMap = new TreeMap<String, List<Node>>();
        this.childrens = childrens;
    }

    @Override
    protected Node[] createNodes(String key) {
        List<Node> nodes = keyMap.get(key);
        Node mergeNode = new MergeNode(nodes.toArray(new Node[nodes.size()]));
        return new Node[]{mergeNode};
    }

    @Override
    protected void addNotify() {
        super.addNotify(); //To change body of generated methods, choose Tools | Templates.
        computeKeys();
    }

    @Override
    protected void removeNotify() {
        super.removeNotify(); //To change body of generated methods, choose Tools | Templates.
    }

    private void computeKeys() {
        for (Children children : childrens) {
            Node[] nodes = children.getNodes(true);
            for (Node node : nodes) {
                add(node.getName(), node);
            }
        }
        setKeys(keyMap.keySet());
    }

    private void add(String key, Node node) {
        List<Node> nodes = keyMap.get(key);
        if (nodes == null) {
            nodes = new ArrayList<Node>();
            keyMap.put(key, nodes);
        }
        nodes.add(node);
    }
}
