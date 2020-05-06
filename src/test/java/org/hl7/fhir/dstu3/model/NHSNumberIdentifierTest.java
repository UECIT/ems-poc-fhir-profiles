package org.hl7.fhir.dstu3.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NHSNumberIdentifierTest {

  @Test
  public void verificationStatus() {
    NHSNumberIdentifier identifier = new NHSNumberIdentifier();

    CodeableConcept status = new CodeableConcept()
        .addCoding(new Coding().setDisplay("Verified"));
    identifier.setNhsNumberVerificationStatus(status);

    assertTrue("ID should have nhsNumberVerificationStatus",
        identifier.hasNhsNumberVerificationStatus());
    assertEquals(status, identifier.getNhsNumberVerificationStatus());
    assertFalse("Identifier should not be empty", identifier.isEmpty());
  }

}