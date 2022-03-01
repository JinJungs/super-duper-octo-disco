package hem.vessel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="SERVICE_ROUTE_URL_INFO")
public class ServiceRouteUrlInfoDto {

    @Id
    private String companyCode;

    private String url;

    private String selector;

    private String method;

    private String etc1;

    private String etc2;

}
