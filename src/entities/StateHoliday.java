package entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "state_holidays")
public class StateHoliday implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holiday_gen")
    @SequenceGenerator(name = "holiday_gen", sequenceName = "holidays_seq")
    @Column(name = "holiday_id", unique = true, nullable = false)
    public Integer getHoliday_id() {
        return holiday_id;
    }

    public void setHoliday_id(Integer holiday_id) {
        this.holiday_id = holiday_id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "holiday_date", nullable = false, unique = true)
    public Date getHoliday_date() {
        return holiday_date;
    }

    public void setHoliday_date(Date holiday_date) {
        this.holiday_date = holiday_date;
    }

    @Column(name = "holiday_name")
    public String getHoliday_name() {
        return holiday_name;
    }

    public void setHoliday_name(String holiday_name) {
        this.holiday_name = holiday_name;
    }

    private Integer holiday_id;
    private Date holiday_date;
    private String holiday_name;

    public StateHoliday() {}

    public StateHoliday(int id, Date date, String name){
        this.holiday_id = id;
        this.holiday_date = date;
        this.holiday_name = name;
    }


}
