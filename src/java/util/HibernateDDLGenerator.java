/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;


import model.Restaurant;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Environment;

import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author hp
 */
public class HibernateDDLGenerator {
    
 public static void main(String[] args) { new HibernateDDLGenerator().execute(Dialect.PSTGRES,Restaurant.class);
 }
  private void execute(Dialect dialect, Class<?>... classes) {
 	 AnnotationConfiguration configuration = new AnnotationConfiguration();
	 configuration.setProperty(Environment.DIALECT, dialect.getClassName());
	 for (Class<?> entityClass : classes) {
	    configuration.addAnnotatedClass(entityClass);
	 }
         configuration.configure("hibernate.cfg.xml");
	SchemaExport schemaExport = new SchemaExport(configuration);
	schemaExport.setDelimiter(";");
	schemaExport.setOutputFile(String.format("%s_%s.%s ", new Object[] {"ddl", dialect.name().toLowerCase(), "sql" }));
	boolean consolePrint = true;
	boolean exportInDatabase = true;
	schemaExport.create(consolePrint, exportInDatabase);
   }
}

