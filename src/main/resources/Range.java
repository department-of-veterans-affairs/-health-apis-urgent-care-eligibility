import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.urgentcare.api.Fhir;
import gov.va.api.health.urgentcare.api.elements.Element;
import gov.va.api.health.urgentcare.api.elements.Extension;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(description = "https://www.hl7.org/fhir/R4/datatypes.html#Range")
public class Range implements Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Valid SimpleQuantity low;

  @Valid SimpleQuantity high;
}
