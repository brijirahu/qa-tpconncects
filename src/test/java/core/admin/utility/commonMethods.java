package core.admin.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

public class commonMethods {

   // File file = new File(filePath);

    public Properties getTestData(){

        FileInputStream inputStream = null;
        File fileName = new File("E:\\AutomationWorkspace\\coreB2B\\src\\test\\testdata.properties");
        Properties prop = new Properties();
        String workDir = System.getProperty("user.dir");

        try {
            //fileName = "E:\\AutomationWorkspace\\coreB2B\\src\\test\\java\\testdata.properties";
            inputStream = new FileInputStream(fileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
            }
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                }
            }
            return prop;
        }


    }


    public String randomAgencyName(){

        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rd = new Random();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < 5){

            int index = (int) (rd.nextFloat() * AB.length());
            sb.append(AB.charAt(index));
        }

        return sb.toString();

    }


}
