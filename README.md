## 📌 Proyecto prueba neoris 📌
Api Rest neoris

--------------------
## 💾 README 💾
--------------------

## 🔰 **Pasos para despliegue de proyecto neoris**  


	📌 Pre-requisitos
			◾ Java 17
			◾ Docker latest version
			◾ Docker compose latest version
			◾ Intellij IDEA latest version

	📌 Dependencias
			◾ Descargar proyecto (https://github.com/johnnatanb/neoris.git)
			◾ Abrir proyecto con Intellij IDEA

	📌 Despliegue Aplicación						
			◾ Ejecutar comando en la raiz del proyecto
				◾ docker-compose up --build (Este comando se encarga de desplegar la aplicación junto con la base de datos)
				◾ despues de desplegar la aplicación y la BD, se debe conectar a la base de datos con un cliente de mysql (MySql Workbench) y crear las tablas que se encuentran en el script scripts_mysql/BaseDatos.sql
				
	📌 Probar la aplicación
		◾ Importar las colecciones de postman que se encuentran en la carpeta postman, estas colecciones tienen los request de /clientes, /cuentas y /movimientos.
				
--------------------------------------------
## Author
	👤 Johnnatan Brausin Rodriguez
		✉ johnnatan.brausin.1990@gmail.com
    ✉ johnnatan_brausin_1990@hotmail.com
--------------------------------------------
