package edu.sabanciuniv.it526.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.sabanciuniv.it526.entity.Category;
import edu.sabanciuniv.it526.entity.Product;
import edu.sabanciuniv.it526.services.CategoryService;
import edu.sabanciuniv.it526.services.ProductService;

@Named
@RequestScoped
public class CategoryListBean {

	@Inject
	private CategoryService categoryService;
	@Inject
	private ProductService pService;

	private List<Category> categories;

	@PostConstruct 
	public void initPage() {
		
		  if (categoryService.checkData() == null) {
		  
		  createData(); this.categories = categoryService.getAllCategories();
		  
		  } else {
		  
		  this.categories = categoryService.getAllCategories(); }
		 
	}

	public void createData() {

		Category cat1 = new Category("Ev & Mobilya");
		Category cat2 = new Category("Süpermarket");
		Category cat3 = new Category("Kozmetik");
		Category cat4 = new Category("Ayakkabı & Çanta");
		Category cat5 = new Category("Saat & Aksesuar");

		categoryService.save(cat1);
		categoryService.save(cat2);
		categoryService.save(cat3);
		categoryService.save(cat4);
		categoryService.save(cat5);

		Product p1 = new Product("Yemek Takımı", 1500.0, 7, cat1);
		Product p2 = new Product("Halı", 565.0, 6,cat1);
		Product p3 = new Product("Ayna", 150.0, 34, cat1);
		Product p4 = new Product("Düzenleyici", 25.0, 45,  cat1);
		Product p5 = new Product("Lambader", 250.0, 45, cat1);
		Product p6 = new Product("Çamaşır Deterjanı", 30.0, 32, cat2);
		Product p7 = new Product("Çay", 35.0, 23, cat2);
		Product p8 = new Product("Kağıt Havlu", 30.0, 2, cat2);
		Product p9 = new Product("Kedi Maması", 100.0, 3, cat2);
		Product p10 = new Product("Diş Macunu", 25.0, 23, cat2);
		Product p11 = new Product("Yüz Kremi", 150.0, 23, cat3);
		Product p12 = new Product("Güneş Koruyucu", 200.0, 21, cat3);
		Product p13 = new Product("Saç Şekillendirici", 90.0, 32, cat3);
		Product p14 = new Product("Oje", 2.0, 32, cat3);
		Product p15 = new Product("Parfüm", 300.0, 21, cat3);
		Product p16 = new Product("Günlük Ayakkabı", 500.0, 1, cat4);
		Product p17 = new Product("Terlik", 50.0, 2, cat4);
		Product p18 = new Product("Omuz Çantası", 350.0, 2, cat4);
		Product p19 = new Product("Bot", 700.0, 23, cat4);
		Product p20 = new Product("Sırt Çantası", 300.0, 21, cat4);
		Product p21 = new Product("Saat", 1000.0, 32, cat5);
		Product p22 = new Product("Cüzdan", 200.0, 32, cat5);
		Product p23 = new Product("Şapka", 65.0, 32, cat5);
		Product p24 = new Product("Şemsiye", 40.0, 32, cat5);
		Product p25 = new Product("Kolye", 100.0, 32, cat5);

		pService.save(p1);
		pService.save(p2);
		pService.save(p3);
		pService.save(p4);
		pService.save(p5);
		pService.save(p6);
		pService.save(p7);
		pService.save(p8);
		pService.save(p9);
		pService.save(p10);
		pService.save(p11);
		pService.save(p12);
		pService.save(p13);
		pService.save(p14);
		pService.save(p15);
		pService.save(p16);
		pService.save(p17);
		pService.save(p18);
		pService.save(p19);
		pService.save(p20);
		pService.save(p21);
		pService.save(p22);
		pService.save(p23);
		pService.save(p24);
		pService.save(p25);

	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
