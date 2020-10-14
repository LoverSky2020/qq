package utils;

import java.util.UUID;

/**
 * @author tty
 * @create 2020-09-05-14:52
 */
public class RandName {

    public static String getRandomName(String fileName){
        int index=fileName.lastIndexOf(".");
        //获取后缀名
        String houzhui=fileName.substring(index);
        String uuidFileName= UUID.randomUUID().toString().replace("-","")+houzhui;
        return uuidFileName;
    }

}
