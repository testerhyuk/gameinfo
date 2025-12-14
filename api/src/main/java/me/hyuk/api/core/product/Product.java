package me.hyuk.api.core.product;

public class Product {
    private final int productId;
    private final String name;
    private final String genre;
    private final String serviceAddress;

    public Product() {
        productId = 0;
        name = null;
        genre = null;
        serviceAddress = null;
    }

    public Product(int productId, String name, String genre, String serviceAddress) {
        this.productId = productId;
        this.name = name;
        this.genre = genre;
        this.serviceAddress = serviceAddress;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }
}
