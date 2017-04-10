package base.orm;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.internal.util.StringHelper;

/** 
 * @author E-mail: guoleihit@gmail.com
 * @version ：2017年2月5日 下午3:39:31  
 */
public class TableNamingStrategy extends ImprovedNamingStrategy {

    private static final long serialVersionUID = 1L;

    private String tablePrefix;

    private String columnPrefix;

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public void setColumnPrefix(String columnPrefix) {
        this.columnPrefix = columnPrefix;
    }

    @Override
    public String tableName(String tableName) {
        String name = addUnderscores(tableName);
        if (StringUtils.isNotBlank(tablePrefix))
            name = tablePrefix + name;
        return name;
    }

    @Override
    public String propertyToColumnName(String propertyName) {
        String name = addUnderscores(StringHelper.unqualify(propertyName));
        if (StringUtils.isNotBlank(tablePrefix))
            name = columnPrefix + name;
        return name;
    }

    @Override
    public String columnName(String columnName) {
        String name = addUnderscores(columnName);
        if (StringUtils.isNotBlank(tablePrefix))
            name = columnPrefix + name;
        return name;
    }

}

