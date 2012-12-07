package intermediate;


import intermediate.IntermediateNode;
import syntaxtree.NodeToken;
import syntaxtree.where;


public class IntermediateWhere extends IntermediateNode {
    IntermediateIdentifier left;
    IntermediateOperator operator;
    IntermediateNode right;

    public IntermediateWhere(where n, String tokenImage) {
        super(n,tokenImage);
        
        left = new IntermediateIdentifier(n.f1.f0.tokenImage);
        operator = new IntermediateOperator(n.f2.tokenImage);
        
        String image = ((NodeToken)n.f3.choice).tokenImage;
        if(n.f3.choice.getClass().equals(NodeToken.class))
        {
            right = new IntermediateNumber(n.f3.choice, image);
        }else
        {
            left = new IntermediateIdentifier(image);
        }
    }
    
}
