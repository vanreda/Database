package fr.univrouen.pollen.domain.polling;

import fr.univrouen.pollen.domain.social.User;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class CommentTest {

    @Test
    public void test_construct_no_param() {
        // GIVEN
        // WHEN
        Comment comment = new Comment();
        // THEN
        assertNotEquals(null, comment.getId());
        assertEquals(null, comment.getPostedAt());
        assertNotEquals(null, comment.getUpdatedAt());
        assertEquals(null, comment.getCommentText());
        assertEquals(null, comment.getAuthor());
    }

    @Test
    public void test_construct_author_is_null_throw_exception() {
        // GIVEN
        final User author = null;
        final String commentText = "Comment";
        // WHEN/THEN
        try {
            Comment comment = new Comment(author, commentText);
            fail("Should throw exception when author is null.");
        }catch(IllegalArgumentException aExp){
            assert(aExp.getMessage().contains("Author and comment should not be null."));
        }
    }

    @Test
    public void test_construct_comment_is_null_throw_exception() {
        // GIVEN
        final User author = new User();
        final String commentText = null;
        // WHEN/THEN
        try {
            Comment comment = new Comment(author, commentText);
            fail("Should throw exception when author is null.");
        }catch(IllegalArgumentException aExp){
            assert(aExp.getMessage().contains("Author and comment should not be null."));
        }
    }

    @Test
    public void test_construct_with_correct_param() {
        // GIVEN
        final User author = new User();
        final String commentText = "Comment";
        final Timestamp currentTime = new Timestamp(new Date().getTime());
        // WHEN
        Comment comment = new Comment(author, commentText);
        // THEN
        assertEquals(author, comment.getAuthor());
        assertEquals(commentText, comment.getCommentText());
        assertNotEquals(null, comment.getPostedAt());
        assertNotEquals(null, comment.getUpdatedAt());
        assertEquals(currentTime, comment.getUpdatedAt());
        assertEquals(currentTime, comment.getPostedAt());
    }

    @Test
    public void test_setId() {
        // GIVEN
        final long id = 42L;
        final Comment comment = new Comment();
        // WHEN
        comment.setId(id);
        // THEN
        assertEquals(id, comment.getId());
    }

    @Test
    public void test_setPostedAt_date_is_null_throw_exception() {
        // GIVEN
        final Timestamp currentTime = null;
        final Comment comment = new Comment();
        // WHEN/THEN
        try {
            comment.setPostedAt(currentTime);
            fail("Should throw exception when postedAt is null.");
        } catch(IllegalArgumentException aExp) {
            assert(aExp.getMessage().contains("Date should not be null."));
        }
    }

    @Test
    public void test_setPostedAt() {
        // GIVEN
        final Timestamp currentTime = new Timestamp(new Date().getTime());
        final Comment comment = new Comment();
        // WHEN
        comment.setPostedAt(currentTime);
        // THEN
        assertEquals(currentTime, comment.getPostedAt());
    }

    @Test
    public void test_setUpdatedAt_date_is_null_throw_exception() {
        // GIVEN
        final Timestamp currentTime = null;
        final Comment comment = new Comment();
        // WHEN/THEN
        try {
            comment.setUpdatedAt(currentTime);
            fail("Should throw exception when updatedAt is null.");
        } catch(IllegalArgumentException aExp) {
            assert(aExp.getMessage().contains("Date should not be null."));
        }
    }

    @Test
    public void test_setUpdatedAt() {
        // GIVEN
        final Timestamp currentTime = new Timestamp(new Date().getTime());
        final Comment comment = new Comment();
        // WHEN
        comment.setUpdatedAt(currentTime);
        // THEN
        assertEquals(currentTime, comment.getUpdatedAt());
    }

    @Test
    public void test_setCommentText_commentText_is_null_throw_exception() {
        // GIVEN
        final String commentText = null;
        final Comment comment = new Comment();
        // WHEN/THEN
        try {
            comment.setCommentText(commentText);
            fail("Should throw exception when commentText is null.");
        } catch(IllegalArgumentException aExp) {
            assert(aExp.getMessage().contains("Comment should not be null."));
        }
    }

    @Test
    public void test_setCommentText() {
        // GIVEN
        final String commentText = "Comment";
        final Comment comment = new Comment();
        final Timestamp currentTime = new Timestamp(new Date().getTime());
        // WHEN
        comment.setCommentText(commentText);
        // THEN
        assertEquals(commentText, comment.getCommentText());
        assertEquals(currentTime, comment.getUpdatedAt());
    }

    @Test
    public void test_setAuthor_author_is_null_throw_exception() {
        // GIVEN
        final User author = null;
        final Comment comment = new Comment();
        // WHEN/THEN
        try {
            comment.setAuthor(author);
            fail("Should throw exception when author is null.");
        } catch(IllegalArgumentException aExp) {
            assert(aExp.getMessage().contains("Author should not be null."));
        }
    }

    @Test
    public void test_setAuthor() {
        // GIVEN
        final User author = new User();
        final Comment comment = new Comment();
        // WHEN
        comment.setAuthor(author);
        // THEN
        assertEquals(author, comment.getAuthor());
    }
}
