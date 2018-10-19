package network;

import io.reactivex.Observable;
import model.LoginMessage;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HttpApi {
    // 服务器地址
    public static String HOST = "http://39.106.203.141:8098/sdzk-mine/";

    @FormUrlEncoded
    @POST("mobile/mobileLogin/login.do")
    Observable<LoginMessage> login(@Field("username")String userName, @Field("password")String password);
}
