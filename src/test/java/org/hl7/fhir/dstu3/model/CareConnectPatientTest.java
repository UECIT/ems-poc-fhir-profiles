package org.hl7.fhir.dstu3.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import org.hl7.fhir.dstu3.model.CareConnectPatient.DeathNotificationStatusExtension;
import org.junit.Ignore;
import org.junit.Test;

public class CareConnectPatientTest {

  public static final CodeableConcept CONCEPT = new CodeableConcept()
      .addCoding(new Coding().setDisplay("concept"));

  @Test
  public void nhsNumberIdentifier() {
    CareConnectPatient patient = new CareConnectPatient();

    CareConnectIdentifier identifier = new NHSNumberIdentifier()
        .setNhsNumberVerificationStatus(CONCEPT)
        .setSystem("nhs")
        .setAssigner(new Reference("Organization/1"))
        .setValue("id");
    patient.addIdentifier(identifier);

    assertEquals(identifier, patient.getIdentifierFirstRep());
    assertFalse("Patient should not be empty", patient.isEmpty());

    // Use inline identifier creation
    patient = new CareConnectPatient();

    identifier = patient.addIdentifier()
        .setNhsNumberVerificationStatus(CONCEPT)
        .setSystem("nhs")
        .setAssigner(new Reference("Organization/1"))
        .setValue("id");

    assertEquals(identifier, patient.getIdentifierFirstRep());
    assertFalse("Patient should not be empty", patient.isEmpty());

    // Use setIdentifier
    patient = new CareConnectPatient();

    identifier = new NHSNumberIdentifier()
        .setNhsNumberVerificationStatus(CONCEPT)
        .setSystem("nhs")
        .setAssigner(new Reference("Organization/1"))
        .setValue("id");
    patient.setIdentifier(Collections.singletonList(identifier));

    assertEquals(identifier, patient.getIdentifierFirstRep());
    assertFalse("Patient should not be empty", patient.isEmpty());
  }

  @Test
  public void ethnicCategory() {
    CareConnectPatient patient = new CareConnectPatient();

    patient.setEthnicCategory(CONCEPT);

    assertEquals(CONCEPT, patient.getEthnicCategory());
    assertFalse("Patient should not be empty", patient.isEmpty());
  }

  @Test
  public void religiousAffiliation() {
    CareConnectPatient patient = new CareConnectPatient();

    patient.setReligiousAffiliation(CONCEPT);

    assertEquals(CONCEPT, patient.getReligiousAffiliation());
    assertFalse("Patient should not be empty", patient.isEmpty());
  }

  @Test
  public void cadavericDonor() {
    CareConnectPatient patient = new CareConnectPatient();

    BooleanType trueValue = new BooleanType(true);
    patient.setCadavericDonorElement(trueValue);

    assertEquals(trueValue, patient.getCadavericDonorElement());
    assertFalse("Patient should not be empty", patient.isEmpty());

    // Use convenience methods to unwrap value
    patient = new CareConnectPatient();

    patient.setCadavericDonor(true);

    assertTrue(patient.getCadavericDonor());
    assertFalse("Patient should not be empty", patient.isEmpty());
  }

  @Test
  public void residentialStatus() {
    CareConnectPatient patient = new CareConnectPatient();

    patient.setResidentialStatus(CONCEPT);

    assertEquals(CONCEPT, patient.getResidentialStatus());
    assertFalse("Patient should not be empty", patient.isEmpty());
  }

  @Test
  public void treatmentCategory() {
    CareConnectPatient patient = new CareConnectPatient();

    patient.setTreatmentCategory(CONCEPT);

    assertEquals(CONCEPT, patient.getTreatmentCategory());
    assertFalse("Patient should not be empty", patient.isEmpty());
  }

  @Ignore
  @Test
  public void nhsCommunication() {
    // TODO nhsCommunication doesn't extend the Patient.Communication element, but has similar fields
  }

  @Test
  public void birthPlace() {
    CareConnectPatient patient = new CareConnectPatient();

    Address address = new Address().setCity("London");
    patient.setBirthPlace(address);

    assertEquals(address, patient.getBirthPlace());
    assertFalse("Patient should not be empty", patient.isEmpty());
  }

  @Test
  public void nominatedPharmacy() {
    CareConnectPatient patient = new CareConnectPatient();

    Reference reference = new Reference("Organization/1");
    patient.setNominatedPharmacy(reference);

    assertEquals(reference, patient.getNominatedPharmacy());
    assertFalse("Patient should not be empty", patient.isEmpty());
  }

  @Test
  public void deathNotificationStatus() {
    CareConnectPatient patient = new CareConnectPatient();

    DeathNotificationStatusExtension status = new DeathNotificationStatusExtension()
        .setDeathNotificationStatus(CONCEPT);
    patient.setDeathNotificationStatus(status);

    assertEquals(status, patient.getDeathNotificationStatus());
    assertFalse("Patient should not be empty", patient.isEmpty());
  }

  @Test
  public void generalPractitioner() {
    CareConnectPatient patient = new CareConnectPatient();

    Reference reference = new Reference("Practitioner/1");
    patient.addGeneralPractitioner(reference);

    assertEquals(1, patient.getGeneralPractitioner().size());
    assertEquals(reference, patient.getGeneralPractitionerFirstRep());
    assertFalse("Patient should not be empty", patient.isEmpty());
  }

  @Test
  public void managingOrganization() {
    CareConnectPatient patient = new CareConnectPatient();

    Reference reference = new Reference("Organization/1");
    patient.setManagingOrganization(reference);

    assertEquals(reference, patient.getManagingOrganization());
    assertFalse("Patient should not be empty", patient.isEmpty());
  }

}