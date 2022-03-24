# fpuna-backend-template

## Requeriemientos

- Java
- Maven
- Wildfly
- PostgresQl

## Configuración

Se debe configurar el datasource en Wildfly para el acceso a la base de datos ([Instrucciones](https://www.stenusys.com/how_to_setup_postgresql_datasource_with_wildfly/))

Luego se debe crear el archivo `env-variables.sh`:
```bash
cp env-variables.sh.example env-variables.sh
```
y rellenar con la variables de entorno.

Por último se debe sar permisos de ejecución a los scripts de migración y despliegue
```bash
chmod +x migrate.sh deploy.sh
```

## Uso

Para ejecutar las migraciones:
```bash
./migrate.sh
```

Para construit y desplegar el proyecto:
```bash
./deploy.sh
```
