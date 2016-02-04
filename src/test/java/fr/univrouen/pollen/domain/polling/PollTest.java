package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.social.User;
import fr.univrouen.pollen.domain.uploads.Media;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class PollTest {

    @Test
    public void test_poll_construct_empty() {
        //GIVEN WHEN
        Poll sond = new Poll();
        String titre = "";
        String desc = "";
        //THEN
        assertEquals(sond.getDescription(), desc);
        assertEquals(sond.getTitle(), titre);
        assertNotNull(sond.getCreatedAt());
        assertNotNull(sond.getUpdatedAt());
    }
    @Test
    public void test_poll_construct_author_empty() {
        //GIVEN
        User author = new User();
        String titre = "";
        String desc = "";
        //WHEN
        Poll sond = new Poll(author);
        //THEN
        assertEquals(sond.getAuthor(), author);
        assertEquals(sond.getDescription(), desc);
        assertEquals(sond.getTitle(), titre);
        assertNotNull(sond.getCreatedAt());
        assertNotNull(sond.getUpdatedAt());
    }
    @Test
    public void test_poll_setID_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        long newID = 42;
        //WHEN
        sond.setId(newID);
        boolean processingCampaign = sond.hasProcessingCampaign();
        //THEN
        assertEquals(sond.getId(), newID);

    }
    @Test
    public void test_poll_setID_noCampaign_0() {
        //GIVEN
        Poll sond = new Poll();
        long newID = 0;

        try {
            //WHEN
            sond.setId(newID);
            fail("Id can not be negative or 0");
        } catch (IllegalArgumentException exc) {
            //THEN
            assertEquals(exc.getMessage(), "Id can not be negative or 0");
        }


    }
    @Test
    public void test_poll_setID_noCampaign_negative() {
        //GIVEN
        Poll sond = new Poll();
        long newID = -54;

        try {
            //WHEN
            sond.setId(newID);
            fail("Id can not be negative or 0");
        } catch (IllegalArgumentException exc) {
            //THEN
            assertEquals(exc.getMessage(), "Id can not be negative or 0");
        }
    }
    @Test
    public void test_poll_setTitle_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        String newTitle = "Tests";
        //WHEN
        sond.setTitle(newTitle);
        boolean processingCampaign = sond.hasProcessingCampaign();
        //THEN
        assertEquals(sond.getTitle(), newTitle);

    }
    @Test
    public void test_poll_setDesc_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        String newDesc = "Des";
        //WHEN
        sond.setDescription(newDesc);
        boolean processingCampaign = sond.hasProcessingCampaign();
        //THEN
        assertEquals(sond.getDescription(), newDesc);

    }
    @Test
    public void test_poll_allowCom_true_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        boolean com = true;
        //WHEN
        sond.setAllowComment(com);
        //THEN
        assertEquals(sond.isAllowComment(), com);
    }
    @Test
    public void test_poll_allowCom_false_noCampaign() {
        //GIVEN WHEN
        Poll sond = new Poll();
        //THEN
        assertEquals(sond.isAllowComment(), false);
    }
    @Test
    public void test_poll_setUpdate_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        long actualTime = new Date().getTime();
        //WHEN
        sond.setUpdatedAt(new Timestamp(actualTime));
        //THEN
        assertEquals(sond.getUpdatedAt(), new Timestamp(actualTime));
    }
    @Test
    public void test_poll_setCreate_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        long actualTime = new Date().getTime();
        //WHEN
        sond.setCreatedAt(new Timestamp(actualTime));
        //THEN
        assertEquals(sond.getCreatedAt(), new Timestamp(actualTime));
    }
    @Test
    public void test_poll_setWebsite_exception_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        String url = "Blajefe.monsite.fr";
        //WHEN

        //THEN
        try {
            sond.setWebsite(url);
            fail("Website URL should be correct to the pattern.");
        } catch (IllegalArgumentException expected) {
             assertEquals("Website URL should be correct to the pattern.", expected.getMessage());
        }

    }
    @Test
    public void test_poll_setWebsite_noCampaign1() {
        //GIVEN
        Poll sond = new Poll();
        String url = "http://www.monsite.fr";
        //WHEN
        sond.setWebsite(url);
        //THEN
        assertEquals(sond.getWebsite(), url);
        /*try {
            sond.setWebsite(url);
            fail("Website URL should be correct to the pattern.");
        } catch (IllegalArgumentException expected) {
            assertEquals("Website URL should be correct to the pattern.", expected.getMessage());
        }*/

    }
    @Test
    public void test_poll_setWebsite_noCampaign2() {
        //GIVEN
        Poll sond = new Poll();
        String url = "http://aaaaaaaaaa";
        //WHEN
        //sond.setWebsite(url);
        //THEN
        //assertEquals(sond.getWebsite(), url);
        try {
            sond.setWebsite(url);
            fail("Website URL should be correct to the pattern.");
        } catch (IllegalArgumentException expected) {
            assertEquals("Website URL should be correct to the pattern.", expected.getMessage());
        }

    }
    @Test
    public void test_poll_setWebsite_noCampaign3() {
        //GIVEN
        Poll sond = new Poll();
        String url = "https://www.google.fr/search?client=ubuntu";
        //WHEN
        sond.setWebsite(url);
        //THEN
        assertEquals(sond.getWebsite(), url);
        /*try {
            sond.setWebsite(url);
            fail("Website URL should be correct to the pattern.");
        } catch (IllegalArgumentException expected) {
            assertEquals("Website URL should be correct to the pattern.", expected.getMessage());
        }*/
    }
    @Test
    public void test_poll_setWebsite_noCampaign4() {
        //GIVEN
        Poll sond = new Poll();
        String url = "http://communaute-universitaire.univ-rouen.fr/";
        //WHEN
        sond.setWebsite(url);
        //THEN
        assertEquals(sond.getWebsite(), url);
        /*try {
            sond.setWebsite(url);
            fail("Website URL should be correct to the pattern.");
        } catch (IllegalArgumentException expected) {
            assertEquals("Website URL should be correct to the pattern.", expected.getMessage());
        }*/

    }
    @Test
    public void test_poll_setMedia_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        Media m = new Media();
        //WHEN
        sond.setMedia(m);
        //THEN
        assertEquals(sond.getMedia(), m);
    }
    @Test
    public void test_poll_setCampaign_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        List<Campaign> campList = new ArrayList<Campaign>();
        //WHEN
        sond.setCampaigns(campList);
        //THEN
        assertEquals(sond.getCampaigns(), campList);
    }
    @Test
    public void test_poll_setQuestions_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        List<Question> questList = new ArrayList<Question>();
        //WHEN
        sond.setQuestions(questList);
        //THEN
        assertEquals(sond.getQuestions(), questList);
    }
    @Test
    public void test_poll_setComments_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        List<Comment> commentList = new ArrayList<Comment>();
        //WHEN
        sond.setComments(commentList);
        //THEN
        assertEquals(sond.getComments(), commentList );
    }
    @Test
    public void test_poll_setClassification_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        ClassificationCategory cc = ClassificationCategory.MUSIC;
        //WHEN
        sond.setClassification(cc);
        //THEN
        assertEquals(sond.getClassification(), cc );
    }
    @Ignore
    @Test
    public void test_poll_setCampaigns_checkIDs() {

    }
    @Test
    public void test_poll_setQuestions_checkIDs() {
        //GIVEN
        Poll sond = new Poll();
        Question q1 = new Question();
        q1.setId(1);
        Question q2 = new Question();
        q2.setId(2);
        Question q3 = new Question();
        q3.setId(3);
        List<Question> lqs = new ArrayList<Question>();
        lqs.add(q1);
        lqs.add(q2);
        lqs.add(q3);
        //WHEN
        sond.setQuestions(lqs);
        //THEN
        assertEquals(sond.getQuestions().get(0).getId(), 1);
        assertEquals(sond.getQuestions().get(1).getId(), 2);
        assertEquals(sond.getQuestions().get(2).getId(), 3);
    }
    @Ignore
    @Test
    public void test_poll_setComments_checkIDs() {

    }



    /* Active campaign */
    @Test
    public void test_poll_setID_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        int newID = 42;
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime()+ 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setId(newID);
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }
    @Test
    public void test_poll_setTitle_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        String newTitle = "Tests";
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setTitle(newTitle);
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }
    @Test
    public void test_poll_setDesc_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        String newDesc = "Des";
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setDescription(newDesc);
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }

    }
    @Test
    public void test_poll_allowCom_true_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        boolean com = true;
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setAllowComment(com);
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }
    @Test
    public void test_poll_setUpdate_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        long actualTime = new Date().getTime();
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setUpdatedAt(new Timestamp(actualTime));
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }
    @Test
    public void test_poll_setCreate_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        long actualTime = new Date().getTime();
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setCreatedAt(new Timestamp(actualTime));
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }
    @Test
    public void test_poll_setWebsite_exception_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        String url = "Blajefe.monsite.fr";
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setWebsite(url);
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }

    }
    @Test
    public void test_poll_setMedia_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        Media m = new Media();
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setMedia(m);
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }
    @Test
    public void test_poll_setComments_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        List<Comment> commentList = new ArrayList<Comment>();
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setComments(commentList);
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }
    @Test
    public void test_poll_setQuestions_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        List<Question> questList = new ArrayList<Question>();
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setQuestions(questList);
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }
    @Test
    public void test_poll_setCampaign_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        List<Campaign> campList = new ArrayList<Campaign>();
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setCampaigns(campList);
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }
    @Test
    public void test_poll_setClassification_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        ClassificationCategory cc = ClassificationCategory.MUSIC;
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setClassification(cc);
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }

    /* Tests CDR */
    @Test
    public void test_poll_with_ordo_questions() {
        //GIVEN
        Poll sond = new Poll();
        Question q1 = new Question();
        q1.setId(1);
        q1.setOrderNumber(1);
        Question q2 = new Question();
        q2.setId(2);
        q2.setOrderNumber(2);
        List<Question> quests = new ArrayList<Question>();
        quests.add(q1);
        quests.add(q2);
        //WHEN
        sond.setQuestions(quests);
        //THEN
        assertEquals(sond.getQuestions().get(0).getOrderNumber(), 1);
        assertEquals(sond.getQuestions().get(1).getOrderNumber(), 2);
    }
    @Test
    public void test_poll_visible_poll() {
        //GIVEN
        Poll sond = new Poll();
        Campaign c = new Campaign();
        c.setVisibility(CampaignVisibility.PUBLIC);
        List<Campaign> camps = new ArrayList<Campaign>();
        camps.add(c);
        //WHEN
        sond.setCampaigns(camps);
        //THEN
        assertEquals(sond.getCampaigns().get(0).getVisibility(), CampaignVisibility.PUBLIC);
    }

    @Test
    public void test_poll_setKeywords_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        String key1 = "test";
        String key2 = "test2";
        List<String> keys = new ArrayList<String>();
        keys.add(key1);
        keys.add(key2);
        //WHEN
        sond.setKeywords(keys);
        //THEN
        assertEquals(keys.get(0), key1);
        assertEquals(keys.get(1), key2);
        assertEquals(keys.size(), 2);
    }
    @Test
    public void test_poll_setKeywords_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        String key1 = "test";
        String key2 = "test2";
        List<String> keys = new ArrayList<String>();
        keys.add(key1);
        keys.add(key2);
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.setKeywords(keys);
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }
    @Test
    public void test_poll_addKeywords_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        String key1 = "test";
        String key2 = "test2";
        List<String> keys = new ArrayList<String>();
        keys.add(key1);
        keys.add(key2);
        sond.setKeywords(keys);
        //WHEN
        sond.addKeyword("key3");
        //THEN
        assertEquals(keys.get(0), key1);
        assertEquals(keys.get(1), key2);
        assertEquals(keys.get(2), "key3");
        assertEquals(keys.size(), 3);
    }
    @Test
    public void test_poll_addKeywords_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        String key1 = "test";
        String key2 = "test2";
        List<String> keys = new ArrayList<String>();
        keys.add(key1);
        keys.add(key2);
        sond.setKeywords(keys);
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.addKeyword("key3");
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }
    @Test
    public void test_poll_removeKey_noCampaign() {
        //GIVEN
        Poll sond = new Poll();
        String key1 = "test";
        String key2 = "test2";
        List<String> keys = new ArrayList<String>();
        keys.add(key1);
        keys.add(key2);
        sond.setKeywords(keys);
        //WHEN
        sond.removeKeyword("test");
        //THEN
        assertEquals(keys.get(0), key2);
        assertEquals(keys.size(), 1);
    }
    @Test
    public void test_poll_removeKey_Campaign() {
        //GIVEN
        Poll sond = new Poll();
        String key1 = "test";
        String key2 = "test2";
        List<String> keys = new ArrayList<String>();
        keys.add(key1);
        keys.add(key2);
        sond.setKeywords(keys);
        //WHEN
        Campaign c = new Campaign();
        c.setStartingAt(new Timestamp(new Date().getTime()));
        c.setEndingAt(new Timestamp(new Date().getTime() + 10000));
        List<Campaign> lcamps = new ArrayList<Campaign>();
        lcamps.add(c);
        sond.setCampaigns(lcamps);
        //THEN
        try {
            sond.removeKeyword("test");
            fail("A campaign is processing.");
        } catch (IllegalArgumentException expected) {
            assertEquals("A campaign is processing.", expected.getMessage());
        }
    }


    /*
    @Test
    public void test() {
        //GIVEN
        Poll sond = new Poll();
        //WHEN

        //THEN
    }

    */
}
