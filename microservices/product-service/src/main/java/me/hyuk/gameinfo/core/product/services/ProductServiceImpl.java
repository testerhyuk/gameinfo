package me.hyuk.gameinfo.core.product.services;

import me.hyuk.api.core.product.Product;
import me.hyuk.api.core.product.ProductService;
import me.hyuk.api.exceptions.InvalidInputException;
import me.hyuk.api.exceptions.NotFoundException;
import me.hyuk.util.http.ServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductServiceImpl implements ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ServiceUtil serviceUtil;

    public ProductServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public Product getProduct(int productId) {
        LOG.debug("/product -> return the found product for productId={}", productId);

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId : " + productId);
        }

        /*
            TODO : DB 연결 시 DB 존재하지 않는 값 예외 처리
        */
        if (productId == 13) {
            throw new NotFoundException("No product found for productId : " + productId);
        }

        return new Product(productId, "name-" + productId, "RPG", serviceUtil.getServiceAddress());
    }
}
