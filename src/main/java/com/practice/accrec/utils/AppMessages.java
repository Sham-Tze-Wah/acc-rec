package com.practice.accrec.utils;

public class AppMessages {
    public static final String UNABLE_TO_FETCH_CUSTOMER_INFO = "unable.fetch.customer.info";

    public static final String UNABLE_TO_CREATE_CUSTOMER_INFO = "unable.create.customer.info";
    public static final String UNABLE_TO_UPDATE_CUSTOMER_INFO = "unable.update.customer.info";
    public static final String UNABLE_TO_UPDATE_CUSTOMER_INFO_DELETED ="unable.update.customer.info.deleted" ;

    private AppMessages() {
        // This prevents the class from being instantiated
        throw new AssertionError("This class should not be instantiated.");
    }
}
