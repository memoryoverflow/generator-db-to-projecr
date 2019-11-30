package cn.lyj.generator.core.service.dbService;

import cn.lyj.generator.core.entity.table.LTable;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-06 00:23
 */
public abstract class DataBaseService
{
    public abstract List<LTable> getTables() throws SQLException;
    public abstract List<String> getTableNames() throws SQLException;
}
