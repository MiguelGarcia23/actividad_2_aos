cd config-server
nohup mvn spring-boot:run > config_server.log 2>&1 &

cd ..
sleep 15

cd eureka-server
nohup mvn spring-boot:run > eureka_server.log 2>&1 &

cd ..
sleep 15

cd inventario
nohup java -jar target/inventario-0.0.1-SNAPSHOT.jar > inventario.log 2>&1 &

cd ..

cd ventas
nohup java -jar target/ventas-0.0.1-SNAPSHOT.jar > ventas_1.log 2>&1 &

cd ..

cd contenido_digital
nohup java -jar target/contenido_digital-0.0.1-SNAPSHOT.jar > contenido_digital_1.log 2>&1 &

cd ..

cd incidencias
nohup java -jar target/incidencias-0.0.1-SNAPSHOT.jar > incidencias_1.log 2>&1 &

cd ..
sleep 10

# No se crean dos instancias del microservicio Inventario por el problema que se
# comenta en la documentación en el apartado "6.5. Consistencia de datos de stock"

cd ventas
nohup java -jar target/ventas-0.0.1-SNAPSHOT.jar > ventas_2.log 2>&1 &

cd ..

cd contenido_digital
nohup java -jar target/contenido_digital-0.0.1-SNAPSHOT.jar > contenido_digital_2.log 2>&1 &

cd ..

cd incidencias
nohup java -jar target/incidencias-0.0.1-SNAPSHOT.jar > incidencias_2.log 2>&1 &

cd ..
sleep 10

cd servicio_central
nohup mvn spring-boot:run > servicio_central.log 2>&1 &

cd ..
sleep 15

echo "=================================================="
echo "Servicios desplegados"
echo "=================================================="