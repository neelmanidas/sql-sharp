
package intermediate;

public class IntermediateSetFunctionType extends IntermediateColumSelection {
    private String functionName;    
    private IntermediateIdentifier param;

    public IntermediateSetFunctionType(String functionName, IntermediateIdentifier identifier) {
        super(functionName+"_"+identifier);
        this.functionName = functionName;
        this.param = identifier;
    }

    /**
     * @return the functionName
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * @return the param
     */
    public IntermediateIdentifier getParam() {
        return param;
    }
    
}
