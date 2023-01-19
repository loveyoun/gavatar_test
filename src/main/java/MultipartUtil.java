import org.springframework.util.StringUtils;

import java.util.UUID;

public final class MultipartUtil {

    //private static final String BASE_DIR = "image";

    public static String getLocalHomeDir(){
        return System.getProperty("user.home");
    }


    public static String createFileID(){
        return UUID.randomUUID().toString();
    }


    public static String getFormat(String contentType){
        if(StringUtils.hasText(contentType)){
            return contentType.substring(contentType.lastIndexOf('/') + 1);
        }
        return null;
    }


    public static String createPath(String fileID, String format){
        //return String.format("%s/%s.%s", BASE_DIR, fileID, format);
        return String.format("%s.%s", fileID, format);
    }


}
