/*
 * 
******************************************
* Command line class for RanName project *
******************************************

Option Usage:
	-db, --database: database link for database connection.
	-l, --length: length of user name, default value is 5.
	-o, --output: output file to store created user names.
	--pwdLength	: length of password, default value is 10.
	-s, --schema: schema used for creating user table in database.
	-t, --tokens: string tokens used for user name. User
				  name will always contain Tokens. 
*/

package io.technoobs.boost.RanName;

import static java.lang.System.out;  
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import java.io.IOException;

public class RanNameCmd {

	/*
	 * (optional) Database option
	 */
	@Option(name = "-db", aliases = "--database", usage = "Database link for database connection.")
	private String dbCon;

	/*
	 * (optional) User name length
	 */
	@Option(name = "-l", aliases = "--length", usage = "Length of user name. Default length is 5.")
	private int nameLen;
	
	/*
	 * (optional) Number of users
	 */
	@Option(name = "-n", aliases = "--num", usage = "Number of users to be created.")
	private int userNum;

	/*
	 * (optional) Output file to store created user names
	 */
	@Option(name = "-o", aliases = "--output", usage = "Output file to store created user names.")
	private String outFile;
	
	/*
	 * (optional) Output file format
	 */
	@Option(name = "-outFormat", usage = "Output file format. Only receives \"raw\", \"csv\", and \"json\".")
	private String outFormat;

	/*
	 * (optional) Password length
	 */
	@Option(name = "--pwdLength", usage = "Length of password. Default length is 10.")
	private int pwdLen;

	/*
	 * (optional) User table schema
	 */
	@Option(name = "-s", aliases = "--schema", usage = "Schema used for creating user table in database.")
	private String userSchema;

	/*
	 * (optional) User name tokens
	 */
	@Option(name = "-t", aliases = "--tokens", usage = "User name tokens.")
	private String nameToken;

	private void doMain(final String[] arguments) {
		final CmdLineParser parser = new CmdLineParser(this);
		if (arguments.length < 1) {
			parser.printUsage(out);
			System.exit(-1);
		}
		try {
			parser.parseArgument(arguments);
		} catch (CmdLineException clEx) {
			out.println("ERROR: Unable to parse command-line options: " + clEx);
		}
		
		RanName ranName = new RanName(nameLen, pwdLen, userNum, 
				nameToken, outFile);
		RanNameGenerator ranGenerator = new RanNameGenerator(ranName);
		
		// No output file, print users in console
		if(outFile == null) {
			ranGenerator.createUsers();
			System.out.print(ranGenerator.storedUsers.toString());
		} else {
			ranGenerator.createUsers();
			RanNameFile ranFile = new RanNameFile("", outFile, outFormat, ranGenerator.storedUsers);
			ranFile.store();
			System.out.println("OK");
		}
	}
	
	
	public static void main(final String[] arguments) throws IOException {
		final RanNameCmd ranControl = new RanNameCmd();
		ranControl.doMain(arguments);
	}
}
