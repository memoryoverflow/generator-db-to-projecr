package cn.lyj.generator.core.parser;

import cn.lyj.generator.common.enums.ColumnType;
import cn.lyj.generator.common.enums.ConstVal;
import cn.lyj.generator.common.enums.DdlSql;
import cn.lyj.generator.common.enums.StringPools;
import cn.lyj.generator.common.utils.StringUtil;
import cn.lyj.generator.core.entity.GlobConfig;
import cn.lyj.generator.core.entity.table.Field;
import cn.lyj.generator.core.entity.table.LTable;
import cn.lyj.generator.core.globConfig.Configuration;
import cn.lyj.generator.core.service.dbService.DataBaseExcute;
import cn.lyj.generator.core.service.dbService.LJdbc;
import cn.lyj.generator.core.velocity.LVelocityEngine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 解析表
 * </p>
 *
 * @author 永健
 * @since 2019-11-06 10:43
 */
public class TableParser extends Parser
{
    private LJdbc lJdbc;

    @Override
    protected LJdbc jdbc()
    {
        return lJdbc;
    }

    public TableParser(LJdbc lJdbc)
    {
        this.lJdbc = lJdbc;
    }

    @Override
    public List<LTable> parser(GlobConfig globConfig) throws Exception
    {

        // 所有的表
        DataBaseExcute dataBaseExcute = new DataBaseExcute(lJdbc);
        List<LTable> tables = dataBaseExcute.getTables();

        List<LTable> filterTable = new ArrayList<>();

        String[] tableNames = globConfig.getIncludeTableName();

        for (int i = 0; i < tables.size(); i++)
        {
            for (String tableName : tableNames)
            {
                if (tableName.equals(tables.get(i).getTableName()))
                {
                    filterTable.add(tables.get(i));
                }
            }
        }

        for (LTable table : filterTable)
        {
            // 表字段
            ResultSet resultSet = jdbc().executeQuery(String.format(DdlSql.SHOW_COLUM.getDdlSql(), table.getTableName()));
            // 解析表
            installFields(resultSet, table, globConfig.isHump(), globConfig.isLombok());
        }

        return filterTable;


    }

    private void installFields(ResultSet resultSet, LTable table, boolean isHump, boolean lombok) throws SQLException
    {
        List<Field> fields = new ArrayList<>();
        while (resultSet.next())
        {

            String colunmName = resultSet.getString(StringPools.FIELD);
            String fieldName = colunmName;
            String jdbcType = subColumType(resultSet.getString(StringPools.COLUMN_TYPE));
            String javaType = ColumnType.getJavaType(jdbcType);
            boolean pri = false;
            if (ConstVal.COLUMN_PK_val.equals(resultSet.getString(StringPools.COLUMN_PK)))
            {
                pri = true;
            }

            boolean auto = false;
            if (ConstVal.COLUMN_PK_AUTO.equals(resultSet.getString(StringPools.IS_AUTOINCREMENT)))
            {
                auto = true;
            }
            String comment = resultSet.getString(StringPools.COMMENT);

            String setName = "";
            String getName = "";
            // 属性 驼峰转换
            if (isHump)
            {
                fieldName = StringUtil.lineToHump(colunmName);
            }

            if (!lombok)
            {
                // 开启驼峰
                if (isHump)
                {
                    setName = "set" + StringUtil.firstUp(StringUtil.lineToHump(colunmName));
                    getName = "get" + StringUtil.firstUp(StringUtil.lineToHump(colunmName));
                }
                else
                {
                    setName = "set" + StringUtil.firstUp(colunmName);
                    getName = "get" + StringUtil.firstUp(colunmName);
                }
            }


            fields.add(new Field().setName(fieldName)
                    .setJdbcType(jdbcType)
                    .setPrimaryKey(pri)
                    .setAuto(auto)
                    .setComment(comment)
                    .setJavaType(javaType)
                    .setColumn(colunmName)
                    .setSetName(setName)
                    .setGetName(getName));
        }
        table.setFields(fields);
    }

    private String subColumType(String type)
    {
        return type.substring(0, type.indexOf("(") == -1 ? type.length() : type.indexOf("("));
    }
}
