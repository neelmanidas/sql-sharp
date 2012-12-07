package intermediate;


import intermediate.IntermediateNode;
import syntaxtree.NodeToken;
import syntaxtree.where;


public class IntermediateWhere extends IntermediateNode {
    private IntermediateIdentifier left;
    private IntermediateOperator operator;
    private IntermediateNode right;

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

    /**
     * @return the left
     */
    public IntermediateIdentifier getLeft() {
        return left;
    }

    /**
     * @return the operator
     */
    public IntermediateOperator getOperator() {
        return operator;
    }

    /**
     * @return the right
     */
    public IntermediateNode getRight() {
        return right;
    }
    
}
