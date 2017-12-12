import java.util.ArrayList;
import java.util.List; 

public class MusicDownloads
{
 private List<DownloadInfo> downloadList;

 public MusicDownloads()
 {     downloadList = new ArrayList<DownloadInfo>(); 
    }

 public List getDownloadList(){
      return downloadList; 
    }
    
 public DownloadInfo getDownloadInfo(String title){
  for(int i = 0; i < downloadList.size(); i++){
    if(downloadList.get(i).getTitle().equals(title)){
      return downloadList.get(i);
    }
  }
  return null;
 }

 public void updateDownloads(List<String> titles){
  for(int i = 0; i < titles.size(); i++){
    if(getDownloadInfo(titles.get(i))== null){
      downloadList.add(new DownloadInfo(titles.get(i)));
    }
  }
  for(int j = 0; j < titles.size(); j++){
    getDownloadInfo(titles.get(j)).incrementTimesDownloaded();
  }
 }
    
 public String toString(){
       String str = "";    
       for (int i=0; i<downloadList.size(); i++){
             if (i == 0) str += "["+downloadList.get(i).toString(); 
             else if (i == downloadList.size()-1) str += ", "+downloadList.get(i).toString()+"]"; 
             else str += ", "+downloadList.get(i).toString(); 
        }       
       return str; 
    }
 
 public static void main(String[] args){
      MusicDownloads webMusicA = new MusicDownloads();   
      DownloadInfo d1 = new DownloadInfo("Hey Jude", 5); 
      DownloadInfo d2 = new DownloadInfo("Soul Sister", 3);
      DownloadInfo d3 = new DownloadInfo("Aqualung", 10);
      webMusicA.getDownloadList().add(d1); 
      webMusicA.getDownloadList().add(d2); 
      webMusicA.getDownloadList().add(d3); 
      System.out.println("\fMusic Download List: "+webMusicA); 
      System.out.println(webMusicA.getDownloadInfo("Aqualung")); 
      System.out.println(webMusicA.getDownloadInfo("Happy Birthday"));
      List<String> songTitles = new ArrayList<String>(); 
      String[] ss = {"Lights", "Aqualung", "Soul Sister", "Go Now", "Lights", "Soul Sister"}; 
      for (int i=0; i<ss.length; i++){
          songTitles.add(ss[i]); 
        }
      webMusicA.updateDownloads(songTitles); 
      System.out.println("Music Download List: "+webMusicA);  
    }
