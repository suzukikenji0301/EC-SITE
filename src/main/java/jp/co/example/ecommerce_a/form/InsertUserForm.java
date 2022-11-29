package jp.co.example.ecommerce_a.form;

public class InsertUserForm {

	/** ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** メール */
	private String email;
	/** パスワード */
	private String password;
	/** 郵便番号 */
	private String zipcord;
	/** 住所 */
	private String address;
	/** 電話番号 */
	private String telephone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getZipcord() {
		return zipcord;
	}

	public void setZipcord(String zipcord) {
		this.zipcord = zipcord;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "insertUserForm [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", zipcord=" + zipcord + ", address=" + address + ", telephone=" + telephone + "]";
	}

}
