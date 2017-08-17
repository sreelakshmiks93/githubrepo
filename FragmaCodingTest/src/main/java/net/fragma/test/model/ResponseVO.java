/**
 * 
 */
package net.fragma.test.model;

/**
 * @author SreeLakshmi
 *
 */
public class ResponseVO {

	private int code;
	
	private String status;
	
	private Object data;
	
	public ResponseVO() {
		// TODO Auto-generated constructor stub
	}

	public ResponseVO(int code, String status, Object data) {
		super();
		this.code = code;
		this.status = status;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseVO [code=" + code + ", status=" + status + ", data="
				+ data + "]";
	}

	 
	
}
