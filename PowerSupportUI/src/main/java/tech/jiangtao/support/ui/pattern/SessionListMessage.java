package tech.jiangtao.support.ui.pattern;

import java.util.Date;
import org.jivesoftware.smack.packet.Message;
import tech.jiangtao.support.kit.archive.type.DataExtensionType;
import tech.jiangtao.support.kit.archive.type.MessageExtensionType;

public class SessionListMessage {
  public String sessionId;
  public String userJid;
  public String username;
  public String avatar;
  public Date date;
  public String unReadMessage;
  public int unReadMessageCount;
  public Message.Type type;
  public DataExtensionType messageType;
  public int messageExtensionType;

  public static class Builder {
    public String sessionId;
    public String userJid;
    public String username;
    public String avatar;
    public Date date;
    public String unReadMessage;
    public int unReadMessageCount;
    public Message.Type type;
    public DataExtensionType messageType;
    public int messageExtensionType;

    public SessionListMessage build() {
      SessionListMessage message = new SessionListMessage();
      message.sessionId = sessionId;
      message.userJid = userJid;
      message.username = username;
      message.avatar = avatar;
      message.date = date;
      message.unReadMessage = unReadMessage;
      message.unReadMessageCount = unReadMessageCount;
      message.type = type;
      message.messageType = messageType;
      message.messageExtensionType = messageExtensionType;
      return message;
    }

    public Builder userJid(String userJid) {
      this.userJid = userJid;
      return this;
    }

    public Builder username(String username) {
      this.username = username;
      return this;
    }

    public Builder avatar(String avatar) {
      this.avatar = avatar;
      return this;
    }

    public Builder date(Date date) {
      this.date = date;
      return this;
    }

    public Builder unReadMessage(String unReadMessage) {
      this.unReadMessage = unReadMessage;
      return this;
    }

    public Builder unReadMessageCount(int count) {
      this.unReadMessageCount = count;
      return this;
    }

    public Builder type(Message.Type type) {
      this.type = type;
      return this;
    }

    public Builder messageType(DataExtensionType messageType) {
      this.messageType = messageType;
      return this;
    }

    public Builder sessionId(String sessionId) {
      this.sessionId = sessionId;
      return this;
    }

    public Builder messageExtensionType(int messageExtensionType) {
      this.messageExtensionType = messageExtensionType;
      return this;
    }
  }
}
