cd inventario
mvn clean package

cd ..

cd ventas
mvn clean package

cd ..

cd contenido_digital
mvn clean package

cd ..

cd incidencias
mvn clean package

cd ..

cd servicio_central
mvn clean package

cd ..

cd eureka-server
mvn clean package

cd ..

cd config-server
mvn clean package

echo "=================================================="
echo "Servicios compilados"
echo "=================================================="