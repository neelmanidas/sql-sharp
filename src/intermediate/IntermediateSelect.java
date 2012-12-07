package intermediate;


import java.util.LinkedList;
import syntaxtree.NodeListOptional;
import syntaxtree.NodeSequence;
import syntaxtree.NodeToken;
import syntaxtree.identifier;

import syntaxtree.select;
import syntaxtree.setFunctionType;
import visitor.DepthFirstVisitor;


public class IntermediateSelect extends IntermediateNode {
    private LinkedList<IntermediateColumSelection> params;
    
    
    public IntermediateSelect(select n, String tokenImage) {
        super(n,tokenImage);
        params = new LinkedList<>();   
        
        n.f1.choice.accept(new DepthFirstVisitor(){

            @Override
            public void visit(identifier n) {
                getParams().add(new IntermediateIdentifier(n.f0.tokenImage));
            }

            @Override
            public void visit(setFunctionType n) {
                getParams().add(new IntermediateSetFunctionType(n.f0.tokenImage, new IntermediateIdentifier(n.f2.tokenImage)));
            }           
                        
        });
    }    

    /**
     * @return the params
     */
    public LinkedList<IntermediateColumSelection> getParams() {
        return params;
    }
    
}
