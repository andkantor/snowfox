package com.andkantor.snowfox.web.model.stock;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockInfoList extends ArrayList<StockInfo> {
}
