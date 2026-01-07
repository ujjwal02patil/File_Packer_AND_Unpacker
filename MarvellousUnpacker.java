package MarvellousPackerUnpacker;

import java.util.*;
import java.io.*;

public class MarvellousUnpacker
{
    private String PackName;
    
    public MarvellousUnpacker(String A)
    {
        this.PackName = A;
    }
    public void UnpackingActivity()
    {
        try
        {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("--------------------Marvellous Packer UnPacker-------------------------");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("-------------------------UnPacking Activity------------------------------");
            System.out.println("-----------------------------------------------------------------------");
            
            String Header = null;
            File fobjnew  = null;
            int FileSize = 0,iRet = 0,iCountFile = 0;

            File fobj = new File(PackName);

            //If Packed file is not present
            if( !fobj.exists())
            {
                System.out.println("Unable to Accessed packed file");
                return;
            }

            System.out.println("Packed File Successfully opened");

            FileInputStream fiobj = new FileInputStream(fobj);
            
            //Buffer to read the header
            byte HeaderBuffer[] = new byte[100];

            //Scan the Packed file to extract the files from it
            while((iRet = fiobj.read(HeaderBuffer,0,100)) != -1)
            {
                //Convert byte array to string..
                Header = new String(HeaderBuffer);

                Header = Header.trim();
                
                //tokenize the header into 2 parts 
                String Tokens[] = Header.split(" ");

                //Create Newfile to Extract 
                fobjnew = new File(Tokens[0]);
                fobjnew.createNewFile();
                
                FileSize = Integer.parseInt(Tokens[1]);

                //Create new Buffer to store files data
                byte Buffer[] = new byte[FileSize];

                FileOutputStream foobj = new FileOutputStream(fobjnew);

                //Read the data from packed file 
                fiobj.read(Buffer,0,FileSize);

                //Write the data into extracted file
                foobj.write(Buffer,0,FileSize);

                System.out.println("File unpacked with name :"+Tokens[0]+ " Having Size : "+ FileSize);
                
                iCountFile++;

                foobj.close();  

            }// End of While Loop

            System.out.println("-----------------------------------------------------------------------");
            System.out.println("----------------------Statistical Report-------------------------------");
            System.out.println("-----------------------------------------------------------------------");

            System.out.println("Total numbers of files Unpacked : "+iCountFile);
            
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("--------------Thank you for using our Application----------------------");
            System.out.println("-----------------------------------------------------------------------");


            fiobj.close();
            
        }
        catch(Exception eobj)
        {}

    }

}