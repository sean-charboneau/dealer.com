import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class KeyCounts
{
	public static void main(String[] args)
	{
		outputKeyCounts("input.txt");
		outputKeyCounts("input1.txt");
		outputKeyCounts("input2.txt");
	}

	public static void outputKeyCounts(String filename)
	{
		try
		{
			HashMap<String, Integer> counts = sumKeyCounts(filename);
			Iterator<String> keySetIterator = counts.keySet().iterator();

			// Iterate through the results and print them out nicely
			while (keySetIterator.hasNext())
			{
				String key = keySetIterator.next();
				System.out.println("The total for " + key + " is "
				        + counts.get(key) + ".");
			}
			System.out.println("-----");
		}
		catch (IOException e)
		{
			// File not found
			System.out.println("Error loading file");
			e.printStackTrace();
		}
	}

	// PRECONDITIONS
	// The file contains data in the format "key,count"
	// where key is a string and count is an integer.
	public static HashMap<String, Integer> sumKeyCounts(String filename)
	        throws IOException
	{
		HashMap<String, Integer> counts = new HashMap<String, Integer>();

		// Load the file from the local directory
		BufferedReader br = new BufferedReader(new InputStreamReader(
		        KeyCounts.class.getClassLoader().getResourceAsStream(filename)));
		try
		{
			String line = br.readLine();

			// For each line, either add to the existing entry or create a new
			// one
			while (line != null)
			{
				String[] parts = line.split(",");
				String name = parts[0];
				int sum = Integer.parseInt(parts[1]);

				if (counts.containsKey(name))
				{
					sum += counts.get(name);
				}

				counts.put(name, sum);
				line = br.readLine();
			}
		}
		catch (IOException e)
		{
			// The file contained an invalid entry
			System.out.println("Error reading file contents");
			e.printStackTrace();
		}
		finally
		{
			br.close();
		}

		return counts;
	}
}