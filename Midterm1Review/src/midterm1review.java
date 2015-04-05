import java.util.*;
public class midterm1review {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      //Scanner in = new Scanner (System.in);

/*
       System.out.println("Name : " + a.getName() + "\nAge : " + a.getAge()
                           + "\nHotness : " + a.getHotness());


          System.out.println("Enter Name, Age, Hotness : ");
 
          Profile b = new Profile(in.next(),in.nextInt(), in.nextDouble());
       System.out.println("Name : " + b.getName() + "\nAge : " + b.getAge()
                           + "\nHotness : " + a.getHotness());
*
 */
              //System.out.println("\n\nhotness level changed: ");
       //a.setHotness(9.5);
      Profile a = new Profile("Ashley", 23, 8);
      Profile b = new Profile("Stephanie", 25, 9);
       System.out.println("first Profile: "+ a.toString());
       System.out.println("\nsecond Profile"+b.toString());
       
       
       //a = b;
       //System.out.println("\nAfter equals\n\nfirst Profile: "+ a.toString());
       //System.out.println("\nsecond Profile"+b.toString());

       //b.setName("Bertha");
       a.setAge(b.getAge());
       System.out.println("\n\nA's name : " + a.toString());
       System.out.println("\n\nB's name : " + b.toString());
       
       System.out.println("\n\nIs " + a.getName() + "legal?");
       if(isLegal(a)){
          System.out.println("She's good.");
       } else
          System.out.println("Wait a while you perv.");



    }
    
    public static boolean isLegal (Profile n){
         return n.getAge() >= 18 ? true : false ;
    }


}


        /*String check = "ABCDEFG";
       System.out.println(check);

       System.out.println("substring 2,4 : " + check.substring(2,4));
       System.out.println("substring 0,4 : " + check.substring(0,4));
       System.out.println("substring 2   : " + check.substring(2));

       System.out.println("index of C : " + check.indexOf("C"));
       System.out.println("index of D : " + check.indexOf("D"));

       System.out.println(".equals method returns a boolean : "
                         + check.equals("ABCDEFG"));


     System.out.println("Input a String: ");
       Scanner scan = new Scanner(System.in);
       check = scan.next();
       System.out.println(check);
       String flagName = "Cody";
       if(check.equals(flagName))
          System.out.println("It equals.. a boolean value of true : " + flagName);
       else
          System.out.println("It does not equal " + flagName);

       System.out.println(".length returns an integer Specifically");
       System.out.println(flagName.length());

       //check = "www.yahoo.com";
       //System.out.println(".split = a " + java.util.Arrays.toString(check.split(".")));
       System.out.println("charAt :" + check.charAt(4));

       System.out.println("tolower : " + check.toLowerCase());
       System.out.println(check);
       //string concatenation
       check +=(" it's good for you and me!");
       check = check + " whatever";
       System.out.println(check);

       System.out.println("The added to " + addExcla(check));
       System.out.println(check);
       check = addExcla(check);
       System.out.println(check);

    }

    public static String addExcla(String toAddto){
      return toAddto + "!!!";
       *
       *
       *
       */