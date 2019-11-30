package us;

import bridge.Driver;
import bridge.ProjectHandlerBridge;
import org.junit.Before;

public class ProjectHandlerTest {

    private ProjectHandlerBridge projectHandlerBridge;

    @Before
    public void setUp() throws Exception {
        this.projectHandlerBridge = Driver.getBridge();
    }

    public boolean registerProject(String id1, String id2, String id3, String id4, String guideName, String projectName) {
        return projectHandlerBridge.registerProject(id1, id2, id3, id4, guideName, projectName);
    }

    public boolean addProject(String project, String description, int numOfHours, String proposerFirstName, String proposerLastName, String proposerEmail, String proposerPhone, String organization) {
        return projectHandlerBridge.addProject(project, description, numOfHours, proposerFirstName, proposerLastName, proposerEmail, proposerPhone, organization);
    }
}
