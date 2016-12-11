package tech.jiangtao.support.ui.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import tech.jiangtao.support.ui.R;
import tech.jiangtao.support.ui.R2;
import tech.jiangtao.support.ui.adapter.ContactViewHolder;
import tech.jiangtao.support.ui.pattern.ConstrutContact;

/**
 * Class: ContactsViewHolder </br>
 * Description: 通讯录界面 </br>
 * Creator: kevin </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 04/12/2016 9:34 PM</br>
 * Update: 04/12/2016 9:34 PM </br>
 **/

public class ContactsViewHolder extends ContactViewHolder{
  @BindView(R2.id.wocao)  CircleImageView mItemChat;
  @BindView(R2.id.item_chat_username)  TextView mItemChatUsername;
  private Context mContext;

  public ContactsViewHolder(Context context, ViewGroup parent) {
    super(context, parent, R.layout.list_item_contact);
    mContext = context;
    ButterKnife.bind(this,itemView);
  }

  @Override public void bindTo(int position, ConstrutContact l) {
    Glide.with(mContext)
        .load(l.mVCardRealm.getAvatar())
        .asBitmap()
        .centerCrop()
        .error(R.mipmap.ic_chat_default)
        .placeholder(R.mipmap.ic_chat_default)
        .into(mItemChat);
    mItemChatUsername.setText(l.mVCardRealm.getNickName());
  }
}
