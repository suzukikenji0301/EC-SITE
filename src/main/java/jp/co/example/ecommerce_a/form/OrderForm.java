package jp.co.example.ecommerce_a.form;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 注文時に使うフォーム.
 * 
 * @author Hirabuki
 *
 */
public class OrderForm {

	/** 宛先氏名 */
	@NotBlank(message = "名前を入力して下さい")
	private String destinationName;
	/** 宛先Eメール */
	@Size(min = 1, max = 127, message = "Eメールは１文字以上127文字以内で記載してください")
	@Email(message = "Eメールの形跡が不正です")
	private String destinationEmail;
	/** 宛先郵便番号 */
	@NotBlank(message = "郵便番号を入力して下さい")
	@Pattern(regexp = "^[0-9]{3}-[0-9]{4}$", message = "郵便番号形式にしてください")
	private String destinationZipcode;

	/** 宛先住所 */
	@NotBlank(message = "住所を入力して下さい")
	private String destinationAddress;
	/** 宛先TEL */
	@NotBlank(message = "電話番号を入力して下さい")
	@Pattern(regexp = "/^0\\d{4}-\\d{4}-\\d{4}$/", message = "郵便番号形式にしてください")
	private String distinationTel;
	/** 配達日 */
	@NotBlank(message = "配達日時を入力して下さい")
	private String deliveryDate;
	/** 配達時間 */
	private String deliveryTime;
	/** 支払い方法 */
	private String paymentMethod;
	/** オーダーID */
	private String orderId;
	/** クレジットカード番号 */
	private String cardNumber;
	/** 有効期限（月） */
	private String cardExpMonth;
	/** 有効期限（年） */
	private String cardExpYear;
	/** クレジットカード名義人 */
	private String cardName;
	/** セキュリティコード */
	private String cardCvv;

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getDestinationEmail() {
		return destinationEmail;
	}

	public void setDestinationEmail(String destinationEmail) {
		this.destinationEmail = destinationEmail;
	}

	public String getDestinationZipcode() {
		return destinationZipcode;
	}

	public void setDestinationZipcode(String destinationZipcode) {
		this.destinationZipcode = destinationZipcode;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public String getDistinationTel() {
		return distinationTel;
	}

	public void setDistinationTel(String distinationTel) {
		this.distinationTel = distinationTel;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public Integer intGetPaymentMethod() {
		return Integer.parseInt(paymentMethod);
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getOrderId() {
		return orderId;
	}

	public Integer intGetOrderId() {
		return Integer.parseInt(orderId);
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardExpMonth() {
		return cardExpMonth;
	}

	public void setCardExpMonth(String cardExpMonth) {
		this.cardExpMonth = cardExpMonth;
	}

	public String getCardExpYear() {
		return cardExpYear;
	}

	public void setCardExpYear(String cardExpYear) {
		this.cardExpYear = cardExpYear;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardCvv() {
		return cardCvv;
	}

	public void setCardCvv(String cardCvv) {
		this.cardCvv = cardCvv;
	}

	public Timestamp getDeliveryTimestamp() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String str = deliveryDate + deliveryTime + ":00:00";
		Timestamp timestamp = null;
		try {
			timestamp = new Timestamp(simpleDateFormat.parse(str).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}

	@Override
	public String toString() {
		return "OrderForm [destinationName=" + destinationName + ", destinationEmail=" + destinationEmail
				+ ", destinationZipcode=" + destinationZipcode + ", destinationAddress=" + destinationAddress
				+ ", distinationTel=" + distinationTel + ", deliveryDate=" + deliveryDate + ", deliveryTime="
				+ deliveryTime + ", paymentMethod=" + paymentMethod + ", orderId=" + orderId + ", cardNumber="
				+ cardNumber + ", cardExpMonth=" + cardExpMonth + ", cardExpYear=" + cardExpYear + ", cardName="
				+ cardName + ", cardCvv=" + cardCvv + "]";
	}
}