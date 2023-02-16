#include<iostream>
//#include"pzhelp"
#include<cstring>
using namespace std;

int c, lines=0, end_space;
char text[50000], line[60], line2[60];
int len=59;

//?----------functions----------?//

bool isletter(char letter){     //! Says if the character isn't a space
    if(letter!=' ' && letter!=EOF && letter!='\n'){return 1;}
    else{return 0;}
}


int wordcount(char line){    //! Counts how many words are in the line
    int words=1;
    for(int i=0; i<60; i++){
        if(isletter(line[i]) && !isletter(line[i+1])){
            words++;
        }
    }
    return words;
}


int spaces(char line){
    int line_words=wordcount(line);
}

//?-----------------------------?//


int main(){

  int start = 0;
  int end;
  int text_len = 0;  

  while((c=getchar())!=EOF){    //! Bazei olo to keimeno sto text[]
      text[text_len++] = c;            //? text_len = how many characters are in the whole paragraph
  } 

//? 
  while(start<text_len){        //!koboume to keimeno se komatia ton 60 me start kai end
    lines++;
    end = start + 60;
    if(end<=text_len){
      if(isletter(text[end-1]) && isletter(text[end])){   //!blepoume an h teleutaia lexh exei
        end_space=1;

        //? If there is a word on the end of the line find the last space before the line. and hold the index on end and the number of spaces on endspace.
        while(isletter(text[end-1])){             
          end--;                                         
          end_space++;
        }
      }
    }
    
    for(int i=start; i<end; i++){       //!metaferei apo to start-end tou text[] sto line[]
        text[i]=line[i];
    }
    

        } 
        }
    }

    }

    start = end;
  }


