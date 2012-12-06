import intermediate.DFVShowTreeVisitor;
import intermediate.IntermediateNode;
import intermediate.DFVSequencer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import syntaxtree.Node;
import syntaxtree.Prog;
import visitor.DepthFirstVisitor;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        SQLParser parser = new SQLParser(new FileInputStream("testsql"));
        Prog prog = parser.Prog();
        
        DepthFirstVisitor st = new DFVShowTreeVisitor();
        st.visit(prog);
        
        DFVSequencer seq = new DFVSequencer();
        seq.visit(prog);
        for (Iterator<IntermediateNode> it = seq.getSequence().iterator(); it.hasNext();) {
            IntermediateNode n = it.next();
            
        }
    }
}
