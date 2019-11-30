package bridge;

import java.util.LinkedList;
import java.util.List;

public class ProxyBridge implements ProjectHandlerBridge {

    private ProjectHandlerBridge projectHandler;
    private List<String> registeredIDs = new LinkedList<String>();
    private List<String> newProjects = new LinkedList<String>();
    private List<String> takenProjects = new LinkedList<String>();



    private final static String NOT_PERMITTED_ORGANIZATION_A = "BGU_Student";
    private final static String NOT_PERMITTED_ORGANIZATION_B = "BGU_4TH_YEAR";

    public void setProjectHandler(ProjectHandlerBridge projectHandler) {
        this.projectHandler = projectHandler;
    }

    public boolean registerProject(String id1, String id2, String id3, String id4, String guideName, String projectName) {
        if (projectHandler != null)
            return projectHandler.registerProject(id1, id2, id3, id4, guideName, projectName);

        if (verifyIDs(id1, id2, id3, id4) && !guideName.isEmpty() && verifyLegalProjectName(projectName)) {
            addIDs(id1, id2, id3, id4);
            assignProjectName(projectName);
            return true;
        }

        return false;
    }

    private boolean verifyLegalProjectName(String projectName) {
        if (takenProjects.contains(projectName)) return false;
        takenProjects.add(projectName);
        return true;
    }

    private void assignProjectName(String projectName) {
        takenProjects.add(projectName);
    }

    private boolean verifyIDs(String id1, String id2, String id3, String id4) {
        if (id1.isEmpty() || id2.isEmpty() || id3.isEmpty() || id4.isEmpty())   return false;
        if (id1.equals(id2) || id1.equals(id3) || id1.equals(id4))  return false;
        if (id2.equals(id3) || id1.equals(id4))  return false;
        if (id3.equals(id4))  return false;
        if (registeredIDs.contains(id1) || registeredIDs.contains(id2) || registeredIDs.contains(id3) || registeredIDs.contains(id4))
            return false;
        return true;
    }

    private void addIDs(String id1, String id2, String id3, String id4) {
        registeredIDs.add(id1);
        registeredIDs.add(id2);
        registeredIDs.add(id3);
        registeredIDs.add(id4);
    }

    public boolean addProject(String project, String description, int numOfHours, String proposerFirstName, String proposerLastName, String proposerEmail, String proposerPhone, String organization) {
        if (projectHandler != null)
            return projectHandler.addProject(project, description, numOfHours, proposerFirstName, proposerLastName, proposerEmail, proposerPhone, organization);

        if (verifyProposer(proposerFirstName, proposerLastName, proposerEmail, proposerPhone, organization) && verifyProject(project, description, numOfHours)) {
            newProjects.add(project);
            return true;
        }

        return false;
    }

    private boolean verifyProject(String project, String description, int numOfHours) {
        if (numOfHours < 0 || description.isEmpty() || project.isEmpty() || newProjects.contains(project))
            return false;
        return true;
    }

    private boolean verifyProposer(String proposerFirstName, String proposerLastName, String proposerEmail, String proposerPhone, String organization) {
        if (proposerFirstName.isEmpty() || proposerLastName.isEmpty() || proposerEmail.isEmpty() || proposerPhone.isEmpty() || organization.isEmpty())
            return false;

        if (organization.equals(NOT_PERMITTED_ORGANIZATION_A) || organization.equals(NOT_PERMITTED_ORGANIZATION_B))
            return false;

        return true;
    }




}
