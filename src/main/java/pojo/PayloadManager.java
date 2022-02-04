package pojo;

import com.google.gson.Gson;
import static utility.Utility.fetchvalue;

public class PayloadManager {

    private static Gson gson = new Gson();

    public static String AuthorizationPayload() {
        return gson.toJson(loginPojo.builder().loginId(fetchvalue("Email"))
                .password(fetchvalue("Password")).build());
    }

    public static String AuthorizationPayload_403() {
        return gson.toJson(loginPojo.builder().loginId(fetchvalue("Email_403"))
                .password(fetchvalue("Password_403")).build());
    }
}
