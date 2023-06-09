package com.example.projection;

import com.example.entity.ProductEntity;

public interface ProductProjection {
    Long getId();
    String getName();
    String getGia();
    int getSoLuong();
    String getMoTa();

    Integer getTotalMoney();

    String getImage();
    int getQuantity();
    Long getCategoryId();


    static ProductProjection from (ProductEntity entity){
        return new ProductProjection() {
            @Override
            public Long getId() {
                return entity.getId();
            }

            @Override
            public String getName() {
                return entity.getName();
            }

            @Override
            public String getGia() {
                return entity.getGia();
            }

            public String getImage(){return entity.getImage();}

            @Override
            public int getSoLuong() {
                return entity.getSoLuong();
            }

            @Override
            public String getMoTa() {
                return entity.getMoTa();
            }

            @Override
            public Integer getTotalMoney() {
                return null;
            }

            @Override
            public int getQuantity() {
                return 0;
            }

            @Override
            public Long getCategoryId() {
                return entity.getCategory().getId();
            }
        };
    }
}
