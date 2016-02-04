package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.analyse.Polarity;
import fr.univrouen.pollen.domain.social.User;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class AnswerTest {

    @Test
    public void test_answer_setid() {
        //GIVEN
        Answer a = new Answer();
        long id = 512;
        //WHEN
        a.setId(id);
        //THEN
        assertEquals(a.getId(), id);
    }

    @Test
    public void test_answer_setid_neg() {
        //GIVEN
        Answer a = new Answer();
        long id = -2;
        try {
            //WHEN
            a.setId(id);
            fail("Id can not be negative or 0");
        } catch (IllegalArgumentException exc) {
            //THEN
            assertEquals(exc.getMessage(), "Id can not be negative or 0");
        }
    }

    @Test
    public void test_answer_setid_0() {
        //GIVEN
        Answer a = new Answer();
        long id = 0;
        try {
            //WHEN
            a.setId(id);
            fail("Id can not be negative or 0");
        } catch (IllegalArgumentException exc) {
            //THEN
            assertEquals(exc.getMessage(), "Id can not be negative or 0");
        }
    }

    @Test
    public void test_answer_setPostedAt() {
        //GIVEN
        Answer a = new Answer();
        long actualTime = new Date().getTime();
        //WHEN
        a.setPostedAt(new Timestamp(actualTime));
        //THEN
        assertEquals(a.getPostedAt(), new Timestamp(actualTime));
    }

    @Test
    public void test_answer_setUpdatedAt() {
        //GIVEN
        Answer a = new Answer();
        long actualTime = new Date().getTime();
        //WHEN
        a.setUpdatedAt(new Timestamp(actualTime));
        //THEN
        assertEquals(a.getUpdatedAt(), new Timestamp(actualTime));
    }

    @Ignore
    @Test
    public void test_answer_setMedia() {

    }

    @Test
    public void test_answer_setPolarity() {
        //GIVEN
        Answer a = new Answer();
        Polarity p = Polarity.NEUTRAL;
        //WHEN
        a.setPolarity(p);
        //THEN
        assertEquals(a.getPolarity(), p);
    }

    @Test
    public void test_answer_setQuestion() {
        //GIVEN
        Answer a = new Answer();
        Question q = new Question();
        //WHEN
        a.setQuestion(q);
        //THEN
        assertEquals(a.getQuestion(), q);
    }

    @Test
    public void test_answer_setQuestion_null() {
        //GIVEN
        Answer a = new Answer();
        Question q = null;
        try {
            //WHEN
            a.setQuestion(q);
            fail("Question should not be null.");
        } catch (Exception exc) {
            //THEN
            assertEquals(exc.getMessage(), "Question should not be null.");
        }
    }

    @Test
    public void test_answer_setUser() {
        //GIVEN
        Answer a = new Answer();
        User u = new User();
        //WHEN
        a.setUser(u);
        //THEN
        assertEquals(a.getUser(), u);
    }

    @Test
    public void test_answer_setUser_null() {
        //GIVEN
        Answer a = new Answer();
        User u = null;
        try {
            //WHEN
            a.setUser(u);
            fail("User should not be null.");
        } catch (IllegalArgumentException exc) {
            //THEN
            assertEquals(exc.getMessage(), "User should not be null.");
        }
    }

    @Test
    public void test_answer_setText() {
        //GIVEN
        Answer a = new Answer();
        String text = "blabla";
        //WHEN
        a.setText(text);
        //THEN
        assertEquals(a.getText(), text);
    }

    @Test
    public void test_answer_setChoices() {
        //GIVEN
        Answer a = new Answer();
        List<ProposedChoice> lp = new ArrayList<ProposedChoice>();
        ProposedChoice p = new ProposedChoice();
        lp.add(p);
        //WHEN
        a.setChoices(lp);
        //THEN
        assertEquals(a.getChoices(), lp);
    }

    @Test
    public void test_answer_setCampaign() {
        //GIVEN
        Answer a = new Answer();
        Campaign c = new Campaign();
        long time = new Date().getTime();
        c.setStartingAt(new Timestamp(time));
        c.setEndingAt(new Timestamp(time+500));
        //WHEN
        a.setCampaign(c);
        //THEN
        assertEquals(a.getCampaign(), c);
        assertEquals(a.getCampaign().getEndingAt(),new Timestamp(time+500));
        assertEquals(a.getCampaign().getStartingAt(),new Timestamp(time));
    }

    @Test
    public void test_answer_setCampaign_null() {
        //GIVEN
        Answer a = new Answer();
        Campaign c = null;
        //WHEN
        try {
            a.setCampaign(c);
            fail("Campaign should not be null.");
        } catch (Exception exc) {
            assertEquals(exc.getMessage(), "Campaign should not be null.");
        }
        //THEN
    }

    @Ignore
    @Test
    public void test_answer_setComments() {

    }

    @Ignore
    @Test
    public void test_answer_addComment() {

    }

    @Ignore
    @Test
    public void test_answer_deleteComment() {

    }
}