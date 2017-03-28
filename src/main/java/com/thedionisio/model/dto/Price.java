package com.thedionisio.model.dto;

/**
 * Created by jonathan on 3/7/17.
 */
public class Price {
    @Override
    public String toString() {
        return "Price{" +
                "single=" + single +
                ", woman=" + woman +
                ", man=" + man +
                '}';
    }

    public Double single;
    public Double woman;
    public Double man;
}
