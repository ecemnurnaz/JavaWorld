package edu.sabanciuniv.it526.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import edu.sabanciuniv.it526.entity.Category;
import edu.sabanciuniv.it526.services.CategoryService;
import edu.sabanciuniv.it526.services.ProductService;

@Named
@RequestScoped
public class CategoryBean {
	
	@Inject
	private CategoryService catService;
	
	@Inject
	private ProductService productService;
	
	private Category cat = new Category();
	
	private List<Category> categories;
	
	@PostConstruct
	public void initPage()
	{
		this.categories = catService.getAllCategories();
				
	}
	
	public void updateCategory(RowEditEvent evt)
	{
		System.out.println("Category update");
		Category toBeUpdated = (Category)evt.getObject();
		System.out.println(toBeUpdated.getName() + " Update edilecek");
		catService.update(toBeUpdated);
	}
	
	public String saveCategory()
	{
		catService.save(cat);
		this.cat = new Category();
		return "addcategory?faces-redirect=true";
	}
	public String deleteCategory(int categoryId)
	{
		catService.delete(categoryId);
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

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

}
