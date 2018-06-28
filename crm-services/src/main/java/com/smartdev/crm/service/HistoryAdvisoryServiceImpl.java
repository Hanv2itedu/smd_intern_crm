package com.smartdev.crm.service;

import com.smartdev.user.dao.repository.HistoryAdvisoryRepository;
import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.HistoryAdvisory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.smartdev.user.model.StatusCount;

import java.util.*;

@Service
public class HistoryAdvisoryServiceImpl implements HistoryAdvisoryService {
    @Autowired
    HistoryAdvisoryRepository historyAdvisoryRepository;
  
    @Override
    public List<HistoryAdvisory> getHistoryAdvisoriesByCustomer(Customer customer) {
        return historyAdvisoryRepository.findByCustomerByCustomerId(customer);
    }

    public static final String PROSPECT = "prospect";
    public static final String LEAD = "lead";
    public static final String POTENTIAL_LEAD = "potential lead";
    public static final String ACTIVE_LEAD = "active lead";

    @Override
    public List<HistoryAdvisory> findAll() {
        return historyAdvisoryRepository.findAll();
    }

    @Override
    public List<Integer> getYearOfHistoryAdvisory() {
        List<Integer> years = new ArrayList<>();
        List<HistoryAdvisory> historyAdvisories = findAll();
        for(HistoryAdvisory ha : historyAdvisories) {
            years.add(getYearFromDate(ha.getDate()));
        }
        return years;
    }

    @Override
    public StatusCount getNumberOfEachStatusByYearAndMonth(int year, int month) {
        List<HistoryAdvisory> historyAdvisories = findAll();
        StatusCount statusCount = new StatusCount(0,0,0,0);
        for(HistoryAdvisory historyAdvisory : historyAdvisories) {
            if(getYearFromDate(historyAdvisory.getDate()) == year && getMonthFormDate(historyAdvisory.getDate()) == month) {
                switch (historyAdvisory.getStatusByStatusId().getName()) {
                    case PROSPECT:
                        statusCount.setProspect(statusCount.getProspect() + 1);
                        break;
                    case LEAD:
                        statusCount.setLead(statusCount.getLead() + 1);
                        break;
                    case POTENTIAL_LEAD:
                        statusCount.setPotentialLead(statusCount.getPotentialLead() + 1);
                        break;
                    case ACTIVE_LEAD:
                        statusCount.setActiveLead(statusCount.getActiveLead() + 1);
                        break;
                }
            }
        }
        return statusCount;
    }

    private int getYearFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if(date == null)
            return 0;
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    private int getMonthFormDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if(date == null) {
            return 0;
        }
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    private Map<String, Integer> initHistoryClassifier() {
        Map<String, Integer> historyClassifier = new HashMap<>();
        historyClassifier.put(PROSPECT,0);
        historyClassifier.put(LEAD, 0);
        historyClassifier.put(POTENTIAL_LEAD, 0);
        historyClassifier.put(ACTIVE_LEAD, 0);
        return historyClassifier;
    }
}
