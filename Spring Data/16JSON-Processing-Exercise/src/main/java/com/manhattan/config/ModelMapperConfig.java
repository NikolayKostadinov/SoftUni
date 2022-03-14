package com.manhattan.config;

import com.manhattan.models.dtos.CategoriesByProductsDto;
import com.manhattan.models.dtos.ProductsInRangeDto;
import com.manhattan.models.dtos.UserAndSoldProductsDto;
import com.manhattan.models.entities.Category;
import com.manhattan.models.entities.Product;
import com.manhattan.models.entities.User;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        Converter<BigDecimal, String> priceToString =
                ctx -> ctx.getSource() == null ? "0" : String.format("%.2f", ctx.getSource());

        Converter<User, String> toFullName =
                ctx -> ctx.getSource() == null ? "" : getFullName(ctx);

        mapper.createTypeMap(Product.class, ProductsInRangeDto.class)
                .addMappings(mpr -> {
                    mpr.using(priceToString).map(Product::getPrice, ProductsInRangeDto::setPrice);
                    mpr.using(toFullName).map(Product::getSeller, ProductsInRangeDto::setSeller);
                });

        Converter<List<Product>, BigDecimal> toAvgPrice =
                ctx -> ctx.getSource() == null ? BigDecimal.ZERO : average(ctx.getSource(), RoundingMode.HALF_UP);

        Converter<List<Product>, BigDecimal> toRevenue =
                ctx -> ctx.getSource() == null ? BigDecimal.ZERO : sum(ctx.getSource());

        Converter<List<Product>, Long> toCount =
                ctx -> ctx.getSource() == null ? 0L : count(ctx.getSource());


        mapper.createTypeMap(Category.class, CategoriesByProductsDto.class)
                .addMappings(mpr -> {
                    mpr.using(toCount).map(Category::getProducts, CategoriesByProductsDto::setProductCount);
                    mpr.using(toAvgPrice).map(Category::getProducts, CategoriesByProductsDto::setAveragePrice);
                    mpr.using(toRevenue).map(Category::getProducts, CategoriesByProductsDto::setTotalRevenue);
                });

        Converter<User, Integer> toSoldProductsCount =
                ctx -> Math.toIntExact(ctx.getSource() == null || ctx.getSource().getSoldProducts() == null ? 0L :
                        ctx.getSource().getSoldProducts().size());
//        mapper.createTypeMap(User.class, UserAndSoldProductsDto.class)
//                .addMappings(mpr -> {
//                    mpr.map(User::getSoldProducts, (dest, v) -> dest.getSoldProducts().setProducts(v));
//                });
        return mapper;
    }

    private String getFullName(MappingContext<User, String> ctx) {
        if (ctx.getSource().getFirstName() == null) {
            return ctx.getSource().getLastName();
        }

        return String.format("%s %s", ctx.getSource().getFirstName(), ctx.getSource().getLastName());
    }

    private BigDecimal average(Collection<Product> products, RoundingMode roundingMode) {
        BigDecimal sum = sum(products);
        long count = count(products);
        return sum.divide(new BigDecimal(count),roundingMode);
    }

    private long count(Collection<Product> products) {
        long count = products.stream().filter(Objects::nonNull).count();
        return count;
    }

    private BigDecimal sum(Collection<Product> products) {
        BigDecimal sum = products.stream()
                .map(Product::getPrice)
                .map(Objects::requireNonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum;
    }


}
