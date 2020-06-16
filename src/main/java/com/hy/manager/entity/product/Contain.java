package com.hy.manager.entity.product;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Contain implements Serializable {

    private List<AddProduct> addList;
    private Product product;




}
