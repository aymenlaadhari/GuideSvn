
package util;

   enum Dialect {
MYSQL("org.hibernate.dialect.MySQLInnoDBDialect"),
ORACLE("org.unhcr.omss.db.oracle.OracleDialectDeferredFK"),
PSTGRES("org.hibernate.dialect.PostgreSQLDialect"),
SYBASE("org.hibernate.dialect.SybaseAnywhereDialect");

private final String className;

private Dialect(String className) {
    this.className = className;
}

public String getClassName() {
    return className;
}
   }
