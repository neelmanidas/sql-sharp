package intermediate;


import syntaxtree.NodeToken;
import syntaxtree.orderby;

public class IntermediateOrderBy extends IntermediateNode {
    private IntermediateIdentifier param;
    private boolean byDescending = false;
    
    public IntermediateOrderBy(orderby n, String tokenImage) {
        super(n,tokenImage);
        
        param = new IntermediateIdentifier(n.f1.f0.tokenImage);
        byDescending = n.f2.present()?((NodeToken)n.f2.node).tokenImage.equals("DESC"):false;
    }
    
        /**
     * @return the param
     */
    public IntermediateIdentifier getParam() {
        return param;
    }

    /**
     * @return the byDescending
     */
    public boolean isByDescending() {
        return byDescending;
    }
    
}
