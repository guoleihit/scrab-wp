/**
 * 
 */
package base.entity;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/** 
 * @author E-mail: guoleihit@gmail.com
 * @version ：2017年2月2日 下午3:01:11  
 */
public class UUIDEntityListener {
    @PrePersist
    public void prePersist(UUIDEntity entity) {
        entity.setCreateTime(new Date());
        entity.setModifyTime(new Date());
    }

    @PreUpdate
    public void preUpdate(UUIDEntity entity) {
        entity.setModifyTime(new Date());
    }

}