
import intermediate.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import syntaxtree.Node;
import syntaxtree.Prog;
import visitor.DepthFirstVisitor;

public class Main {

    static String translation = "";

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        SQLParser parser = new SQLParser(new FileInputStream("testsql"));
        Prog prog = parser.Prog();

        DepthFirstVisitor st = new DFVShowTreeVisitor();
        st.visit(prog);

        DFVSequencer seq = new DFVSequencer();
        seq.visit(prog);

        IntermediateNode select = seq.getSequence().getFirst();
        seq.getSequence().remove(0);
        seq.getSequence().add(1, select);

        for (Iterator<IntermediateNode> it = seq.getSequence().iterator(); it.hasNext();) {
            IntermediateNode n = it.next();

            translate(n);
        }

        System.out.println("traduccion:");
        System.out.println("C#: " + translation + ";");
    }

    private static void translate(IntermediateNode n) {
        if (n.getClass().equals(IntermediateSelect.class)) {
            IntermediateSelect no = (IntermediateSelect) n;
            translation += ".Select(s => new{";
            if (no.getParams().size() != 0) {
                for (Iterator<IntermediateColumSelection> it = no.getParams().iterator(); it.hasNext();) {
                    IntermediateColumSelection ics = it.next();
                    String colum;
                    if (ics.getClass().equals(IntermediateIdentifier.class)) {
                        String name = ((IntermediateIdentifier) ics).getName();
                        colum = name + "=s." + name;
                    } else {
                        IntermediateSetFunctionType ft = ((IntermediateSetFunctionType) ics);
                        colum = ft.getName() + "=" + ft.getFunction() + "(f => f." + ft.getParam().getName() + ")";
                    }

                    colum += ",";
                    translation += colum;
                }
                translation = translation.substring(0, translation.lastIndexOf(",")) + "}";
            } else {
                translation += "s => s";
            }            
            translation += ")";
        }
        if (n.getClass().equals(IntermediateFrom.class)) {
            IntermediateFrom no = (IntermediateFrom) n;

            translation += "var q = new DataReader(\"" + no.getSource().getName() + "\")";
        }
        if (n.getClass().equals(IntermediateWhere.class)) {
            IntermediateWhere no = (IntermediateWhere) n;
            translation += ".Where(w => w." + no.getLeft().getName() + " " + no.getOperator().getOperator() + " " + no.getRight().getToken() + ")";
        }
        if (n.getClass().equals(IntermediateGroupBy.class)) {
            IntermediateGroupBy no = (IntermediateGroupBy) n;
            translation += ".GroupBy(g => g." + no.getParam().getName() + ")";
        }
        if (n.getClass().equals(IntermediateOrderBy.class)) {
            IntermediateOrderBy no = (IntermediateOrderBy) n;
            translation += ".OrderBy(o => o." + no.getParam().getName() + ")";
        }
    }
}
