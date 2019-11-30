package bridge;

public interface ProjectHandlerBridge {

    boolean registerProject(String id1, String id2, String id3, String id4, String guideName, String projectName);

    boolean addProject(String project, String description, int numOfHours, String proposerFirstName, String proposerLastName, String proposerEmail, String proposerPhone, String organization);

}
