package  MarvellousPackerUnpacker;

import java.util.*;
import java.io.*;

public class MarvellousPacker
{
    private  String PackName;
    private String DirName;

    public MarvellousPacker(String A,String B)
    {
        this.PackName = A;
        this.DirName = B;
    }

    public void PackingActivity()
    {
        try
        {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("--------------------Marvellous Packer UnPacker-------------------------");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("-------------------------Packing Activity------------------------------");
            System.out.println("-----------------------------------------------------------------------");
            int i = 0,j = 0,iRet = 0,iCountFile = 0;
           
            File packobj = new File(PackName);
            
            File fobj = new File(DirName);
            //Check the Existence of Directory
            if((fobj.exists()) && (fobj.isDirectory()))
            {
                System.out.println(DirName +"is successfully opened");
                 //Create a Packed file
                boolean bRet = packobj.createNewFile();

                if(bRet == false)
                {
                    System.out.println("unable to create pack file");
                    return;
                }
                
                System.out.println("Packed File get Successfully created with name : "+PackName);

                //Retrive all files from Directory
                File Arr[] = fobj.listFiles();

                //Packed file object
                FileOutputStream foobj = new FileOutputStream(packobj);

                //Buffer for read and write activity
                byte Buffer[] = new byte[1024];
               
                String Header = null;

                // Directory Traversal
                for(i = 0;i < Arr.length;i++)
                {
                   Header = Arr[i].getName() + " " +Arr[i].length();

                   //Loop to form 100 byte Header
                   for(j = Header.length(); j < 100;j++)
                   {
                        Header =  Header + " ";
                   }

                   //Write Header into Packed file
                   foobj.write(Header.getBytes());

                   //open file from directory for reading
                   FileInputStream fiobj = new FileInputStream(Arr[i]);

                   // write contents of file into Packedfile
                    while ((iRet = fiobj.read(Buffer)) != -1 ) 
                    {

                        foobj.write(Buffer,0,iRet);  
                        System.out.println("file name Scanned is : "+Arr[i].getName());
                        System.out.println("file size read is "+iRet);   
                    }
                    
                    fiobj.close();

                    iCountFile++;
                }

                System.out.println("Packing Activity Done");
                
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("----------------------Statistical Report-------------------------------");
                System.out.println("-----------------------------------------------------------------------");

                //To be Added
                System.out.println("Total Files Packed : "+iCountFile);

                System.out.println("-----------------------------------------------------------------------");
                System.out.println("--------------Thank you for using our Application----------------------");
                System.out.println("-----------------------------------------------------------------------");


            }
            else
            {
                System.out.println("there is no such Directory");
            }

        }//End of try

        catch(Exception eobj)
        {}

    }//End of Packing Activity function
}//End MarvellousPacker class
