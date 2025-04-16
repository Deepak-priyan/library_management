import java.util.*;
import java.io.*;
class LibraryFunctions{
        Scanner s=new Scanner(System.in);
        List<Integer> bookno=new ArrayList<Integer>(Arrays.asList(9876,5432,1098,7654,3210));
        List<String> bookname=new ArrayList<String>(Arrays.asList("loonshots","rebel ideas","the Art of possibility","think Again","where good ideas come from"));
        List<String> authorname=new ArrayList<String>(Arrays.asList("safi bahcall"," matthew syed","rosamund stone zander & benjamin zander","adam grant","steven johnson"));
        List<String> status=new ArrayList<String>(Arrays.asList("Available","Available","Available","Available","Available"));
        
        
        public void showBook()
        {
            System.out.println();
            System.out.println("....! Books Details !....");
            System.out.println();
            for(int i=0;i<bookno.size();i++)
            {
                System.out.println("Book Number: "+bookno.get(i)+" | Book Name: "+bookname.get(i)+" | Author: "+authorname.get(i)+" | Status: "+status.get(i));
            }

        }



        public void bookBarrow()
        {
            try{
                String stuName,bookName1,date;
                long regNo,bookNo1;
                System.out.print("Enter your Name: ");
                stuName=s.nextLine();
                System.out.print("Enter your Register Number: ");
                regNo=s.nextLong();
                s.nextLine();
                System.out.print("Enter Book Name: ");
                bookName1=s.nextLine();
                System.out.println(bookName1);
                bookName1=bookName1.toLowerCase();
                int index=bookname.indexOf(bookName1);
                if(index==-1)
                {
                    System.out.println("Invalid book nmae:");
                    System.exit(0);
                }
                System.out.print("Enter Book Number: ");
                bookNo1=s.nextLong();
                System.out.print("Enter Date: ");
                date=s.nextLine();
                s.nextLine();
                String fileName=stuName+regNo;
                FileWriter fw= new FileWriter(fileName+".txt");
                fw.write("Student Name: "+stuName+ " | Register Number: "+regNo+" | Book Name: "+bookName1+" | Book No: "+bookNo1+" | Date: "+date+"\n");
                fw.close();
                status.set(index,"Not Available");
                System.out.println("Book Barrowed Successfully!....Due date: 30 days.");
            }
            catch(Exception e)
            {
                System.out.print("File creating error");
            }
        }


}
class Library{
       public static void main(String arg[])
    {
        LibraryFunctions l=new LibraryFunctions();
        int userChoice;
        int funChoice;
        Scanner s=new Scanner(System.in);
        do{
              System.out.print("Enter the User Type \n 1.Student \n 2.librarian \n 3.Exit \n Enter your choice: ");
              userChoice=s.nextInt();
              if(userChoice==1)
               {
                 System.out.println();
                    System.out.print(" 1.SHOW BOOKS DETAILS \n 2.BOOK BARROW \n 3.BOOK RTURN \n 4.SEARCH BOOK \n ENTER YOUR CHOICE: ");
                    funChoice=s.nextInt();
                    switch(funChoice)
                    {
                        case 1:
                        {
                            l.showBook();
                            break;
                        }
                        case 2:
                        {
                            l.bookBarrow();
                            break;
                         }
                        case 3:
                        {
                            //bookReturn(); 
                         }
                        case 4:
                        {
                            //searchBook();
                        }
                        default:
                        {
                           System.out.print("Invalid input!.....");
                        }
                    }
           
                }
            else if(userChoice==2)
            {
                System.out.print("1.SHOW BOOKS DETAILS \n 2.ADD BOOKS"); 
                funChoice=s.nextInt();
                switch(funChoice)
                {
                    case 1:
                    {
                        l.showBook();
                        break;
                    }
                    case 2:
                    {
                        // addBook();
                         break;
                    }
                    default:
                    {
                        System.out.print("Invalid input!.....");
                    }
                }    
            }
        }while(userChoice !=0);
   }
}
