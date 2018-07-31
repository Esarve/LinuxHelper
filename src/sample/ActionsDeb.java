package sample;


import java.io.*;

public class ActionsDeb {


    public StringBuffer installSofts(String soft) {

        try{
            System.out.println("Package name: "+soft);
            Process process = Runtime.getRuntime().exec("apt-get install -y "+soft);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            process.getInputStream()
                    )
            );

            StringBuffer output = new StringBuffer();
            String line ="";

            try {

                process.waitFor();

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

    public StringBuffer initializaCache(){
        try {
            Process process = Runtime.getRuntime().exec("apt-get -y update");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            process.getInputStream()
                    )
            );

            StringBuffer output = new StringBuffer();
            String line ="";


            try {

                process.waitFor();

            }catch (InterruptedException e){

                e.printStackTrace();
            }

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

