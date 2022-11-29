package jp.co.example.ecommerce_a.form;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * 注文時に使うフォーム.
 * 
 * @author Hirabuki
 *
 */
public class OrderForm {
	
	/** 宛先氏名 */
	private String destinationName;
	/** 宛先Eメール */
	private String destinationEmail;
	/** 宛先郵便番号 */
	private String destinationZipcode;
	/** 宛先住所 */
	private String destinationAddress;
	/** 宛先TEL */
	private String distinationTel;
	/** 配達日 */
	private String deliveryDate;
	/** 配達時間 */
	private String deliveryTime;
	/** 支払い方法 */
	private String paymentMethod;
	/** オーダーID */
	private String orderId;

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

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public Timestamp getDeliveryTime (String deliveryDate, String deliveryTime) throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String str = deliveryDate + deliveryTime;
		Timestamp timestamp = new Timestamp(simpleDateFormat.parse(str).getTime());
		return timestamp;
	}

	@Override
	public String toString() {
		return "OrderForm [destinationName=" + destinationName + ", destinationEmail=" + destinationEmail
				+ ", destinationZipcode=" + destinationZipcode + ", destinationAddress=" + destinationAddress
				+ ", distinationTel=" + distinationTel + ", deliveryDate=" + deliveryDate + ", deliveryTime="
				+ deliveryTime + ", paymentMethod=" + paymentMethod + ", orderId=" + orderId + "]";
	}

}
