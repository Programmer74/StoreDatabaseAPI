package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;

@Entity
@Table(name="pictures")
public class Picture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "picture_gen")
    @SequenceGenerator(name = "picture_gen", sequenceName = "pic_seq", allocationSize = 1)
    @Column(name="pic_id", nullable = false, unique = true)
    private int picId;

    @Column(name="picture", nullable = false)
    private Blob picture;

    @Column(name="pic_comment")
    private Clob picComment;

    public Picture() { }

    public Picture(int id, Blob pic, Clob picComment){
        this.picId = id;
        this.picture = pic;
        this.picComment = picComment;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public Clob getPicComment() {
        return picComment;
    }

    public void setPicComment(Clob picComment) {
        this.picComment = picComment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Picture)) return false;

        Picture picture1 = (Picture) o;

        if (picId != picture1.picId) return false;
        if (picture != null ? !picture.equals(picture1.picture) : picture1.picture != null) return false;
        return picComment != null ? picComment.equals(picture1.picComment) : picture1.picComment == null;
    }

    @Override
    public int hashCode() {
        int result = picId;
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (picComment != null ? picComment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "picId=" + picId +
                ", picture=" + picture +
                ", picComment=" + picComment +
                '}';
    }
}
