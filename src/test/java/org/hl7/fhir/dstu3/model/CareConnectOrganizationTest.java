package org.hl7.fhir.dstu3.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Collections;
import org.junit.Test;

public class CareConnectOrganizationTest {

  @Test
  public void identifier() {
    CareConnectOrganization organization = new CareConnectOrganization();

    CareConnectIdentifier identifier = new CareConnectIdentifier().setValue("id");
    organization.addIdentifier(identifier);

    assertEquals(identifier, organization.getIdentifierFirstRep());
    assertFalse("Organization should not be empty", organization.isEmpty());

    // Use inline-created identifier
    organization = new CareConnectOrganization();
    identifier = organization.addIdentifier().setValue("id");

    assertEquals(identifier, organization.getIdentifierFirstRep());
    assertFalse("Organization should not be empty", organization.isEmpty());

    // Test setIdentifier
    organization = new CareConnectOrganization();
    identifier = new CareConnectIdentifier().setValue("id");
    organization.setIdentifier(Collections.singletonList(identifier));

    assertEquals(identifier, organization.getIdentifierFirstRep());
    assertFalse("Organization should not be empty", organization.isEmpty());
  }
}