package com.egakat.econnect.maestros.constants;

public class RestConstants {
	
	final public static String base = "/api/maestros";

	final public static String bodega = base + "/bodega";

	final public static String canal = base + "/canal";

	final public static String ciudad = base + "/ciudad";

	final public static String cliente = base + "/cliente";

	final public static String departamento = base + "/departamento";

	final public static String direccion = base + "/direccion";

	final public static String empresa = base + "/empresa";
	
	final public static String estadoInventario = base + "/estado-inventario";

	final public static String lineaNegocio = base + "/linea-negocio";

	final public static String pais = base + "/pais";

	final public static String producto = base + "/producto";

	final public static String punto = base + "/punto";

	final public static String servicio = base + "/servicio";

	final public static String subestadoInventario = base + "/subestado-inventario";

	final public static String tercero = base + "/tercero";

	final public static String tipoRemesa = base + "/tipo-remesa";

	final public static String tipoRuta = base + "/tipo-ruta";

	final public static String unidadMedida = base + "/unidad-medida";

	final public static String unidadNegocio = base + "/unidad-negocio";


	final public static String serviciosByCliente = "/{id}/servicios";
	
	final public static String productosByCliente = "/{id}/productos";
	
	final public static String tercerosByCliente = "/{id}/terceros";
	
	final public static String direccionesByCliente = "/{id}/direcciones";
	
	
	final public static String atributosByProducto = "/{id}/atributos";

	final public static String codigosByProducto = "/{id}/codigos";

	final public static String medidasByProducto = "/{id}/medidas";
	

	final public static String departamentosByPais = "/{id}/departamentos";

	final public static String ciudadesByDepartamento = "/{id}/ciudades";
	
	final public static String puntosByTercero = "/{id}/puntos";
	
	final public static String lineasNegocioByUnidadNegocio = "/{id}/lineas-negocio";
	
	final public static String tiposRemesaByUnidadNegocio = "/{id}/tipos-remesa";

}
