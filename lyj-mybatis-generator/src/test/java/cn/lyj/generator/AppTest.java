package cn.lyj.generator;

import cn.lyj.generator.core.entity.DbPropertis;
import cn.lyj.generator.core.entity.GlobConfig;
import cn.lyj.generator.core.entity.table.LTable;
import cn.lyj.generator.core.globConfig.Configuration;
import cn.lyj.generator.core.globConfig.Project;
import cn.lyj.generator.core.parser.TableParser;
import cn.lyj.generator.core.service.dbService.LJdbc;
import cn.lyj.generator.core.service.project.ProjectService;
import cn.lyj.generator.core.velocity.LVelocityEngine;
import org.junit.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws Exception
    {
        assertTrue(true);

        // 数据库参数配置
        DbPropertis dbPropertis = new DbPropertis("teaching_sys", "root", "qxb123", "www.qxb360.cn", 3306);

        // 连接数据库
        LJdbc lJdbc = new LJdbc(dbPropertis);

        // 项目参数配置
        GlobConfig globConfig = new GlobConfig();
        globConfig.setClassAuthor("永健");
        globConfig.setProjectName("lyj-demo");
        globConfig.setPackageName("cn.lyj.generator.test");
        globConfig.setGroupId("cn.lyj");
        globConfig.setArtifactId("lyj-demo");
        //        globConfig.setIncludeTableName(new String[]{});
        globConfig.setIncludeTableName(new String[]{"tb_student_job"});
        globConfig.setTablePrefix("tb_");
        globConfig.setHump(true);
        globConfig.setLombok(false);

        // 读取表
        List<LTable> tables = new TableParser(lJdbc).parser(globConfig);

        // 生成项目结构
        Project project = new Project(globConfig.getPackageName(), globConfig.getProjectName());

        new ProjectService(project, globConfig.getIncludeTableName().length == 0 ? false : true).excute();

        // 模版引擎生成类
        new LVelocityEngine(project, new Configuration(lJdbc, globConfig, tables)).excute();


    }

    @Test
    public void c()
    {
    }


}
