package org.hl7.fhir.dstu3.model;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Collections;
import org.junit.Test;

public class CareConnectRelatedPersonTest extends CareConnectProfileTest<CareConnectRelatedPerson> {

  @Test
  public void patient() {
    setResource(new CareConnectRelatedPerson());
    Reference patientRef = new Reference("patientref");

    resource.setPatient(patientRef);

    assertThat(resource.getPatient(), is((patientRef)));
  }

  @Test
  public void identifierAdd() {
    setResource(new CareConnectRelatedPerson());

    CareConnectIdentifier identifier = new CareConnectIdentifier().setValue("id");
    resource.addIdentifier(identifier);

    assertEquals(identifier, resource.getIdentifierFirstRep());
    assertFalse("Practitioner should not be empty", resource.isEmpty());
  }

  @Test
  public void identifierInline() {
    setResource(new CareConnectRelatedPerson());
    CareConnectIdentifier identifier = resource.addIdentifier().setValue("id");

    assertEquals(identifier, resource.getIdentifierFirstRep());
    assertFalse("Practitioner should not be empty", resource.isEmpty());
  }

  @Test
  public void identifierSet() {
    setResource(new CareConnectRelatedPerson());
    CareConnectIdentifier identifier = new CareConnectIdentifier().setValue("id");
    resource.setIdentifier(Collections.singletonList(identifier));

    assertEquals(identifier, resource.getIdentifierFirstRep());
    assertFalse("Practitioner should not be empty", resource.isEmpty());
  }
}