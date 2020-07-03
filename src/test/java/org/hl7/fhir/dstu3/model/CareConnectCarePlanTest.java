package org.hl7.fhir.dstu3.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class CareConnectCarePlanTest extends CareConnectProfileTest<CareConnectCarePlan> {

  @Test
  public void setContext() {
    setResource(new CareConnectCarePlan());

    Reference reference = new Reference("Encounter/123");
    resource.setContext(reference);

    assertEquals(reference, resource.getContext());
    assertFalse("Care Plan should not be empty", resource.isEmpty());
  }

  @Test
  public void setSubject() {
    setResource(new CareConnectCarePlan());

    Reference reference = new Reference("Encounter/345");
    resource.setSubject(reference);

    assertEquals(reference, resource.getSubject());
    assertFalse("Care Plan should not be empty", resource.isEmpty());
  }

}
