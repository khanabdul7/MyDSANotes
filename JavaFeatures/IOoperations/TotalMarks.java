package JavaFeatures.IOoperations;

import java.io.*;

/**
 * W.A.P to fetch marks from two files, add them and write into another file.
 * */
public class TotalMarks {
    public static void main(String[] args) throws IOException {
        //  Initialize Buffered Class members
        BufferedReader inFile1 = null;
        BufferedReader inFile2 = null;
        BufferedWriter outFile = null;

        try{
            inFile1 = new BufferedReader(new FileReader(".idea/JohnTerm1.txt"));  // InputFile 1
            inFile2 = new BufferedReader(new FileReader(".idea/JohnTerm2.txt"));  // InputFile 2

            // Getting Marks for 1st term.
            String[] firstTermEng = inFile1.readLine().split(":");
            String EngMarks = firstTermEng[1];
            String[] firstTermMath = inFile1.readLine().split(":");
            String MathMarks = firstTermMath[1];
            String[] firstTermSci = inFile1.readLine().split(":");
            String SciMarks = firstTermSci[1];

            // Getting Marks for 2nd term.
            String[] secondTermEng = inFile2.readLine().split(":");
            String EngMarks2 = secondTermEng[1];
            String[] secondTermMath = inFile2.readLine().split(":");
            String MathMarks2 = secondTermMath[1];
            String[] secondTermSci = inFile2.readLine().split(":");
            String SciMarks2 = secondTermSci[1];

            // Calculating Total marks in each sub.
            int YoYEnglish = Integer.parseInt(EngMarks)+Integer.parseInt(EngMarks2);
            int YoYMath = Integer.parseInt(MathMarks)+Integer.parseInt(MathMarks2);
            int YoYScience = Integer.parseInt(SciMarks)+Integer.parseInt(SciMarks2);

            // Writing into file.
            outFile = new BufferedWriter(new FileWriter(".idea/JohnTotal.txt"));  // OutputFile
            outFile.write("English: "+YoYEnglish+"\n");
            outFile.write("Math: "+YoYMath+"\n");
            outFile.write("Science: "+YoYScience+"\n");
            outFile.close();
            System.out.println("Total marks added to file named JohnTotal.txt ");
        }
        catch (IOException io){
            io.printStackTrace();
        }
        finally {
            inFile1.close();
            inFile2.close();
        }
    }
}
