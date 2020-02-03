package org.hl7.fhir.dstu3.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class NHSNumberIdentifierTest {

  @Test
  public void value() {
    NHSNumberIdentifier identifier = new NHSNumberIdentifier();

    identifier.setValue("id");

    assertEquals("id", identifier.getValue());
    assertFalse("Identifier should not be empty", identifier.isEmpty());
  }

  @Test
  public void system() {
    NHSNumberIdentifier identifier = new NHSNumberIdentifier();

    identifier.setSystem("system");

    assertEquals("system", identifier.getSystem());
    assertFalse("Identifier should not be empty", identifier.isEmpty());
  }

  @Test
  public void assigner() {
    NHSNumberIdentifier identifier = new NHSNumberIdentifier();

    Reference assigner = new Reference("Organization/1");
    identifier.setAssigner(assigner);

    assertEquals(assigner, identifier.getAssigner());
    assertFalse("Identifier should not be empty", identifier.isEmpty());
  }

  @Test
  public void verificationStatus() {
    NHSNumberIdentifier identifier = new NHSNumberIdentifier();

    CodeableConcept status = new CodeableConcept()
        .addCoding(new Coding().setDisplay("Verified"));
    identifier.setNhsNumberVerificationStatus(status);

    assertEquals(status, identifier.getNhsNumberVerificationStatus());
    assertFalse("Identifier should not be empty", identifier.isEmpty());
  }

}