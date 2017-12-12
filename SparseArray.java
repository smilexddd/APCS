import java.util.ArrayList; 
import java.util.List; 

public class SparseArray
{
 private int numRows;
 private int numCols;
 private List<SparseArrayEntry> entries;

 public SparseArray()
 { entries = new ArrayList<SparseArrayEntry>(); }

 public int getNumRows()
 { return numRows; }

 public int getNumCols()
 { return numCols; }

 public int getValueAt(int row, int col)
 {   
     for (int i = 0; i < entries.size(); i++){
          if(entries.get(i).getRow() == row && entries.get(i).getCol() == col){
            return entries.get(i).getValue();
          }
        }
     return 0; 
  }

 public void removeColumn(int col)
 {   
     for(int i = 0; i < entries.size(); i++){
      if(entries.get(i).getCol() == col){
        entries.remove(i);
      }
     } 
     for(int j = 0; j < entries.size(); j++){
      if(entries.get(j).getCol() > 0){
        int v = entries.get(j).getValue();
        int r = entries.get(j).getRow();
        int c = entries.get(j).getCol() - 1;
        entries.remove(j);
        entries.add(j, new SparseArrayEntry(r, c, v));
      }
     }
     numCols--;
  }
 
 public List<SparseArrayEntry> getEntries(){
     return entries; 
    }
 public void update(int r, int c){
     if ((r+1) > numRows) numRows = r+1; 
     if ((c+1) > numCols) numCols = c+1; 
  }
  
 public void add(int r, int c, int val){
      boolean found = false; 
      for (int i=0; i<entries.size(); i++){
          if (entries.get(i).getRow()==r && entries.get(i).getCol()==c){
               entries.get(i).setValue(val);
               found = true; 
            }
        }
        
      if (!found){
          if (val!=0) {
              SparseArrayEntry s = new SparseArrayEntry(r, c, val);
              entries.add(s); 
          }
          update(r, c);  // if val == 0, add col and Row but not an entry. 
       }
  }
 public void display(){
     System.out.printf("%4s", "");
     for (int j=0; j<numCols; j++) System.out.printf("%2s ", j);
     System.out.print("\n----");
     for (int j=0; j<numCols; j++) System.out.print("---");
     System.out.println(); 
     for (int i=0; i<numRows; i++){
         System.out.printf(" %2d:", i); 
         for (int j=0; j<numCols; j++){
              System.out.print(String.format("%2d ", getValueAt(i, j))); 
            }     
         System.out.println(); 
       } 
     System.out.println("Rows="+numRows);
     System.out.println("Cols="+numCols); 
    }
} 
