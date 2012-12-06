import java.util.LinkedList;
import syntaxtree.Node;
import syntaxtree.from;
import syntaxtree.groupby;
import syntaxtree.orderby;
import syntaxtree.select;
import syntaxtree.where;
import visitor.DepthFirstVisitor;


public class DFVSequencer extends DepthFirstVisitor {
    private LinkedList<IntermediateNode> sequence;

    public DFVSequencer() {
        sequence = new LinkedList<>();
    }

    @Override
    public void visit(select n) {        
        super.visit(n);        
        sequence.add(new IntermediateSelect(n,n.f0.tokenImage));
    }

    @Override
    public void visit(from n) {
        sequence.add(new IntermediateFrom(n,n.f0.tokenImage));
        super.visit(n);
    }

    @Override
    public void visit(where n) {
        sequence.add(new IntermediateWhere(n,n.f0.tokenImage));
        super.visit(n);
    }

    @Override
    public void visit(groupby n) {
        sequence.add(new IntermediateGroupBy(n,n.f0.tokenImage));
        super.visit(n);
    }

    @Override
    public void visit(orderby n) {
        sequence.add(new IntermediateOrderBy(n,n.f0.tokenImage));
        super.visit(n);
    }        
   
    
    /**
     * @return the sequence
     */
    public LinkedList<IntermediateNode> getSequence() {
        return sequence;
    }
}
