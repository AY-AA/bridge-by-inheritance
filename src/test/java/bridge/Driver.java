package bridge;

public class Driver {

    public static ProjectHandlerBridge getBridge() {
        ProjectHandlerBridge bridge = new ProxyBridge();

        // TODO: when real bridge is ready, assign real:
//        bridge.setBridge(new RealBridge());

        return bridge;
    }
}
