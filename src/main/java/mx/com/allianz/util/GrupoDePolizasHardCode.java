package mx.com.allianz.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import mx.com.allianz.model.FamiliaProducto;
import mx.com.allianz.model.Producto;
import mx.com.allianz.model.ProductosConfiguracionModel;

@Service
public class GrupoDePolizasHardCode {
	private JSONObject familiasParaLaRuleta = JSONFactoryUtil.createJSONObject();

	public String setFamilia(String producto, List<Producto> todosLosProductos) {
		String familia = "";
		boolean existeEnElCatalogo = false;
		if (todosLosProductos != null) {
			for (Producto productoActual : todosLosProductos) {
				if (productoActual.getIdProducto().equalsIgnoreCase(producto)) {
					familia = productoActual.getFamiliaProducto().getIdFamilia();
					existeEnElCatalogo = true;
					break;
				}
			}
		}
		if (!familia.equals("") && existeEnElCatalogo) {

			familiasParaLaRuleta.put("" + familia, true);
		} else {
			familia = "404";
			familiasParaLaRuleta.put("404", true);
		}
		return familia;
	}

	public JSONObject obtenerJsonFamiliasParaLaRuleta() {
		return familiasParaLaRuleta;
	}

	private void obtenerTodasLasFamilias(List<Producto> todasLosProductos) {
		List<Producto> familiasSinRepetir = new ArrayList<>();
		if (todasLosProductos != null) {
			for (Producto familia : todasLosProductos) {
				if (!familiaYaExiste(familia.getFamiliaProducto().getIdFamilia(), familiasSinRepetir)) {
					familiasSinRepetir.add(familia);
				}
			}
			for (int i = 0; i < familiasSinRepetir.size(); i++) {
				familiasParaLaRuleta.put(familiasSinRepetir.get(i).getFamiliaProducto().getIdFamilia(), false);
			}
		}
	}

	private boolean familiaYaExiste(String familia, List<Producto> productos) {
		if (familia != null && !familia.trim().isEmpty() && productos != null) {
			for (Producto producto : productos) {
				if (familia.equalsIgnoreCase(producto.getFamiliaProducto().getIdFamilia())) {
					return true;
				}
			}
		}
		return false;
	}

	public String obtenerColor(String emisor, List<Producto> todosLosProductos) {
		if (emisor != null) {
			if (todosLosProductos != null) {
				for (Producto productoActual : todosLosProductos) {
					if (productoActual.getIdProducto().equalsIgnoreCase(emisor)) {
						return productoActual.getFamiliaProducto().getColorHexadecimal();
					}
				}
			}
		}
		return null;
	}

	public List<Producto> obtenerTodosLosProductos(ProductosConfiguracionModel productos) {

		List<Producto> todos = new ArrayList<Producto>();
		todos.addAll(obtenerProductos(productos.getFamiliasHogar(), "hogar"));
		todos.addAll(obtenerProductos(productos.getFamiliasSalud(), "salud"));
		todos.addAll(obtenerProductos(productos.getFamiliasProteccion(), "proteccion"));
		todos.addAll(obtenerProductos(productos.getFamiliasAhorro(), "ahorro"));
		todos.addAll(obtenerProductos(productos.getFamiliasInversion(), "inversion"));
		todos.addAll(obtenerProductos(productos.getFamiliasAuto(), "auto"));
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
