echo "=================================================="
echo "Deteniendo el sistema de Microservicios..."
echo "=================================================="

# Matar procesos específicos por nombre en su línea de comandos
pkill -f "config-server"
pkill -f "eureka-server"
pkill -f "inventario-0.0.1-SNAPSHOT.jar"
pkill -f "ventas-0.0.1-SNAPSHOT.jar"
pkill -f "contenido_digital-0.0.1-SNAPSHOT.jar"
pkill -f "incidencias-0.0.1-SNAPSHOT.jar"
pkill -f "servicio_central"

echo "¡Todos los microservicios de la joyería han sido detenidos!"