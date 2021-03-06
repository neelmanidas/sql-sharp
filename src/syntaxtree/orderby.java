//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> <ORDERBY>
 * f1 -> identifier()
 * f2 -> [ <ASC> | <DESC> ]
 */
public class orderby implements Node {
   public NodeToken f0;
   public identifier f1;
   public NodeOptional f2;

   public orderby(NodeToken n0, identifier n1, NodeOptional n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public orderby(identifier n0, NodeOptional n1) {
      f0 = new NodeToken("ORDER BY");
      f1 = n0;
      f2 = n1;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

