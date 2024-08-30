package in.ashokit.service;

import in.ashokit.bindings.PlanResponse;
import in.ashokit.bindings.SearchRequest;

import java.util.List;

public interface InsurancePlanService {
    public List<PlanResponse>searchPlans(SearchRequest request);
    public List<String>getPlanNames();
    public List<String>getPlanStatus();






}
