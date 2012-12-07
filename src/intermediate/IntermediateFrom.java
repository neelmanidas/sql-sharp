package intermediate;


import syntaxtree.from;

public class IntermediateFrom extends IntermediateNode {
    private IntermediateIdentifier source;
    
    
    public IntermediateFrom(from n, String tokenImage) {
        super(n,tokenImage);
        source = new IntermediateIdentifier(n.f1.f0.tokenImage);
    }

    /**
     * @return the source
     */
    public IntermediateIdentifier getSource() {
        return source;
    }
    
}
