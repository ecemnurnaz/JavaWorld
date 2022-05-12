package edu.sabanciuniv.it526.mbeans;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import edu.sabanciuniv.it526.entity.Category;
import edu.sabanciuniv.it526.entity.Product;
import edu.sabanciuniv.it526.services.CategoryService;
import edu.sabanciuniv.it526.services.ProductService;

@Named
@RequestScoped
public class ProductListBean  {

	@Inject
	private ProductService productService;
	@Inject
	private CategoryService categoryService;
	
	private Product product = new Product();
	private Category category;
	
	@PostConstruct
	public void initPage() {
		
		
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		this.category = categoryService.getById(categoryId);	
		
		  for (Product product : category.getProducts()) {
		  System.out.println(product); }
	}
	
	public void saveProduct() {
		this.product.setCategory(category);
		productService.save(this.product);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}

