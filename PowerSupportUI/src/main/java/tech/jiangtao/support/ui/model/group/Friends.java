package tech.jiangtao.support.ui.model.group;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vurtex on 2017/3/29.
 * 好友基类
 */

public class Friends implements Parcelable {
    public String userId;
    public int onlineStatus;
    public String nickName;
    public String avatar;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeInt(this.onlineStatus);
        dest.writeString(this.nickName);
        dest.writeString(this.avatar);
    }

    public Friends() {
    }

    protected Friends(Parcel in) {
        this.userId = in.readString();
        this.onlineStatus = in.readInt();
        this.nickName = in.readString();
        this.avatar = in.readString();
    }

    public static final Creator<Friends> CREATOR = new Creator<Friends>() {
        @Override
        public Friends createFromParcel(Parcel source) {
            return new Friends(source);
        }

        @Override
        public Friends[] newArray(int size) {
            return new Friends[size];
        }
    };
}
