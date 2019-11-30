package cn.lyj.generator.core.velocity;

import cn.lyj.generator.common.enums.ConstVal;
import cn.lyj.generator.common.enums.StringPools;
import cn.lyj.generator.common.utils.DateTimeUtils;
import cn.lyj.generator.common.utils.StringUtil;
import cn.lyj.generator.common.utils.ZipUtils;
import cn.lyj.generator.core.entity.GlobConfig;
import cn.lyj.generator.core.entity.JavaClass;
import cn.lyj.generator.core.entity.PackageConfig;
import cn.lyj.generator.core.entity.table.LTable;
import cn.lyj.generator.core.globConfig.Configuration;
import cn.lyj.generator.core.globConfig.Project;
import cn.lyj.generator.core.parser.TableParser;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-06 11:46
 */
public class LVelocityEngine
{
    private static Logger logger = LoggerFactory.getLogger(LVelocityEngine.class);

    private Configuration configuration;

    private Project project;

    private JavaClass javaClass;

    private VelocityEngine velocityEngine;

    private PackageConfig packageConfig;


    public LVelocityEngine(Project project, Configuration configuration)
    {
        this.javaClass = configuration.getJavaClass();
        this.project = project;
        this.configuration = configuration;
    }

    public void downLoad(HttpServletResponse response) throws IOException
    {
        response.setHeader(
                "Content-disposition",
                "attachment;filename=project.zip");
        String projectProjectCompletePath = project.getProjectCompletePath();
        ZipUtils.toZip(projectProjectCompletePath, response.getOutputStream(), true);
        logger.info("##  项目下载完成");
    }


    public LVelocityEngine excute() throws Exception
    {
        logger.info("######################");
        logger.info("##  开始生成java类...");
        createVe();
        TemplateConfig templateConfig = new TemplateConfig();

        List<LTable> tables = new TableParser(configuration.getJdbc()).parser(configuration.getGlobConfig());
        for (LTable table : tables)
        {
            logger.info("......");
            // 是否开启驼峰
            toUnderScoreCase(table);

            // 生成每个表对应的三层实体名
            makeJavaClassName(table);

            createEntity(table, project.getEntityFolder(), templateConfig);

            createMapper(table, project.getMapperJavaFolder(), templateConfig);

            createMapperXml(table, templateConfig);

            createService(table, project.getServiceFolder(), templateConfig);

            createServiceImpl(table, project.getServiceImplFolder(), templateConfig);

            createController(table, project.getControllerFolder(), templateConfig);
        }
        logger.info("......");
        createIml(this.configuration.getGlobConfig(), templateConfig);

        createPomXml(this.configuration.getGlobConfig(), templateConfig);

        createApp(getVelocityContext(null, ""), this.configuration.getGlobConfig(), templateConfig);

        createApplicationYml(getVelocityContext(null, ""), configuration, templateConfig);

        createMpConfig(getVelocityContext(null, project.getCommonConfigFolder()), templateConfig);
        createWebConfig(getVelocityContext(null, project.getCommonConfigFolder()), templateConfig);

        createError(getVelocityContext(null, project.getExceptionFolder()), templateConfig);

        // createNotFoundException(getVelocityContext(null, project.getExceptionFolder()), templateConfig);

        createGlobalExceptionHandler(getVelocityContext(null, project.getExceptionFolder()), templateConfig);

        createMyException(getVelocityContext(null, project.getExceptionFolder()), templateConfig);

        createR(getVelocityContext(null, project.getWebFolder()), templateConfig);

        createOrderBy(getVelocityContext(null, project.getWebFolder()), templateConfig);

        createServletUtils(getVelocityContext(null, project.getUtilsFolder()), templateConfig);
        createStringUtils(getVelocityContext(null, project.getUtilsFolder()), templateConfig);
        createFilterNullUtils(getVelocityContext(null, project.getUtilsFolder()), templateConfig);
        createDateTimeUtils(getVelocityContext(null, project.getUtilsFolder()), templateConfig);

        createBaseController(getVelocityContext(null, project.getWebFolder()), templateConfig);
        createSysAspect(getVelocityContext(null, project.getWebFolder()), templateConfig);

        logger.info("##  创建完成");
        logger.info("######################");
        return this;
    }

    private void createServletUtils(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getServletUtils(), StringPools.UTF8);
        writer(template, param, project.getUtilsCompleteFolder() + "/" + javaClass.getServletUtils());
    }

    private void createStringUtils(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getStringUtils(), StringPools.UTF8);
        writer(template, param, project.getUtilsCompleteFolder() + "/" + javaClass.getStringUtils());
    }

    private void createFilterNullUtils(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getFilterNull(), StringPools.UTF8);
        writer(template, param, project.getUtilsCompleteFolder() + "/" + javaClass.getFilterNull());
    }

    private void createDateTimeUtils(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getDateTimeUtils(), StringPools.UTF8);
        writer(template, param, project.getUtilsCompleteFolder() + "/" + javaClass.getDateTimeUtils());
    }

    private void createOrderBy(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getOrderBy(), StringPools.UTF8);
        writer(template, param, project.getWebCompleteFolder() + "/" + javaClass.getOrderBy());
    }

    private void createMyException(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getMyException(), StringPools.UTF8);
        writer(template, param, project.getExceptionCompletePath() + "/" + javaClass.getMyException());
    }

    private void createGlobalExceptionHandler(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getGlobalExceptionHandler(), StringPools.UTF8);
        writer(template, param, project.getExceptionCompletePath() + "/" + javaClass.getGlobalExceptionHandler());
    }


    private void createError(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getError(), StringPools.UTF8);
        writer(template, param, project.getExceptionCompletePath() + "/" + javaClass.getError());
    }

    private void createMpConfig(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getMpConfig(), StringPools.UTF8);
        writer(template, param, project.getCommonConfigComplete() + "/" + javaClass.getMpConfig());
    }

    private void createWebConfig(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getWebConfig(), StringPools.UTF8);
        writer(template, param, project.getCommonConfigComplete() + "/" + javaClass.getWebConfig());
    }

    private void createNotFoundException(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getNotFoundException(), StringPools.UTF8);
        writer(template, param, project.getExceptionCompletePath() + "/" + javaClass.getNotFoundException());
    }

    private void createBaseController(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getBaseController(), StringPools.UTF8);
        writer(template, param, project.getWebCompleteFolder() + "/" + javaClass.getBaseController());
    }

    private void createSysAspect(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getSysAspect(), StringPools.UTF8);
        param.put("controllerPackage", project.getControllerFolder().replaceAll("/", "."));
        writer(template, param, project.getWebCompleteFolder() + "/" + javaClass.getSysAspect());
    }

    private void createR(VelocityContext param, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getR(), StringPools.UTF8);
        writer(template, param, project.getWebCompleteFolder() + "/" + javaClass.getR());
    }

    private void createApplicationYml(VelocityContext param, Configuration configuration, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getApplicationYml(), StringPools.UTF8);
        param.put("dbHost", configuration.getJdbc().getDbPropertis().getDbHost());
        param.put("dbPort", configuration.getJdbc().getDbPropertis().getDbPort());
        param.put("dbRoot", configuration.getJdbc().getDbPropertis().getDbRoot());
        param.put("dbPwd", configuration.getJdbc().getDbPropertis().getDbPwd());
        param.put("dbName", configuration.getJdbc().getDbPropertis().getDbName());
        param.put("hump", configuration.getGlobConfig().isHump());
        param.put("tablePrefix", configuration.getGlobConfig().getTablePrefix());
        writer(template, param, project.getResourcesCompleteFoler() + "/" + javaClass.getAplicationYml());
    }


    /**
     * 生成对应的 三层结构 类名字
     *
     * @param table
     */
    private void makeJavaClassName(LTable table)
    {
        table.setServiceName("I" + table.getEntityName() + "Service");
        table.setServiceImplName(table.getEntityName() + "ServiceImpl");
        table.setControllerName(table.getEntityName() + "Controller");
        table.setMapperName(table.getEntityName() + "Mapper");
        table.setEntityName(table.getEntityName());
        table.setMappeerXmlName(table.getEntityName() + "Mapper");
    }

    /**
     * <p>
     * 是否驼峰
     * 将表名转换 转换实体
     * </p>
     *
     * @param table
     *
     * @return void
     */
    private void toUnderScoreCase(LTable table)
    {
        String tablePrefix = this.configuration.getGlobConfig().getTablePrefix();
        String tableName = table.getTableName();
        String entityName = table.getEntityName();

        // 去除表前缀 ，首字母大写
        if (StringUtils.isNotBlank(tablePrefix))
        {
            if (tableName.contains(tablePrefix))
            {
                entityName = tableName.replace(tablePrefix, "");
            }else {
                entityName=tableName;
            }
        }else {
            entityName=tableName;
            entityName=tableName;
        }
        table.setEntityName(StringUtil.firstUp(StringUtil.lineToHump(entityName)));

        table.setBasePath(StringUtil.lineToHump(entityName));

    }

    private void createVe()
    {
        Properties p = new Properties();
        p.setProperty(ConstVal.VM_LOAD_PATH_KEY, ConstVal.VM_LOAD_PATH_VALUE);
        p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, StringPools.EMPTY);
        p.setProperty(Velocity.ENCODING_DEFAULT, StringPools.UTF8);
        p.setProperty(Velocity.INPUT_ENCODING, StringPools.UTF8);
        p.setProperty("file.resource.loader.unicode", StringPools.TRUE);
        VelocityEngine ve = new VelocityEngine(p);
        ve.init();
        this.velocityEngine = ve;
    }

    /**
     * 模版数据共同数据
     *
     * @param table
     *
     * @return
     */
    private VelocityContext getVelocityContext(LTable table, String currentClassPackage)
    {
        VelocityContext param = new VelocityContext();
        param.put("date", DateTimeUtils.formatNow());
        param.put("author", this.configuration.getGlobConfig().getClassAuthor());
        // 表对象
        param.put("table", table);
        if (this.packageConfig == null)
        {
            this.packageConfig = new PackageConfig(this.project, currentClassPackage, configuration.getGlobConfig().getPackageName());
        }
        else
        {
            this.packageConfig.setCurrent(currentClassPackage);
        }
        param.put("packageConfig", packageConfig);
        param.put("package", packageConfig.getPackageName());
        return param;
    }

    /**
     * 创建实体
     *
     * @param table
     * @param templateConfig
     *
     * @throws FileNotFoundException
     */
    private void createEntity(LTable table, String currentPackge, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getEntity(), StringPools.UTF8);
        VelocityContext param = getVelocityContext(table, currentPackge);

        param.put("lombok", this.configuration.getGlobConfig().isLombok());
        param.put("hump", this.configuration.getGlobConfig().isHump());

        // 是否开启继承父类
        if (this.configuration.getGlobConfig().isSuperClass())
        {
            param.put("superEntityClass", "父类名称");
        }
        writer(template, param, installFilePath(project.getEntityCommpletePath(), table.getEntityName(), ConstVal.JAVA_FILE_SUFFIX));
    }


    /**
     * 创建Service
     *
     * @param table
     * @param templateConfig
     *
     * @throws FileNotFoundException
     */
    private void createService(LTable table, String currentClassPackage, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getService(), StringPools.UTF8);
        VelocityContext param = getVelocityContext(table, currentClassPackage);

        writer(template, param, installFilePath(project.getServiceCommpletePath(), table.getServiceName(), ConstVal.JAVA_FILE_SUFFIX));
    }

    private String installFilePath(String bashPath, String fileName, String fileSuffix)
    {
        return bashPath + "/" + fileName + fileSuffix;
    }

    /**
     * 创建实现类
     *
     * @param table
     * @param templateConfig
     *
     * @throws FileNotFoundException
     */
    private void createServiceImpl(LTable table, String currentClassPackage, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getServiceImpl(), StringPools.UTF8);
        VelocityContext param = getVelocityContext(table, currentClassPackage);
        writer(template, param, installFilePath(project.getServiceImplCommpletePath(), table.getServiceImplName(), ConstVal.JAVA_FILE_SUFFIX));
    }

    /**
     * 创建controller
     *
     * @param table
     * @param templateConfig
     *
     * @throws FileNotFoundException
     */
    private void createController(LTable table, String currentClassPackage, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getController(), StringPools.UTF8);
        VelocityContext param = getVelocityContext(table, currentClassPackage);
        writer(template, param, installFilePath(project.getControllerCommpletePath(), table.getControllerName(), ConstVal.JAVA_FILE_SUFFIX));
    }

    /**
     * 创建Mapper.java
     *
     * @param table
     * @param templateConfig
     *
     * @throws FileNotFoundException
     */
    private void createMapper(LTable table, String currentClassPackage, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getMapper(), StringPools.UTF8);
        VelocityContext param = getVelocityContext(table, currentClassPackage);
        writer(template, param, installFilePath(project.getMapperJavaCommpletePath(), table.getMapperName(), ConstVal.JAVA_FILE_SUFFIX));
    }

    /**
     * 创建xml
     *
     * @param table
     * @param templateConfig
     */
    private void createMapperXml(LTable table, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getXml(), StringPools.UTF8);
        VelocityContext param = getVelocityContext(table, "");
        writer(template, param, installFilePath(project.getMapperXmlCommpletePath(), table.getMappeerXmlName(), ConstVal.XML_FILE_SUFFIX));
    }

    /**
     * 创建 项目配置记录文件
     *
     * @param globConfig
     * @param templateConfig
     *
     * @throws FileNotFoundException
     */
    private void createIml(GlobConfig globConfig, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getIml(), StringPools.UTF8);
        writer(template, new VelocityContext(), project.getProjectCompletePath() + "/" + javaClass.getAppIml());
    }


    /**
     * 创建Pom.xml
     *
     * @param globConfig
     * @param templateConfig
     *
     * @throws FileNotFoundException
     */
    private void createPomXml(GlobConfig globConfig, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getPom(), StringPools.UTF8);
        VelocityContext param = new VelocityContext();
        param.put("groupId", globConfig.getGroupId());
        param.put("artifactId", globConfig.getArtifactId());
        writer(template, param, project.getProjectCompletePath() + "/" + javaClass.getPomXml());
    }

    /**
     * 创建启动类
     *
     * @param globConfig
     * @param templateConfig
     *
     * @throws FileNotFoundException
     */
    private void createApp(VelocityContext param, GlobConfig globConfig, TemplateConfig templateConfig) throws FileNotFoundException
    {
        Template template = velocityEngine.getTemplate(templateConfig.getApp(), StringPools.UTF8);
        writer(template, param, project.getPackageCompletePath() + "/" + javaClass.getAppJava());
    }


    private void writer(Template template, VelocityContext velocityContext, String fileName) throws FileNotFoundException
    {
        //设置输出
        PrintWriter writer = new PrintWriter(fileName);
        //将环境数据转化输出
        template.merge(velocityContext, writer);
        writer.close();
    }
}
