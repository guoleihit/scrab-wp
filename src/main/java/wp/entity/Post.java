package wp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import base.entity.UUIDEntity;

@Entity
@Table(name = Post.NAME)
public class Post extends UUIDEntity {
    private static final long serialVersionUID = 1L;
    public static final String NAME = "wp-post";

    private Date postDate;

    private String title;

    private String abstractMessage;

    private String messageBody;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Column(length = 64)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(length = 512)
    public String getAbstractMessage() {
        return abstractMessage;
    }

    public void setAbstractMessage(String abstractMessage) {
        this.abstractMessage = abstractMessage;
    }

    @Column(length = 1024)
    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
