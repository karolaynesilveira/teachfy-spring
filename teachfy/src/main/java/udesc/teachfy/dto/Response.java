package udesc.teachfy.dto;

public class Response<T> {

	private String message;
	private T data;
	
	public Response() {};
	
	public Response(String message) {
		super();
		this.message = message;
	}

	public Response(String message, T data) {
		super();
		this.message = message;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
