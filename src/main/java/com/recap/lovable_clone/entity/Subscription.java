package com.recap.lovable_clone.entity;

import com.recap.lovable_clone.enums.SubscriptionStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription {
    Long id;
    User userId;
    String stripeSubscriptionId;
    SubscriptionStatus Status;
    Instant currentPeriodStart;
    Instant currentPeriodEnd;
    Boolean cancelAtPeriodEnd;
    Instant createdAt;
    Instant updatedAt;
}
