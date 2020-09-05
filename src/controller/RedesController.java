package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController(){
		super();
	}
	
	private String readProcess(String process){
		String result = "";
		String adapter = "";
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream flow = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			while(line != null){
				if(process.contains("ipconfig")){
					if(line.contains("Adaptador")){
						adapter = line;
					}
					if(line.contains("IPv4")){
						result += adapter + "\n" + line + "\n \n";
					}
				}
				if(process.contains("PING")){
					result = line.trim();
					
				}
				line = buffer.readLine();
			}
			buffer.close();
			reader.close();
			flow.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String ip(String systemName){
		String process = "";
		if(systemName.contains("Windows 10")){
			process = "ipconfig";
		}else {
			process = "ifconfig";
		}
		return readProcess(process);
	}

	
	public String ping(String systemName){
		String process = "";
		if(systemName.contains("Windows 10")){
			process = "PING www.google.com.br";
		}else {
			process = "ifconfig";
		}
		String avg = readProcess(process);
		avg = avg.substring(avg.lastIndexOf(" "));
		return avg;
	}
	
}