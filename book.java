import java.io.Serializable;

class book implements Serializable{
//title - return title
//author - return author
//score - reutrn score
//dateFinished - return datefinished
private String title;
private String author;
private String score;
private String dateFinished;
private int index;
public book(String t, String a, String s, String d,int i){
        title = t;
        author = a;
        score = s;
        dateFinished = d;
        index = i;
}
public String returnTitle() { return title;}
public String returnAuthor() { return author;}
public String returnDateFinished() { return dateFinished;}
public String returnScore(){return score;}
public int returnIndex(){return index;}
public String returnAll(book book){
        String temp = "";
        temp += "Title: "+book.returnTitle()+", "+"\n";
        temp+="Author: "+book.returnAuthor()+", "+"\n";
        temp+="Date Finished:: "+book.returnDateFinished()+", "+"\n";
        temp+="Score: "+book.returnScore()+"/10"+"\n";
        temp += "Book Id : "+book.returnIndex();
        return temp;
}
public void setIndex(int i){
        index =i;
}



}