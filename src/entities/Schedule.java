package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sched_gen")
    @SequenceGenerator(name = "sched_gen", sequenceName = "staff_schedule_seq")
    @Column(name = "sched_id", nullable = false, unique = true)
    private Integer schedId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    private Staff staffId;

    @Temporal(TemporalType.DATE)
    @Column(name = "day_off", nullable = false)
    private Date dayOff;

    public Schedule() { }

    public Schedule(Staff staffId, Date dayOff) {
        this.staffId = staffId;
        this.dayOff = dayOff;
    }

    public Integer getSchedId() {
        return schedId;
    }

    public void setSchedId(Integer schedId) {
        this.schedId = schedId;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public Date getDayOff() {
        return dayOff;
    }

    public void setDayOff(Date dayOff) {
        this.dayOff = dayOff;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;

        Schedule schedule = (Schedule) o;

        if (!schedId.equals(schedule.schedId)) return false;
        if (!staffId.equals(schedule.staffId)) return false;
        return dayOff != null ? dayOff.equals(schedule.dayOff) : schedule.dayOff == null;
    }

    @Override
    public int hashCode() {
        int result = schedId.hashCode();
        result = 31 * result + staffId.hashCode();
        result = 31 * result + (dayOff != null ? dayOff.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "schedId=" + schedId +
                ", staffId=" + staffId +
                ", dayOff=" + dayOff +
                '}';
    }
}
