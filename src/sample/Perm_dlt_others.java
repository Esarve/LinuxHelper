package sample;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Perm_dlt_others {

    public void ChnagePermission (String url, String code){
        /*System.out.println("Path "+url);
        System.out.println("Code "+code);*/
        try {
            Process process = Runtime.getRuntime().exec("chmod "+code+" "+url);
            process.waitFor();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPermission(String url){
        String output="";
        try {
            Process process = Runtime.getRuntime().exec("ls -ld "+url);
            process.waitFor();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            process.getInputStream()
                    )
            );

            while (reader.ready()){
                output=reader.readLine();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public void Removefile(String url){
        try {
            Process process = Runtime.getRuntime().exec(new String[] { "sh", "-c", "rm "+url });
            process.waitFor();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void RemoveDir(String url){
        try {
            Process process = Runtime.getRuntime().exec("rm -r "+ url);
            process.waitFor();

            StringBuffer output= new StringBuffer();
            String line = "";

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            process.getInputStream()
                    )
            );
            while (reader.ready()){
                line=reader.readLine();
                output.append(line+"\n");
            }
            System.out.println(output);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shutdown(String time){
        try {
            System.out.println(time);
            Process process = Runtime.getRuntime().exec("shutdown -h "+time);
            process.waitFor();
            System.out.println("Done");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StringBuffer execute(String cmd){
        try {
            System.out.println(cmd);
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            System.out.println("Done");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            process.getInputStream()
                    )
            );
            StringBuffer output= new StringBuffer();
            String line = "";

            while (reader.ready()){
                line=reader.readLine();
                output.append(line+"\n");
            }
            return output;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
