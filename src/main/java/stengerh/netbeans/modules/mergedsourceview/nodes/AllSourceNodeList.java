
package stengerh.netbeans.modules.mergedsourceview.nodes;

import java.util.Collections;
import java.util.List;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Sources;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.nodes.Node;

/**
 *
 * @author Holger Stenger
 */
public class AllSourceNodeList implements NodeList<String> {
    private final Sources sources;

    public AllSourceNodeList(Sources sources) {
        this.sources = sources;
    }

    @Override
    public List<String> keys() {
        return Collections.singletonList("AllPackages");
    }

    @Override
    public void addChangeListener(ChangeListener cl) {
    }

    @Override
    public void removeChangeListener(ChangeListener cl) {
    }

    @Override
    public Node node(String key) {
        return new AllSourceNode(sources);
    }

    @Override
    public void addNotify() {
    }

    @Override
    public void removeNotify() {
    }

}
