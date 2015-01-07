
package Chess;


/**
 * An adaptor, transforming the JDBC interface to the TableModel interface.
 *
 * @version 1.20 09/25/97
 * @author Philip Milne
 */

import java.util.Vector;
import java.sql.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.event.TableModelEvent;

public class JDBCAdapter
{
    Connection          connection;
    Statement           statement;
    ResultSet           resultSet;
    String[]            columnNames = {};
    Vector		rows = new Vector();
    ResultSetMetaData   metaData;
    private boolean				bConnected = false;

    public boolean isConnected()
    {
    	return bConnected;
    }
    public JDBCAdapter(String url, String driverName,
                       String user, String passwd)
	{
		bConnected = false;
        try {
            Class.forName(driverName);
            System.out.println("Opening db connection");

            connection = DriverManager.getConnection(url, user, passwd);
            statement = connection.createStatement();
        }
        catch (ClassNotFoundException ex) {
            System.err.println("Cannot find the database driver classes.");
            System.err.println(ex);
        }
        catch (SQLException ex) {
            System.err.println("Cannot connect to this database.");
            System.err.println(ex);
        }
        bConnected = true;
     }

    public void close() throws SQLException {
        System.out.println("Closing db connection");
        bConnected = false;
        connection.close();
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

}