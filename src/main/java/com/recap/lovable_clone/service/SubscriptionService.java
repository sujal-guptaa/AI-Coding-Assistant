package com.recap.lovable_clone.service;

import com.recap.lovable_clone.dto.subscription.CheckoutRequest;
import com.recap.lovable_clone.dto.subscription.CheckoutResponse;
import com.recap.lovable_clone.dto.subscription.PortalResponse;
import com.recap.lovable_clone.dto.subscription.SubscriptionResponse;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);
    PortalResponse openCustomerPortal(Long userId);
}
