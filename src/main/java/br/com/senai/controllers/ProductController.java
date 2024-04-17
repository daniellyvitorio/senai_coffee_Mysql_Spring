package br.com.senai.controllers;

import br.com.senai.models.Product;
import br.com.senai.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    //metodo para salvar no banco de dados
    @PostMapping(value="/createProduct",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product createProduct(@RequestBody Product product){
        //Cria um novo objeto Product
        Product newProduct = new Product();
        //Seta as propriedades do Product
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        //Chama o método save para salvar o objeto no banco de dados
        return productRepository.save(newProduct);
    }

    //atualizar cafe
    @PutMapping(value="/updateProduct",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody Product product){
        Product getProduct = productRepository.findById(product.getId()).orElseThrow();
        Product updateProduct = new Product();

        updateProduct.setId(product.getId());
        updateProduct.setName(product.getName());
        updateProduct.setPrice(product.getPrice());

        return  productRepository.save(updateProduct);
    }
    // Metodo deletar product
    @DeleteMapping(value="/deleteProduct/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    //@PathVariable pega um valor passado junto a barra de endereço
    public  Product deleteProduct(@PathVariable Long id){
        //Verifica se existe o café no bando de dados procurando id
        Product getProduct = productRepository.findById(id).orElseThrow();
        //chamamos p método .delete e passamos o café a ser deletado
        productRepository.delete(getProduct);
        return  getProduct;
    }
}
