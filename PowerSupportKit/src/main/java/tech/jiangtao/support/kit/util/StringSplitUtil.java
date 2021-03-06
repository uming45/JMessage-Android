package tech.jiangtao.support.kit.util;

import java.util.Objects;
import tech.jiangtao.support.kit.SupportIM;

/**
 * Class: StringSplitUtil </br>
 * Description: 字符串切割工具 </br>
 * Creator: kevin </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 08/12/2016 1:40 PM</br>
 * Update: 08/12/2016 1:40 PM </br>
 **/

public class StringSplitUtil {

  /**
   * 剪切/，jid比较
   */
  public static String splitDivider(String jidResource) {
    String jid;
    if (jidResource != null && jidResource.contains("/")) {
      int index = jidResource.indexOf("/");
      jid = jidResource.substring(0, index);
    } else {
      jid = jidResource;
    }
    return jid;
  }

  /**
   * 用户名
   * @param jidResource
   * @return
   */
  public static String splitPrefix(String jidResource) {
    String jid;
    if (jidResource != null && jidResource.contains("@")) {
      int index = jidResource.indexOf("@");
      jid = jidResource.substring(0, index);
    } else {
      throw new NullPointerException("jid不能为空");
    }
    return jid;
  }

  public static String userJid(String nickName) {
    if (nickName != null && !Objects.equals(nickName, "") && !Objects.equals(nickName.trim(), "")) {
      return nickName+"@"+ SupportIM.mDomain;
    }
    return null;
  }
}
