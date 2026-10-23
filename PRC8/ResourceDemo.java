
class WarehouseResource implements AutoCloseable {

    WarehouseResource() {
        System.out.println("Resource opened.");
    }

    public void process() throws Exception {
        System.out.println("Processing warehouse data...");
        throw new Exception("Original processing error");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource closed.");
        throw new Exception("Error while closing resource");
    }
}

public class ResourceDemo {

    public static void main(String[] args) {
        try (WarehouseResource resource =
                     new WarehouseResource()) {

            resource.process();

        } catch (Exception e) {
            System.out.println(
                    "Caught error: " + e.getMessage());

            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println(
                        "Suppressed error: "
                        + suppressed.getMessage());
            }
        }

        System.out.println("25CE077 - Dwij");
    }
}
