package cn.lyj.generator.core.entity;

import cn.lyj.generator.common.enums.ConstVal;
import cn.lyj.generator.core.globConfig.Project;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-06 16:39
 */
public class PackageConfig
{


    private String packageName;

    /**
     * 以下是实体类的包名
     */
    private String entity;

    private String service;

    private String serviceImpl;

    private String mapper;

    private String xml;

    private String controller;

    private String error;

    private String r;
    private String baseController;
    private String myException;
    private String current;
    private String orderBy;
    private String servletUtils;
    private String maConfig;
    private String notFoundException;
    private String filterNull;
    private String stringUtils;
    private String sysAspect;
    private String webConfig;
    private String dateTimeUtils;

    private Project project;


    public PackageConfig(Project project, String currentClassPackage, String packageName)
    {
        this.project = project;
        setCurrent(currentClassPackage);
        this.packageName = packageName;
        this.entity = project.getEntityFolder().replace("/", ".");
        this.service = project.getServiceFolder().replace("/", ".");
        this.serviceImpl = project.getServiceImplFolder().replace("/", ".");
        this.mapper = project.getMapperJavaFolder().replace("/", ".");
        this.controller = project.getControllerFolder().replace("/", ".");
        this.xml = project.getMapperXmlFolder().replace("/", ".");
        this.error = project.getExceptionFolder().replaceAll("/", ".") + "." + ConstVal.ERROR_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");
        this.r = project.getWebFolder().replaceAll("/", ".") + "." + ConstVal.R_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");
        this.baseController = project.getWebFolder().replaceAll("/", ".") + "." + ConstVal.BASECONTROLLER_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");
        this.myException = project.getExceptionFolder().replaceAll("/", ".") + "." + ConstVal.MYEXCEPTION_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");
        this.orderBy = project.getWebFolder().replaceAll("/", ".") + "." + ConstVal.ORDERBY_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");
        this.servletUtils = project.getUtilsFolder().replaceAll("/", ".") + "." + ConstVal.SERVLETUTILS_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");
        this.maConfig = project.getCommonConfigFolder().replaceAll("/", ".") + "." + ConstVal.MP_CONFIG_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");
        this.notFoundException = project.getExceptionFolder().replaceAll("/", ".") + "." + ConstVal.NOT_FOUND_EXCEPTIOPN_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");

        this.filterNull = project.getUtilsFolder().replaceAll("/", ".") + "." + ConstVal.FILTERNULL_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");
        this.stringUtils = project.getUtilsFolder().replaceAll("/", ".") + "." + ConstVal.STRINGUTILS_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");
        this.dateTimeUtils = project.getUtilsFolder().replaceAll("/", ".") + "." + ConstVal.DATETIMEUTILS_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");
        this.sysAspect = project.getWebCompleteFolder().replaceAll("/", ".") + "." + ConstVal.SYSASPECT_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");
        this.webConfig = project.getCommonConfigFolder().replaceAll("/", ".") + "." + ConstVal.WEBCONFIG_JAVA.replace(ConstVal.JAVA_FILE_SUFFIX, "");
    }

    public String getPackageName()
    {
        return packageName;
    }

    public String getEntity()
    {
        return entity;
    }

    public String getService()
    {
        return service;
    }

    public String getServiceImpl()
    {
        return serviceImpl;
    }

    public String getMapper()
    {
        return mapper;
    }

    public String getXml()
    {
        return xml;
    }

    public String getController()
    {
        return controller;
    }

    public String getError()
    {
        return error;
    }

    public String getR()
    {
        return r;
    }

    public String getBaseController()
    {
        return baseController;
    }

    public String getMyException()
    {
        return myException;
    }

    public String getCurrent()
    {
        return current;
    }

    public void setCurrent(String current)
    {
        this.current = this.current = current.replaceAll("/", ".");
        ;
    }

    public String getOrderBy()
    {
        return orderBy;
    }

    public String getServletUtils()
    {
        return servletUtils;
    }

    public String getMaConfig()
    {
        return maConfig;
    }

    public String getNotFoundException()
    {
        return notFoundException;
    }

    public String getFilterNull()
    {
        return filterNull;
    }

    public String getStringUtils()
    {
        return stringUtils;
    }

    public String getSysAspect()
    {
        return sysAspect;
    }

    public String getWebConfig()
    {
        return webConfig;
    }

    public String getDateTimeUtils()
    {
        return dateTimeUtils;
    }
}
