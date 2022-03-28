# fpuna-backend-template

## Requeriemientos

- Java
- Maven
- Wildfly
- PostgreSQL

## Configuración

Se debe configurar el Datasource en Wildfly para el acceso a la base de datos ([Instrucciones](https://www.stenusys.com/how_to_setup_postgresql_datasource_with_wildfly/)) y modificar el archivo `src/main/resources/META-INF/persistance.xml` de modo a utilizar el Datasource creado:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0" xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
   <persistence-unit name="fidelizacion">
      <!-- If you are running in a production environment, add a managed 
         data source, this example data source is just for development and testing! -->
      <!-- The datasource is deployed as ${ds-deployment-location}, you
         can find it in the source at postgres_local-ds.xml -->
      <jta-data-source>[JDI_NAME_DEL_DATASOURCE]</jta-data-source>
      <class>com.backend.fidelizacion.model.Persona</class>
      <properties>
         <property name="hibernate.id.new_generator_mappings" value="true"/>
         <property name="hibernate.show_sql" value="true" />
         <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
         
      </properties>
   </persistence-unit>
</persistence>
```

Luego se debe crear el archivo `env-variables.sh`:
```bash
cp env-variables.sh.example env-variables.sh
```
y rellenar con la variables de entorno.

## Uso

Para ejecutar las migraciones:
```bash
./migrate.sh
```

Para construit y desplegar el proyecto:
```bash
./deploy.sh
```
