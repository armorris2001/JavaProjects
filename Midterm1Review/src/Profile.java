
public class Profile {

   private String mName = "";
   private int    mAge  = 0;
   private double mHotness = 0;

   public Profile(String n, int a, double h){
      this.mName = n;
      this.mAge = a;
      this.mHotness = h;
   }

   public String getName(){return mName;}
   public void  setName(String newName){ mName = newName;}

   public int  getAge () {return mAge;}
   public void setAge (int newAge){mAge = newAge;}

   public double getHotness(){return mHotness;}
   public void   setHotness(double newHotness){mHotness = newHotness;}

   public String toString(){return "\nName: "+mName + "\nAge: " + mAge
    + "\nHotness: "+ mHotness; }


}
