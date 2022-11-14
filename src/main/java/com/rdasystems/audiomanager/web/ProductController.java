/***
 *     @PostConstruct
 *     public void makeList(){}  method avec cette annotation s'execute en premiere
 */

package com.rdasystems.audiomanager.web;
import com.rdasystems.audiomanager.dao.ProductCategoryRepository;
import com.rdasystems.audiomanager.dao.ProductRepository;
import com.rdasystems.audiomanager.exception.ProductErrorResponse;
import com.rdasystems.audiomanager.exception.ProductNotFoundException;
import com.rdasystems.audiomanager.model.Product;
import com.rdasystems.audiomanager.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class ProductController {
    List<Product> products;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @GetMapping("products/category/{categoryid}")
    public List<Product> filterByCategory(@PathVariable final Long categoryid ){
        Map map= new HashMap<>();
        if(map.isEmpty()){
            productCategoryRepository.findAll().forEach(el->{
                map.put(el.getId(),el.getProductSet());
            });
            if (map.isEmpty()){
                throw new ProductNotFoundException("");
            }
        }
        if(map.get(categoryid)==null){
            throw new ProductNotFoundException("no such category ! ");
        }

        return  (List<Product>) map.get(categoryid);
    }
    @GetMapping
    public List<ProductCategory> allCategories(@PathVariable Long categoryid ){
     return productCategoryRepository.findAll();
    }
@GetMapping("/products")
@ResponseStatus(HttpStatus.FOUND)
//@JsonIgnoreProperties(ignoreUnknown = true)
public List<Product> alproductsroducts(){
products=productRepository.findAll(PageRequest.of(1,5)).getContent();
  return products;
}

@ExceptionHandler
public ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException ex) {
    ProductErrorResponse errorResponse = new ProductErrorResponse();
    errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
    errorResponse.setMessage(ex.getMessage());
    errorResponse.setTime(LocalDateTime.now());
    return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
}

@GetMapping("/products/{productId}")
@ResponseStatus(HttpStatus.NOT_FOUND)
    public  Optional<Product> ProductItemById(@PathVariable Long productId){
    Optional<Product> product=productRepository.findById(productId);
    if(product==null){
        System.out.println("product==null");
        throw new ProductNotFoundException("Product with id="+productId+" Not found");
    }

    return product;
}
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product PostAproducts(@RequestBody Product product){
        product.setCreatedDate(new Date());
        System.out.println("before save @RequestBody hold"+product);
         productRepository.save(product);
         System.out.println("after save @RequestBody hold"+product);
       return product;
    }
}


