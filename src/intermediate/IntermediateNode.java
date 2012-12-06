package intermediate;


import syntaxtree.Node;


public abstract class IntermediateNode {        
    private Node abstractSyntaxNode;
    private String token; 

    public IntermediateNode(Node abstractSyntaxNode, String token) {
        this.abstractSyntaxNode = abstractSyntaxNode;
        this.token = token;
    }

    public Node getAbstractSyntaxNode() {
        return abstractSyntaxNode;
    }

    public String getToken() {
        return token;
    }
    
}
