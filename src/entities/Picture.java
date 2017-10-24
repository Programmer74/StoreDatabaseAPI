package entities;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Clob;

@Entity
@Table(name="pictures")
public class Picture implements java.io.Serializable{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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
    public String toString(){
        return (picId + " " + picture + " " + picComment);
    }
}
