package jp.co.example.ecommerce_a.form;

/**
 * @author kenji.suzuki
 *
 */
public class InsertContactForm {

	/** 名前 */
	private String name;
	/** フリガナ */
	private String fullName;
	/** メールアドレス */
	private String mailAddress;
	/** 電話番号 */
	private Integer telePhone;
	/** 性別 */
	private String gender;
	/** お問合せ内容 */
	private String inquiryDetails;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public Integer getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(Integer telePhone) {
		this.telePhone = telePhone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInquiryDetails() {
		return inquiryDetails;
	}

	public void setInquiryDetails(String inquiryDetails) {
		this.inquiryDetails = inquiryDetails;
	}

	@Override
	public String toString() {
		return "InsertContactForm [name=" + name + ", fullName=" + fullName + ", mailAddress=" + mailAddress
				+ ", telePhone=" + telePhone + ", gender=" + gender + ", inquiryDetails=" + inquiryDetails + "]";
	}

}
