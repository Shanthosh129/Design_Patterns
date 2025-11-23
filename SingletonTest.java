public class SingletonTest {
    public static void main(String [] args){
        System.out.println("Starting Singleton Test...");
        // Try to get the first instance with specifi config
        System.out.println("\nAttempt 1: Getting Instance (should create it)");
        ConfigurationManager config1 = ConfigurationManager.getInstance("192.168.1.1", 8080);
        config1.displayConfig();

        System.out.println("\nAttempt 2: Getting Instance (should reuse the existing one)");
        ConfigurationManager config2 = ConfigurationManager.getInstance("10.0.0.5", 9000);
        config2.displayConfig();

        System.out.println("\n--- Verification ---");

        // verify instances 
        boolean isSameInstance = (config1 == config2);
        System.out.println("config1 == config2: **" + isSameInstance + "**");

        // verify that teh configuration from the first call persists
        // (config2 did NOT change the settings)
        System.out.println("Config2's Address:" + config2.getServerAddress());
        System.out.println("Expected Address: 192.168.1.1");

        if(isSameInstance &&config2.getServerAddress().equals("192.168.1.1")){
            System.out.println("\nSuccess! The Singleton pattern works correctly.");
        } else {
            System.out.println("\nFailure: The Singleton pattern did not prevent multiple instances or initialization.");
        
        }
    }
}
