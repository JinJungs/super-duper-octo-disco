package hem.vessel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="SHIPPING_COMPANY")
public class ShippingCompanyDto {

    @Id
    private String companyCode;

    private String companyName;


}
