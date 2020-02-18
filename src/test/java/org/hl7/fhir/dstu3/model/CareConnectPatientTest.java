package org.hl7.fhir.dstu3.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import org.hl7.fhir.dstu3.model.CareConnectPatient.DeathNotificationStatusExtension;
import org.junit.Ignore;
import org.junit.Test;

public class CareConnectPatientTest extends CareConnectProfileTest<CareConnectPatient> {

  public static final CodeableConcept CONCEPT = new CodeableConcept()
      .addCoding(new Coding().setDisplay("concept"));

  @Test
  public void nhsNumberIdentifier() {
   setResource(new CareConnectPatient());

    CareConnectIdentifier identifier = new NHSNumberIdentifier()
        .setNhsNumberVerificationStatus(CONCEPT)
        .setSystem("nhs")
        .setAssigner(new Reference("Organization/1"))
        .setValue("id");
    resource.addIdentifier(identifier);

    assertEquals(identifier, resource.getIdentifierFirstRep());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }

  @Test
  public void identifierInline() {
    setResource(new CareConnectPatient());
    CareConnectIdentifier identifier = resource.addIdentifier()
        .setNhsNumberVerificationStatus(CONCEPT)
        .setSystem("nhs")
        .setAssigner(new Reference("Organization/1"))
        .setValue("id");

    assertEquals(identifier, resource.getIdentifierFirstRep());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }

  @Test
  public void identifierSet() {
    setResource(new CareConnectPatient());
    CareConnectIdentifier identifier = new NHSNumberIdentifier()
        .setNhsNumberVerificationStatus(CONCEPT)
        .setSystem("nhs")
        .setAssigner(new Reference("Organization/1"))
        .setValue("id");
    resource.setIdentifier(Collections.singletonList(identifier));

    assertEquals(identifier, resource.getIdentifierFirstRep());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }

  @Test
  public void ethnicCategory() {
    setResource(new CareConnectPatient());

    resource.setEthnicCategory(CONCEPT);

    assertEquals(CONCEPT, resource.getEthnicCategory());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }

  @Test
  public void religiousAffiliation() {
    setResource(new CareConnectPatient());

    resource.setReligiousAffiliation(CONCEPT);

    assertEquals(CONCEPT, resource.getReligiousAffiliation());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }

  @Test
  public void cadavericDonor() {
    setResource(new CareConnectPatient());

    BooleanType trueValue = new BooleanType(true);
    resource.setCadavericDonorElement(trueValue);

    assertEquals(trueValue, resource.getCadavericDonorElement());
    assertFalse("Patient should not be empty", resource.isEmpty());

    // Use convenience methods to unwrap value
    resource = new CareConnectPatient();

    resource.setCadavericDonor(true);

    assertTrue(resource.getCadavericDonor());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }

  @Test
  public void residentialStatus() {
    setResource(new CareConnectPatient());

    resource.setResidentialStatus(CONCEPT);

    assertEquals(CONCEPT, resource.getResidentialStatus());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }

  @Test
  public void treatmentCategory() {
    setResource(new CareConnectPatient());

    resource.setTreatmentCategory(CONCEPT);

    assertEquals(CONCEPT, resource.getTreatmentCategory());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }

  @Ignore
  @Test
  public void nhsCommunication() {
    // TODO nhsCommunication doesn't extend the Patient.Communication element, but has similar fields
  }

  @Test
  public void birthPlace() {
    setResource(new CareConnectPatient());

    Address address = new Address().setCity("London");
    resource.setBirthPlace(address);

    assertEquals(address, resource.getBirthPlace());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }

  @Test
  public void nominatedPharmacy() {
    setResource(new CareConnectPatient());

    Reference reference = new Reference("Organization/1");
    resource.setNominatedPharmacy(reference);

    assertEquals(reference, resource.getNominatedPharmacy());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }

  @Test
  @Ignore //Broken
  public void deathNotificationStatus() {
    setResource(new CareConnectPatient());

    DeathNotificationStatusExtension status = new DeathNotificationStatusExtension()
        .setDeathNotificationStatus(CONCEPT);
    resource.setDeathNotificationStatus(status);

    assertEquals(status, resource.getDeathNotificationStatus());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }

  @Test
  public void generalPractitioner() {
    setResource(new CareConnectPatient());

    Reference reference = new Reference("Practitioner/1");
    resource.addGeneralPractitioner(reference);

    assertEquals(1, resource.getGeneralPractitioner().size());
    assertEquals(reference, resource.getGeneralPractitionerFirstRep());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }

  @Test
  public void managingOrganization() {
    setResource(new CareConnectPatient());

    Reference reference = new Reference("Organization/1");
    resource.setManagingOrganization(reference);

    assertEquals(reference, resource.getManagingOrganization());
    assertFalse("Patient should not be empty", resource.isEmpty());
  }
}