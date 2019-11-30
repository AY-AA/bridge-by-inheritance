package us;

import bridge.ProjectHandlerBridge;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AddProjectStoryTest extends ProjectHandlerTest{

    private final static String PROJECT_A = "project_A";
    private final static String DESCRIPTION_A = "very good project";
    private final static int NUM_OF_HOURS_A = 5;
    private final static String PROPOSER_FIRST_NAME_A = "Someone";
    private final static String PROPOSER_LAST_NAME_A = "Somebody";
    private final static String PROPOSER_EMAIL_A = "some@someone.com";
    private final static String PROPOSER_PHONE_A = "0505050050";
    private final static String ORGANIZATION_A = "Google";

    private final static String PROJECT_B = "project_B";
    private final static String DESCRIPTION_B = "very good project with special features";
    private final static int NUM_OF_HOURS_B = 6;
    private final static String PROPOSER_FIRST_NAME_B = "Someoneok";
    private final static String PROPOSER_LAST_NAME_B = "Somebodyok";
    private final static String PROPOSER_EMAIL_B = "some111@someone.com";
    private final static String PROPOSER_PHONE_B = "0505050123";
    private final static String ORGANIZATION_B = "Microsoft";

    private final static String NOT_PERMITTED_ORGANIZATION_A = "BGU_Student";
    private final static String NOT_PERMITTED_ORGANIZATION_B = "BGU_4TH_YEAR";


    @Test
    public void testProjectAddition() {
        assertTrue(addProject(PROJECT_A, DESCRIPTION_A, NUM_OF_HOURS_A, PROPOSER_FIRST_NAME_A, PROPOSER_LAST_NAME_A, PROPOSER_EMAIL_A, PROPOSER_PHONE_A, ORGANIZATION_A));
        assertTrue(addProject(PROJECT_B, DESCRIPTION_B, NUM_OF_HOURS_B, PROPOSER_FIRST_NAME_B, PROPOSER_LAST_NAME_B, PROPOSER_EMAIL_B, PROPOSER_PHONE_B, ORGANIZATION_B));
    }

    @Test
    public void testProjectAdditionWithMissingDetails() {
        assertFalse(addProject("", DESCRIPTION_A, NUM_OF_HOURS_A, PROPOSER_FIRST_NAME_A, PROPOSER_LAST_NAME_B, PROPOSER_EMAIL_A, PROPOSER_PHONE_A, ORGANIZATION_A));
        assertFalse(addProject(PROJECT_B, DESCRIPTION_B, NUM_OF_HOURS_B, PROPOSER_FIRST_NAME_B, PROPOSER_LAST_NAME_B, PROPOSER_EMAIL_B, PROPOSER_PHONE_B, ""));
    }

    @Test
    public void testProjectNotPermittedPerson() {
        assertFalse(addProject(PROJECT_A, DESCRIPTION_A, NUM_OF_HOURS_A, PROPOSER_FIRST_NAME_A, PROPOSER_LAST_NAME_A, PROPOSER_EMAIL_A, PROPOSER_PHONE_A, NOT_PERMITTED_ORGANIZATION_A));
        assertFalse(addProject(PROJECT_B, DESCRIPTION_B, NUM_OF_HOURS_B, PROPOSER_FIRST_NAME_B, PROPOSER_LAST_NAME_B, PROPOSER_EMAIL_B, PROPOSER_PHONE_B, NOT_PERMITTED_ORGANIZATION_B));
    }

    @Test
    public void testProjectWhichAlreadyExistsAddition() {
        assertTrue(addProject(PROJECT_A, DESCRIPTION_A, NUM_OF_HOURS_A, PROPOSER_FIRST_NAME_A, PROPOSER_LAST_NAME_A, PROPOSER_EMAIL_A, PROPOSER_PHONE_A, ORGANIZATION_A));
        assertFalse(addProject(PROJECT_A, DESCRIPTION_B, NUM_OF_HOURS_B, PROPOSER_FIRST_NAME_B, PROPOSER_LAST_NAME_B, PROPOSER_EMAIL_B, PROPOSER_PHONE_B, ORGANIZATION_B));
    }


}
