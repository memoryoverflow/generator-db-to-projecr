package cn.lyj.generator.core.parser;

import cn.lyj.generator.core.entity.GlobConfig;
import cn.lyj.generator.core.entity.table.LTable;
import cn.lyj.generator.core.service.dbService.LJdbc;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-06 10:43
 */
public abstract class Parser
{
    protected abstract LJdbc jdbc();

    public abstract List<LTable> parser(GlobConfig globConfig) throws Exception;
}
