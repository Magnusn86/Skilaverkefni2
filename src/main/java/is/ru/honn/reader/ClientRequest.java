package is.ru.honn.reader;

import is.ru.honn.reader.Exceptions.ReaderException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is used to retrieve a JSON string from a URI or file
 */
public class ClientRequest
{
    public ClientRequest()
    {
    }


    /**
     * Retrieves a JSON string from the url parameter
     * @param url the URI where the JSON file is located
     * @return returns the JSON string from the requested URI
     */
    public String getRequest(String url)
    {
        Client client = ClientBuilder.newClient();
        Response response = client.target(url).request().get();

        String result = response.readEntity(String.class);
        client.close();

        return result;
    }

    /**
     * Retrieves a JSON file from a local file and returns the content as a JSON string
     * @param fileName of the file to retrieve the content from
     * @return returns a  JSON string with the contens of the file
     * @throws ReaderException is thrown if it is unable to open or read file
     */
    public String getFileContent(String fileName) throws ReaderException
    {
        StringBuilder content = new StringBuilder();
        try
        {
            java.io.FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                content.append(line);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex)
        {
            String msg = "Unable to open file '" + fileName + "'";
            throw new ReaderException(msg, ex);
        }
        catch(IOException ex)
        {
            String msg = "Error reading file '" + fileName + "'";
            throw new ReaderException(msg, ex);
        }
        return content.toString();
    }

}
