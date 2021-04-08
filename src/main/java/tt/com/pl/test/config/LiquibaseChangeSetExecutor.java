package tt.com.pl.test.config;

import liquibase.Liquibase;
import liquibase.change.Change;
import liquibase.changelog.ChangeSet;
import liquibase.changelog.ChangeSet.ExecType;
import liquibase.changelog.ChangeSet.RunStatus;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.changelog.visitor.ChangeExecListener;
import liquibase.database.Database;
import liquibase.exception.LiquibaseException;
import liquibase.exception.PreconditionErrorException;
import liquibase.exception.PreconditionFailedException;
import liquibase.integration.spring.SpringLiquibase;
import liquibase.precondition.core.PreconditionContainer.ErrorOption;
import liquibase.precondition.core.PreconditionContainer.FailOption;

import java.sql.Connection;

public class LiquibaseChangeSetExecutor extends SpringLiquibase implements ChangeExecListener {

	boolean reRun = true;

	@Override
	public void afterPropertiesSet() throws LiquibaseException {
		while (reRun) {
			reRun = false;
			super.afterPropertiesSet();
		}
	}

	@Override
	protected Liquibase createLiquibase(Connection c) throws LiquibaseException {
		Liquibase liquibase = super.createLiquibase(c);
		liquibase.setChangeExecListener(this);
		return liquibase;
	}

	@Override
	public void willRun(ChangeSet changeSet, DatabaseChangeLog databaseChangeLog, Database database, RunStatus runStatus) {
	}

	@Override
	public void ran(ChangeSet changeSet, DatabaseChangeLog databaseChangeLog, Database database, ExecType execType) {
	}

	@Override
	public void willRollback(ChangeSet changeSet, DatabaseChangeLog databaseChangeLog, Database database) {

	}

	@Override
	public void rolledBack(ChangeSet changeSet, DatabaseChangeLog databaseChangeLog, Database database) {
	}

	@Override
	public void preconditionFailed(PreconditionFailedException error, FailOption onFail) {
		if (FailOption.CONTINUE.equals(onFail)) {
			reRun = true;
		}
	}

	@Override
	public void preconditionErrored(PreconditionErrorException error, ErrorOption onError) {
		if (FailOption.CONTINUE.equals(onError)) {
			reRun = true;
		}
	}

	@Override
	public void willRun(Change change, ChangeSet changeSet, DatabaseChangeLog changeLog, Database database) {
	}

	@Override
	public void ran(Change change, ChangeSet changeSet, DatabaseChangeLog changeLog, Database database) {
	}

	@Override
	public void runFailed(ChangeSet changeSet, DatabaseChangeLog databaseChangeLog, Database database, Exception exception) {
	}

	@Override
	public void rollbackFailed(ChangeSet changeSet, DatabaseChangeLog databaseChangeLog, Database database, Exception e) {

	}
}
