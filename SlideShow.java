package pictures;


import java.io.File;
import java.util.Scanner ;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Random;


//Class slideshow scans through the slides and selects the best possible combination
class SlideShow {
    ArrayList<Slides> slidesArray = new ArrayList<Slides>();
    int min;
    int i = 0;
    int[] minArray;
    Slides slide1;
    Slides slide2;
    int id;
    String slide1StringId;
    int deleteId = 0;
    int h ;
    FileOutputStream fout = null;
    Random rand = new Random();
SlideShow(){

    //file where the output is written to
     try {
                               fout = new FileOutputStream(/*file you write your output to goes here*/;
             
                                 }

                           catch(FileNotFoundException e){
                               System.out.println("Cannot open File");
                               }
      

     //an instance of class PhotoArray, passing it the path of the input file and number of picture
       
    PhotoArray photoArray = new PhotoArray(/* path of input file*/ ,/*number of pictures*/);
     
             //create the slides
              for(int i = 0; i<photoArray.stringArrayList.size(); ){
        slidesArray.add(new Slides(0,photoArray.stringArrayList));
              }
              System.out.println("size" + slidesArray.size());

        //choose the slides for the slideshow   
          for (int s = 0; s<slidesArray.size();){
                minArray = new int [slidesArray.size()];
          //for the first time, the first slide is the one with and id of zero      
              if (h == 0){
                  slide1 = slidesArray.get(0);
                  deleteId = 0;
              }

           //subsequently make the first slide the last slide   
              else {
                  for (int v = 0; v<slidesArray.size();v++){
                      if (slide1StringId == slidesArray.get(v).slideId){
                               deleteId = v;
                               break;
                      }
                  }
                  
                  
              }
             //calls the method findMinInterest() which determines the min 
             //interest of a slide with other slides and stores the
             //value in an array
              for (int k = 0; k < slidesArray.size(); k++){
                
                  minArray[k] = findMinInterest(slide1,k);
               
                  
              }
            

              //get the id of the max min Interest from minArray
              id = getMax(minArray);
              //System.out.println(id);
              if (h == 0){

               String source = slide1.slideId + "\n";
               System.out.print(source);
               
               byte buf[] = source.getBytes();
                            //write the slide id into the file
                              try{
                                 fout.write(buf);
                                   }
 
                                 catch(IOException e){
                                    System.out.println("I/O Error " + e);
                                   }
               slidesArray.remove(0);
              }
               else{
                   
                   slide1StringId = slidesArray.get(id).slideId;
                   String source = slide1StringId + "\n";
            
                            byte buf[] = source.getBytes();
                            
                              try{
                                 fout.write(buf);
                                 
               //System.out.println("");
                                   }
 
                                 catch(IOException e){
                                    System.out.println("I/O Error " + e);
                                   }
             for (int r = 0; r<slidesArray.size(); r++){
                 if(slide1StringId == slidesArray.get(r).slideId){
                     slide1 = slidesArray.get(r);
                     break;
                 }
             }
//delete the slide from the slidesArray
              slidesArray.remove(deleteId);
               }
            
h++;

          }    
            try{
                                    fout.close();
                                     }

                              catch(IOException e2){
                                    System.out.println(e2);
                                  }    
   

        }  


//method which calculates the minInterest

        public int findMinInterest (Slides s1, int i){
            
            ArrayList<String> tags1 = new ArrayList<String>();
    ArrayList<String> tags2 = new ArrayList<String>();
            
            int countSame = 0;
            int count1= 0;
            int count2 =0; 
            tags1 = s1.mTags;
            tags2 = slidesArray.get(i).mTags;

            for (int p = 0; p<tags1.size();p++){
                if(tags2.contains(tags1.get(p))){
                    countSame++;

                }
                else{
                    count1++;
                }
            }
            for(int q = 0; q<tags2.size();q++){
                 if (tags1.contains(tags2.get(q))) {

                 }
                 else{

                     count2++;
                 }

            }

 if (countSame<=count1 && countSame<=count2) min = countSame;

 if (count1<=countSame && count1<=count2) min = count1;

 if (count2<=count1 && count2<=countSame) min = count2;
 
 
 return min;
 
          
        }
//get maximum min interest
    public  int getMax(int[] inputArray){ 
    int maxValue = inputArray[0]; 
    id = 0;
    
   
    for(int i=1;i < inputArray.length;i++){ 
      if(inputArray[i] > maxValue){ 
         maxValue = inputArray[i]; 
         
         id = i;
        

      } 
     

    } 
    
    
    
    if(maxValue == 0){
      
      
      id = rand.nextInt(inputArray.length);
     // System.out.print("  " + "ID changed, ID:" + id);
    }
    if(inputArray.length == 1){
      id = 0;
    }
//System.out.print("id:" + id + "  ");
    return id; 
  }

       
        


}