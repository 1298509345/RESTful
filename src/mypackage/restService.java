package mypackage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Path("/sendService")
public class restService {
    @POST
    @Path("sendEmail")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean sendEmail(@FormParam("email") String email,
                             @FormParam("title") String title,
                             @FormParam("content") String content) {
        try {
            String addr[] = email.split(";");
            for (int i = 0; i < addr.length; i++) {
                if (validateEmailAddress(addr[i])) {
                    String info[] = {addr[i], title, content};
                    new sendEmailFunc().start(info);
                } else {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean validateEmailAddress(String email) {
        if (email == null)
            return false;
        String rule = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(rule);
        matcher = pattern.matcher(email);
        if (matcher.matches())
            return true;
        else
            return false;
    }
//    public static void main(String[] args) {
//        String info[]={"1298509345@qq.com","测试邮件","payload"};
//        try {
//            new sendEmailFunc().start(info);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}


//localhost:8080/rest/sendService/sendEmail?url=1298509345@qq.com&payload=dsadsdsaasd