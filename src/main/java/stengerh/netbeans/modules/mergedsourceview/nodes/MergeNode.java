
package stengerh.netbeans.modules.mergedsourceview.nodes;

import java.awt.Image;
import javax.swing.Action;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Holger Stenger
 */
public class MergeNode extends AbstractNode {
    private final Node[] nodes;
    
    public MergeNode(Node[] nodes) {
        this(nodes, getChildren(nodes));
    }

    private MergeNode(Node[] nodes, Children[] children) {
        super(new MergeChildren(children), (nodes.length > 0) ? nodes[0].getLookup() : Lookups.fixed());
        this.nodes = nodes;
        if (nodes.length > 0) {
            setName(nodes[0].getName());
            setDisplayName(nodes[0].getDisplayName());
        }
    }

    private static Children[] getChildren(Node[] nodes) {
        Children[] children = new Children[nodes.length];
        for (int index = 0; index < nodes.length; ++index) {
            children[index] = nodes[index].getChildren();
        }
        return children;
    }

    @Override
    public Image getIcon(int type) {
        if (nodes.length > 0) {
            return nodes[0].getIcon(type);
        } else {
            return super.getIcon(type);
        }
    }

    @Override
    public Image getOpenedIcon(int type) {
        if (nodes.length > 0) {
            return nodes[0].getOpenedIcon(type);
        } else {
            return super.getOpenedIcon(type);
        }
    }

    @Override
    public Action[] getActions(boolean context) {
        if (nodes.length > 0) {
            return nodes[0].getActions(context);
        } else {
            return super.getActions(context);
        }
    }

    @Override
    public Action getPreferredAction() {
        if (nodes.length > 0) {
            return nodes[0].getPreferredAction();
        } else {
            return super.getPreferredAction();
        }
    }
}
