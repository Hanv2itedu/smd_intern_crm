package com.smartdev.crm.service;

import com.smartdev.user.entity.SellerDetail;

import java.util.List;

public interface SellerDetailService {
    public List<SellerDetail> getAllSellerDetail();
    SellerDetail findByUsername(String username);

    public void update(SellerDetail sellerDetail);
}
