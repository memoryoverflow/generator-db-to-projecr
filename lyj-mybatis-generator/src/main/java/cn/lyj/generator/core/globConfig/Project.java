package cn.lyj.generator.core.globConfig;

import cn.lyj.generator.common.enums.ConstVal;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-07 17:10
 */
public class Project
{

    private String projectBasePath = ConstVal.PROJECT_PATH;

    private String projectName;
    private String packageName;
    private String resourcesFoler = ConstVal.RESOURCES;
    private String templates = ConstVal.TEMPLATES;
    private String srcMainJava = ConstVal.SRC_MAIN_JAVA;
    private String srcMain = ConstVal.SRC_MAIN;

    private String commonFolder = ConstVal.COMMON;
    private String commonConfig = commonFolder + "/" + ConstVal.CONFIG;
    private String exceptionFolder = commonFolder + "/" + ConstVal.EXCEPTION;
    private String utilsFolder = commonFolder + "/" + ConstVal.UTILS;
    private String webFolder = commonFolder + "/" + ConstVal.WEB;

    private String coreFolder = ConstVal.CORE;
    private String entityFolder = coreFolder + "/" + ConstVal.ENTITY;
    private String serviceFolder = coreFolder + "/" + ConstVal.SERVICE;
    private String serviceImplFolder = serviceFolder + "/" + ConstVal.SERVICE_IMPL;
    private String controllerFolder = coreFolder + "/" + ConstVal.CONTROLLER;
    private String mapperJavaFolder = coreFolder + "/" + ConstVal.MAPPER;
    private String mapperXmlFolder = resourcesFoler + "/" + ConstVal.MAPPER;

    private String testFolder = ConstVal.TEST + "/" + packageName;

    public String getCoreFolderComplete()
    {
        return getPackageCompletePath() + "/" + this.coreFolder;
    }

    public String getCommonFolderComplete()
    {
        return getPackageCompletePath() + "/" + this.commonFolder;
    }

    public Project(String packageName, String projectName)
    {
        this.setPackageName(packageName);
        this.projectName = projectName;
    }

    public String getCommonConfigComplete()
    {
        return getPackageCompletePath() + "/" + commonConfig;
    }

    public String getCommonConfigFolder()
    {
        return commonConfig;
    }

    public void setCommonConfig(String commonConfig)
    {
        this.commonConfig = commonConfig;
    }

    public String getSrcMainCompletePath()
    {
        return getProjectCompletePath() + "/" + this.srcMain;
    }


    public String getSrcMain()
    {
        return srcMain;
    }

    public void setSrcMain(String srcMain)
    {
        this.srcMain = srcMain;
    }

    public String getProjectCompletePath()
    {
        return this.projectBasePath + "/" + this.projectName;
    }

    public String getEntityCommpletePath()
    {
        return getPackageCompletePath() + "/" + this.entityFolder;
    }

    public String getServiceCommpletePath()
    {
        return getPackageCompletePath() + "/" + this.serviceFolder;
    }

    public String getServiceImplCommpletePath()
    {
        return getPackageCompletePath() + "/" + this.serviceImplFolder;
    }

    public String getMapperJavaCommpletePath()
    {
        return getPackageCompletePath() + "/" + this.mapperJavaFolder;
    }

    public String getControllerCommpletePath()
    {
        return getPackageCompletePath() + "/" + this.controllerFolder;
    }

    public String getMapperXmlCommpletePath()
    {
        return getSrcMainCompletePath() + "/" + this.mapperXmlFolder;
    }


    public String getSrcMainJavaCompletePath()
    {
        return getProjectCompletePath() + "/" + this.srcMainJava;
    }

    public String getPackageCompletePath()
    {
        return getSrcMainJavaCompletePath() + "/" + this.packageName;
    }


    public String getProjectBasePath()
    {
        return projectBasePath;
    }

    public void setProjectBasePath(String projectBasePath)
    {
        this.projectBasePath = projectBasePath;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public void setPackageName(String packageName)
    {
        if (packageName.indexOf(".") >= 0)
        {
            packageName = packageName.replaceAll("\\.", "/");
        }
        this.packageName = packageName;
    }

    public String getResourcesFoler()
    {
        return resourcesFoler;
    }

    public String getResourcesCompleteFoler()
    {
        return this.getSrcMainCompletePath() + "/" + this.resourcesFoler;
    }

    public void setResourcesFoler(String resourcesFoler)
    {
        this.resourcesFoler = resourcesFoler;
    }

    public String getSrcMainJava()
    {
        return srcMainJava;
    }

    public void setSrcMainJava(String srcMainJava)
    {
        this.srcMainJava = srcMainJava;
    }

    public String getCommonFolder()
    {
        return commonFolder;
    }

    public void setCommonFolder(String commonFolder)
    {
        this.commonFolder = commonFolder;
    }


    public String getExceptionCompletePath()
    {
        return getPackageCompletePath() + "/" + getExceptionFolder();
    }

    public String getExceptionFolder()
    {
        return exceptionFolder;
    }

    public void setExceptionFolder(String exceptionFolder)
    {
        this.exceptionFolder = exceptionFolder;
    }


    public String getUtilsCompleteFolder()
    {
        return getPackageCompletePath() + "/" + getUtilsFolder();
    }

    public String getUtilsFolder()
    {
        return utilsFolder;
    }

    public void setUtilsFolder(String utilsFolder)
    {
        this.utilsFolder = utilsFolder;
    }

    public String getWebFolder()
    {
        return webFolder;
    }

    public void setWebFolder(String webFolder)
    {
        this.webFolder = webFolder;
    }

    public String getCoreFolder()
    {
        return coreFolder;
    }

    public void setCoreFolder(String coreFolder)
    {
        this.coreFolder = coreFolder;
    }

    public String getEntityFolder()
    {
        return entityFolder;
    }

    public void setEntityFolder(String entityFolder)
    {
        this.entityFolder = entityFolder;
    }

    public String getServiceFolder()
    {
        return serviceFolder;
    }

    public void setServiceFolder(String serviceFolder)
    {
        this.serviceFolder = serviceFolder;
    }

    public String getServiceImplFolder()
    {
        return serviceImplFolder;
    }

    public void setServiceImplFolder(String serviceImplFolder)
    {
        this.serviceImplFolder = serviceImplFolder;
    }

    public String getControllerFolder()
    {
        return controllerFolder;
    }

    public void setControllerFolder(String controllerFolder)
    {
        this.controllerFolder = controllerFolder;
    }

    public String getMapperJavaFolder()
    {
        return mapperJavaFolder;
    }

    public void setMapperJavaFolder(String mapperJavaFolder)
    {
        this.mapperJavaFolder = mapperJavaFolder;
    }

    public String getMapperXmlFolder()
    {
        return mapperXmlFolder;
    }

    public void setMapperXmlFolder(String mapperXmlFolder)
    {
        this.mapperXmlFolder = mapperXmlFolder;
    }

    public String getTestFolder()
    {
        return testFolder;
    }

    public void setTestFolder(String testFolder)
    {
        this.testFolder = testFolder;
    }

    public String getWebCompleteFolder()
    {
        return getPackageCompletePath() + "/" + getWebFolder();
    }

    public String getTemplates()
    {
        return templates;
    }

    public String getTemplatesComplete()
    {
        return this.getResourcesCompleteFoler() + "/" + templates;
    }

    public void setTemplates(String templates)
    {
        this.templates = templates;
    }
}
