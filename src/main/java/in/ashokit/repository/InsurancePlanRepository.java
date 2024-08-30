package in.ashokit.repository;

import in.ashokit.bindings.PlanResponse;
import in.ashokit.entity.InsurancePlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface InsurancePlanRepository extends JpaRepository<InsurancePlanEntity, Serializable> {
    @Query("Select distinct planName from InsurancePlanEntity")
    public List<String>getPlanNames();
    @Query("Select distinct planStatus from InsurancePlanEntity")
    public List<String>getPlanStatus();
}
