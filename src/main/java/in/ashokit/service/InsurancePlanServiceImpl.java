package in.ashokit.service;

import in.ashokit.bindings.PlanResponse;
import in.ashokit.bindings.SearchRequest;
import in.ashokit.entity.InsurancePlanEntity;
import in.ashokit.repository.InsurancePlanRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class InsurancePlanServiceImpl implements InsurancePlanService{
    /**
     * @param request
     * @return
     */
    @Autowired
   private InsurancePlanRepository repo;
    @Override
    public List<PlanResponse> searchPlans(SearchRequest request) {
        InsurancePlanEntity entity=new InsurancePlanEntity();
        if(request!=null && request.getPlanName()!=null && !request.getPlanName().equals("")){
            entity.setPlanName(request.getPlanName());
        }
        if(request!=null && request.getPlanStatus()!=null && !request.getPlanStatus().equals("")){
            entity.setPlanStatus(request.getPlanStatus());
        }

        Example<InsurancePlanEntity>of= Example.of(entity);
        List<InsurancePlanEntity>findAll=repo.findAll(of);

        List<PlanResponse>plans=new ArrayList<>();
        for (InsurancePlanEntity plan:findAll){
            PlanResponse planRes=new PlanResponse();
            BeanUtils.copyProperties(plan,planRes);
            plans.add(planRes);
        }


        return plans;
    }

    /**
     * @return
     */
    @Override
    public List<String> getPlanNames() {
        return repo.getPlanNames();
    }

    /**
     * @return
     */
    @Override
    public List<String> getPlanStatus() {
        return repo.getPlanStatus();
    }
}
