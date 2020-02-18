package org.hl7.fhir.dstu3.model;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import org.junit.Test;

public class CareConnectOrganizationTest extends CareConnectProfileTest<CareConnectOrganization> {

  @Test
  public void identifierAdd() {
    setResource(new CareConnectOrganization());

    CareConnectIdentifier identifier = new CareConnectIdentifier().setValue("id");
    resource.addIdentifier(identifier);
    assertThat(resource.getIdentifier(), hasSize(1));
    assertThat(resource.getIdentifierFirstRep().equalsDeep(identifier), is(true));
  }

  @Test
  public void identifierInline() {
    setResource(new CareConnectOrganization());
    CareConnectIdentifier identifier = resource.addIdentifier().setValue("id");

    assertEquals(identifier, resource.getIdentifierFirstRep());
    assertFalse("Organization should not be empty", resource.isEmpty());
  }

  @Test
  public void identifierSet() {
    setResource(new CareConnectOrganization());
    CareConnectIdentifier identifier = new CareConnectIdentifier().setValue("id");
    resource.setIdentifier(Collections.singletonList(identifier));

    assertEquals(identifier, resource.getIdentifierFirstRep());
    assertFalse("Organization should not be empty", resource.isEmpty());
  }
}