package org.hl7.fhir.dstu3.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;

public abstract class CareConnectProfileTest<T extends DomainResource> {

  private IParser parser;
  protected T resource;

  protected void setResource(T resource) {
    this.resource = resource;
  }

  @Before
  public void setupParser() {
    FhirContext context = FhirContext.forDstu3();
    IParser fhirParser = context.newJsonParser();
    fhirParser.setPreferTypes(Arrays.asList(
        CareConnectCarePlan.class,
        CareConnectCareTeam.class,
        CareConnectCondition.class,
        CareConnectEncounter.class,
        CareConnectEpisodeOfCare.class,
        CareConnectHealthcareService.class,
        CareConnectLocation.class,
        CareConnectMedication.class,
        CareConnectObservation.class,
        CareConnectOrganization.class,
        CareConnectPatient.class,
        CareConnectPractitioner.class,
        CareConnectProcedure.class,
        CareConnectProcedureRequest.class,
        CareConnectRelatedPerson.class,
        CareConnectSpecimen.class
    ));
    this.parser = fhirParser;
  }

  @SuppressWarnings("unchecked")
  @After
  public void serializeAndDeserialize() {
    String s = parser.encodeResourceToString(resource);
    T parseResource = (T) parser.parseResource(resource.getClass(), s);
    assertThat(parseResource.equalsDeep(resource), is(true));
  }

}
