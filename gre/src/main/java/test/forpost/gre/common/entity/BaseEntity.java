package test.forpost.gre.common.entity;

import java.sql.Timestamp;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    private Timestamp createTimeStamp;

    private Timestamp updateTimeStamp;

    public BaseEntity()
    {
        this.createTimeStamp = new Timestamp(System.currentTimeMillis());
        this.updateTimeStamp = new Timestamp(System.currentTimeMillis());
    }
}
