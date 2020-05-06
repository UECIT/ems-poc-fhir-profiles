package org.hl7.fhir.dstu3.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Collections;
import org.junit.Test;

public class CareConnectPractitionerTest extends CareConnectProfileTest<CareConnectPractitioner> {

  @Test
  public void identifierAdd() {
    setResource(new CareConnectPractitioner());

    CareConnectIdentifier identifier = new CareConnectIdentifier().setValue("id");
    resource.addIdentifier(identifier);

    assertEquals(identifier, resource.getIdentifierFirstRep());
    assertFalse("Practitioner should not be empty", resource.isEmpty());
  }

  @Test
  public void identifierInline() {
    setResource(new CareConnectPractitioner());
    CareConnectIdentifier identifier = resource.addIdentifier().setValue("id");

    assertEquals(identifier, resource.getIdentifierFirstRep());
    assertFalse("Practitioner should not be empty", resource.isEmpty());
  }

  @Test
  public void identifierSet() {
    setResource(new CareConnectPractitioner());
    CareConnectIdentifier identifier = new CareConnectIdentifier().setValue("id");
    resource.setIdentifier(Collections.singletonList(identifier));

    assertEquals(identifier, resource.getIdentifierFirstRep());
    assertFalse("Practitioner should not be empty", resource.isEmpty());
  }
}