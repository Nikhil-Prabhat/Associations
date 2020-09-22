package com.cognizant.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Catalog;
import com.cognizant.entity.Product;
import com.cognizant.model.MCatalog;
import com.cognizant.model.MProduct;
import com.cognizant.repository.CatalogRepository;
import com.cognizant.repository.ProductRepository;

@RestController
@RequestMapping("products")
public class DatabaseController {

	@Autowired
	CatalogRepository catalogRepository;

	@Autowired
	ProductRepository productRepository;

	@GetMapping("/showall")
	public List<MProduct> showAllProducts() {
		List<MProduct> productList = new ArrayList<>();
		List<Catalog> findAll = catalogRepository.findAll();

		for (Catalog c : findAll) {
			for (Product p : c.getProducts()) {
				MProduct product = new MProduct();
				product.setCatalogid(p.getCatalog().getCatid());
				product.setPrice(p.getPrice());
				product.setProdid(p.getProdid());
				product.setProdname(p.getProdname());
				productList.add(product);

			}

		}

		return productList;
	}

	@GetMapping("showall/catalogs")
	public List<MCatalog> showAllCatalogs() {
		List<MCatalog> list = new ArrayList<>();
		List<Catalog> findAll = catalogRepository.findAll();

		for (Catalog c : findAll) {
			MCatalog n = new MCatalog();
			n.setCatid(c.getCatid());
			n.setCatname(c.getCatname());
			List<MProduct> plist = new ArrayList<>();
			for (Product p : c.getProducts()) {

				MProduct m = new MProduct();
				m.setCatalogid(p.getCatalog().getCatid());
				m.setPrice(p.getPrice());
				m.setProdid(p.getProdid());
				m.setProdname(p.getProdname());
				plist.add(m);
			}

			n.setProducts(plist);
			list.add(n);
		}

		return list;
	}

	@GetMapping("showall/products")
	public List<MProduct> showAllProductsInDB() {

		List<MProduct> list = new ArrayList<>();
		List<Product> findAll = productRepository.findAll();
		for (Product p : findAll) {
			MProduct m = new MProduct();
			m.setCatalogid(p.getCatalog().getCatid());
			m.setPrice(p.getPrice());
			m.setProdid(p.getProdid());
			m.setProdname(p.getProdname());
			list.add(m);
		}

		return list;

	}

	@GetMapping("/getproductsunderprice/{min}/{max}")
	public List<MProduct> getProductsUnderPrice(@PathVariable("min") int min, @PathVariable("max") int max) {

		List<MProduct> productList = new ArrayList<>();
		List<Product> productsUnderPrice = productRepository.getProductsUnderPrice(min, max);

		for (Product p : productsUnderPrice) {
			MProduct m = new MProduct();
			m.setCatalogid(p.getCatalog().getCatid());
			m.setPrice(p.getPrice());
			m.setProdid(p.getProdid());
			m.setProdname(p.getProdname());
			productList.add(m);
		}

		return productList;
	}

	@PostMapping("/addCatalog")
	public void AddCatalog(@RequestBody Catalog catalog) {
		catalogRepository.save(catalog);
	}

}
