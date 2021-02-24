package pq.empm.util;

public class UploadUtil {
public static String getUploadPath(String fileName,String prefix){
    String hash = Integer.toHexString(fileName.hashCode());
    while(hash.length()<8){
        hash += "0";
    }
    for (int i = 0; i < hash.length(); i++) {
        prefix += "/"+hash.charAt(i);
    }

    //upload/8级路径 upload/1/d/3/f/4/f/5/g
    return prefix;
}
}
