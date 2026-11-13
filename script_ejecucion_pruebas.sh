echo ==================================================
echo Ejecutando pruebas sobre el Servicio Central
echo ==================================================

URL_BASE=http://localhost:9000/api/servicio-central

echo ""
echo "[PRUEBA 1] Obtener el Inventario de Productos"
curl -X GET "$URL_BASE/inventario" -H "Accept: application/json" -i

echo ""
echo ""
echo "[PRUEBA 2] Obtener las Ventas"
curl -X GET "$URL_BASE/ventas" -H "Accept: application/json" -i

echo ""
echo ""
echo "[PRUEBA 3] Obtener los Contenidos Digitales almacenados"
curl -X GET "$URL_BASE/contenido-digital" -H "Accept: application/json" -i

echo ""
echo ""
echo "[PRUEBA 4] Obtener las Incidencias"
curl -X GET "$URL_BASE/incidencias" -H "Accept: application/json" -i

echo ""
echo ""
echo "[PRUEBA 5] Obtener un producto con su imagen almacenada en contenido digital"
curl -X GET "$URL_BASE/producto-con-imagen/1" -H "Accept: application/json" -i

echo ""
echo ""
echo "[PRUEBA 6] Consultar el Dashboard"
curl -X GET "$URL_BASE/dashboard" -H "Accept: application/json" -i

echo ""
echo ""
echo "[PRUEBA 7] Crear una nueva Venta (POST)"
curl -X POST "$URL_BASE/ventas" \
     -H "Content-Type: application/json" \
     -d "{
           \"idCliente\": 123,
           \"total\": 20.00,
           \"lineasVenta\": [
             {
               \"idProducto\": 1,
               \"cantidad\": 2,
               \"precioUnitario\": 10.00
             }
           ]
         }" -i

echo ""
echo ""
sleep 10
echo "[Continuación de PRUEBA 7] Obtener el Inventario de Productos para ver que se redujo el stock de 3 a 1"
curl -X GET "$URL_BASE/inventario" -H "Accept: application/json" -i

echo ""
echo ""
echo "=================================================="
echo "Pruebas finalizadas."