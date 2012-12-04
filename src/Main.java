
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ekthor
 */
public class Main {
    public static void main(String []args) throws FileNotFoundException, ParseException
    {
        SQLParser parser = new SQLParser(new FileInputStream("testsql"));
        parser.Prog();
    }
}
