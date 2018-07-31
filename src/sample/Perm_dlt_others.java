package sample;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Perm_dlt_others {

    public void ChnagePermission (String url, String code){
        System.out.println("Path "+url);
        System.out.println("Code "+code);
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
}
