public class ConfigurationManager {

    // 2. Private static instance variable
    private static volatile ConfigurationManager instance;

    // Configuration settings (example data)
    private String serverAddress;
    private int portNumber;

    // 1. Private constructor
    private ConfigurationManager(String address, int port) {
        // Prevent instantiation via Reflection
        if (instance != null) {
            throw new IllegalStateException("Singleton already initialized.");
        }
        this.serverAddress = address;
        this.portNumber = port;
        System.out.println("ConfigurationManager instance created.");
    }

    // 3. Public static factory method
    public static ConfigurationManager getInstance(String address, int port) {
        // First check (outside the synchronized block)
        if (instance == null) {
            // Synchronize on the class object
            synchronized (ConfigurationManager.class) {
                // Second check (inside the synchronized block)
                if (instance == null) {
                    instance = new ConfigurationManager(address, port);
                }
            }
        }
        return instance;
    }

    // Example methods to use the instance
    public String getServerAddress() {
        return serverAddress;
    }

    public int getPortNumber() {
        return portNumber;
    }
    
    // Optional: Protect against deserialization attacks
    protected Object readResolve() {
        return instance;
    }
    public void displayConfig() {
        System.out.println("--- Current Configuration ---");
        System.out.println("Address: " + serverAddress);
        System.out.println("Port: " + portNumber);
    }
}