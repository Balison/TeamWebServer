package httpRequest;

/**
 *
 * @author franko
 */
public class HttpRequest {

    private String method;
    private String resource;
    private String version;
    
    public HttpRequest(String method, String resource, String version) {
        this.method = method;
        this.resource = resource;
        this.version = version;
    }

    public boolean equals(HttpRequest other){
        return method.equals(other.method)&& resource.equals(other.resource)
                && version.equals(other.version);
    
    }
    
    public String getMethod(){
        return method;
    }
    
    public String getResource(){
        return resource;
    }
    
    public String getProtocol(){
        return version;
    }

}
