package pictures;


import java.io.File;
import java.util.Scanner ;
import java.util.*;

//converts input file into an array of photos
class PhotoArray{

   
    public ArrayList <ArrayList<String>>  stringArrayList;
    File file;
    private int mRow;
//constructor which is passed the file path and number of picture
    PhotoArray(String file,int row){
        this.file = new File(file);
        mRow = row;
        stringArrayList = new ArrayList<ArrayList<String>>();
    for (int g= 0; g<mRow;g++){
        stringArrayList.add(new ArrayList<String>());
    }
    getArray();

}

    public void getArray(){
        stringArrayList = readFilesString();


}
String string;

public  ArrayList<ArrayList<String>> readFilesString(){
    int i = 0;
     try{
    Scanner fileScanner = new Scanner(file);
while (fileScanner.hasNextLine()) {
    stringArrayList.get(i).add(Integer.toString(i));
  String line = fileScanner.nextLine();

  Scanner lineScanner = new Scanner(line);
  while (lineScanner.hasNext()) {
    String token = lineScanner.next();
    stringArrayList.get(i).add(token);
  }
  lineScanner.close();
  i++;
}
fileScanner.close();
     }
    
    
    catch (Exception e){
       // System.out.println(e);
    }
     //scanner.close();
   // newS.close();
    return stringArrayList;


}

}




