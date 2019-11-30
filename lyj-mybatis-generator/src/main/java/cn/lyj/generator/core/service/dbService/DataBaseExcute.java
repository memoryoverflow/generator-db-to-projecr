package cn.lyj.generator.core.service.dbService;

import cn.lyj.generator.common.cache.Cache;
import cn.lyj.generator.common.enums.StringPools;
import cn.lyj.generator.common.utils.ServletUtils;
import cn.lyj.generator.common.utils.StringUtil;
import cn.lyj.generator.core.entity.DbPropertis;
import cn.lyj.generator.core.entity.table.LTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-06 00:25
 */
public class DataBaseExcute extends DataBaseService
{
    private static Logger logger = LoggerFactory.getLogger(DataBaseExcute.class);


    private LJdbc jdbc;

    public DataBaseExcute(LJdbc jdbc)
    {
        this.jdbc = jdbc;
    }

    @Override
    public List<LTable> getTables() throws SQLException
    {

        logger.info("######################");
        logger.info("##  读取数据库中的所有表...");

        List<LTable> tables = new ArrayList<>();

        ResultSet resultSet = jdbc.getConnection().getMetaData().getTables(jdbc.getDbPropertis().getDbName(), null, null, new String[]{"TABLE", "VIEW"});
        while (resultSet.next())
        {
            LTable table = new LTable();
            table.setComment(resultSet.getString(StringPools.TABLE_REMARKS));
            table.setTableName(resultSet.getString(StringPools.TABLE_NAME));
            tables.add(table);
        }
        logger.info("##  读取完成！");
        logger.info("######################");
        logger.info("");
        return tables;
    }

    @Override
    public List<String> getTableNames() throws SQLException
    {
        List<LTable> tables = getTables();
        List<String> list = new ArrayList<>();
        tables.forEach(table -> {
            list.add(table.getTableName());
        });
        return list;
    }


}
