package com.andkantor.snowfox.stock.model;

public class QuantityChangeResponse {

    private boolean success;
    private String errorMessage;

    private QuantityChangeResponse(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static QuantityChangeResponse successfulResponse() {
        return new QuantityChangeResponse(true, "");
    }

    public static QuantityChangeResponse unsuccessfulResponse(String errorMessage) {
        return new QuantityChangeResponse(false, errorMessage);
    }
}
