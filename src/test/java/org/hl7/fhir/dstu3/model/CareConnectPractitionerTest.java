package org.hl7.fhir.dstu3.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Collections;
import org.junit.Test;

public class CareConnectPractitionerTest {

  @Test
  public void identifier() {
    CareConnectPractitioner practitioner = new CareConnectPractitioner();

    CareConnectIdentifier identifier = new CareConnectIdentifier().setValue("id");
    practitioner.addIdentifier(identifier);

    assertEquals(identifier, practitioner.getIdentifierFirstRep());
    assertFalse("Practitioner should not be empty", practitioner.isEmpty());

    // Test inline identifier creation
    practitioner = new CareConnectPractitioner();
    identifier = practitioner.addIdentifier().setValue("id");

    assertEquals(identifier, practitioner.getIdentifierFirstRep());
    assertFalse("Practitioner should not be empty", practitioner.isEmpty());

    // Test setIdentifier
    practitioner = new CareConnectPractitioner();
    identifier = new CareConnectIdentifier().setValue("id");
    practitioner.setIdentifier(Collections.singletonList(identifier));

    assertEquals(identifier, practitioner.getIdentifierFirstRep());
    assertFalse("Practitioner should not be empty", practitioner.isEmpty());
  }
}