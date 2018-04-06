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

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.BooleanOptionHandler;

import java.io.File;

public class RanNameCmd {
	
	/*
	(optional) Database option
	*/
	@Option(name="-db", aliases="--database", usage="Database link for database connection.")
	private String dbCon;
	
	/*
	(optional) User name length
	*/
	@Option(name="-l", aliases="--length", usage="Length of user name. Default length is 5.")
	private int nameLen;
	
	/*
	(optional) Output file to store created user names
	*/
	@Option(name="-o", aliases="--output", usage="Output file to store created user names.")
	private String outFile;
	
	/*
	(optional) Password length
	*/
	@Option(name="--pwdLength", usage="Length of password. Default length is 10.")
	private int pwdLen;
	
	/*
	(optional) User table schema
	*/
	@Option(name="--s", aliases="--schema", usage="Schema used for creating user table in database.")
	private String userSchema;
	
	/*
	(optional) User name tokens
	*/
	@Option(name="-t", aliases="--tokens", usage="User name tokens.")
	private String nameToken;
	
	
}
