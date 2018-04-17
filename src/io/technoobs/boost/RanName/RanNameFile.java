/*
 * RanName file processor
*/

package io.technoobs.boost.RanName;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RanNameFile {

	// input file
	private String inPutFile;
	// output file
	private String outPutFile;
	// content format: raw, csv, json
	private String cFormat;
	// generated users
	private ArrayList<ArrayList<String>> users;

	public RanNameFile() {
		
	}
	
	public RanNameFile(String inFile, String outFile, String contentFormat,
			ArrayList<ArrayList<String>> users) {
		inPutFile = inFile;
		outPutFile = outFile;
		cFormat = contentFormat;
		this.users = users;
	}

	/*
	 * Store generated username and password in file
	 */
	public void store() {
		try {
			File file = new File(outPutFile);
			// Create file if the file not exists
			if(!file.exists()) {
				file.createNewFile();
			} else {
				file.delete();
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fw);
			// Write user information according to file format
			if(cFormat == "raw") { // raw format
				for(ArrayList<String> userInfo : users) {
					writer.write(userInfo.toString());
					writer.write("\n");
				}
			} else if(cFormat == "csv") { // csv format
				writer.write("UserName,Password\n");
				for(ArrayList<String> userInfo : users) {
					// write username
					writer.write(userInfo.get(0).toString() + ",");
					// write password
					writer.write(userInfo.get(1).toString());
					writer.write("\n");
				}
			} else if(cFormat == "json") { // json format
				writer.write("{\n");
				writer.write("	\"users\": {\n");
				for(ArrayList<String> userInfo : users) {
					writer.write("		{\n");
					writer.write("			\"name\": \"" + userInfo.get(0).toString() + "\",\n");
					writer.write("			\"password\": \"" + userInfo.get(1).toString() + "\"\n");
					writer.write("		},\n");
				}
				writer.write("	}\n}");
			}
			writer.close();
		} catch(IOException x) {
			System.err.format("IOException: %s%n", x);
			x.printStackTrace();
		}
	}
}

