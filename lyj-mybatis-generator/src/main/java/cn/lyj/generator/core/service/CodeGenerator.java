package cn.lyj.generator.core.service;

import cn.lyj.generator.core.entity.DbPropertis;
import cn.lyj.generator.core.entity.GlobConfig;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-06 00:11
 */
public interface CodeGenerator
{
    void createProject(GlobConfig globConfig, DbPropertis dbPropertis);

    void createTemplate(GlobConfig globConfig, DbPropertis dbPropertis);
}
