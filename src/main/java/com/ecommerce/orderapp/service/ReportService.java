package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.report.OrderDetailReport;

import java.util.Date;
import java.util.List;

public interface ReportService {
    List<OrderDetailReport> getReport(Date start, Date end);
}
