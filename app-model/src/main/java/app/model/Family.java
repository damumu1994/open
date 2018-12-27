package app.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: lxb
 * @Date: 2018/12/26 0026
 * @Description:
 */
@Entity
@Data
@Table(name = "sss")
public class Family {
    @Id@GeneratedValue
    private Integer id;
    private String familyName;
    private Date createDate;
}
