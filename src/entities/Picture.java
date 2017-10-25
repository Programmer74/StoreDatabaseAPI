package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Arrays;

@Entity
@Table(name="pictures")
public class Picture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "picture_gen")
    @SequenceGenerator(name = "picture_gen", sequenceName = "pic_seq", allocationSize = 1)
    @Column(name="pic_id", nullable = false, unique = true)
    private Integer picId;

    @Column(name="picture", nullable = false)
    @Lob
    private byte[] picture;

    @Column(name="pic_comment")
    @Lob
    private String picComment;

    public Picture() { }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicComment() {
        return picComment;
    }

    public void setPicComment(String picComment) {
        this.picComment = picComment;
    }

    public Picture(byte[] picture, String picComment) {
        this.picture = picture;
        this.picComment = picComment;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Picture)) return false;

        Picture picture1 = (Picture) o;

        if (!picId.equals(picture1.picId)) return false;
        if (!Arrays.equals(picture, picture1.picture)) return false;
        return picComment != null ? picComment.equals(picture1.picComment) : picture1.picComment == null;
    }

    @Override
    public int hashCode() {
        int result = picId.hashCode();
        result = 31 * result + Arrays.hashCode(picture);
        result = 31 * result + (picComment != null ? picComment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "picId=" + picId +
                ", picture=" + Arrays.toString(picture) +
                ", picComment='" + picComment + '\'' +
                '}';
    }
}
