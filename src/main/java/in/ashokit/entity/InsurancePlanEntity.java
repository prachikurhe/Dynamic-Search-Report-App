package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="INSURANCE_PLANS")
@Data
public class InsurancePlanEntity {
    @Id
    private Integer planId;
    private String planName;
    private String planHolderName;
    private String planHolderSsn;
    private  String planStatus;


}
