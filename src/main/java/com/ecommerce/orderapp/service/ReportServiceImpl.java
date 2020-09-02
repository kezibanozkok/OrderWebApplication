package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.report.OrderDetailReport;
import com.ecommerce.orderapp.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final OrderDetailRepository orderDetailRepository;


    @Override
    public List<OrderDetailReport> getReport(Date start, Date end) {
        return orderDetailRepository.findOrdersByDateBetween(start, end);
    }
}
