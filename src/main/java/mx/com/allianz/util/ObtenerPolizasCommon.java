package mx.com.allianz.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.allianz.config.ProductosConfiguration;
import mx.com.allianz.model.FamiliaProducto;
import mx.com.allianz.model.Producto;

public class ObtenerPolizasCommon {
	@Autowired
	private ProductosConfiguration productosConfiguration;

	public List<Producto> obtenerTodosLosProductos() {
		String familiasHogar = productosConfiguration.getProductosHogar();
		String familiasSalud = productosConfiguration.getProductosSalud();
		String familiasProteccion = productosConfiguration.getProductosProteccion();
		String familiasAhorro = productosConfiguration.getProductosAhorro();
		String familiasInversion = productosConfiguration.getProductosInversion();
		String familiasAuto = productosConfiguration.getProductosAuto();
		List<Producto> todos = new ArrayList<Producto>();
		todos.addAll(obtenerProductos(familiasHogar, "hogar"));
		todos.addAll(obtenerProductos(familiasSalud, "salud"));
		todos.addAll(obtenerProductos(familiasProteccion, "proteccion"));
		todos.addAll(obtenerProductos(familiasAhorro, "ahorro"));
		todos.addAll(obtenerProductos(familiasInversion, "inversion"));
		todos.addAll(obtenerProductos(familiasAuto, "auto"));
		return todos;
	}

	private List<Producto> obtenerProductos(String productos, String familia) {

		if (productos != null) {
			String[] productosArreglo = productos.split(",");
			if (productosArreglo != null) {
				List<Producto> productosCatalogo = new ArrayList<Producto>();
				for (String producto : productosArreglo) {
					FamiliaProducto familiaProducto = new FamiliaProducto(familia, producto, "#");
					Producto productoAIngresar = new Producto(familiaProducto, producto, producto);
					productosCatalogo.add(productoAIngresar);
				}
				return productosCatalogo;
			}
		}

		return null;
	}

}
