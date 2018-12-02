package File_format;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
// converint csv file to matrix by adress
public class CSVReader {
	 public String a;
     public CSVReader(String s) {
    	this. a=s;
     }
    
    
	public String[][] tomatrix() throws IOException 
	{
		// initializng veriables
		String csvFile = this.a;
		String line = "h";
		String cvsSplitBy = ",";
		int rowcounter =0;
		int columncounter=1;
		int i=0;
		// reading the file
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		char a='u';
		line = br.readLine();
		//getting nuber of columns
		while(i<line.length())
		{      
			a=line.charAt(i);
			if(a==','|| a=='\n') {
				columncounter++;
			}
			i++;

		}
		br.close();
		//getting  number of rows
		BufferedReader br2 = new BufferedReader(new FileReader(csvFile));
		line = br2.readLine();
	
		while(line!=null)
		{
			rowcounter++;  	
			line = br2.readLine();
		}
        //initializng new matrix to restore the result
		String t[][]=new String[rowcounter][columncounter];
        // inserting each line to the matrix
		try (BufferedReader br3 = new BufferedReader(new FileReader(csvFile))) {
			i=0; 
			while((line= br3.readLine())!=null) {
				t[i]=line.split(",");
				i++;
				
			}




		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		/**
		//printing the matrix
		for (int g=0;g<rowcounter;g++) {
			System.out.println(Arrays.toString(t[g]));
		}
		*/
		//return the matrix
		return t;
	}
	//function to get one layer from the matrix
	public String[] layer(int x) throws IOException{
   	 String[] t = new String[120];
   	 t=this.tomatrix()[x];
   	
   	 return t;
   }


}