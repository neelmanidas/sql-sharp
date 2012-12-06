//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class DepthFirstVisitor implements Visitor {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public void visit(NodeList n) {
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
         e.nextElement().accept(this);
   }

   public void visit(NodeListOptional n) {
      if ( n.present() )
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
            e.nextElement().accept(this);
   }

   public void visit(NodeOptional n) {
      if ( n.present() )
         n.node.accept(this);
   }

   public void visit(NodeSequence n) {
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
         e.nextElement().accept(this);
   }

   public void visit(NodeToken n) { }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> queryList()
    * f1 -> <EOF>
    */
   public void visit(Prog n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> querySpecification()
    * f1 -> ( querySpecification() )*
    */
   public void visit(queryList n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> select()
    * f1 -> from()
    * f2 -> [ where() ]
    * f3 -> [ groupby() ]
    * f4 -> [ orderby() ]
    * f5 -> ";"
    */
   public void visit(querySpecification n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
   }

   /**
    * f0 -> <SELECT>
    * f1 -> ( "*" | derivedColumn() ( "," derivedColumn() )* )
    */
   public void visit(select n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> <FROM>
    * f1 -> identifier()
    */
   public void visit(from n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> <WHERE>
    * f1 -> booleanValueExpression()
    */
   public void visit(where n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> <GROUPBY>
    * f1 -> identifier()
    */
   public void visit(groupby n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> <ORDERBY>
    * f1 -> identifier()
    * f2 -> [ <ASC> | <DESC> ]
    */
   public void visit(orderby n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
   }

   /**
    * f0 -> commonValueExpression()
    * f1 -> [ <AS> identifier() ]
    */
   public void visit(derivedColumn n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> "(" commonValueExpression() ")"
    *       | nonparenthesizedValueExpressionPrimary()
    */
   public void visit(commonValueExpression n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> identifier()
    *       | <setfunctiontype> "(" commonValueExpression() ")"
    *       | <number>
    */
   public void visit(nonparenthesizedValueExpressionPrimary n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> <identifier>
    */
   public void visit(identifier n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> booleanTerm()
    * f1 -> booleanValueExpressionPrime()
    */
   public void visit(booleanValueExpression n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> ( <OR> booleanTerm() booleanValueExpressionPrime() )?
    */
   public void visit(booleanValueExpressionPrime n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> booleanFactor()
    * f1 -> booleanTermPrime()
    */
   public void visit(booleanTerm n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> ( <AND> booleanFactor() booleanTermPrime() )?
    */
   public void visit(booleanTermPrime n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> [ <NOT> ]
    * f1 -> boleanPredicand()
    * f2 -> [ <compop> boleanPredicand() ]
    */
   public void visit(booleanFactor n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
   }

   /**
    * f0 -> "(" booleanValueExpression() ")"
    *       | nonparenthesizedValueExpressionPrimary()
    */
   public void visit(boleanPredicand n) {
      n.f0.accept(this);
   }

}
