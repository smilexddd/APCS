public class HorseBarn
{
   private Horse[] spaces;

   HorseBarn(Horse[] h){
      spaces = h; 
    }
    
   public int findHorseSpace(String name)
   {  int ret = -1;
      boolean found = false; 
      for (int i=0; i<spaces.length && !found; i++){
           if (spaces[i] != null){
               if (spaces[i].getName().equals(name)){
                   ret = i; 
                   found = true; 
                }
            }
        } 
      return ret; 
    }

   public void consolidate(){
    for(int i = 0; i < spaces.length; i++){
      for(int j = i + 1; j < spaces.length; j++){
        if(spaces[i] == null && spaces[j] != null){
          spaces[i] = spaces[j];
          spaces[j] = null;
        }
      }
    }
   }
    
   public Horse[] getSpaces(){
      return spaces; 
    }
    
   public static void main(String[] args){
      System.out.print("\fPart (a):");
      Horse[] h = new Horse[7]; 
      for (int i=0; i<h.length; i++) h[i]= null; 
      h[0] = new Horse1("Trigger", 1340);
      h[2] = new Horse1("Silver", 1210); 
      h[3] = new Horse1("Lady", 1575);
      h[5] = new Horse1("Patches", 1350); 
      h[6] = new Horse1("Duke", 1410);
      
      HorseBarn sweetHome = new HorseBarn(h); 
      System.out.println("Part (a):"); 
      System.out.println(sweetHome.findHorseSpace("Trigger")); 
      System.out.println(sweetHome.findHorseSpace("Silver")); 
      System.out.println(sweetHome.findHorseSpace("Coco")); 
      
      System.out.println("\nPart (b): Before"); 
      h[3]= null; 
      sweetHome = new HorseBarn(h); // new setting for sweetHome; 
      Horse[] hh = sweetHome.getSpaces();
      for (int i=0; i<hh.length; i++){
          System.out.println(hh[i]); 
        }
      
      sweetHome.consolidate();
      hh = sweetHome.getSpaces();
      System.out.println("\nPart (b): After"); 
      for (int i=0; i<hh.length; i++){
          System.out.println(hh[i]); 
        }      
    }
} 
