package com.cyberup.util;

import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;

public class FileUtil {
	
	public static String getFileSize(long filesize) {
		  
	    DecimalFormat df = new DecimalFormat(".##"); 
	    String fSize="";
	    if ((filesize > 1024) && (filesize < 1024 * 1024)) {
	    	fSize = df.format((float)filesize/1024).toString() + " KB" ;
	    } else if (filesize >= 1024 * 1024) {
	    	fSize = df.format((float)filesize/(1024*1024)).toString() + " MB" ;
	    } else {
	    	fSize = Long.toString(filesize) + " Bytes" ;
	    }
	    return fSize;
	}
	
	public static String extractMimeType(File file)
	{
		try {
			Magic parser = new Magic();
			MagicMatch match = parser.getMagicMatch(file, false);
			String type = match.getMimeType();
			
			return type;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
     * Read the contents of a file and place them in
     * a string object.
     *
     * @param file path to file.
     * @return String contents of the file.
     */
    public static String fileContentsToString(String file)
    {
        String contents = "";

        File f = null;
        try
        {
            f = new File(file);

            if (f.exists())
            {
                FileReader fr = null;
                try
                {
                    fr = new FileReader(f);
                    char[] template = new char[(int) f.length()];
                    fr.read(template);
                    contents = new String(template);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (fr != null)
                    {
                        fr.close();
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return contents;
    }
}
