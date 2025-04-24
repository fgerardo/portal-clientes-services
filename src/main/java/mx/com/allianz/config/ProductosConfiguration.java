package mx.com.allianz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "productos")
public class ProductosConfiguration {

	private String productosVisiblesPortal;
	private String productosHogar;
	private String productosSalud;
	private String productosProteccion;
	private String productosAhorro;
	private String productosInversion;
	private String productosAuto;
	private String pagosLineaPolizasSuceptibles;
	private String programarPagosPolizasSuceptibles;
	private String envioCobroSuceptibles;
	private String disponibleEnvioCobro;
	private String productosSuceptiblesCuentaSaldo;
	private String productosValidacionContratanteEmpresariales;

	public String getProductosHogar() {
		return productosHogar;
	}

	public void setProductosHogar(String productosHogar) {
		this.productosHogar = productosHogar;
	}

	public String getProductosSalud() {
		return productosSalud;
	}

	public void setProductosSalud(String productosSalud) {
		this.productosSalud = productosSalud;
	}

	public String getProductosProteccion() {
		return productosProteccion;
	}

	public void setProductosProteccion(String productosProteccion) {
		this.productosProteccion = productosProteccion;
	}

	public String getProductosAhorro() {
		return productosAhorro;
	}

	public void setProductosAhorro(String productosAhorro) {
		this.productosAhorro = productosAhorro;
	}

	public String getProductosInversion() {
		return productosInversion;
	}

	public void setProductosInversion(String productosInversion) {
		this.productosInversion = productosInversion;
	}

	public String getProductosAuto() {
		return productosAuto;
	}

	public void setProductosAuto(String productosAuto) {
		this.productosAuto = productosAuto;
	}

	public String getProductosVisiblesPortal() {
		return productosVisiblesPortal;
	}

	public void setProductosVisiblesPortal(String productosVisiblesPortal) {
		this.productosVisiblesPortal = productosVisiblesPortal;
	}

	public String getPagosLineaPolizasSuceptibles() {
		return pagosLineaPolizasSuceptibles;
	}

	public void setPagosLineaPolizasSuceptibles(String pagosLineaPolizasSuceptibles) {
		this.pagosLineaPolizasSuceptibles = pagosLineaPolizasSuceptibles;
	}

	public String getProgramarPagosPolizasSuceptibles() {
		return programarPagosPolizasSuceptibles;
	}

	public void setProgramarPagosPolizasSuceptibles(String programarPagosPolizasSuceptibles) {
		this.programarPagosPolizasSuceptibles = programarPagosPolizasSuceptibles;
	}

	public String getEnvioCobroSuceptibles() {
		return envioCobroSuceptibles;
	}

	public void setEnvioCobroSuceptibles(String envioCobroSuceptibles) {
		this.envioCobroSuceptibles = envioCobroSuceptibles;
	}

	public String getDisponibleEnvioCobro() {
		return disponibleEnvioCobro;
	}

	public void setDisponibleEnvioCobro(String disponibleEnvioCobro) {
		this.disponibleEnvioCobro = disponibleEnvioCobro;
	}

	public String getProductosSuceptiblesCuentaSaldo() {
		return productosSuceptiblesCuentaSaldo;
	}

	public void setProductosSuceptiblesCuentaSaldo(String productosSuceptiblesCuentaSaldo) {
		this.productosSuceptiblesCuentaSaldo = productosSuceptiblesCuentaSaldo;
	}

	public String getProductosValidacionContratanteEmpresariales() {
		return productosValidacionContratanteEmpresariales;
	}

	public void setProductosValidacionContratanteEmpresariales(String productosValidacionContratanteEmpresariales) {
		this.productosValidacionContratanteEmpresariales = productosValidacionContratanteEmpresariales;
	}

}
