package com.recap.lovable_clone.service.Impl;

import com.recap.lovable_clone.dto.subscription.CheckoutRequest;
import com.recap.lovable_clone.dto.subscription.CheckoutResponse;
import com.recap.lovable_clone.dto.subscription.PortalResponse;
import com.recap.lovable_clone.dto.subscription.SubscriptionResponse;
import com.recap.lovable_clone.service.serviceInterface.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
