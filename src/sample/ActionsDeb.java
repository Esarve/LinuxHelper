package sample;


import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ActionsDeb {

    public String chrome = "chromium-browser";
    public String htop= "htop";
    public String firefox = "firefox";
    public String thunderbird = "thunderbird";
    public String deluge = "deluge";
    public String empathy = "empathy";

    public StringBuffer installSofts(String soft)throws Exception {
        try{

            Process process = Runtime.getRuntime().exec("apt-get install -y "+chrome);
//            BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
//            writer.write("samsung5");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            process.getInputStream()
                    )
            );

            StringBuffer output = new StringBuffer();
            String line ="";

            try {

                process.waitFor(5,TimeUnit.SECONDS);

            }catch (InterruptedException e){

                e.printStackTrace();
            }
            System.out.println("Flag 3");

            while (reader.ready()){
                line=reader.readLine();
                output.append(line+"\n");
            }
            System.out.println(output.toString());

            return output;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

