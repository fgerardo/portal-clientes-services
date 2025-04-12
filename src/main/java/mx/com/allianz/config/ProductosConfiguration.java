package mx.com.allianz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "productos")
public class ProductosConfiguration {

	private String productosVisiblesPortal;

	public String getProductosVisiblesPortal() {
		return productosVisiblesPortal;
	}

	public void setProductosVisiblesPortal(String productosVisiblesPortal) {
		this.productosVisiblesPortal = productosVisiblesPortal;
	}

}
