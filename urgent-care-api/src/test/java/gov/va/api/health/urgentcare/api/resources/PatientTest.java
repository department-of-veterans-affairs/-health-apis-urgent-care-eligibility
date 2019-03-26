package gov.va.api.health.urgentcare.api.resources;

import static gov.va.api.health.urgentcare.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.urgentcare.api.ZeroOrOneOfVerifier;
import gov.va.api.health.urgentcare.api.samples.SamplePatients;
import org.junit.Test;

public class PatientTest {

  private final SamplePatients data = SamplePatients.get();

  @Test
  public void patient() {
    assertRoundTrip(data.patient());
  }

  @Test
  public void relatedFields() {
    ZeroOrOneOfVerifier.builder().sample(data.patient()).fieldPrefix("deceased").build().verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.patient())
        .fieldPrefix("multipleBirth")
        .build()
        .verify();
  }
}
