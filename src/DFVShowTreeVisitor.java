import syntaxtree.NodeToken;
import syntaxtree.Prog;
import syntaxtree.boleanPredicand;
import syntaxtree.booleanFactor;
import syntaxtree.booleanTerm;
import syntaxtree.booleanTermPrime;
import syntaxtree.booleanValueExpression;
import syntaxtree.booleanValueExpressionPrime;
import syntaxtree.commonValueExpression;
import syntaxtree.derivedColumn;
import syntaxtree.from;
import syntaxtree.groupby;
import syntaxtree.identifier;
import syntaxtree.nonparenthesizedValueExpressionPrimary;
import syntaxtree.orderby;
import syntaxtree.queryList;
import syntaxtree.querySpecification;
import syntaxtree.select;
import syntaxtree.where;
import visitor.DepthFirstVisitor;


class DFVShowTreeVisitor extends DepthFirstVisitor {

    int depht = 0;

    @Override
    public void visit(Prog n) {
        System.out.println("prog");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(boleanPredicand n) {
        System.out.println(tab() + "boleanPredicand");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(booleanFactor n) {
        System.out.println(tab() + "booleanFactor");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(booleanTerm n) {
        System.out.println(tab() + "booleanTerm");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(booleanTermPrime n) {
        System.out.println(tab() + "booleanTermPrime");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(booleanValueExpression n) {
        System.out.println(tab() + "booleanValueExpression");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(booleanValueExpressionPrime n) {
        System.out.println(tab() + "booleanValueExpressionPrime");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(commonValueExpression n) {
        System.out.println(tab() + "commonValueExpression");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(derivedColumn n) {
        System.out.println(tab() + "derivedColumn");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(nonparenthesizedValueExpressionPrimary n) {
        System.out.println(tab() + "nonparenthesizedValueExpressionPrimary");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(querySpecification n) {
        System.out.println(tab() + "querySpecification");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(queryList n) {
        System.out.println(tab() + "queryList");
        depht++;
        super.visit(n);
        depht--;
    }

    private String tab() {
        String tab = "";
        for (int i = 0; i < depht; i++) {
            tab += " ";
        }

        return tab;
    }

    @Override
    public void visit(NodeToken n) {
        System.out.println(tab() + "{"+ n.tokenImage+"}");
        depht++;      
        super.visit(n);        
        depht--;
    }

    @Override
    public void visit(from n) {
        System.out.println(tab() + "from");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(groupby n) {
        System.out.println(tab() + "groupby");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(identifier n) {
        System.out.println(tab() + "identifier");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(orderby n) {
        System.out.println(tab() + "orderby");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(select n) {
        System.out.println(tab() + "select");
        depht++;
        super.visit(n);
        depht--;
    }

    @Override
    public void visit(where n) {
        System.out.println(tab() + "where");
        depht++;
        super.visit(n);
        depht--;
    }
}