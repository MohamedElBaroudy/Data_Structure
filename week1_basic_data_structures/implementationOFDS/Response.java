public class Response<T> {
    public String message;
    public T result;

    public Response(String message, T result){
        this.message = message;
        this.result = result;
    }

    public Response(String message){
        this.message = message;
    }
}