public class Singleton {
    public static volatile Singleton instance;
    //configuration settings 
    private String  serverAddress;
    private int portNo;

    //1. private constructor
    private Singleton(String address,int port){
        //prevent second instatiation
        if(instance  != null){
            throw new IllegalStateException("Singleton already instatiated");
            
        }
        this.serverAddress = address;
        this.portNo = port;
        System.out.println("ConfigurationManager instance created.");
    }   
    
    //public static factory methods
    public static Singleton getInstance(String address, int port){
        // First check (outside the synchronized block)
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton(address , port);
                }
            }
        }
        return instance;
    }
     // Example methods to use the instance
    public String getServerAddress() {
        return serverAddress;
    }

    public int getPortN0() {
        return portNo;
    }
    
    // Optional: Protect against deserialization attacks
    protected Object readResolve() {
        return instance;
    }
}
