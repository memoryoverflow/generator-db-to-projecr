package cn.lyj.generator.core.controller;

import cn.lyj.generator.common.cache.Cache;
import cn.lyj.generator.common.enums.ConstVal;
import cn.lyj.generator.common.utils.ServletUtils;
import cn.lyj.generator.common.utils.ZipUtils;
import cn.lyj.generator.common.web.BaseController;
import cn.lyj.generator.common.web.R;
import cn.lyj.generator.core.entity.DbPropertis;
import cn.lyj.generator.core.entity.GlobConfig;
import cn.lyj.generator.core.entity.table.LTable;
import cn.lyj.generator.core.globConfig.Configuration;
import cn.lyj.generator.core.globConfig.Project;
import cn.lyj.generator.core.parser.TableParser;
import cn.lyj.generator.core.service.dbService.DataBaseExcute;
import cn.lyj.generator.core.service.dbService.LJdbc;
import cn.lyj.generator.core.service.project.ProjectService;
import cn.lyj.generator.core.velocity.LVelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-05 19:01
 */
@RestController
public class ReqController extends BaseController
{
    private static Logger logger = LoggerFactory.getLogger(ReqController.class);


    @GetMapping("/getTables")
    public R tables(@Valid DbPropertis dbPropertis) throws SQLException
    {

        // 1.连接数据库
        LJdbc lJdbc = new LJdbc(dbPropertis);
        // 2.获取表
        List<LTable> tables = new DataBaseExcute(lJdbc).getTables();
        lJdbc.close();
        return success(tables);
    }

    @PostMapping("/create/project")
    public R create(@Valid GlobConfig globConfig, @Valid DbPropertis dbPropertis, HttpServletResponse response) throws Exception
    {
        // 3.解析表
        LJdbc lJdbc = new LJdbc(dbPropertis);

        // 生成项目结构
        Project project = new Project(globConfig.getPackageName(), globConfig.getProjectName());
        new ProjectService(project, globConfig.getIncludeTableName().length == 0 ? false : true).excute();

        // 模版引擎生成类
        new LVelocityEngine(project, new Configuration(lJdbc, globConfig)).excute();

        lJdbc.close();

        return success(project.getProjectCompletePath());
    }

    @GetMapping("/downLoad")
    public void downLoad(@RequestParam("path") String path, HttpServletResponse response) throws IOException
    {
        response.setHeader(
                "Content-disposition",
                "attachment;filename=project.zip");
        ZipUtils.toZip(path, response.getOutputStream(), true);
    }
}
