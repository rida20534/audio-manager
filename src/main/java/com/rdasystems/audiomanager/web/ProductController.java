/*********************************************************************
 *     @PostConstruct
 *     public void makeList(){}  method avec cette annotation s'execute en premiere
 * ----HttpHeaders responseHeaders = new HttpHeaders();
 * ----responseHeaders.set("TotalPages", String.valueOf(totalPages));
 *-----responseHeaders.set("numberOfElements", String.valueOf(numberOfElements));
 * ----new HttpEntity<>(results.getContent(),responseHeaders);
 * //@JsonIgnoreProperties(ignoreUnknown = true)
 *****************************************************************************************/

package com.rdasystems.audiomanager.web;
import com.rdasystems.audiomanager.dao.InventoryRepository;
import com.rdasystems.audiomanager.dao.ProductCategoryRepository;
import com.rdasystems.audiomanager.exception.ProductErrorResponse;
import com.rdasystems.audiomanager.exception.ProductNotFoundException;
import com.rdasystems.audiomanager.model.Inventory;
import com.rdasystems.audiomanager.model.Product;
import com.rdasystems.audiomanager.model.ProductCategory;
import com.rdasystems.audiomanager.service.ProductService;
import com.rdasystems.audiomanager.utility.LocalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    ProductService productService;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @GetMapping("products/category")
    public LocalResponse<Product> filterByCategory(
                   @RequestParam String page,
                   @RequestParam String size,
                   @RequestBody ProductCategory productcategory){
                   Page<Product> results=productService.findProducstByCategory(productcategory,Integer.parseInt(page),Integer.parseInt(size));
          return new LocalResponse<>(
                                 results.getContent(),
                                 results.getTotalPages(),
                                 results.getNumberOfElements(),
                                 results.getNumber());
    }

     @GetMapping("/products")
     @ResponseStatus(HttpStatus.FOUND)
     public ResponseEntity<LocalResponse<Product>> alproductsroducts(@RequestParam String page,@RequestParam String size){
        var results=productService.findAll(Integer.parseInt(page),Integer.parseInt(size));

        return new ResponseEntity<>(new LocalResponse<>(results.getContent(),results.getTotalPages(),results.getNumberOfElements(), results.getNumber()),HttpStatus.FOUND);
}
    @GetMapping("/products/search")
    @ResponseStatus(HttpStatus.FOUND)
    public LocalResponse<Product> searchProductByDescName(@RequestParam String keywords, @RequestParam String page, @RequestParam String size){
        Page<Product> results=productService.searchByDescriptionAndName(keywords,Integer.parseInt(page),Integer.parseInt(size));
        int totalPages= results.getTotalPages();
        int numberOfElements=results.getNumberOfElements();
        int  numberOfpage=results.getNumber();
    return new LocalResponse<>(results.getContent(),totalPages,numberOfElements,numberOfpage);

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
@ResponseStatus(HttpStatus.FOUND)
    public  Product ProductItemById(@PathVariable Long productId){
    Product product=productService.findById(productId);
    if(product==null){
        System.out.println("product==null");
        throw new ProductNotFoundException("Product with id="+productId+" Not found");
    }

    return product;
}
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<Product> PostAproducts(@RequestBody Product product){
        System.out.println("before save @RequestBody hold"+product);
        //Inventory invent=product.getInventory();
       // System.out.println(invent);
        productCategoryRepository.save(product.getCategory()) ;
        productService.save(product);

        //System.out.println("after save @RequestBody hold"+product);
       // throw  new ProductNotFoundException("operation is forbidden you can't create a ressource operation forbiden");
      return new ResponseEntity<>(product,HttpStatus.FORBIDDEN) ;
    }
}

