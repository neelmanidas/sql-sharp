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
    * f1 -> selectList()
    * f2 -> from()
    * f3 -> identifier()
    * f4 -> [ where() booleanValueExpression() ]
    * f5 -> [ groupby() identifier() ]
    * f6 -> [ orderby() commonValueExpression() [ asc() | desc() ] ]
    * f7 -> ";"
    */
   public R visit(querySpecification n);

   /**
    * f0 -> <SELECT>
    */
   public R visit(select n);

   /**
    * f0 -> asterisk()
    *       | derivedColumn() ( "," derivedColumn() )*
    */
   public R visit(selectList n);

   /**
    * f0 -> <asterisk>
    */
   public R visit(asterisk n);

   /**
    * f0 -> commonValueExpression()
    * f1 -> [ [ as() ] identifier() ]
    */
   public R visit(derivedColumn n);

   /**
    * f0 -> "(" commonValueExpression() ")"
    *       | nonparenthesizedValueExpressionPrimary()
    */
   public R visit(commonValueExpression n);

   /**
    * f0 -> identifier()
    *       | <setfunctiontype> "(" commonValueExpression() ")"
    *       | <number>
    */
   public R visit(nonparenthesizedValueExpressionPrimary n);

   /**
    * f0 -> <AS>
    */
   public R visit(as n);

   /**
    * f0 -> <FROM>
    */
   public R visit(from n);

   /**
    * f0 -> <identifier>
    */
   public R visit(identifier n);

   /**
    * f0 -> <WHERE>
    */
   public R visit(where n);

   /**
    * f0 -> booleanTerm()
    * f1 -> booleanValueExpressionPrime()
    */
   public R visit(booleanValueExpression n);

   /**
    * f0 -> ( or() booleanTerm() booleanValueExpressionPrime() )?
    */
   public R visit(booleanValueExpressionPrime n);

   /**
    * f0 -> <OR>
    */
   public R visit(or n);

   /**
    * f0 -> booleanFactor()
    * f1 -> booleanTermPrime()
    */
   public R visit(booleanTerm n);

   /**
    * f0 -> ( and() booleanFactor() booleanTermPrime() )?
    */
   public R visit(booleanTermPrime n);

   /**
    * f0 -> <AND>
    */
   public R visit(and n);

   /**
    * f0 -> [ not() ]
    * f1 -> boleanPredicand()
    * f2 -> [ <compop> boleanPredicand() ]
    */
   public R visit(booleanFactor n);

   /**
    * f0 -> <NOT>
    */
   public R visit(not n);

   /**
    * f0 -> "(" booleanValueExpression() ")"
    *       | nonparenthesizedValueExpressionPrimary()
    */
   public R visit(boleanPredicand n);

   /**
    * f0 -> <GROUPBY>
    */
   public R visit(groupby n);

   /**
    * f0 -> <ORDERBY>
    */
   public R visit(orderby n);

   /**
    * f0 -> <ASC>
    */
   public R visit(asc n);

   /**
    * f0 -> <DESC>
    */
   public R visit(desc n);

}

