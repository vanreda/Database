package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.uploads.Media;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class QuestionTest {

    @Test
    public void test_question_setId() {
        //GIVEN
        Question q = new Question();
        long id = 512;
        //WHEN
        q.setId(id);
        //THEN
        assertEquals(q.getId(), id);
    }

    @Test
    public void test_question_setId_negative() {
        //GIVEN
        Question q = new Question();
        long id = -2;
        try {
            //WHEN
            q.setId(id);
            fail("Id can not be negative or 0");
        } catch (IllegalArgumentException exc) {
            //THEN
            assertEquals(exc.getMessage(), "Id can not be negative or 0");
        }
    }

    @Test
    public void test_question_setId_0() {
        //GIVEN
        Question q = new Question();
        long id = 0;
        try {
            //WHEN
            q.setId(id);
            fail("Id can not be negative or 0");
        } catch (IllegalArgumentException exc) {
            //THEN
            assertEquals(exc.getMessage(), "Id can not be negative or 0");
        }
    }

    @Test
    public void test_question_setAllowNoAnswer_false() {
        //GIVEN
        Question q = new Question();
        boolean allow = false;
        //WHEN
        q.setAllowNoAnswer(allow);
        //THEN
        assertEquals(q.isAllowNoAnswer(), allow);
    }

    @Test
    public void test_question_setAllowNoAnswer_true() {
        //GIVEN
        Question q = new Question();
        boolean allow = true;
        //WHEN
        q.setAllowNoAnswer(allow);
        //THEN
        assertEquals(q.isAllowNoAnswer(), allow);
    }

    @Test
    public void test_question_setType() {
        //GIVEN
        Question q = new Question();
        QuestionType qt = QuestionType.SIMPLE_CHOICE;
        //WHEN
        q.setType(qt);
        //THEN
        assertEquals(q.getType(), qt);
    }

    @Test
    public void test_question_setOrderNumber_negative() {
        //GIVEN
        Question q = new Question();
        int order = -54;

        try {
            //WHEN
            q.setOrderNumber(order);
            fail("order number can not be negative or 0");
        } catch (IllegalArgumentException exc) {
            //THEN
            assertEquals(exc.getMessage(), "order number can not be negative or 0");
        }
    }

    @Test
    public void test_question_setOrderNumber_0() {
        //GIVEN
        Question q = new Question();
        int order = 0;

        try {
            //WHEN
            q.setOrderNumber(order);
            fail("order number can not be negative or 0");
        } catch (IllegalArgumentException exc) {
            //THEN
            assertEquals(exc.getMessage(), "order number can not be negative or 0");
        }
    }

    @Test
    public void test_question_setOrderNumber() {
        //GIVEN
        Question q = new Question();
        int order = 54;
        //WHEN
        q.setOrderNumber(order);
        //THEN
        assertEquals(q.getOrderNumber(), order);
    }

    @Test
    public void test_question_setAnswers() {
        //GIVEN
        Question q = new Question();
        List<Answer> lAns = new ArrayList<Answer>();
        //WHEN
        q.setAnswers(lAns);
        //THEN
        assertEquals(q.getAnswers(),lAns);
    }

    @Test
    public void test_question_setProposedChoices() {
        //GIVEN
        Question q = new Question();
        List<ProposedChoice> lprop = new ArrayList<ProposedChoice>();
        //WHEN
        q.setProposedChoices(lprop);
        //THEN
        assertEquals(q.getProposedChoices(), lprop);
    }

    @Test
    public void test_question_setConditions() {
        //GIVEN
        Question q = new Question();
        List<QuestionCondition> lcond = new ArrayList<QuestionCondition>();
        //WHEN
        q.setConditions(lcond);
        //THEN
        assertEquals(q.getConditions(), lcond);
    }

    @Ignore
    @Test
    public void test_question_deleteAnswer() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Ignore
    @Test
    public void test_question_addProposedChoices() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Ignore
    @Test
    public void test_question_deleteProposedChoice() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Ignore
    @Test
    public void test_question_addComment() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Ignore
    @Test
    public void test_question_deleteComment() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    public void test_question_setText() {
        //GIVEN
        Question q = new Question();
        String text = "Blabla";
        //WHEN
        q.setText(text);
        //THEN
        assertEquals(q.getText(), text);
    }

    @Test
    public void test_question_setMedia() {
        //GIVEN
        Question q = new Question();
        Media m = new Media();
        //WHEN
        q.setMedia(m);
        //THEN
        assertEquals(q.getMedia(), m);
    }

    @Test
    public void test_question_setAllowAddAnswer_true() {
        //GIVEN
        Question q = new Question();
        boolean b = true;
        //WHEN
        q.setAllowAddAnswer(b);
        //THEN
        assertEquals(q.isAllowAddAnswer(), b);
    }

    @Test
    public void test_question_setAllowAddAnswer_false() {
        //GIVEN
        Question q = new Question();
        boolean b = false;
        //WHEN
        q.setAllowAddAnswer(b);
        //THEN
        assertEquals(q.isAllowAddAnswer(), b);
    }

    @Test
    public void test_question_setPoll() {
        //GIVEN
        Question q = new Question();
        Poll p = new Poll();
        //WHEN
        q.setPoll(p);
        //THEN
        assertEquals(q.getPoll(), p);
    }

    @Test
    public void test_question_questionUniqueChoice() {
        //GIVEN
        Poll sond = new Poll();
        Question q = new Question();
        q.setType(QuestionType.SIMPLE_CHOICE);
        List<Question> lq = new ArrayList<Question>();
        lq.add(q);
        //WHEN
        sond.setQuestions(lq);
        //THEN
        assertNotNull(sond.getQuestions());
        assertNotNull(sond.getQuestions().get(0));
        assertEquals(sond.getQuestions().get(0).getType(), QuestionType.SIMPLE_CHOICE);
    }

    @Test
    public void test_question_questionMultiChoice() {
        //GIVEN
        Poll sond = new Poll();
        Question q = new Question();
        q.setType(QuestionType.MULTIPLE_CHOICE);
        List<Question> lq = new ArrayList<Question>();
        lq.add(q);
        //WHEN
        sond.setQuestions(lq);
        //THEN
        assertNotNull(sond.getQuestions());
        assertNotNull(sond.getQuestions().get(0));
        assertEquals(sond.getQuestions().get(0).getType(), QuestionType.MULTIPLE_CHOICE);
    }
}