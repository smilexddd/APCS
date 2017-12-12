import java.util.ArrayList; 
import java.util.List; 

public class ClimbingClub
{
   private List<ClimbInfo> climbList;

   public ClimbingClub()
   { climbList = new ArrayList<ClimbInfo>(); }

   public void addClimb(String peakName, int climbTime)
   {  climbList.add(new ClimbInfo(peakName, climbTime)); 
   }
   
   public void addClimB(String peakName, int climbTime){
    int index = 0;
    for(int i = 0; i < climbList.size(); i++){
      if(climbList.get(i).getName().compareTo(peakName) <= 0){
        index = i;
      }
    }
    if(climbList.size() > 0 && climbList.get(climbList.size()-1).getName().compareTo(peakName) <= 0){
      index = climbList.size();
    }
    climbList.add(index, new ClimbInfo(peakName,climbTime));
   }

   public int distinctPeakNames()
   {
       if (climbList.size() == 0){
           return 0;
        }
       ClimbInfo currInfo = climbList.get(0);
       String prevName = currInfo.getName();
       String currName = null;
       int numNames = 1;
       for (int k = 1; k < climbList.size(); k++){
           currInfo = climbList.get(k);
           currName = currInfo.getName();
           if (prevName.compareTo(currName) != 0){
               numNames++;
               prevName = currName;
            }
       }
       return numNames; 
      }
    
   public List<ClimbInfo> getClimbList(){
        return climbList; 
    }
    
   public static void main(String[] args){
     System.out.println("\fPart (a):"); 
     ClimbingClub hikerClub = new ClimbingClub();
     hikerClub.addClimb("Monadnock", 274);
     hikerClub.addClimb("Whiteface", 301);
     hikerClub.addClimb("Algonquin", 225);
     hikerClub.addClimb("Monadnock", 344); 

     for (ClimbInfo c : hikerClub.getClimbList()){
        System.out.println(c);
     }
     int numNames = hikerClub.distinctPeakNames(); 
     System.out.println(numNames+" Part (c-1) works?="+(numNames==3)); 
     
     // part (b)
     System.out.println("\nPart (b):");
     ClimbingClub hikerCluB = new ClimbingClub();
     hikerCluB.addClimB("Monadnock", 274);
     hikerCluB.addClimB("Whiteface", 301);
     hikerCluB.addClimB("Algonquin", 225);
     hikerCluB.addClimB("Monadnock", 344); 
     for (ClimbInfo c : hikerCluB.getClimbList()){
        System.out.println(c);
     }
     numNames = hikerCluB.distinctPeakNames(); 
     System.out.println(numNames+" Part (c-2) works?="+(numNames==3)); 
   } 
}
