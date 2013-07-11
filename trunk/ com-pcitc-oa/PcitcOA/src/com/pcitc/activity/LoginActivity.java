package com.pcitc.activity;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.pcitc.entity.PcitcConstants;
import com.pcitc.utils.ActivityStackControlUtil;
import com.pcitc.utils.PcitcAsyncTask;
import com.pcitc.xmlparse.GetInputStream;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * 登入界面
 * 
 * @author rushun.zhang
 * 
 */
public class LoginActivity extends AbstractActivity {

	protected static String uName = null;
	private EditText txtUser;
	private EditText txtPwd;
	private Button btnLogin;
	private CheckBox imgView;
	private ImageButton ib_log_select;
	private String version;
	private SharedPreferences share;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);
		overrideParent();
		initUI();
	}

	@Override
	public void overrideParent() {
		// TODO Auto-generated method stub
		title_bar.setVisibility(View.GONE);
	}

	@Override
	public void initUI() {
		// TODO Auto-generated method stub
		
		ActivityStackControlUtil.add(this);
		txtUser = (EditText) findViewById(R.id.txtUser);
		txtPwd = (EditText) findViewById(R.id.txtPwd);
		btnLogin = (Button) findViewById(R.id.loginButton);
		imgView = (CheckBox) findViewById(R.id.imageView1);
		ib_log_select = (ImageButton) findViewById(R.id.ib_log_select);
		ib_log_select.setOnClickListener(this);
		imgView.setOnClickListener(this);
		btnLogin.setOnClickListener(this);

		share = getSharedPreferences("pcitc_properties", 0);
		String name = share.getString("username", "");
		String pword = share.getString("password", "");
		boolean remeber = share.getBoolean("remeber", false);
		txtUser.setText(name);
		txtPwd.setText(pword);
		imgView.setChecked(remeber);
		
			try {
				PackageInfo info = this.getPackageManager().getPackageInfo(    
						                   this.getPackageName(), 0);
			version =	info.versionName;
			System.out.println(version);
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		UpVersion();
		super.onResume();
	}

	private void UpVersion() {
		// TODO Auto-generated method stub

		PcitcAsyncTask task = new PcitcAsyncTask(LoginActivity.this) {

			@Override
			public Object before(Object... params) throws Exception {
				// TODO Auto-generated method stub

				String versionUrl = PcitcConstants.IP
						+ "_layouts/InterFace/VersionCheck.ashx?VersionID="
						+ version;
				
				String s = GetInputStream.getString(versionUrl);
				return s;
			}

			@Override
			public void after(Object result) {
				// TODO Auto-generated method stub
				if (result != null && !result.equals("")) {
					if (((String) result).contains("False")
							|| ((String) result).contains("false")) {
						AlertDialog.Builder dialog = new AlertDialog.Builder(
								LoginActivity.this);
						dialog.setTitle("提示")
								.setMessage("有新的版本更新，是否更新")
								.setPositiveButton("是",
										new DialogInterface.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {
												
												//getFileFromServer();
												
											}
										}).setNegativeButton("否", null);
						dialog.create().show();
					}
				}
			}
		};
		task.execute();
	}

	// 从服务器下载apk:
	public void getFileFromServer() {
		// 如果相等的话表示当前的sdcard挂载在手机上并且是可用的
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			PcitcAsyncTask task = new PcitcAsyncTask(LoginActivity.this) {

				@Override
				public Object before(Object... params) throws Exception {
					// TODO Auto-generated method stub

					File file = new File(
							Environment.getExternalStorageDirectory()+"//download",
							"PcitcOA.apk");
					System.out.println(Uri.fromFile(file));
					InputStream is = GetInputStream.getInputStream("");
					FileOutputStream fos = new FileOutputStream(file);
					BufferedInputStream bis = new BufferedInputStream(is);

					byte[] buffer = new byte[1024];
					int len;
					// int total=0;
					while ((len = bis.read(buffer)) != -1) {
						fos.write(buffer, 0, len);
						// total+= len;

					}
					fos.close();
					bis.close();
					is.close();
					return file;
				}

				@Override
				public void after(Object result) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Intent.ACTION_VIEW);
					intent.setDataAndType(Uri.fromFile((File) result),
							"application/vnd.android.package-archive");
					startActivity(intent);

				}
			};
			task.execute();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ib_log_select:

			break;

		case R.id.loginButton:
			if (imgView.isChecked()) {
				saveRemember(true);

			} else {
				saveRemember(false);

			}
			
			loginLogic();

			break;
		default:
			break;
		}
	}

	private void saveRemember(boolean b) {
		// TODO Auto-generated method stub
		if (b) {
			Editor editor = share.edit();// 获取编辑器
			editor.putBoolean("remeber", b);
			editor.putString("username", txtUser.getText().toString());
			editor.putString("password", txtPwd.getText().toString());
			editor.commit();
		} else {
			Editor editor = share.edit();// 获取编辑器
			editor.putBoolean("remeber", b);
			editor.putString("username", "");
			editor.putString("password", "");
			editor.commit();
		}
	}

	private void loginLogic() {
		final String userName = txtUser.getText().toString();
		final String userPassWord = txtPwd.getText().toString();

		if (userName != null && userPassWord != null && !userName.equals("")
				&& !userPassWord.equals("")) { // 用户名密码不能为空

			PcitcAsyncTask pcitcTask = new PcitcAsyncTask(LoginActivity.this) {

				@Override
				public Object before(Object... params) throws Exception {
					// TODO Auto-generated method stub
					// 检测用户名密码是否正确
					String checkUrl = PcitcConstants.IP
							+ "_layouts/InterFace/LoginAuthentication.ashx?UserName="
							+ userName.trim() + "&UserPwd="
							+ userPassWord.trim();
					Log.i("TAG", "checkUrl:" + checkUrl);
					String checkResult = GetInputStream.getString(checkUrl);
					return checkResult;
				}

				@Override
				public void after(Object result) {
					// TODO Auto-generated method stub

					if (result != null) {

						if (((String) result).contains("True")
								|| ((String) result).contains("true")) {
							uName = userName;
							Toast.makeText(LoginActivity.this, "登录成功！",
									Toast.LENGTH_SHORT).show();
							Intent intent = new Intent(LoginActivity.this,
									FeatureListActivity.class);
							startActivity(intent);
							finish();
						} else {
							Toast.makeText(LoginActivity.this,
									"登录失败，请检查用户名和密码！", 500).show();
						}

					}
				}

			};
			pcitcTask.execute();

		} else if (null == txtUser.getText()
				|| txtUser.getText().toString().equals("")) {
			Toast.makeText(LoginActivity.this, "请输入用户名！", Toast.LENGTH_SHORT)
					.show();
		} else if (null == txtPwd.getText()
				|| txtPwd.getText().toString().equals("")) {
			Toast.makeText(LoginActivity.this, "请输入用户密码！", Toast.LENGTH_SHORT)
					.show();
		}

	}

	@Override
	protected void onDestroy() {
		ActivityStackControlUtil.remove(this);

		super.onDestroy();
	}

}
