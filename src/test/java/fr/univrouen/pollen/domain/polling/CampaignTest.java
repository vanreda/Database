package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.social.User;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

//TODO : vérifier les throw des column false
public class CampaignTest {

    @Ignore
    @Test
    public void test_campaign_SetPollNotifications() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    public void test_campaign_SetAnswers() {
        //GIVEN
        Campaign c = new Campaign();
        List<Answer> ans = new ArrayList<Answer>();
        //WHEN
        c.setAnswers(ans);
        //THEN
        assertEquals(c.getAnswers(), ans);
    }

    @Test
    public void test_campaign_SetId() {
        //GIVEN
        Campaign c = new Campaign();
        long id = 52;
        //WHEN
        c.setId(id);
        //THEN
        assertEquals(c.getId(), id);
    }

    @Test
    public void test_campaign_SetId_0() {
        //GIVEN
        Campaign c = new Campaign();
        long id = 0;
        try {
            //WHEN
            c.setId(id);
            fail("Id can not be negative or 0");
        } catch (Exception exc) {
            //THEN
            assertEquals(exc.getMessage(),"Id can not be negative or 0");
        }
    }

    @Test
    public void test_campaign_SetId_negative() {
        //GIVEN
        Campaign c = new Campaign();
        long id = -25;
        try {
            //WHEN
            c.setId(id);
            fail("Id can not be negative or 0");
        } catch (Exception exc) {
            //THEN
            assertEquals(exc.getMessage(),"Id can not be negative or 0");
        }
    }

    @Test
    public void test_campaign_SetResultAvailability() {
        //GIVEN
        Campaign c = new Campaign();
        ResultAvailability r = ResultAvailability.AFTER_CAMPAIGN;
        //WHEN
        c.setResultAvailability(r);
        //THEN
        assertEquals(c.getResultAvailability(), r);
    }

    @Ignore
    @Test
    public void test_campaign_SetAllowedResultsUsers() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    public void test_campaign_SetStartingAt() {
        //GIVEN
        Campaign c = new Campaign();
        long start = new Date().getTime();
        //WHEN
        c.setStartingAt(new Timestamp(start));
        //THEN
        assertEquals(c.getStartingAt(), new Timestamp(start));
    }

    @Test
    public void test_campaign_SetEndingAt() {
        //GIVEN
        Campaign c = new Campaign();
        long end = new Date().getTime();
        //WHEN
        c.setEndingAt(new Timestamp(end));
        //THEN
        assertEquals(c.getEndingAt(), new Timestamp(end));
    }

    //TODO
    @Test
    public void test_campaign_SetClosingModality() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    public void test_campaign_SetVotes() {
        //GIVEN
        Campaign c = new Campaign();
        int votes = 516;
        //WHEN
        c.setVotes(votes);
        //THEN
        assertEquals(c.getVotes(), votes);
    }

    @Test
    public void test_campaign_SetVotes_negative() {
        //GIVEN
        Campaign c = new Campaign();
        int votes = -515;
        try {
            //WHEN
            c.setVotes(votes);
            fail("Votes can not be negative");
        } catch (Exception exc) {
            //THEN
            assertEquals(exc.getMessage(), "Votes can not be negative");
        }
    }

    @Test
    public void test_campaign_SetMaxVotes() {
        //GIVEN
        Campaign c = new Campaign();
        int maxvotes = 52;
        //WHEN
        c.setMaxVotes(maxvotes);
        //THEN
        assertEquals(c.getMaxVotes(), maxvotes);
    }

    @Test
    public void test_campaign_SetMaxVotes_0() {
        //GIVEN
        Campaign c = new Campaign();
        int maxvotes = 0;
        try {
            //WHEN
            c.setMaxVotes(maxvotes);
            fail("maxVotes can not be negative");
        } catch (Exception exc) {
            //THEN
            assertEquals(exc.getMessage(), "maxVotes can not be negative");
        }
    }

    @Test
    public void test_campaign_SetMaxVotes_negative() {
        //GIVEN
        Campaign c = new Campaign();
        int maxvotes = -1;
        try {
            //WHEN
            c.setMaxVotes(maxvotes);
            fail("maxVotes can not be negative");
        } catch (Exception exc) {
            //THEN
            assertEquals(exc.getMessage(), "maxVotes can not be negative");
        }
    }

    @Test
    public void test_campaign_SetFrequency() {
        //GIVEN
        Campaign c = new Campaign();
        CampaignRecurrence cr = CampaignRecurrence.MONTHLY;
        //WHEN
        c.setFrequency(cr);
        //THEN
        assertEquals(c.getFrequency(), cr);
    }

    @Test
    public void test_campaign_SetVisibility() {
        //GIVEN
        Campaign c = new Campaign();
        CampaignVisibility cr = CampaignVisibility.PUBLIC;
        //WHEN
        c.setVisibility(cr);
        //THEN
        assertEquals(c.getVisibility(), cr);
    }

    @Test
    public void test_campaign_SetResultVisibility() {
        //GIVEN
        Campaign c = new Campaign();
        CampaignResultVisibility cv = CampaignResultVisibility.PRIVATE;
        //WHEN
        c.setResultVisibility(cv);
        //THEN
        assertEquals(c.getResultVisibility(), cv);
    }

    @Test
    public void test_campaign_SetAllowedUsers() {
        //GIVEN
        Campaign c = new Campaign();
        List<User> users = new ArrayList<User>();
        //WHEN
        c.setAllowedUsers(users);
        //THEN
        assertEquals(c.getAllowedUsers(), users);
    }

    @Test
    public void test_campaign_SetResultAvailability_null() {
        //GIVEN
        Campaign c = new Campaign();
        ResultAvailability ra = null;
        try {
            //WHEN
            c.setResultAvailability(ra);
            fail("resultAvailability can not be null");
        } catch (Exception exc) {
            //THEN
            assertEquals(exc.getMessage(), "resultAvailability can not be null");
        }
    }

    @Test
    public void test_campaign_SetStartingAt_null() {
        //GIVEN
        Campaign c = new Campaign();
        Timestamp ra = null;
        try {
            //WHEN
            c.setStartingAt(ra);
            fail("startingat can not be null");
        } catch (Exception exc) {
            //THEN
            assertEquals(exc.getMessage(), "startingat can not be null");
        }
    }

    @Test
    public void test_campaign_SetEndingAt_null() {
        //GIVEN
        Campaign c = new Campaign();
        Timestamp ra = null;
        try {
            //WHEN
            c.setEndingAt(ra);
            fail("endingAt can not be null");
        } catch (Exception exc) {
            //THEN
            assertEquals(exc.getMessage(), "endingAt can not be null");
        }
    }

    @Test
    public void test_campaign_SetFrequency_null() {
        //GIVEN
        Campaign c = new Campaign();
        CampaignRecurrence ra = null;
        try {
            //WHEN
            c.setFrequency(ra);
            fail("frequency can not be null");
        } catch (Exception exc) {
            //THEN
            assertEquals(exc.getMessage(), "frequency can not be null");
        }
    }

    @Test
    public void test_campaign_SetVisibility_null() {
        //GIVEN
        Campaign c = new Campaign();
        CampaignVisibility ra = null;
        try {
            //WHEN
            c.setVisibility(ra);
            fail("visibility can not be null");
        } catch (Exception exc) {
            //THEN
            assertEquals(exc.getMessage(), "visibility can not be null");
        }
    }

    @Test
    public void test_campaign_SetResultVisibility_null() {
        //GIVEN
        Campaign c = new Campaign();
        CampaignResultVisibility ra = null;
        try {
            //WHEN
            c.setResultVisibility(ra);
            fail("resultVisibility can not be nul");
        } catch (Exception exc) {
            //THEN
            assertEquals(exc.getMessage(), "resultVisibility can not be null");
        }
    }
}