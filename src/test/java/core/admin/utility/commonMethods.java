package core.admin.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class commonMethods {

   // File file = new File(filePath);

    public Properties getTestData(){

        FileInputStream inputStream = null;
        File fileName = new File("E:\\AutomationWorkspace\\coreB2B\\src\\test\\java\\testdata.properties");
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


}
