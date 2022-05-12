package edu.sabanciuniv.it526.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import edu.sabanciuniv.it526.entity.Category;
import edu.sabanciuniv.it526.entity.Product;
import edu.sabanciuniv.it526.services.CategoryService;
import edu.sabanciuniv.it526.services.ProductService;

@Named
@RequestScoped
public class ProductBean {

	@Inject
	private CategoryService catService;

	@Inject
	private ProductService productService;

	private Product product = new Product();
	private Category category = new Category();
	private List<Category> categories = new ArrayList<Category>();
	private List<Product> products;
	
	@PostConstruct
	public void initPage() {
		
		products = productService.getAllProduct();
		categories = catService.getAllCategories();
		
	}

	public String saveProduct() {
	

		this.product.setCategory(this.category);
		productService.save(this.product);

		return "categorylist.xhtml";
	}

	public void updateProduct(RowEditEvent evt) {
		Product toBeUpdated = (Product) evt.getObject();
		System.out.println(toBeUpdated.getName() + " Update edilecek");
		productService.update(toBeUpdated);
	}

	public String deleteProduct(int id) {
		productService.delete(id);
		return "categorylist?faces-redirect=true";
	}

	public CategoryService getCatService() {
		return catService;
	}

	public void setCatService(CategoryService catService) {
		this.catService = catService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
