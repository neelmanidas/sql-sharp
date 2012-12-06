package intermediate;


import java.util.LinkedList;
import syntaxtree.NodeListOptional;
import syntaxtree.NodeSequence;
import syntaxtree.NodeToken;
import syntaxtree.derivedColumn;
import syntaxtree.select;
import visitor.DepthFirstVisitor;


public class IntermediateSelect extends IntermediateNode {
    LinkedList<String> params;
    
    
    public IntermediateSelect(select n, String tokenImage) {
        super(n,tokenImage);
        params = new LinkedList<>();   
        
        n.f1.choice.accept(new DepthFirstVisitor(){

            @Override
            public void visit(derivedColumn n) {
                super.visit(n);
            }                 
                        
        });
    }    
}
