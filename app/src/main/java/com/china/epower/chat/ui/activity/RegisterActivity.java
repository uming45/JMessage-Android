package com.china.epower.chat.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.china.epower.chat.R;
import com.google.gson.Gson;
import net.grandcentrix.tray.AppPreferences;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import tech.jiangtao.support.kit.callback.RegisterCallBack;
import tech.jiangtao.support.kit.eventbus.RegisterAccount;
import tech.jiangtao.support.kit.init.SupportIM;
import tech.jiangtao.support.kit.userdata.SimpleLogin;
import tech.jiangtao.support.kit.util.ErrorAction;
import tech.jiangtao.support.kit.util.StringSplitUtil;
import tech.jiangtao.support.ui.api.ApiService;
import tech.jiangtao.support.ui.api.service.AccountServiceApi;
import work.wanghao.simplehud.SimpleHUD;

/**
 * Class: RegisterActivity </br>
 * Description: 注册页面 </br>
 * Creator: kevin </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 11/04/2017 11:06 PM</br>
 * Update: 11/04/2017 11:06 PM </br>
 **/
public class RegisterActivity extends BaseActivity {

  @BindView(R.id.register_username) AppCompatEditText mRegisterUsername;
  @BindView(R.id.register_password) AppCompatEditText mRegisterPassword;
  @BindView(R.id.register_retry_password) AppCompatEditText mRegisterRetryPassword;
  @BindView(R.id.register_button) AppCompatButton mRegisterButton;
  private AccountServiceApi mAccountServiceApi;
  private AppPreferences mAppPreferences;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    setUpToolbar();
    mAppPreferences = new AppPreferences(this);
  }

  public void setUpToolbar() {
    getTitleTextView().setText("注 册");
  }

  public void register(String username, String password) {
    //注册
    mAccountServiceApi = ApiService.getInstance().createApiService(AccountServiceApi.class);
    mAccountServiceApi.createAccount(StringSplitUtil.userJid(username), username, password)
        .subscribeOn(Schedulers.io())
        .doOnSubscribe(() -> SimpleHUD.showLoadingMessage(this, "正在注册", false))
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(user -> {
          SimpleHUD.dismiss();
          // TODO: 11/04/2017  注册成功后需要在service中获取一次数据并且保存
          Gson gson = new Gson();
          mAppPreferences.put(SupportIM.USER, gson.toJson(user));
          LoginActivity.startLogin(this);
        }, new ErrorAction() {
          @Override public void call(Throwable throwable) {
            super.call(throwable);
            SimpleHUD.dismiss();
            SimpleHUD.showErrorMessage(RegisterActivity.this, "已有该账户");
          }
        });
  }

  @OnClick(R.id.register_button) public void onClick(View v) {
    String username = mRegisterUsername.getText().toString();
    String password = mRegisterPassword.getText().toString();
    String retryPassword = mRegisterRetryPassword.getText().toString();
    if (username.equals("")) {
      SimpleHUD.showErrorMessage(RegisterActivity.this, "用户名不能为空");
      return;
    }
    if (password.equals("")) {
      SimpleHUD.showErrorMessage(RegisterActivity.this, "密码不能为空");
      return;
    }
    if (password.length() < 6) {
      SimpleHUD.showErrorMessage(RegisterActivity.this, "最低密码长度为六");
      return;
    }
    if (!(retryPassword.equals(password))) {
      SimpleHUD.showErrorMessage(RegisterActivity.this, "请确认两次密码是否一致");
      return;
    }
    register(username, password);
  }

  @Override protected boolean preSetupToolbar() {
    return true;
  }

  public static void startRegister(Activity activity) {
    activity.startActivity(new Intent(activity, RegisterActivity.class));
  }
}
