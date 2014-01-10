package stengerh.netbeans.modules.mergedsourceview.nodes;

import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.api.project.Sources;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.netbeans.spi.project.ui.support.NodeList;

/**
 *
 * @author Holger Stenger
 */
@NodeFactory.Registration(projectType = "org-netbeans-modules-maven", position = 50)
public class MavenAllSourceNodeFactory implements NodeFactory {

    @Override
    public NodeList<?> createNodes(Project p) {
        Sources sources = ProjectUtils.getSources(p);
        if (sources == null) {
            return NodeFactorySupport.fixedNodeList();
        } else {
            return new AllSourceNodeList(sources);
        }
    }

}
