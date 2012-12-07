//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors with no argument must implement this interface.
 */

public interface GJNoArguVisitor<R> {

   //
   // GJ Auto class visitors with no argument
   //

   public R visit(NodeList n);
   public R visit(NodeListOptional n);
   public R visit(NodeOptional n);
   public R visit(NodeSequence n);
   public R visit(NodeToken n);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> queryList()
    * f1 -> <EOF>
    */
   public R visit(Prog n);

   /**
    * f0 -> querySpecification()
    * f1 -> ( querySpecification() )*
    */
   public R visit(queryList n);

   /**
    * f0 -> select()
    * f1 -> from()
    * f2 -> [ where() ]
    * f3 -> [ groupby() ]
    * f4 -> [ orderby() ]
    * f5 -> ";"
    */
   public R visit(querySpecification n);

   /**
    * f0 -> <SELECT>
    * f1 -> ( "*" | commonValueExpression() ( "," commonValueExpression() )* )
    */
   public R visit(select n);

   /**
    * f0 -> <FROM>
    * f1 -> identifier()
    */
   public R visit(from n);

   /**
    * f0 -> <WHERE>
    * f1 -> booleanValueExpression()
    */
   public R visit(where n);

   /**
    * f0 -> <GROUPBY>
    * f1 -> identifier()
    */
   public R visit(groupby n);

   /**
    * f0 -> <ORDERBY>
    * f1 -> identifier()
    * f2 -> [ <ASC> | <DESC> ]
    */
   public R visit(orderby n);

   /**
    * f0 -> "(" commonValueExpression() ")"
    *       | nonparenthesizedValueExpressionPrimary()
    */
   public R visit(commonValueExpression n);

   /**
    * f0 -> identifier()
    *       | setFunctionType()
    *       | <number>
    */
   public R visit(nonparenthesizedValueExpressionPrimary n);

   /**
    * f0 -> <identifier>
    */
   public R visit(identifier n);

   /**
    * f0 -> <setfunctiontype>
    * f1 -> "("
    * f2 -> <identifier>
    * f3 -> ")"
    */
   public R visit(setFunctionType n);

   /**
    * f0 -> booleanTerm()
    * f1 -> booleanValueExpressionPrime()
    */
   public R visit(booleanValueExpression n);

   /**
    * f0 -> ( <OR> booleanTerm() booleanValueExpressionPrime() )?
    */
   public R visit(booleanValueExpressionPrime n);

   /**
    * f0 -> booleanFactor()
    * f1 -> booleanTermPrime()
    */
   public R visit(booleanTerm n);

   /**
    * f0 -> ( <AND> booleanFactor() booleanTermPrime() )?
    */
   public R visit(booleanTermPrime n);

   /**
    * f0 -> [ <NOT> ]
    * f1 -> boleanPredicand()
    * f2 -> [ <compop> boleanPredicand() ]
    */
   public R visit(booleanFactor n);

   /**
    * f0 -> "(" booleanValueExpression() ")"
    *       | nonparenthesizedValueExpressionPrimary()
    */
   public R visit(boleanPredicand n);

}

