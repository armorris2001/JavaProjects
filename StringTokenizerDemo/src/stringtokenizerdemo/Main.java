/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stringtokenizerdemo;
import java.util.StringTokenizer;
/**
 *
 * @author PC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       String sentence = "it's,fleece,was,white,as,snow";
       StringTokenizer mystery = new StringTokenizer(sentence, ",");
       System.out.println(mystery.countTokens());
       System.out.println(mystery.nextToken());
       System.out.println(mystery.nextToken());
    }

}
