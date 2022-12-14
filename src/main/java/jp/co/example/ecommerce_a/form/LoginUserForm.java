package jp.co.example.ecommerce_a.form;

/**
 * ログイン時に使うフォーム.
 * 
 * @author Hirabuki
 */
public class LoginUserForm {

	/** メールアドレス */
	private String email;
	/** パスワード */
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
