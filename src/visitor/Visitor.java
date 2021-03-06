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
    * f0 -> select()
    * f1 -> from()
    * f2 -> [ where() ]
    * f3 -> [ groupby() ]
    * f4 -> [ orderby() ]
    * f5 -> ";"
    */
   public void visit(querySpecification n);

   /**
    * f0 -> <SELECT>
    * f1 -> ( "*" | commonValueExpression() ( "," commonValueExpression() )* )
    */
   public void visit(select n);

   /**
    * f0 -> <FROM>
    * f1 -> identifier()
    */
   public void visit(from n);

   /**
    * f0 -> <WHERE>
    * f1 -> booleanValueExpression()
    */
   public void visit(where n);

   /**
    * f0 -> <GROUPBY>
    * f1 -> identifier()
    */
   public void visit(groupby n);

   /**
    * f0 -> <ORDERBY>
    * f1 -> identifier()
    * f2 -> [ <ASC> | <DESC> ]
    */
   public void visit(orderby n);

   /**
    * f0 -> "(" commonValueExpression() ")"
    *       | nonparenthesizedValueExpressionPrimary()
    */
   public void visit(commonValueExpression n);

   /**
    * f0 -> identifier()
    *       | setFunctionType()
    *       | <number>
    */
   public void visit(nonparenthesizedValueExpressionPrimary n);

   /**
    * f0 -> <identifier>
    */
   public void visit(identifier n);

   /**
    * f0 -> <setfunctiontype>
    * f1 -> "("
    * f2 -> <identifier>
    * f3 -> ")"
    */
   public void visit(setFunctionType n);

   /**
    * f0 -> booleanTerm()
    * f1 -> booleanValueExpressionPrime()
    */
   public void visit(booleanValueExpression n);

   /**
    * f0 -> ( <OR> booleanTerm() booleanValueExpressionPrime() )?
    */
   public void visit(booleanValueExpressionPrime n);

   /**
    * f0 -> booleanFactor()
    * f1 -> booleanTermPrime()
    */
   public void visit(booleanTerm n);

   /**
    * f0 -> ( <AND> booleanFactor() booleanTermPrime() )?
    */
   public void visit(booleanTermPrime n);

   /**
    * f0 -> [ <NOT> ]
    * f1 -> boleanPredicand()
    * f2 -> [ <compop> boleanPredicand() ]
    */
   public void visit(booleanFactor n);

   /**
    * f0 -> "(" booleanValueExpression() ")"
    *       | nonparenthesizedValueExpressionPrimary()
    */
   public void visit(boleanPredicand n);

}

