package pictures;

import java.io.File;
import java.util.Scanner ;
import java.util.*;

//this class chooses photos into slides
class Slides{
    public ArrayList<ArrayList<String>> photoArray;
    public char orientation;
    public int mNumTags;
    public ArrayList<String> mTags = new ArrayList<String>();
    public int mNum;
    public String slideId;

//constructor which is passed the array of photos
    Slides( int num,ArrayList<ArrayList<String>> photoArray){
        this.photoArray = photoArray;
        mNum = num;
            choosePhoto();
            
            }

//this method chooses the photos into slides
        public void choosePhoto(){
            if (photoArray.get(mNum).get(1).charAt(0) == 'H'){
                slideId = photoArray.get(mNum).get(0);
                orientation = 'H';
                mNumTags = Integer.parseInt(photoArray.get(mNum).get(2));
                
                for (int j = 0; j<mNumTags;j++){
                    String s = photoArray.get(mNum).get(j+3);
                    mTags.add(s);

                   }

                photoArray.remove(mNum);
              
            }

            
            else if (photoArray.get(mNum).get(1).charAt(0) == 'V'){
                
            for (int i = 1; i<photoArray.size();i++){
                if (photoArray.get(mNum+i).get(1).charAt(0) == 'V'){
                    slideId = photoArray.get(mNum).get(0) + " " + photoArray.get(mNum+i).get(0);
                    int mNumTags1 =Integer.parseInt(photoArray.get(mNum).get(2));
                    int mNumTags2 =Integer.parseInt(photoArray.get(mNum+i).get(2));
                    mNumTags = mNumTags1 + mNumTags2;
                     

                     for(int g = 0; g<mNumTags1;g++){
                         mTags.add( photoArray.get(mNum).get(g+3));
                         }
                    for (int y = 0; y<mNumTags2;y++){
                        if(mTags.contains(photoArray.get(mNum + i).get(y+3)) == false) {
                             mTags.add(photoArray.get(mNum + i).get(y+3));
                    }   
                    }
                    photoArray.remove(mNum);
                    photoArray.remove(mNum+i-1);
                    
                    
                    break;  
                    
                    }
            }
             }
             



            
             }


             } 
