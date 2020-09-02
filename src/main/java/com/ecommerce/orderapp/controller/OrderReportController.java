package com.ecommerce.orderapp.controller;

import com.ecommerce.orderapp.report.OrderDetailReport;
import com.ecommerce.orderapp.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/report/orders")
@RequiredArgsConstructor
public class OrderReportController {

    private final ReportService reportService;

    @GetMapping
    public List<OrderDetailReport> getReport() throws ParseException {
        return reportService.getReport(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-01"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-04"));
    }
}
