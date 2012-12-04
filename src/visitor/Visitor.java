//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All void visitors must implement this interface.
 */

public interface Visitor {

   //
   // void Auto class visitors
   //

   public void visit(NodeList n);
   public void visit(NodeListOptional n);
   public void visit(NodeOptional n);
   public void visit(NodeSequence n);
   public void visit(NodeToken n);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> queryList()
    * f1 -> <EOF>
    */
   public void visit(Prog n);

   /**
    * f0 -> querySpecification()
    * f1 -> ( querySpecification() )*
    */
   public void visit(queryList n);

   /**
    * f0 -> "SELECT"
    * f1 -> selectList()
    * f2 -> "FROM"
    * f3 -> <identifier>
    * f4 -> [ "WHERE" booleanValueExpression() ]
    * f5 -> [ "GROUP BY" <identifier> ]
    * f6 -> ";"
    */
   public void visit(querySpecification n);

   /**
    * f0 -> "*"
    *       | derivedColumn() ( "," derivedColumn() )*
    */
   public void visit(selectList n);

   /**
    * f0 -> commonValueExpression()
    * f1 -> [ [ "AS" ] <identifier> ]
    */
   public void visit(derivedColumn n);

   /**
    * f0 -> "(" commonValueExpression() ")"
    *       | nonparenthesizedValueExpressionPrimary()
    */
   public void visit(commonValueExpression n);

   /**
    * f0 -> <identifier>
    *       | <setfunctiontype> "(" commonValueExpression() ")"
    *       | <number>
    */
   public void visit(nonparenthesizedValueExpressionPrimary n);

   /**
    * f0 -> booleanTerm()
    * f1 -> booleanValueExpressionPrime()
    */
   public void visit(booleanValueExpression n);

   /**
    * f0 -> ( "OR" booleanTerm() booleanValueExpressionPrime() )?
    */
   public void visit(booleanValueExpressionPrime n);

   /**
    * f0 -> booleanFactor()
    * f1 -> booleanTermPrime()
    */
   public void visit(booleanTerm n);

   /**
    * f0 -> ( "AND" booleanFactor() booleanTermPrime() )?
    */
   public void visit(booleanTermPrime n);

   /**
    * f0 -> [ "NOT" ]
    * f1 -> boleanPredicand()
    * f2 -> [ <compop> boleanPredicand() ]
    * f3 -> [ "IS" [ "NOT" ] <truthValue> ]
    */
   public void visit(booleanFactor n);

   /**
    * f0 -> "(" booleanValueExpression() ")"
    *       | nonparenthesizedValueExpressionPrimary()
    */
   public void visit(boleanPredicand n);

}
