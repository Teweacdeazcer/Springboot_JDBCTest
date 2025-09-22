package kr.ac.kopo.kkssmm.springboot_jdbctest1.controller.exam05;

import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Detail;
import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Product;
import kr.ac.kopo.kkssmm.springboot_jdbctest1.repository.DetailRepository;
import kr.ac.kopo.kkssmm.springboot_jdbctest1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/exam06")
public class exam06Controller {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DetailRepository detailRepository;

    @GetMapping
    public String requestInsert(Model model){
        Product product = new Product();
        product.setName("Iphone 17");
        product.setPrice(1200000);

        Detail detail = new Detail();
        detail.setDescription("아이폰 17 신형");
        detail.setWeight(200f);
        detail.setWidth(85f);
        detail.setHeight(150f);
        detail.setProduct(product);
        detailRepository.save(detail);

        product.setDetail(detail);
        productRepository.save(product);

        Iterable<Product> productList = productRepository.findAll();
        Iterable<Detail> detailList = detailRepository.findAll();
        model.addAttribute("productList",productList);
        model.addAttribute("detailList",detailList);

        return "viewPage06";
    }
}
