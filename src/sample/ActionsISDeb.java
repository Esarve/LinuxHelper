package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ActionsISDeb {

    public String chrome = "chromium-browser";
    public String htop= "htop";
    public String firefox = "firefox";
    public String thunderbird = "thunderbird";

    public StringBuffer installSofts(String soft){
        try{
            String targert = new String("pt-get --assume-yes install chromium-browser");
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(targert);
//            BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(proc.getOutputStream()));
//            writer.write("samsung5");
            proc.waitFor();
            StringBuffer output = new StringBuffer();
            BufferedReader reader =  new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = "";
            while((line=reader.readLine())!=null){
                output.append(line+"\n");
            }
            System.out.println(output);
            return output;
        }catch(Throwable t){
            t.printStackTrace();
        }
        return null;
    }
}

