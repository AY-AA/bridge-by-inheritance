package us;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegisterToProjectStoryTest extends ProjectHandlerTest {

    private final static String ID_1_A = "303030301";
    private final static String ID_2_A = "303030302";
    private final static String ID_3_A = "303030303";
    private final static String ID_4_A = "303030304";
    private final static String GUIDE_NAME_A = "guideX";
    private final static String PROJECT_NAME_A = "projectX";

    private final static String ID_1_B = "303030311";
    private final static String ID_2_B = "303030312";
    private final static String ID_3_B = "303030313";
    private final static String ID_4_B = "303030314";
    private final static String GUIDE_NAME_B = "guideY";
    private final static String PROJECT_NAME_B = "projectY";



    @Test
    public void testRegisterProject() {
        assertTrue(registerProject(ID_1_A, ID_2_A, ID_3_A, ID_4_A, GUIDE_NAME_A, PROJECT_NAME_A));
        assertTrue(registerProject(ID_1_B, ID_2_B, ID_3_B, ID_4_B, GUIDE_NAME_B, PROJECT_NAME_B));
    }

    @Test
    public void testRegisterProjectWithMissingDetails() {
        assertFalse(registerProject("", ID_2_A, ID_3_A, ID_4_A, GUIDE_NAME_A, PROJECT_NAME_A));
        assertFalse(registerProject(ID_1_B, ID_2_B, ID_3_B, ID_4_B, "", PROJECT_NAME_B));
    }

    @Test
    public void testRegisterProjectWithAlreadyAssignedIDs() {
        assertTrue(registerProject(ID_1_A, ID_2_A, ID_3_A, ID_4_A, GUIDE_NAME_A, PROJECT_NAME_A));
        assertFalse(registerProject(ID_1_A, ID_2_A, ID_3_A, ID_4_A, GUIDE_NAME_B, PROJECT_NAME_B));
    }

    @Test
    public void testRegisterProjectOfAssignedProject() {
        assertTrue(registerProject(ID_1_A, ID_2_A, ID_3_A, ID_4_A, GUIDE_NAME_A, PROJECT_NAME_A));
        assertFalse(registerProject(ID_1_B, ID_2_B, ID_3_B, ID_4_B, GUIDE_NAME_A, PROJECT_NAME_A));
    }


}
