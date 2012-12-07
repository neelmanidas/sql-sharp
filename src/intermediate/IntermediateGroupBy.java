package intermediate;


import syntaxtree.groupby;

public class IntermediateGroupBy extends IntermediateNode {
    private IntermediateIdentifier param;

    public IntermediateGroupBy(groupby n, String tokenImage) {
        super(n,tokenImage);
        
        param = new IntermediateIdentifier(n.f1.f0.tokenImage);
    }

    /**
     * @return the param
     */
    public IntermediateIdentifier getParam() {
        return param;
    }
    
}
