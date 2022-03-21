package couponsopsjava;

import java.util.*;
import java.util.stream.Collectors;


public class CouponOperation implements ICouponOperation {

    Map<Website, List<Coupon>> webCoupons;

    public CouponOperation() {
        this.webCoupons = new LinkedHashMap<>();
    }

    public void registerSite(Website w) {
        if (this.webCoupons.containsKey(w)) {
            throw new IllegalArgumentException();
        }

        this.webCoupons.put(w, new ArrayList<>());
    }

    public void addCoupon(Website w, Coupon c) {
        if (!this.webCoupons.containsKey(w) || this.webCoupons.get(w).contains(c)) {
            throw new IllegalArgumentException();
        }
        this.webCoupons.get(w).add(c);
    }

    public Website removeWebsite(String domain) {
        Website website = this.webCoupons.keySet()
                .stream()
                .filter(x -> x.domain.equals(domain))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
        this.webCoupons.remove(website);
        return website;
    }

    public Coupon removeCoupon(String code) {
        for (Map.Entry<Website, List<Coupon>> website : webCoupons.entrySet()) {
            for (Coupon coupon : website.getValue()) {
                if (coupon.code.equals(code)) {
                    this.webCoupons.get(website.getKey()).remove(coupon);
                    return coupon;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean exist(Website w) {
        return this.webCoupons.containsKey(w);
    }

    public boolean exist(Coupon c) {
        return this.webCoupons.values()
                .stream()
                .anyMatch(w -> w.contains(c));
    }

    public Collection<Website> getSites() {
        return this.webCoupons.keySet().stream().collect(Collectors.toList());
    }

    public Collection<Coupon> getCouponsForWebsite(Website w) {
        if (!this.webCoupons.containsKey(w)) throw new IllegalArgumentException();
        return this.webCoupons.get(w);
    }

    public void useCoupon(Website w, Coupon c) {
        if (!this.webCoupons.containsKey(w)) throw new IllegalArgumentException();
        if (!this.webCoupons.get(w).remove(c)) throw new IllegalArgumentException();
    }

    public Collection<Coupon> getCouponsOrderedByValidityDescAndDiscountPercentageDesc() {
       return this.webCoupons
                .values()
                .stream()
                .flatMap(x->x.stream())
                .sorted((c1,c2) -> {
                    int result = c2.validity - c1.validity;
                    if (result==0){
                        result = c2.discountPercentage- c1.discountPercentage;
                    }
                    return result;
                }).collect(Collectors.toList());
    }

    public Collection<Website> getWebsitesOrderedByUserCountAndCouponsCountDesc() {
        return this.webCoupons.entrySet()
                .stream()
                .sorted((w1, w2) -> {
                    int result = w1.getKey().usersCount - w2.getKey().usersCount;
                    if (result == 0) {
                        result = w2.getValue().size() - w1.getValue().size();
                    }
                    return result;
                })
                .map(x -> x.getKey())
                .collect(Collectors.toList());
    }
}
