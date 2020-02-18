package org.hl7.fhir.dstu3.model;

import ca.uhn.fhir.model.api.annotation.Binding;
import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.util.ElementUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ResourceDef(name = "Patient", profile = CareConnectPatient.PROFILE)
public class CareConnectPatient extends Patient {

  private static final long serialVersionUID = -1894418594217458769L;

  static final String PROFILE = "https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Patient-1";


  public CareConnectPatient() {
    super();
    this.setMeta(new Meta().addProfile(PROFILE));
  }

  @Child(name = "identifier", type = {
      NHSNumberIdentifier.class}, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "An identifier for this patient", formalDefinition = "An identifier for this patient.")
  protected List<NHSNumberIdentifier> identifier = new ArrayList<>();

  /**
   * @param value MUST be list of type {@link NHSNumberIdentifier}
   */
  @Override
  public CareConnectPatient setIdentifier(List<Identifier> value) {
    this.identifier = new ArrayList<>();
    for (Identifier i : value) {
      this.identifier.add((NHSNumberIdentifier) i);
    }
    return this;
  }

  /**
   * @param value MUST be of type {@link NHSNumberIdentifier}
   */
  @Override
  public CareConnectPatient addIdentifier(Identifier value) {
    this.identifier.add((NHSNumberIdentifier) value);
    return this;
  }

  @Override
  public NHSNumberIdentifier addIdentifier() {
    NHSNumberIdentifier identifier = new NHSNumberIdentifier();
    this.identifier.add(identifier);
    return identifier;
  }

  @Override
  public NHSNumberIdentifier getIdentifierFirstRep() {
    if (getIdentifier().isEmpty()) {
      addIdentifier();
    }
    return identifier.get(0);
  }

  @Override
  public List<Identifier> getIdentifier() {
    return Collections.unmodifiableList(this.identifier);
  }

  @Child(name = "ethnicCategory")
  @Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-EthnicCategory-1", definedLocally = false, isModifier = false)
  @Description(shortDefinition = "This extension is constrained to represent the ethnic category for a patient")
  protected CodeableConcept ethnicCategory;

  public CodeableConcept getEthnicCategory() {
    return ethnicCategory;
  }

  public CareConnectPatient setEthnicCategory(CodeableConcept ethnicCategory) {
    this.ethnicCategory = ethnicCategory;
    return this;
  }

  @Child(name = "religiousAffiliation")
  @Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-ReligiousAffiliation-1", definedLocally = false, isModifier = false)
  @Description(shortDefinition = "This extension is constrained to represent the religious affiliation for a patient.")
  protected CodeableConcept religiousAffiliation;

  public CodeableConcept getReligiousAffiliation() {
    return religiousAffiliation;
  }

  public CareConnectPatient setReligiousAffiliation(CodeableConcept religiousAffiliation) {
    this.religiousAffiliation = religiousAffiliation;
    return this;
  }

  @Child(name = "patient-cadavericDonor")
  @Extension(url = "http://hl7.org/fhir/StructureDefinition/patient-cadavericDonor", definedLocally = false, isModifier = false)
  @Description(shortDefinition = "Flag indicating whether the patient authorized the donation of body parts after death.")
  protected BooleanType cadavericDonor;

  public boolean getCadavericDonor() {
    return cadavericDonor != null && cadavericDonor.booleanValue();
  }

  public BooleanType getCadavericDonorElement() {
    return cadavericDonor;
  }

  public CareConnectPatient setCadavericDonorElement(BooleanType cadavericDonor) {
    this.cadavericDonor = cadavericDonor;
    return this;
  }

  public CareConnectPatient setCadavericDonor(boolean cadavericDonor) {
    this.cadavericDonor = new BooleanType(cadavericDonor);
    return this;
  }

  @Child(name = "residentialStatus")
  @Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-ResidentialStatus-1", definedLocally = false, isModifier = false)
  @Description(shortDefinition = "This extension is constrained to represent the residential status for a patient.")
  protected CodeableConcept residentialStatus;

  public CodeableConcept getResidentialStatus() {
    return residentialStatus;
  }

  public CareConnectPatient setResidentialStatus(CodeableConcept residentialStatus) {
    this.residentialStatus = residentialStatus;
    return this;
  }

  @Child(name = "treatmentCategory")
  @Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-TreatmentCategory-1", definedLocally = false, isModifier = false)
  @Description(shortDefinition = "This extension is constrained to represent the treatment category for a patient.")
  protected CodeableConcept treatmentCategory;

  public CodeableConcept getTreatmentCategory() {
    return treatmentCategory;
  }

  public CareConnectPatient setTreatmentCategory(CodeableConcept treatmentCategory) {
    this.treatmentCategory = treatmentCategory;
    return this;
  }

  @Child(name = "nhsCommunication")
  @Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NHSCommunication-1", definedLocally = false, isModifier = false)
  @Description(shortDefinition = "This extension is constrained to support the communication preferences for a resource in the NHS.")
  protected NhsCommunicationExtension nhsCommunication;

  @Block
  public static class NhsCommunicationExtension extends BackboneElement {

    private static final long serialVersionUID = -1901148205804751417L;

    @Child(name = "language")
    protected org.hl7.fhir.dstu3.model.Extension language;

    public org.hl7.fhir.dstu3.model.Extension getLanguage() {
      return language;
    }

    public void setLanguage(org.hl7.fhir.dstu3.model.Extension language) {
      this.language = language;
    }

    @Child(name = "preferred")
    protected org.hl7.fhir.dstu3.model.Extension preferred;

    public org.hl7.fhir.dstu3.model.Extension getPreferred() {
      return preferred;
    }

    public void setPreferred(org.hl7.fhir.dstu3.model.Extension preferred) {
      this.preferred = preferred;
    }

    @Child(name = "modeOfCommunication")
    protected org.hl7.fhir.dstu3.model.Extension modeOfCommunication;

    public org.hl7.fhir.dstu3.model.Extension getModeOfCommunication() {
      return modeOfCommunication;
    }

    public void setModeOfCommunication(org.hl7.fhir.dstu3.model.Extension modeOfCommunication) {
      this.modeOfCommunication = modeOfCommunication;
    }

    @Child(name = "communicationProficiency")
    protected org.hl7.fhir.dstu3.model.Extension communicationProficiency;

    public org.hl7.fhir.dstu3.model.Extension getCommunicationProficiency() {
      return communicationProficiency;
    }

    public void setCommunicationProficiency(
        org.hl7.fhir.dstu3.model.Extension communicationProficiency) {
      this.communicationProficiency = communicationProficiency;
    }

    @Child(name = "interpreterRequired")
    protected org.hl7.fhir.dstu3.model.Extension interpreterRequired;

    public org.hl7.fhir.dstu3.model.Extension getInterpreterRequired() {
      return interpreterRequired;
    }

    public void setInterpreterRequired(org.hl7.fhir.dstu3.model.Extension interpreterRequired) {
      this.interpreterRequired = interpreterRequired;
    }

    @Override
    public BackboneElement copy() {
      NhsCommunicationExtension copy = new NhsCommunicationExtension();
      copy.language = language;
      copy.preferred = preferred;
      copy.modeOfCommunication = modeOfCommunication;
      copy.communicationProficiency = communicationProficiency;
      copy.interpreterRequired = interpreterRequired;
      return copy;
    }

    @Override
    public boolean isEmpty() {
      return super.isEmpty() && ElementUtil.isEmpty(language, preferred, modeOfCommunication,
          communicationProficiency, interpreterRequired);
    }

  }

  public NhsCommunicationExtension getNhsCommunication() {
    return nhsCommunication;
  }

  public CareConnectPatient setNhsCommunication(NhsCommunicationExtension nhsCommunication) {
    this.nhsCommunication = nhsCommunication;
    return this;
  }

//	@Child(name = "birthDate", type = {BirthDateType.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
//    @Description(shortDefinition="The date of birth for the individual", formalDefinition="The date of birth for the individual." )
//	private DateType birthDate;
//	
//    public CareConnectPatient setBirthDate(Date birthDate) { 
//    	this.birthDate = new BirthDateType().setBirthTime(new DateTimeType(birthDate));
//        return this;
//    }

  @Child(name = "birthPlace")
  @Extension(url = "http://hl7.org/fhir/StructureDefinition/birthPlace", definedLocally = false, isModifier = false)
  @Description(shortDefinition = "The registered place of birth of the patient. A sytem may use "
      + "the address.text if they don't store the birthPlace address in discrete elements.")
  protected Address birthPlace;

  public Address getBirthPlace() {
    return birthPlace;
  }

  public CareConnectPatient setBirthPlace(Address birthPlace) {
    this.birthPlace = birthPlace;
    return this;
  }

  // TODO REFERENCETYPE - figure out how to represent/constrain this.
  @Child(name = "nominatedPharmacy")
  @Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NominatedPharmacy-1", definedLocally = false, isModifier = false)
  @Description(shortDefinition = "This extension is constrained to represent a patient's nominated pharmacy.")
  protected Reference nominatedPharmacy;

  public Reference getNominatedPharmacy() {
    return nominatedPharmacy;
  }

  public CareConnectPatient setNominatedPharmacy(Reference nominatedPharmacy) {
    this.nominatedPharmacy = nominatedPharmacy;
    return this;
  }

  // TODO EXTENSION WITH EXTENSIONS - figure out how to define.
  @Child(name = "deathNotificationStatus")
  @Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-DeathNotificationStatus-1", definedLocally = false, isModifier = false)
  @Description(shortDefinition =
      "This extension is constrained to represent a patient's death notification "
          + "(as held on Personal Demographics Service (PDS)).")
  protected DeathNotificationStatusExtension deathNotificationStatus;

  @Block
  public static class DeathNotificationStatusExtension extends BackboneElement {

    private static final long serialVersionUID = -5850933372453434264L;

    @Child(name = "deathNotificationStatus")
    @Binding(valueSet = "https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-DeathNotificationStatus-1")
    protected CodeableConcept deathNotificationStatus;

    public CodeableConcept getDeathNotificationStatus() {
      return deathNotificationStatus;
    }

    public DeathNotificationStatusExtension setDeathNotificationStatus(
        CodeableConcept deathNotificationStatus) {
      this.deathNotificationStatus = deathNotificationStatus;
      return this;
    }

    @Child(name = "systemEffectiveDate")
    protected BooleanType systemEffectiveDate;

    public BooleanType getSystemEffectiveDate() {
      return systemEffectiveDate;
    }

    public DeathNotificationStatusExtension setSystemEffectiveDate(
        BooleanType systemEffectiveDate) {
      this.systemEffectiveDate = systemEffectiveDate;
      return this;
    }

    @Override
    public BackboneElement copy() {
      DeathNotificationStatusExtension copy = new DeathNotificationStatusExtension();
      copy.deathNotificationStatus = deathNotificationStatus;
      copy.systemEffectiveDate = systemEffectiveDate;
      return copy;
    }

    @Override
    public boolean isEmpty() {
      return super.isEmpty() && ElementUtil.isEmpty(deathNotificationStatus, systemEffectiveDate);
    }

  }

  public DeathNotificationStatusExtension getDeathNotificationStatus() {
    return deathNotificationStatus;
  }

  public CareConnectPatient setDeathNotificationStatus(
      DeathNotificationStatusExtension deathNotificationStatus) {
    this.deathNotificationStatus = deathNotificationStatus;
    return this;
  }

  @Child(name = "generalPractitioner", type = {CareConnectOrganization.class,
      CareConnectPractitioner.class}, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Patient's nominated primary care provider", formalDefinition = "Patient's nominated primary care provider.")
  protected List<Reference> generalPractitioner = new ArrayList<>();

  @Override
  public List<Reference> getGeneralPractitioner() {
    return generalPractitioner;
  }

  @Override
  public CareConnectPatient addGeneralPractitioner(Reference reference) {
    generalPractitioner.add(reference);
    return this;
  }

  @Override
  public Reference addGeneralPractitioner() {
    Reference reference = new Reference();
    generalPractitioner.add(reference);
    return reference;
  }

  @Override
  public CareConnectPatient setGeneralPractitioner(List<Reference> value) {
    generalPractitioner = new ArrayList<>(value);
    return this;
  }

  @Override
  public Reference getGeneralPractitionerFirstRep() {
    if (getGeneralPractitioner().isEmpty()) {
      addGeneralPractitioner();
    }
    return getGeneralPractitioner().get(0);
  }

  @Child(name = "managingOrganization", type = {
      CareConnectOrganization.class}, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Organization that is the custodian of the patient record", formalDefinition = "Organization that is the custodian of the patient record.")
  protected Reference managingOrganization;

  @Override
  public Reference getManagingOrganization() {
    return managingOrganization;
  }

  @Override
  public CareConnectPatient setManagingOrganization(Reference reference) {
    managingOrganization = reference;
    return this;
  }

  @Override
  public boolean isEmpty() {
    return super.isEmpty()
        && ElementUtil
        .isEmpty(ethnicCategory, religiousAffiliation, cadavericDonor, residentialStatus,
            treatmentCategory, nhsCommunication, birthPlace, nominatedPharmacy,
            deathNotificationStatus, managingOrganization, generalPractitioner);
  }

  @Override
  public boolean equalsDeep(Base other_) {
    if (!super.equalsDeep(other_))
      return false;
    if (!(other_ instanceof CareConnectPatient))
      return false;
    CareConnectPatient o = (CareConnectPatient) other_;
    return compareDeep(ethnicCategory, o.ethnicCategory, true)
        && compareDeep(religiousAffiliation, o.religiousAffiliation, true)
        && compareDeep(cadavericDonor, o.cadavericDonor, true)
        && compareDeep(residentialStatus, o.residentialStatus, true)
        && compareDeep(treatmentCategory, o.treatmentCategory, true)
        && compareDeep(nhsCommunication, o.nhsCommunication, true)
        && compareDeep(birthPlace, o.birthPlace, true)
        && compareDeep(nominatedPharmacy, o.nominatedPharmacy, true)
        && compareDeep(deathNotificationStatus, o.deathNotificationStatus, true)
        && compareDeep(managingOrganization, o.managingOrganization, true)
        && compareDeep(generalPractitioner, o.generalPractitioner, true);
  }
}
