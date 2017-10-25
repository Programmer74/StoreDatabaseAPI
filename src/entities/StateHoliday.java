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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StateHoliday)) return false;

        StateHoliday holiday = (StateHoliday) o;

        if (!holiday_id.equals(holiday.holiday_id)) return false;
        if (!holiday_date.equals(holiday.holiday_date)) return false;
        return holiday_name != null ? holiday_name.equals(holiday.holiday_name) : holiday.holiday_name == null;
    }

    @Override
    public int hashCode() {
        int result = holiday_id.hashCode();
        result = 31 * result + holiday_date.hashCode();
        result = 31 * result + (holiday_name != null ? holiday_name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StateHoliday{" +
                "holiday_id=" + holiday_id +
                ", holiday_date=" + holiday_date +
                ", holiday_name='" + holiday_name + '\'' +
                '}';
    }
}
