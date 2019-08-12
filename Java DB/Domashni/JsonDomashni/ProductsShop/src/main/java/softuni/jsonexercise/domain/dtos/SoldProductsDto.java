package softuni.jsonexercise.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class SoldProductsDto implements Serializable {
   @Expose
    private long count;
   @Expose
   List<ProductDetailsDto> productDetails;

    public SoldProductsDto() {
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<ProductDetailsDto> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetailsDto> productDetails) {
        this.productDetails = productDetails;
    }
}
