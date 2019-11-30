package cn.lyj.generator.core.service.project;

import cn.lyj.generator.common.utils.StringUtil;
import cn.lyj.generator.core.globConfig.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-07 17:34
 */
public class ProjectService
{
    private static Logger logger = LoggerFactory.getLogger(ProjectService.class);

    private Project project;
    private boolean exitsTable;

    /**
     * @param project
     * @param exitsTable
     *         是否有表
     */
    public ProjectService(Project project, boolean exitsTable)
    {
        this.project = project;
        this.exitsTable = exitsTable;
    }


    public synchronized void excute()
    {
        logger.info("######################");
        logger.info("##  开始创建项目...");
        createProjectName();
        createSrcMainJava();
        createPackage();
        createCommon();
        createCommonConfig();
        createCommonException();
        createCommonUtils();
        createCommonWeb();

        createResource();

        createResourceTemplate();

        if (exitsTable)
        {
            createCore();
            createCoreEntity();
            createCoreMapper();
            createCoreService();
            createCoreServiceImpl();
            createCoreController();
            createResourceMapper();
        }

        logger.info("##  项目创建完成");
        logger.info("######################");
        logger.info("");
    }


    private void createResourceMapper()
    {
        // 创建文件夹
        StringUtil.checkPath(this.project.getMapperXmlCommpletePath());
    }

    private void createCommonConfig()
    {
        // 创建文件夹
        StringUtil.checkPath(this.project.getCommonConfigComplete());
    }

    private void createProjectName()
    {
        // 创建文件夹
        File file = new File(this.project.getProjectCompletePath());
        if (!file.exists())
        {
            file.mkdirs();
        }
        else
        {
            file.delete();
        }
    }

    private void createSrcMainJava()
    {
        // 创建文件夹
        StringUtil.checkPath(this.project.getSrcMainJavaCompletePath());
    }

    private void createPackage()
    {
        // 创建文件夹
        StringUtil.checkPath(project.getPackageCompletePath());
    }

    private void createCore()
    {
        // 创建文件夹
        StringUtil.checkPath(this.project.getCoreFolderComplete());
    }


    private void createCoreEntity()
    {
        // 创建文件夹
        StringUtil.checkPath(this.project.getEntityCommpletePath());
    }

    private void createCoreMapper()
    {
        // 创建文件夹
        StringUtil.checkPath(this.project.getMapperJavaCommpletePath());
    }

    private void createCoreService()
    {
        // 创建文件夹
        StringUtil.checkPath(this.project.getServiceCommpletePath());
    }

    private void createCoreServiceImpl()
    {
        // 创建文件夹
        StringUtil.checkPath(this.project.getServiceImplCommpletePath());
    }

    private void createCoreController()
    {
        // 创建文件夹
        StringUtil.checkPath(this.project.getControllerCommpletePath());
    }

    private void createCommon()
    {
        // 创建文件夹
        StringUtil.checkPath(this.project.getCommonFolderComplete());
    }

    private void createCommonException()
    {
        // 创建文件夹
        StringUtil.checkPath(this.project.getExceptionCompletePath());
    }

    private void createCommonUtils()
    {
        // 创建文件夹
        StringUtil.checkPath(this.project.getUtilsCompleteFolder());
    }

    private void createCommonWeb()
    {

        // 创建文件夹
        StringUtil.checkPath(this.project.getWebCompleteFolder());
    }

    private void createResource()
    {
        StringUtil.checkPath(this.project.getResourcesCompleteFoler());
    }

    private void createResourceTemplate()
    {
        StringUtil.checkPath(this.project.getTemplatesComplete());
    }
}
