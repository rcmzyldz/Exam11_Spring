package be.intec.exam11.models;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String subject;
    String content;

    @ManyToMany
    @JoinColumn (name = "recipients")
    List<User> recipients;

    @ManyToOne
    @JoinColumn ( name = "sender_id", nullable = false )
    User sender;


    public void setRecipients(List<User> recipients) {
        this.recipients = recipients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        if (getId() != null ? !getId().equals(message.getId()) : message.getId() != null) return false;
        if (getSubject() != null ? !getSubject().equals(message.getSubject()) : message.getSubject() != null)
            return false;
        if (getContent() != null ? !getContent().equals(message.getContent()) : message.getContent() != null)
            return false;
        if (getRecipients() != null ? !getRecipients().equals(message.getRecipients()) : message.getRecipients() != null)
            return false;
        if (getSender() != null ? !getSender().equals(message.getSender()) : message.getSender() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSubject() != null ? getSubject().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        result = 31 * result + (getRecipients() != null ? getRecipients().hashCode() : 0);
        result = 31 * result + (getSender() != null ? getSender().hashCode() : 0);
        return result;
    }



    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", recipients=" + recipients +
                ", sender=" + sender +
                '}';
    }
}
