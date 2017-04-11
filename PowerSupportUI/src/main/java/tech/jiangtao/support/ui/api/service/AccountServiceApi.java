package tech.jiangtao.support.ui.api.service;

import java.util.List;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import tech.jiangtao.support.ui.model.User;
import tech.jiangtao.support.ui.model.group.Friends;
import tech.jiangtao.support.ui.model.group.Groups;

/**
 * Class: AccountServiceApi </br>
 * Description: 账户接口 </br>
 * Creator: kevin </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 11/04/2017 10:18 PM</br>
 * Update: 11/04/2017 10:18 PM </br>
 **/

public interface AccountServiceApi {

  /**
   * 用户注册
   */
  @FormUrlEncoded @POST("account/create") Observable<User> createAccount(
      @Field("userJid") String userId, @Field("nickName") String nickName,
      @Field("password") String password);

  /**
   * 资料更新
   * @param uid
   * @param userJid
   * @param nickName
   * @param avatar
   * @param sex
   * @param signature
   * @return
   */
  @FormUrlEncoded @POST("account/update") Observable<User> updateAccount(@Field("uid") long uid,
      @Field("userJid") String userJid, @Field("nickName") String nickName,
      @Field("avatar") String avatar, @Field("sex") boolean sex,
      @Field("signature") String signature);
}
