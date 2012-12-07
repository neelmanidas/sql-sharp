
package intermediate;

public class IntermediateSetFunctionType extends IntermediateColumSelection {
    private String functionName;    
    private IntermediateIdentifier param;

    public IntermediateSetFunctionType(String functionName, IntermediateIdentifier identifier) {
        super(functionName+"_"+identifier.getName());
        this.functionName = functionName.charAt(0) + functionName.substring(1) ;
        this.param = identifier;
    }

    /**
     * @return the functionName
     */
    public String getFunction() {
        return functionName;
    }

    /**
     * @return the param
     */
    public IntermediateIdentifier getParam() {
        return param;
    }
    
}
