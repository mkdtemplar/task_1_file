import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class FileTask
{
    public static void main(String[] args)
    {
        int countURL = 0;
        int countIPv6 = 0;

        try
        {
            String s;
            URL url = new URL("https://www.ietf.org/rfc/rfc2732.txt");
            BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/result.txt", true));

            String[] words;
            while ((s = read.readLine()) != null)
            {
                words = s.split("\\s+");
                for (String word : words)
                {
                    if (word.contains("URL"))
                    {
                        countURL++;
                    }
                    if (word.contains("IPv6"))
                    {
                        countIPv6++;
                    }
                }
            }

            writer.write("Total URL and URL's words: " + countURL + "\n");
            writer.write("Total IPv6 words: " + countIPv6 + "\n");

            System.out.println(countURL);
            System.out.println(countIPv6);

            read.close();
            writer.close();

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
