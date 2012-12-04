//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors must implement this interface.
 */

public interface GJVisitor<R,A> {

   //
   // GJ Auto class visitors
   //

   public R visit(NodeList n, A argu);
   public R visit(NodeListOptional n, A argu);
   public R visit(NodeOptional n, A argu);
   public R visit(NodeSequence n, A argu);
   public R visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> queryList()
    * f1 -> <EOF>
    */
   public R visit(Prog n, A argu);

   /**
    * f0 -> querySpecification()
    * f1 -> ( querySpecification() )*
    */
   public R visit(queryList n, A argu);

   /**
    * f0 -> "SELECT"
    * f1 -> selectList()
    * f2 -> "FROM"
    * f3 -> <identifier>
    * f4 -> [ "WHERE" booleanValueExpression() ]
    * f5 -> [ "GROUP BY" <identifier> ]
    * f6 -> ";"
    */
   public R visit(querySpecification n, A argu);

   /**
    * f0 -> "*"
    *       | derivedColumn() ( "," derivedColumn() )*
    */
   public R visit(selectList n, A argu);

   /**
    * f0 -> commonValueExpression()
    * f1 -> [ [ "AS" ] <identifier> ]
    */
   public R visit(derivedColumn n, A argu);

   /**
    * f0 -> "(" commonValueExpression() ")"
    *       | nonparenthesizedValueExpressionPrimary()
    */
   public R visit(commonValueExpression n, A argu);

   /**
    * f0 -> <identifier>
    *       | <setfunctiontype> "(" commonValueExpression() ")"
    *       | <number>
    */
   public R visit(nonparenthesizedValueExpressionPrimary n, A argu);

   /**
    * f0 -> booleanTerm()
    * f1 -> booleanValueExpressionPrime()
    */
   public R visit(booleanValueExpression n, A argu);

   /**
    * f0 -> ( "OR" booleanTerm() booleanValueExpressionPrime() )?
    */
   public R visit(booleanValueExpressionPrime n, A argu);

   /**
    * f0 -> booleanFactor()
    * f1 -> booleanTermPrime()
    */
   public R visit(booleanTerm n, A argu);

   /**
    * f0 -> ( "AND" booleanFactor() booleanTermPrime() )?
    */
   public R visit(booleanTermPrime n, A argu);

   /**
    * f0 -> [ "NOT" ]
    * f1 -> boleanPredicand()
    * f2 -> [ <compop> boleanPredicand() ]
    * f3 -> [ "IS" [ "NOT" ] <truthValue> ]
    */
   public R visit(booleanFactor n, A argu);

   /**
    * f0 -> "(" booleanValueExpression() ")"
    *       | nonparenthesizedValueExpressionPrimary()
    */
   public R visit(boleanPredicand n, A argu);

}
