package jp.co.example.ecommerce_a.domain;

/**
 * トッピングの情報を表すdomainクラス.
 * 
 * @author kumagaimayu
 *
 */
public class Topping {

	/** トッピングID */
	private Integer id;
	/** トッピング名 */
	private String name;
	/** トッピング価格(Mの価格) */
	private Integer priceM;
	/** トッピング価格(Mの価格) */
	private Integer priceL;

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

	public Integer getPriceM() {
		return priceM;
	}

	public void setPriceM(Integer priceM) {
		this.priceM = priceM;
	}

	public Integer getPriceL() {
		return priceL;
	}

	public void setPriceL(Integer priceL) {
		this.priceL = priceL;
	}

	@Override
	public String toString() {
		return "Topping [id=" + id + ", name=" + name + ", priceM=" + priceM + ", priceL=" + priceL + "]";
	}

}
