/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.appservice;

import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.rest.RestClient;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class WebAppConfigTests extends AppServiceTest {
    private static String WEBAPP_NAME = "";

    @Override
    protected void initializeClients(RestClient restClient, String defaultSubscription, String domain) {
        WEBAPP_NAME = generateRandomResourceName("java-webapp-", 20);

        super.initializeClients(restClient, defaultSubscription, domain);
    }

    @Test
    public void canCRUDWebAppConfig() throws Exception {
        // Create with new app service plan
        appServiceManager.webApps().define(WEBAPP_NAME)
                .withRegion(Region.US_EAST)
                .withNewResourceGroup(RG_NAME)
                .withNewWindowsPlan(PricingTier.BASIC_B1)
                .withNetFrameworkVersion(NetFrameworkVersion.V3_0)
                .withMinTlsVersion(SupportedTlsVersions.ONE_FULL_STOP_ONE)
                .create();

        WebApp webApp = appServiceManager.webApps().getByResourceGroup(RG_NAME, WEBAPP_NAME);
        Assert.assertNotNull(webApp);
        Assert.assertEquals(Region.US_EAST, webApp.region());
        Assert.assertEquals(NetFrameworkVersion.V3_0, webApp.netFrameworkVersion());
        Assert.assertEquals(SupportedTlsVersions.ONE_FULL_STOP_ONE, webApp.minTlsVersion());

        // Java version
        webApp.update()
                .withJavaVersion(JavaVersion.JAVA_1_7_0_51)
                .withWebContainer(WebContainer.TOMCAT_7_0_50)
                .apply();
        webApp = appServiceManager.webApps().getByResourceGroup(RG_NAME, WEBAPP_NAME);
        Assert.assertEquals(JavaVersion.JAVA_1_7_0_51, webApp.javaVersion());

        // Python version
        webApp.update()
                .withPythonVersion(PythonVersion.PYTHON_34)
                .apply();
        webApp = appServiceManager.webApps().getByResourceGroup(RG_NAME, WEBAPP_NAME);
        Assert.assertEquals(PythonVersion.PYTHON_34, webApp.pythonVersion());


        // Default documents
        int documentSize = webApp.defaultDocuments().size();
        webApp.update()
                .withDefaultDocument("somedocument.html")
                .apply();
        webApp = appServiceManager.webApps().getByResourceGroup(RG_NAME, WEBAPP_NAME);
        Assert.assertEquals(documentSize + 1, webApp.defaultDocuments().size());
        Assert.assertTrue(webApp.defaultDocuments().contains("somedocument.html"));

        // App settings
        webApp.update()
                .withAppSetting("appkey", "appvalue")
                .withStickyAppSetting("stickykey", "stickyvalue")
                .apply();
        webApp = appServiceManager.webApps().getByResourceGroup(RG_NAME, WEBAPP_NAME);
        Map<String, AppSetting> appSettingMap = webApp.getAppSettings();
        Assert.assertEquals("appvalue", appSettingMap.get("appkey").value());
        Assert.assertEquals(false, appSettingMap.get("appkey").sticky());
        Assert.assertEquals("stickyvalue", appSettingMap.get("stickykey").value());
        Assert.assertEquals(true, appSettingMap.get("stickykey").sticky());

        // Connection strings
        webApp.update()
                .withConnectionString("connectionName", "connectionValue", ConnectionStringType.CUSTOM)
                .withStickyConnectionString("stickyName", "stickyValue", ConnectionStringType.CUSTOM)
                .apply();
        webApp = appServiceManager.webApps().getByResourceGroup(RG_NAME, WEBAPP_NAME);
        Map<String, ConnectionString> connectionStringMap = webApp.getConnectionStrings();
        Assert.assertEquals("connectionValue", connectionStringMap.get("connectionName").value());
        Assert.assertEquals(false, connectionStringMap.get("connectionName").sticky());
        Assert.assertEquals("stickyValue", connectionStringMap.get("stickyName").value());
        Assert.assertEquals(true, connectionStringMap.get("stickyName").sticky());

        // HTTPS only
        webApp = webApp.update()
                .withHttpsOnly(true)
                .apply();
        Assert.assertTrue(webApp.httpsOnly());

        // FTPS
        webApp = webApp.update()
                .withFtpsState(FtpsState.FTPS_ONLY)
                .apply();
        Assert.assertEquals(FtpsState.FTPS_ONLY, webApp.ftpsState());

        // Min TLS version
        webApp = webApp.update()
                .withMinTlsVersion(SupportedTlsVersions.ONE_FULL_STOP_TWO)
                .apply();
        Assert.assertEquals(SupportedTlsVersions.ONE_FULL_STOP_TWO, webApp.minTlsVersion());

        // Logs
        webApp = webApp.update()
                .withContainerLoggingEnabled()
                .apply();
        Assert.assertTrue(webApp.diagnosticLogsConfig().inner().httpLogs().fileSystem().enabled());
        // verify on new instance
        // https://github.com/Azure/azure-libraries-for-java/issues/759
        webApp = appServiceManager.webApps().getById(webApp.id());
        Assert.assertTrue(webApp.diagnosticLogsConfig().inner().httpLogs().fileSystem().enabled());
    }

    @Test
    public void canCRUDWebAppConfigJava11() throws Exception {
        // Create with new app service plan
        appServiceManager.webApps().define(WEBAPP_NAME)
                .withRegion(Region.US_EAST)
                .withNewResourceGroup(RG_NAME)
                .withNewWindowsPlan(PricingTier.BASIC_B1)
                .withNetFrameworkVersion(NetFrameworkVersion.V3_0)
                .create();

        WebApp webApp = appServiceManager.webApps().getByResourceGroup(RG_NAME, WEBAPP_NAME);
        Assert.assertNotNull(webApp);
        Assert.assertEquals(Region.US_EAST, webApp.region());
        Assert.assertEquals(NetFrameworkVersion.V3_0, webApp.netFrameworkVersion());

        // Java version
        webApp.update()
                .withJavaVersion(JavaVersion.JAVA_11)
                .withWebContainer(WebContainer.TOMCAT_9_0_NEWEST)
                .apply();
        webApp = appServiceManager.webApps().getByResourceGroup(RG_NAME, WEBAPP_NAME);
        Assert.assertEquals(JavaVersion.JAVA_11, webApp.javaVersion());

        // Python version
        webApp.update()
                .withPythonVersion(PythonVersion.PYTHON_34)
                .apply();
        webApp = appServiceManager.webApps().getByResourceGroup(RG_NAME, WEBAPP_NAME);
        Assert.assertEquals(PythonVersion.PYTHON_34, webApp.pythonVersion());


        // Default documents
        int documentSize = webApp.defaultDocuments().size();
        webApp.update()
                .withDefaultDocument("somedocument.html")
                .apply();
        webApp = appServiceManager.webApps().getByResourceGroup(RG_NAME, WEBAPP_NAME);
        Assert.assertEquals(documentSize + 1, webApp.defaultDocuments().size());
        Assert.assertTrue(webApp.defaultDocuments().contains("somedocument.html"));

        // App settings
        webApp.update()
                .withAppSetting("appkey", "appvalue")
                .withStickyAppSetting("stickykey", "stickyvalue")
                .apply();
        webApp = appServiceManager.webApps().getByResourceGroup(RG_NAME, WEBAPP_NAME);
        Map<String, AppSetting> appSettingMap = webApp.getAppSettings();
        Assert.assertEquals("appvalue", appSettingMap.get("appkey").value());
        Assert.assertEquals(false, appSettingMap.get("appkey").sticky());
        Assert.assertEquals("stickyvalue", appSettingMap.get("stickykey").value());
        Assert.assertEquals(true, appSettingMap.get("stickykey").sticky());

        // Connection strings
        webApp.update()
                .withConnectionString("connectionName", "connectionValue", ConnectionStringType.CUSTOM)
                .withStickyConnectionString("stickyName", "stickyValue", ConnectionStringType.CUSTOM)
                .apply();
        webApp = appServiceManager.webApps().getByResourceGroup(RG_NAME, WEBAPP_NAME);
        Map<String, ConnectionString> connectionStringMap = webApp.getConnectionStrings();
        Assert.assertEquals("connectionValue", connectionStringMap.get("connectionName").value());
        Assert.assertEquals(false, connectionStringMap.get("connectionName").sticky());
        Assert.assertEquals("stickyValue", connectionStringMap.get("stickyName").value());
        Assert.assertEquals(true, connectionStringMap.get("stickyName").sticky());

        // HTTPS only
        webApp = webApp.update()
                .withHttpsOnly(true)
                .apply();
        Assert.assertTrue(webApp.httpsOnly());

        // FTPS
        webApp = webApp.update()
                .withFtpsState(FtpsState.FTPS_ONLY)
                .apply();
        Assert.assertEquals(FtpsState.FTPS_ONLY, webApp.ftpsState());
    }

}