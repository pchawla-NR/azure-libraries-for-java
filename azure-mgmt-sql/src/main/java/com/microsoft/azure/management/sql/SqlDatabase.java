/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.management.sql;

import com.microsoft.azure.management.apigeneration.Beta;
import com.microsoft.azure.management.apigeneration.Fluent;
import com.microsoft.azure.management.apigeneration.Method;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.resources.fluentcore.arm.models.ExternalChildResource;
import com.microsoft.azure.management.resources.fluentcore.arm.models.HasResourceGroup;
import com.microsoft.azure.management.resources.fluentcore.arm.models.Resource;
import com.microsoft.azure.management.resources.fluentcore.model.Appliable;
import com.microsoft.azure.management.resources.fluentcore.model.Attachable;
import com.microsoft.azure.management.resources.fluentcore.model.Creatable;
import com.microsoft.azure.management.resources.fluentcore.model.HasInner;
import com.microsoft.azure.management.resources.fluentcore.model.Refreshable;
import com.microsoft.azure.management.resources.fluentcore.model.Updatable;
import com.microsoft.azure.management.sql.implementation.DatabaseInner;
import com.microsoft.azure.management.storage.StorageAccount;
import org.joda.time.DateTime;
import rx.Completable;
import rx.Observable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * An immutable client-side representation of an Azure SQL Server Database.
 */
@Fluent
@Beta(Beta.SinceVersion.V1_7_0)
public interface SqlDatabase
    extends
        ExternalChildResource<SqlDatabase, SqlServer>,
        HasInner<DatabaseInner>,
        HasResourceGroup,
        Refreshable<SqlDatabase>,
        Updatable<SqlDatabase.Update> {

    /**
     * @return name of the SQL Server to which this database belongs
     */
    String sqlServerName();

    /**
     * @return the collation of the Azure SQL Database
     */
    String collation();

    /**
     * @return the creation date of the Azure SQL Database
     */
    DateTime creationDate();

    /**
     * @return the current Service Level Objective Id of the Azure SQL Database, this is the Id of the
     * Service Level Objective that is currently active
     */
    UUID currentServiceObjectiveId();


    /**
     * @return the Id of the Azure SQL Database
     */
    String databaseId();

    /**
     * @return the recovery period start date of the Azure SQL Database. This
     * records the start date and time when recovery is available for this
     * Azure SQL Database.
     */
    DateTime earliestRestoreDate();

    /**
     * @return the edition of the Azure SQL Database
     */
    DatabaseEdition edition();

    /**
     *
     * @return the configured Service Level Objective Id of the Azure SQL
     * Database, this is the Service Level Objective that is being applied to
     * the Azure SQL Database
     */
    UUID requestedServiceObjectiveId();

    /**
     * @return the max size of the Azure SQL Database expressed in bytes.
     */
    long maxSizeBytes();

    /**
     * @return the name of the configured Service Level Objective of the Azure
     * SQL Database, this is the Service Level Objective that is being
     * applied to the Azure SQL Database
     */
    ServiceObjectiveName requestedServiceObjectiveName();

    /**
     * @return the Service Level Objective of the Azure SQL Database.
     */
    ServiceObjectiveName serviceLevelObjective();

    /**
     * @return the status of the Azure SQL Database
     */
    String status();

    /**
     * @return the elasticPoolName value
     */
    String elasticPoolName();

    /**
     * @return the defaultSecondaryLocation value
     */
    String defaultSecondaryLocation();

    /**
     * @return the parent SQL server ID
     */
    String parentId();

    /**
     * @return the name of the region the resource is in
     */
    String regionName();

    /**
     * @return the region the resource is in
     */
    Region region();

    /**
     * @return true if this Database is SqlWarehouse
     */
    boolean isDataWarehouse();

    /**
     * @return SqlWarehouse instance for more operations
     */
    @Method
    SqlWarehouse asWarehouse();

    /**
     * @return the list of all restore points on this database
     */
    @Method
    List<RestorePoint> listRestorePoints();

    /**
     * @return the list of all restore points on this database
     */
    @Method
    @Beta(Beta.SinceVersion.V1_7_0)
    Observable<RestorePoint> listRestorePointsAsync();

    /**
     * @return the list of usages (DatabaseMetrics) of this database
     */
    @Method
    @Deprecated
    List<DatabaseMetric> listUsages();

    /**
     * @param filter an OData filter expression that describes a subset of metrics to return.
     * @return the list of metrics for this database
     */
    @Method
    @Beta(Beta.SinceVersion.V1_7_0)
    List<SqlDatabaseMetric> listMetrics(String filter);

    /**
     * @param filter an OData filter expression that describes a subset of metrics to return.
     * @return a representation of the deferred computation of the metrics for this database
     */
    @Method
    @Beta(Beta.SinceVersion.V1_7_0)
    Observable<SqlDatabaseMetric> listMetricsAsync(String filter);

    /**
     * @return the list of metric definitions for this database
     */
    @Method
    @Beta(Beta.SinceVersion.V1_7_0)
    List<SqlDatabaseMetricDefinition> listMetricDefinitions();

    /**
     * @return a representation of the deferred computation of the metric definitions for this database
     */
    @Method
    @Beta(Beta.SinceVersion.V1_7_0)
    Observable<SqlDatabaseMetricDefinition> listMetricDefinitionsAsync();

    /**
     * Gets an Azure SQL Database Transparent Data Encryption for this database.
     *
     * @return an Azure SQL Database Transparent Data Encryption for this database
     */
    @Method
    TransparentDataEncryption getTransparentDataEncryption();

    /**
     * Gets an Azure SQL Database Transparent Data Encryption for this database.
     *
     * @return a representation of the deferred computation of an Azure SQL Database Transparent Data Encryption for this database
     */
    @Method
    @Beta(Beta.SinceVersion.V1_7_0)
    Observable<TransparentDataEncryption> getTransparentDataEncryptionAsync();

    /**
     * @return information about service tier advisors for the current database
     */
    @Method
    Map<String, ServiceTierAdvisor> listServiceTierAdvisors();

    /**
     * @return a representation of the deferred computation of the information about service tier advisors for this database
     */
    @Method
    @Beta(Beta.SinceVersion.V1_7_0)
    Observable<ServiceTierAdvisor> listServiceTierAdvisorsAsync();

    /**
     * @return all the replication links associated with this database
     */
    @Method
    Map<String, ReplicationLink> listReplicationLinks();

    /**
     * @return a representation of the deferred computation of all the replication links associated with this database
     */
    @Method
    @Beta(Beta.SinceVersion.V1_7_0)
    Observable<ReplicationLink> listReplicationLinksAsync();

    /**
     * Exports the current database to a specified URI path.
     *
     * @param storageUri the storage URI to use
     * @return response object
     */
    @Beta(Beta.SinceVersion.V1_7_0)
    SqlDatabaseExportRequest.DefinitionStages.WithStorageTypeAndKey exportTo(String storageUri);

    /**
     * Exports the current database to an existing storage account and relative path.
     *
     * @param storageAccount an existing storage account to be used
     * @param containerName the container name within the storage account to use
     * @param fileName the exported database file name
     * @return response object
     */
    @Beta(Beta.SinceVersion.V1_7_0)
    SqlDatabaseExportRequest.DefinitionStages.WithAuthenticationTypeAndLoginPassword exportTo(StorageAccount storageAccount, String containerName, String fileName);

    /**
     * Exports the current database to a new storage account and relative path.
     *
     * @param storageAccountCreatable a storage account to be created as part of this execution flow
     * @param containerName the container name within the storage account to use
     * @param fileName the exported database file name
     * @return response object
     */
    @Beta(Beta.SinceVersion.V1_7_0)
    SqlDatabaseExportRequest.DefinitionStages.WithAuthenticationTypeAndLoginPassword exportTo(Creatable<StorageAccount> storageAccountCreatable, String containerName, String fileName);

    /**
     * Imports into the current database from a specified URI path; the current database must be empty.
     *
     * @param storageUri the storage URI to use
     * @return response object
     */
    @Beta(Beta.SinceVersion.V1_7_0)
    SqlDatabaseImportRequest.DefinitionStages.WithStorageTypeAndKey importBacpac(String storageUri);

    /**
     * Imports into the current database from an existing storage account and relative path; the current database must be empty.
     *
     * @param storageAccount an existing storage account to be used
     * @param containerName the container name within the storage account to use
     * @param fileName the exported database file name
     * @return response object
     */
    @Beta(Beta.SinceVersion.V1_7_0)
    SqlDatabaseImportRequest.DefinitionStages.WithAuthenticationTypeAndLoginPassword importBacpac(StorageAccount storageAccount, String containerName, String fileName);

    /**
     * Begins a definition for a security alert policy.
     *
     * @param policyName the name of the security alert policy
     * @return the first stage of the SqlDatabaseThreatDetectionPolicy definition
     */
    @Beta(Beta.SinceVersion.V1_7_0)
    SqlDatabaseThreatDetectionPolicy.DefinitionStages.Blank defineThreatDetectionPolicy(String policyName);

    /**
     * Gets a SQL database threat detection policy.
     *
     * @return the SQL database threat detection policy for the current database
     */
    @Method
    @Beta(Beta.SinceVersion.V1_7_0)
    SqlDatabaseThreatDetectionPolicy getThreatDetectionPolicy();

    /**
     * Gets a SQL database automatic tuning state and options.
     *
     * @return the SQL database automatic tuning state and options
     */
    @Method
    @Beta(Beta.SinceVersion.V1_8_0)
    SqlDatabaseAutomaticTuning getDatabaseAutomaticTuning();

    /**
     * Lists the SQL database usage metrics.
     *
     * @return the SQL database usage metrics
     */
    @Method
    @Beta(Beta.SinceVersion.V1_8_0)
    List<SqlDatabaseUsageMetric> listUsageMetrics();

    /**
     * Asynchronously lists the SQL database usage metrics.
     *
     * @return a representation of the deferred computation of this call returning the SQL database usage metrics
     */
    @Method
    @Beta(Beta.SinceVersion.V1_8_0)
    Observable<SqlDatabaseUsageMetric> listUsageMetricsAsync();


    /**
     * Renames the database.
     *
     * @param newDatabaseName the new name for the database
     * @return the renamed SQL database
     */
    @Method
    @Beta(Beta.SinceVersion.V1_8_0)
    SqlDatabase rename(String newDatabaseName);

    /**
     * Renames the database asynchronously.
     *
     * @param newDatabaseName the new name for the database
     * @return a representation of the deferred computation of this call
     */
    @Method
    @Beta(Beta.SinceVersion.V1_8_0)
    Observable<SqlDatabase> renameAsync(String newDatabaseName);

    /**
     * Deletes the database from the server.
     */
    @Method
    void delete();

    /**
     * Deletes the database asynchronously.
     *
     * @return a representation of the deferred computation of this call
     */
    @Method
    @Beta(Beta.SinceVersion.V1_7_0)
    Completable deleteAsync();

    /**
     * @return the SQL Sync Group entry point for the current database
     */
    @Beta(Beta.SinceVersion.V1_9_0)
    SqlSyncGroupOperations.SqlSyncGroupActionsDefinition syncGroups();


    /**************************************************************
     * Fluent interfaces to provision a SQL Database
     **************************************************************/

    /**
     * Container interface for all the definitions that need to be implemented.
     *
     * @param <ParentT> the stage of the parent definition to return to after attaching this definition
     */
    interface SqlDatabaseDefinition<ParentT> extends
        SqlDatabase.DefinitionStages.Blank<ParentT>,
        SqlDatabase.DefinitionStages.WithAllDifferentOptions<ParentT>,
        SqlDatabase.DefinitionStages.WithElasticPoolName<ParentT>,
        SqlDatabase.DefinitionStages.WithRestorableDroppedDatabase<ParentT>,
        SqlDatabase.DefinitionStages.WithImportFrom<ParentT>,
        SqlDatabase.DefinitionStages.WithStorageKey<ParentT>,
        SqlDatabase.DefinitionStages.WithAuthentication<ParentT>,
        SqlDatabase.DefinitionStages.WithRestorePointDatabase<ParentT>,
        SqlDatabase.DefinitionStages.WithSourceDatabaseId<ParentT>,
        SqlDatabase.DefinitionStages.WithCreateMode<ParentT>,
        SqlDatabase.DefinitionStages.WithAttachAllOptions<ParentT>,
        SqlDatabase.DefinitionStages.WithAttachFinal<ParentT> {
    }

    /**
     * Grouping of all the SQL Database definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the SQL Server Firewall rule definition.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface Blank<ParentT> extends
            SqlDatabase.DefinitionStages.WithAllDifferentOptions<ParentT> {
        }

        /**
         * The SQL database interface with all starting options for definition.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        @Beta(Beta.SinceVersion.V1_7_0)
        interface WithAllDifferentOptions<ParentT> extends
            SqlDatabase.DefinitionStages.WithElasticPoolName<ParentT>,
            SqlDatabase.DefinitionStages.WithRestorableDroppedDatabase<ParentT>,
            SqlDatabase.DefinitionStages.WithImportFrom<ParentT>,
            SqlDatabase.DefinitionStages.WithRestorePointDatabase<ParentT>,
            SqlDatabase.DefinitionStages.WithSampleDatabase<ParentT>,
            SqlDatabase.DefinitionStages.WithSourceDatabaseId<ParentT>,
            SqlDatabase.DefinitionStages.WithEditionDefaults<ParentT>,
            SqlDatabase.DefinitionStages.WithAttachAllOptions<ParentT> {
        }

        /**
         * The SQL Database definition to set the elastic pool for database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithElasticPoolName<ParentT>  {
            /**
             * Sets the existing elastic pool for the SQLDatabase.
             *
             * @param elasticPoolName for the SQL Database
             * @return The next stage of the definition.
             */
            WithExistingDatabaseAfterElasticPool<ParentT> withExistingElasticPool(String elasticPoolName);

            /**
             * Sets the existing elastic pool for the SQLDatabase.
             *
             * @param sqlElasticPool for the SQL Database
             * @return The next stage of the definition.
             */
            WithExistingDatabaseAfterElasticPool<ParentT> withExistingElasticPool(SqlElasticPool sqlElasticPool);

            /**
             * Sets the new elastic pool for the SQLDatabase, this will create a new elastic pool while creating database.
             *
             * @param sqlElasticPool creatable definition for new elastic pool to be created for the SQL Database
             * @return The next stage of the definition.
             */
            WithExistingDatabaseAfterElasticPool<ParentT> withNewElasticPool(Creatable<SqlElasticPool> sqlElasticPool);
        }

        /**
         * The stage to decide whether using existing database or not.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithExistingDatabaseAfterElasticPool<ParentT> extends
            SqlDatabase.DefinitionStages.WithImportFromAfterElasticPool<ParentT>,
            SqlDatabase.DefinitionStages.WithRestorePointDatabaseAfterElasticPool<ParentT>,
            SqlDatabase.DefinitionStages.WithSampleDatabaseAfterElasticPool<ParentT>,
            SqlDatabase.DefinitionStages.WithSourceDatabaseId<ParentT>,
            SqlDatabase.DefinitionStages.WithAttachAfterElasticPoolOptions<ParentT> {
        }

        /**
         * The SQL Database definition to import a BACPAC file as the source database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithImportFrom<ParentT>  {
            /**
             * Creates a new database from a BACPAC file.
             *
             * @param storageUri the source URI for the database to be imported
             * @return The next stage of the definition.
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithStorageKey<ParentT> importFrom(String storageUri);

            /**
             * Creates a new database from a BACPAC file.
             *
             * @param storageAccount an existing storage account to be used
             * @param containerName the container name within the storage account to use
             * @param fileName the exported database file name
             * @return The next stage of the definition.
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAuthentication<ParentT> importFrom(StorageAccount storageAccount, String containerName, String fileName);
        }

        /**
         * Sets the storage key type and value to use.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithStorageKey<ParentT>  {
            /**
             * @param storageAccessKey the storage access key to use
             * @return next definition stage
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAuthentication<ParentT> withStorageAccessKey(String storageAccessKey);

            /**
             * @param sharedAccessKey the shared access key to use; it must be preceded with a "?."
             * @return next definition stage
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAuthentication<ParentT> withSharedAccessKey(String sharedAccessKey);
        }

        /**
         * Sets the authentication type and SQL or Active Directory administrator login and password.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithAuthentication<ParentT>  {
            /**
             * @param administratorLogin the SQL administrator login
             * @param administratorPassword the SQL administrator password
             * @return next definition stage
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAttachAllOptions<ParentT> withSqlAdministratorLoginAndPassword(String administratorLogin, String administratorPassword);

            /**
             * @param administratorLogin the Active Directory administrator login
             * @param administratorPassword the Active Directory administrator password
             * @return next definition stage
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAttachAllOptions<ParentT> withActiveDirectoryLoginAndPassword(String administratorLogin, String administratorPassword);
        }

        /**
         * The SQL Database definition to import a BACPAC file as the source database within an elastic pool.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithImportFromAfterElasticPool<ParentT>  {
            /**
             * Creates a new database from a BACPAC file.
             *
             * @param storageUri the source URI for the database to be imported
             * @return The next stage of the definition.
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithStorageKeyAfterElasticPool<ParentT> importFrom(String storageUri);

            /**
             * Creates a new database from a BACPAC file.
             *
             * @param storageAccount an existing storage account to be used
             * @param containerName the container name within the storage account to use
             * @param fileName the exported database file name
             * @return The next stage of the definition.
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAuthenticationAfterElasticPool<ParentT> importFrom(StorageAccount storageAccount, String containerName, String fileName);
        }

        /**
         * Sets the storage key type and value to use.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithStorageKeyAfterElasticPool<ParentT>  {
            /**
             * @param storageAccessKey the storage access key to use
             * @return next definition stage
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAuthenticationAfterElasticPool<ParentT> withStorageAccessKey(String storageAccessKey);

            /**
             * @param sharedAccessKey the shared access key to use; it must be preceded with a "?."
             * @return next definition stage
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAuthenticationAfterElasticPool<ParentT> withSharedAccessKey(String sharedAccessKey);
        }

        /**
         * Sets the authentication type and SQL or Active Directory administrator login and password.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithAuthenticationAfterElasticPool<ParentT>  {
            /**
             * @param administratorLogin the SQL administrator login
             * @param administratorPassword the SQL administrator password
             * @return next definition stage
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAttachFinal<ParentT> withSqlAdministratorLoginAndPassword(String administratorLogin, String administratorPassword);

            /**
             * @param administratorLogin the Active Directory administrator login
             * @param administratorPassword the Active Directory administrator password
             * @return next definition stage
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAttachFinal<ParentT> withActiveDirectoryLoginAndPassword(String administratorLogin, String administratorPassword);
        }

        /**
         * The SQL Database definition to set a restorable dropped database as the source database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithRestorableDroppedDatabase<ParentT>  {
            /**
             * Creates a new database from a previously deleted database (see restorable dropped database).
             * <p>
             * Collation, Edition, and MaxSizeBytes must remain the same while the link is
             * active. Values specified for these parameters will be ignored.
             *
             * @param restorableDroppedDatabase the restorable dropped database
             * @return The next stage of the definition.
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAttachFinal<ParentT> fromRestorableDroppedDatabase(SqlRestorableDroppedDatabase restorableDroppedDatabase);
        }

        /**
         * The SQL Database definition to set a restore point as the source database within an elastic pool.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithRestorePointDatabaseAfterElasticPool<ParentT>  {
            /**
             * Creates a new database from a restore point.
             *
             * @param restorePoint the restore point
             * @return The next stage of the definition.
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAttachAfterElasticPoolOptions<ParentT> fromRestorePoint(RestorePoint restorePoint);

            /**
             * Creates a new database from a restore point.
             *
             * @param restorePoint the restore point
             * @param restorePointDateTime date and time to restore from
             * @return The next stage of the definition.
             */
            @Beta(Beta.SinceVersion.V1_8_0)
            SqlDatabase.DefinitionStages.WithAttachAfterElasticPoolOptions<ParentT> fromRestorePoint(RestorePoint restorePoint, DateTime restorePointDateTime);
        }

        /**
         * The SQL Database definition to set a restore point as the source database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithRestorePointDatabase<ParentT>  {
            /**
             * Creates a new database from a restore point.
             *
             * @param restorePoint the restore point
             * @return The next stage of the definition.
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAttachAllOptions<ParentT> fromRestorePoint(RestorePoint restorePoint);

            /**
             * Creates a new database from a restore point.
             *
             * @param restorePoint the restore point
             * @param restorePointDateTime date and time to restore from
             * @return The next stage of the definition.
             */
            @Beta(Beta.SinceVersion.V1_8_0)
            SqlDatabase.DefinitionStages.WithAttachAllOptions<ParentT> fromRestorePoint(RestorePoint restorePoint, DateTime restorePointDateTime);
        }

        /**
         * The SQL Database definition to set a sample database as the source database within an elastic pool.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithSampleDatabaseAfterElasticPool<ParentT>  {
            /**
             * Creates a new database from a restore point.
             *
             * @param sampleName the sample database to use as the source
             * @return The next stage of the definition.
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAttachAfterElasticPoolOptions<ParentT> fromSample(SampleName sampleName);
        }

        /**
         * The SQL Database definition to set a sample database as the source database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithSampleDatabase<ParentT>  {
            /**
             * Creates a new database from a restore point.
             *
             * @param sampleName the sample database to use as the source
             * @return The next stage of the definition.
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithAttachAllOptions<ParentT> fromSample(SampleName sampleName);
        }

        /**
         * The SQL Database definition to set the source database id for database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithSourceDatabaseId<ParentT>  {

            /**
             * Sets the resource if of source database for the SQL Database.
             * <p>
             * Collation, Edition, and MaxSizeBytes must remain the same while the link is
             * active. Values specified for these parameters will be ignored.
             *
             * @param sourceDatabaseId id of the source database
             * @return The next stage of the definition.
             */
            SqlDatabase.DefinitionStages.WithCreateMode<ParentT> withSourceDatabase(String sourceDatabaseId);

            /**
             * Sets the resource if of source database for the SQL Database.
             * <p>
             * Collation, Edition, and MaxSizeBytes must remain the same while the link is
             * active. Values specified for these parameters will be ignored.
             *
             * @param sourceDatabase instance of the source database
             * @return The next stage of the definition.
             */
            SqlDatabase.DefinitionStages.WithCreateMode<ParentT> withSourceDatabase(SqlDatabase sourceDatabase);
        }

        /**
         * The SQL Database definition to set the create mode for database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithCreateMode<ParentT>  {
            /**
             * Sets the create mode for the SQL Database.
             *
             * @param createMode create mode for the database, should not be default in this flow
             * @return The next stage of the definition.
             */
            SqlDatabase.DefinitionStages.WithAttachFinal<ParentT> withMode(CreateMode createMode);
        }

        /**
         * The final stage of the SQL Database definition after the SQL Elastic Pool definition.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithAttachAfterElasticPoolOptions<ParentT>  extends
            SqlDatabase.DefinitionStages.WithCollationAfterElasticPoolOptions<ParentT>,
            SqlDatabase.DefinitionStages.WithMaxSizeBytesAfterElasticPoolOptions<ParentT>,
            SqlDatabase.DefinitionStages.WithAttachFinal<ParentT> {

        }

        /**
         * The SQL Database definition to set the collation for database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithCollationAfterElasticPoolOptions<ParentT>  {
            /**
             * Sets the collation for the SQL Database.
             *
             * @param collation collation to be set for database
             * @return The next stage of the definition
             */
            SqlDatabase.DefinitionStages.WithAttachAfterElasticPoolOptions<ParentT> withCollation(String collation);
        }

        /**
         * The SQL Database definition to set the Max Size in Bytes for database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithMaxSizeBytesAfterElasticPoolOptions<ParentT> {
            /**
             * Sets the max size in bytes for SQL Database.
             *
             * @param maxSizeBytes max size of the Azure SQL Database expressed in bytes. Note: Only
             * the following sizes are supported (in addition to limitations being
             * placed on each edition): { 100 MB | 500 MB |1 GB | 5 GB | 10 GB | 20
             * GB | 30 GB … 150 GB | 200 GB … 500 GB }
             * @return The next stage of the definition.
             */
            SqlDatabase.DefinitionStages.WithAttachAfterElasticPoolOptions<ParentT> withMaxSizeBytes(long maxSizeBytes);
        }

        /**
         * The SQL Database definition to set the edition for database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithEdition<ParentT> {
            /**
             * Sets the edition for the SQL Database.
             *
             * @param edition edition to be set for database
             * @return The next stage of the definition
             */
            @Deprecated
            SqlDatabase.DefinitionStages.WithAttachAllOptions<ParentT> withEdition(DatabaseEdition edition);
        }

        /**
         * The SQL Database definition to set the edition default for database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithEditionDefaults<ParentT> extends WithAttachFinal<ParentT> {
            /**
             * Sets a "Basic" edition for the SQL Database.
             *
             * @return The next stage of the definition
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithEditionDefaults<ParentT> withBasicEdition();

            /**
             * Sets a "Basic" edition and maximum storage capacity for the SQL Database.
             *
             * @param maxStorageCapacity the max storage capacity
             * @return The next stage of the definition
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithEditionDefaults<ParentT> withBasicEdition(SqlDatabaseBasicStorage maxStorageCapacity);

            /**
             * Sets a "Standard" edition for the SQL Database.
             *
             * @param serviceObjective edition to be set for database
             * @return The next stage of the definition
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithEditionDefaults<ParentT> withStandardEdition(SqlDatabaseStandardServiceObjective serviceObjective);

            /**
             * Sets a "Standard" edition and maximum storage capacity for the SQL Database.
             *
             * @param serviceObjective edition to be set for database
             * @param maxStorageCapacity edition to be set for database
             * @return The next stage of the definition
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithEditionDefaults<ParentT> withStandardEdition(SqlDatabaseStandardServiceObjective serviceObjective, SqlDatabaseStandardStorage maxStorageCapacity);

            /**
             * Sets a "Premium" edition for the SQL Database.
             *
             * @param serviceObjective edition to be set for database
             * @return The next stage of the definition
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithEditionDefaults<ParentT> withPremiumEdition(SqlDatabasePremiumServiceObjective serviceObjective);

            /**
             * Sets a "Premium" edition and maximum storage capacity for the SQL Database.
             *
             * @param serviceObjective edition to be set for database
             * @param maxStorageCapacity edition to be set for database
             * @return The next stage of the definition
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            SqlDatabase.DefinitionStages.WithEditionDefaults<ParentT> withPremiumEdition(SqlDatabasePremiumServiceObjective serviceObjective, SqlDatabasePremiumStorage maxStorageCapacity);

            /**
             * The SQL Database definition to set the collation for database.
             *
             * @param <ParentT> the stage of the parent definition to return to after attaching this definition
             */
            interface WithCollation<ParentT> {
                /**
                 * Sets the collation for the SQL Database.
                 *
                 * @param collation collation to be set for database
                 * @return The next stage of the definition
                 */
                SqlDatabase.DefinitionStages.WithEditionDefaults<ParentT> withCollation(String collation);
            }
        }

        /**
         * The SQL Database definition to set the collation for database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithCollation<ParentT> {
            /**
             * Sets the collation for the SQL Database.
             *
             * @param collation collation to be set for database
             * @return The next stage of the definition
             */
            SqlDatabase.DefinitionStages.WithAttachAllOptions<ParentT> withCollation(String collation);
        }

        /**
         * The SQL Database definition to set the Max Size in Bytes for database.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithMaxSizeBytes<ParentT> {
            /**
             * Sets the max size in bytes for SQL Database.
             *
             * @param maxSizeBytes max size of the Azure SQL Database expressed in bytes. Note: Only
             * the following sizes are supported (in addition to limitations being
             * placed on each edition): { 100 MB | 500 MB |1 GB | 5 GB | 10 GB | 20
             * GB | 30 GB … 150 GB | 200 GB … 500 GB }
             * @return The next stage of the definition.
             */
            @Deprecated
            SqlDatabase.DefinitionStages.WithAttachAllOptions<ParentT> withMaxSizeBytes(long maxSizeBytes);
        }

        /**
         * The SQL Database definition to set the service level objective.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithServiceObjective<ParentT> {
            /**
             * Sets the service level objective for the SQL Database.
             *
             * @param serviceLevelObjective service level objected for the SQL Database
             * @return The next stage of the definition.
             */
            @Deprecated
            SqlDatabase.DefinitionStages.WithAttachAllOptions<ParentT> withServiceObjective(ServiceObjectiveName serviceLevelObjective);
        }


        /**
         * The final stage of the SQL Database definition with all the other options.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithAttachAllOptions<ParentT> extends
            SqlDatabase.DefinitionStages.WithServiceObjective<ParentT>,
            SqlDatabase.DefinitionStages.WithEdition<ParentT>,
            SqlDatabase.DefinitionStages.WithEditionDefaults<ParentT>,
            SqlDatabase.DefinitionStages.WithCollation<ParentT>,
            SqlDatabase.DefinitionStages.WithMaxSizeBytes<ParentT>,
            SqlDatabase.DefinitionStages.WithAttachFinal<ParentT> {
        }

        /** The final stage of the SQL Database definition.
         * <p>
         * At this stage, any remaining optional settings can be specified, or the SQL Database definition
         * can be attached to the parent SQL Server definition.
         *
         * @param <ParentT> the stage of the parent definition to return to after attaching this definition
         */
        interface WithAttachFinal<ParentT> extends
            Attachable.InDefinition<ParentT> {
        }
    }

    /**
     * The template for a SqlDatabase update operation, containing all the settings that can be modified.
     */
    interface Update extends
        UpdateStages.WithEdition,
        UpdateStages.WithElasticPoolName,
        UpdateStages.WithMaxSizeBytes,
        UpdateStages.WithServiceObjective,
        Resource.UpdateWithTags<SqlDatabase.Update>,
        Appliable<SqlDatabase> {
    }

    /**
     * Grouping of all the SqlDatabase update stages.
     */
    interface UpdateStages {

        /**
         * The SQL Database definition to set the edition for database.
         */
        interface WithEdition {
            /**
             * Sets the edition for the SQL Database.
             *
             * @param edition edition to be set for database
             * @return The next stage of the update.
             */
            @Deprecated
            Update withEdition(DatabaseEdition edition);
            /**
             * Sets a "Basic" edition for the SQL Database.
             *
             * @return The next stage of the definition
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            Update withBasicEdition();

            /**
             * Sets a "Basic" edition and maximum storage capacity for the SQL Database.
             *
             * @param maxStorageCapacity the max storage capacity
             * @return The next stage of the definition
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            Update withBasicEdition(SqlDatabaseBasicStorage maxStorageCapacity);

            /**
             * Sets a "Standard" edition for the SQL Database.
             *
             * @param serviceObjective edition to be set for database
             * @return The next stage of the definition
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            Update withStandardEdition(SqlDatabaseStandardServiceObjective serviceObjective);

            /**
             * Sets a "Standard" edition and maximum storage capacity for the SQL Database.
             *
             * @param serviceObjective edition to be set for database
             * @param maxStorageCapacity edition to be set for database
             * @return The next stage of the definition
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            Update withStandardEdition(SqlDatabaseStandardServiceObjective serviceObjective, SqlDatabaseStandardStorage maxStorageCapacity);

            /**
             * Sets a "Premium" edition for the SQL Database.
             *
             * @param serviceObjective edition to be set for database
             * @return The next stage of the definition
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            Update withPremiumEdition(SqlDatabasePremiumServiceObjective serviceObjective);

            /**
             * Sets a "Premium" edition and maximum storage capacity for the SQL Database.
             *
             * @param serviceObjective edition to be set for database
             * @param maxStorageCapacity edition to be set for database
             * @return The next stage of the definition
             */
            @Beta(Beta.SinceVersion.V1_7_0)
            Update withPremiumEdition(SqlDatabasePremiumServiceObjective serviceObjective, SqlDatabasePremiumStorage maxStorageCapacity);
        }

        /**
         * The SQL Database definition to set the Max Size in Bytes for database.
         */
        interface WithMaxSizeBytes {
            /**
             * Sets the max size in bytes for SQL Database.
             * @param maxSizeBytes max size of the Azure SQL Database expressed in bytes. Note: Only
             * the following sizes are supported (in addition to limitations being
             * placed on each edition): { 100 MB | 500 MB |1 GB | 5 GB | 10 GB | 20
             * GB | 30 GB … 150 GB | 200 GB … 500 GB }
             * @return The next stage of the update.
             */
            @Deprecated
            Update withMaxSizeBytes(long maxSizeBytes);
        }

        /**
         * The SQL Database definition to set the service level objective.
         */
        interface WithServiceObjective {
            /**
             * Sets the service level objective for the SQL Database.
             *
             * @param serviceLevelObjective service level objected for the SQL Database
             * @return The next stage of the update.
             */
            @Deprecated
            Update withServiceObjective(ServiceObjectiveName serviceLevelObjective);
        }

        /**
         * The SQL Database definition to set the elastic pool for database.
         */
        interface WithElasticPoolName {
            /**
             * Removes database from it's elastic pool.
             *
             * @return The next stage of the update.
             */
            WithEdition withoutElasticPool();

            /**
             * Sets the existing elastic pool for the SQLDatabase.
             *
             * @param elasticPoolName for the SQL Database
             * @return The next stage of the update.
             */
            Update withExistingElasticPool(String elasticPoolName);

            /**
             * Sets the existing elastic pool for the SQLDatabase.
             *
             * @param sqlElasticPool for the SQL Database
             * @return The next stage of the update.
             */
            Update withExistingElasticPool(SqlElasticPool sqlElasticPool);

            /**
             * Sets the new elastic pool for the SQLDatabase, this will create a new elastic pool while creating database.
             *
             * @param sqlElasticPool creatable definition for new elastic pool to be created for the SQL Database
             * @return The next stage of the update.
             */
            Update withNewElasticPool(Creatable<SqlElasticPool> sqlElasticPool);
        }
    }
}
