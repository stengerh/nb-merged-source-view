
package stengerh.netbeans.modules.mergedsourceview.nodes;

import org.netbeans.api.java.project.JavaProjectConstants;
import org.netbeans.api.project.SourceGroup;
import org.netbeans.api.project.Sources;
import org.netbeans.spi.java.project.support.ui.PackageView;
import org.openide.nodes.Node;
import org.openide.util.NbBundle;

/**
 *
 * @author Holger Stenger
 */
@NbBundle.Messages("AllSourceNode_DisplayName=All Packages")
public class AllSourceNode extends MergeNode {
    public AllSourceNode(Sources sources) {
        super(getNodes(sources.getSourceGroups(JavaProjectConstants.SOURCES_TYPE_JAVA)));
        setName("AllPackages");
        setDisplayName(Bundle.AllSourceNode_DisplayName());
    }

    private static Node[] getNodes(SourceGroup[] sourceGroups) {
        Node[] sourceGroupNodes = new Node[sourceGroups.length];
        for (int index = 0; index < sourceGroups.length; ++index) {
            sourceGroupNodes[index] = PackageView.createPackageView(sourceGroups[index]);
        }
        return sourceGroupNodes;
    }
}
