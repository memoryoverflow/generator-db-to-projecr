package cn.lyj.generator.core.velocity;

import cn.lyj.generator.common.enums.ConstVal;

/**
 * <p>
 * 模版引擎
 * </p>
 *
 * @author 永健
 * @since 2019-11-06 11:50
 */

public class TemplateConfig
{
    private String entity = ConstVal.TEMPLATE_ENTITY_JAVA;


    private String service = ConstVal.TEMPLATE_SERVICE;

    private String serviceImpl = ConstVal.TEMPLATE_SERVICE_IMPL;

    private String mapper = ConstVal.TEMPLATE_MAPPER;

    private String xml = ConstVal.TEMPLATE_XML;

    private String controller = ConstVal.TEMPLATE_CONTROLLER;

    private String app = ConstVal.TEMPLATE_APP;

    private String pom = ConstVal.TEMPLATE_POM_XML;

    private String iml = ConstVal.TEMPLATE_IML;
    private String applicationYml = ConstVal.TEMPLATE_APPLICATION_YML;

    private String baseController = ConstVal.TEMPLATE_BASECONTROLLER;
    private String globalExceptionHandler = ConstVal.TEMPLATE_GLOBAL_EXCEPTION;
    private String myException = ConstVal.TEMPLATE_MYEXCEPTION;
    private String orderBy = ConstVal.TEMPLATE_ORDERBY;
    private String servletUtils = ConstVal.TEMPLATE_SERVLETUTILS;
    private String mpConfig = ConstVal.TEMPLATE_MP_CONFIG;
    private String notFoundException = ConstVal.TEMPLATE_NOT_FOUND;
    private String error = ConstVal.TEMPLATE_ERROR;
    private String r = ConstVal.TEMPLATE_R;
    private String filterNull = ConstVal.TEMPLATE_FILTERNULL;
    private String stringUtils = ConstVal.TEMPLATE_STRINGUTILS;
    private String webConfig = ConstVal.TEMPLATE_WEBCOFIG;
    private String sysAspect = ConstVal.TEMPLATE_ASPECT;
    private String dateTimeUtils = ConstVal.TEMPLATE_DATETIME_UTILS;

    public String getService()
    {
        return service;
    }

    public TemplateConfig setService(String service)
    {
        this.service = service;
        return this;
    }

    public String getEntity()
    {
        return entity;
    }

    public TemplateConfig setEntity(String entity)
    {
        this.entity = entity;
        return this;
    }

    public String getServiceImpl()
    {
        return serviceImpl;
    }

    public TemplateConfig setServiceImpl(String serviceImpl)
    {
        this.serviceImpl = serviceImpl;
        return this;
    }

    public String getMapper()
    {
        return mapper;
    }

    public TemplateConfig setMapper(String mapper)
    {
        this.mapper = mapper;
        return this;
    }

    public String getXml()
    {
        return xml;
    }

    public void setXml(String xml)
    {
        this.xml = xml;
    }

    public String getController()
    {
        return controller;
    }

    public void setController(String controller)
    {
        this.controller = controller;
    }

    public String getApp()
    {
        return app;
    }

    public TemplateConfig setApp(String app)
    {
        this.app = app;
        return this;
    }

    public String getPom()
    {
        return pom;
    }

    public TemplateConfig setPom(String pom)
    {
        this.pom = pom;
        return this;
    }

    public String getIml()
    {
        return iml;
    }

    public TemplateConfig setIml(String iml)
    {
        this.iml = iml;
        return this;
    }

    public String getError()
    {
        return error;
    }

    public String getBaseController()
    {

        return baseController;
    }

    public String getGlobalExceptionHandler()
    {
        return globalExceptionHandler;
    }

    public String getMyException()
    {
        return myException;
    }

    public String getR()
    {
        return r;
    }

    public String getApplicationYml()
    {
        return applicationYml;
    }

    public String getOrderBy()
    {
        return orderBy;
    }

    public String getServletUtils()
    {
        return servletUtils;
    }

    public String getMpConfig()
    {
        return mpConfig;
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

    public String getWebConfig()
    {
        return webConfig;
    }

    public String getSysAspect()
    {
        return sysAspect;
    }

    public String getDateTimeUtils()
    {
        return dateTimeUtils;
    }
}
