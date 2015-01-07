
package Chess;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

class Network implements Runnable
{
	Socket s;
	final String localhost = new String ("localhost");
	public void run()
	{
		
	}

	public Network() throws UnknownHostException, IOException
	{
		String htmlFilePath = "C:/wamp/www/CHESS/index.html";		// the path given here should be relative path to the existing binaries of the program
		File htmlFile = new File(htmlFilePath);

		Desktop.getDesktop().browse(htmlFile.toURI());

		Desktop.getDesktop().open(htmlFile);
	}

}