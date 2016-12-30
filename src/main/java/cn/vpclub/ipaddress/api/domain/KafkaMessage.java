package cn.vpclub.ipaddress.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Fred on 2016/10/14.
 */
public class KafkaMessage implements Serializable {

    private int index;
    private String title;
    private String content;
    private Date timestamp;

    public KafkaMessage() {
        timestamp = new Date();
    }

    public KafkaMessage(int index, String title) {
        this();
        this.index = index;
        this.title = index + "Title="+title;
        this.content = index + "Content="+this.content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        KafkaMessage other = (KafkaMessage) obj;
        if (this.title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!this.title.equals(other.title)) {
            return false;
        }
        return true;
    }

}