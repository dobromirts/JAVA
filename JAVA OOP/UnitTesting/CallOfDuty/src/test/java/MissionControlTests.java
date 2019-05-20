import callofduty.core.MissionControlImpl;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MissionControlTests {
    private static final Double SURVEILLANCE_MISSION_RATING_MULTIPLIER = 1.5D;

    private static final Double SURVEILLANCE_MISSION_BOUNTY_MULTIPLIER = 2D;

    private Mission firstMission;

    private Mission secondMission;

    private Mission thirdMission;

    private Mission incorrectMinimalBountyAndRatingMission;

    private Mission incorrectMaximumBountyAndRatingMission;

    @Before
    public void setUp() {
        MissionControl missionControl = new MissionControlImpl();

        String missionId = "1q2w3e4r5t";
        String secondMissionId = "4r3e2w1q";
        String thirdMissionId = "aslpls";

        String incorrectMinimalBountyAndMissionMissionId = "incorrect1";
        String incorrectMaximumBountyAndMissionMissionId = "incorrect2";

        Double missionRating = 0D;
        Double missionBounty = 0D;

        Double incorrectMinimalMissionRating = -10D;
        Double incorrectMaximumMissionRating = 1000D;

        Double incorrectMinimalMissionBounty = -10D;
        Double incorrectMaximumMissionBounty = 1000000D;

        this.firstMission = missionControl.generateMission(missionId, missionRating, missionBounty);
        this.secondMission = missionControl.generateMission(secondMissionId, missionRating, missionBounty);
        this.thirdMission = missionControl.generateMission(thirdMissionId, missionRating, missionBounty);
        this.incorrectMinimalBountyAndRatingMission = missionControl.generateMission(incorrectMinimalBountyAndMissionMissionId,
                incorrectMinimalMissionRating,
                incorrectMinimalMissionBounty);
        this.incorrectMaximumBountyAndRatingMission = missionControl.generateMission(incorrectMaximumBountyAndMissionMissionId,
                incorrectMaximumMissionRating,
                incorrectMaximumMissionBounty);
    }

    @Test
    public void testGenerateMission_withLongId_shouldReturnSubstringedId() {
        String expectedId = "1q2w3e4r";
        String actualId = this.firstMission.getId();

        Assert.assertEquals("MissionControl class, generateMission() method does not work properly.", expectedId, actualId);
    }
}

