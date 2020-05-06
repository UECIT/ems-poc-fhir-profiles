package org.hl7.fhir.dstu3.model;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.util.ElementUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ResourceDef(name = "Practitioner", profile = CareConnectPractitioner.PROFILE)
public class CareConnectPractitioner extends Practitioner {

  private static final long serialVersionUID = 5673932590168362570L;

  static final String PROFILE = "https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Practitioner-1";

  public CareConnectPractitioner() {
    super();
    this.setMeta(new Meta().addProfile(PROFILE));
  }

  @Child(name = "identifier", order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = true, summary = true)
  @Description(shortDefinition = "Practitioner identifiers")
  protected List<CareConnectIdentifier> identifier = new ArrayList<>();

  /**
   * @param value MUST be list of type {@link CareConnectIdentifier}
   */
  @Override
  public CareConnectPractitioner setIdentifier(List<Identifier> value) {
    this.identifier = new ArrayList<>();
    for (Identifier i : value) {
      this.identifier.add((CareConnectIdentifier) i);
    }
    return this;
  }

  /**
   * @param value MUST be of type {@link CareConnectIdentifier}
   */
  @Override
  public CareConnectPractitioner addIdentifier(Identifier value) {
    this.identifier.add((CareConnectIdentifier) value);
    return this;
  }

  @Override
  public CareConnectIdentifier addIdentifier() {
    CareConnectIdentifier identifier = new CareConnectIdentifier();
    addIdentifier(identifier);
    return identifier;
  }

  @Override
  public CareConnectIdentifier getIdentifierFirstRep() {
    if (getIdentifier().isEmpty()) {
      addIdentifier();
    }
    return identifier.get(0);
  }

  @Override
  public List<Identifier> getIdentifier() {
    return Collections.unmodifiableList(this.identifier);
  }

  @Override
  public boolean isEmpty() {
    return super.isEmpty() && ElementUtil.isEmpty(identifier);
  }

  @Child(name = "nhsCommunication")
  @Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NHSCommunication-1", definedLocally = false, isModifier = false)
  protected NhsCommunicationExtension nhsCommunication;

  public NhsCommunicationExtension getNhsCommunication() {
    return nhsCommunication;
  }

  public void setNhsCommunication(NhsCommunicationExtension nhsCommunication) {
    this.nhsCommunication = nhsCommunication;
  }

  @Block
  public static class NhsCommunicationExtension extends BackboneElement {

    private static final long serialVersionUID = 2L;

    @Child(name = "language")
    @Extension(url = "https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-HumanLanguage-1", definedLocally = false, isModifier = false)
    protected CodeableConcept language;

    public CodeableConcept getLanguage() {
      return language;
    }

    public NhsCommunicationExtension setLanguage(CodeableConcept language) {
      this.language = language;
      return this;
    }

    @Child(name = "preferred")
    @Extension(url = "preferred", definedLocally = false, isModifier = false)
    protected BooleanType preferred;

    public BooleanType getPreferred() {
      return preferred;
    }

    public NhsCommunicationExtension setPreferred(BooleanType preferred) {
      this.preferred = preferred;
      return this;
    }

    @Child(name = "modeOfCommunication")
    @Extension(url = "https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-LanguageAbilityMode-1", definedLocally = false, isModifier = false)
    protected CodeableConcept modeOfCommunication;

    public CodeableConcept getModeOfCommunication() {
      return modeOfCommunication;
    }

    public NhsCommunicationExtension setModeOfCommunication(CodeableConcept modeOfCommunication) {
      this.modeOfCommunication = modeOfCommunication;
      return this;
    }

    @Child(name = "communicationProficiency")
    @Extension(url = "https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-LanguageAbilityProficiency-1", definedLocally = false, isModifier = false)
    protected CodeableConcept communicationProficiency;

    public CodeableConcept getCommunicationProficiency() {
      return communicationProficiency;
    }

    public NhsCommunicationExtension setCommunicationProficiency(
        CodeableConcept communicationProficiency) {
      this.communicationProficiency = communicationProficiency;
      return this;
    }

    @Child(name = "interpreterRequired")
    @Extension(url = "interpreterRequired", definedLocally = false, isModifier = false)
    protected BooleanType interpreterRequired;

    public BooleanType getInterpreterRequired() {
      return interpreterRequired;
    }

    public NhsCommunicationExtension setInterpreterRequired(BooleanType interpreterRequired) {
      this.interpreterRequired = interpreterRequired;
      return this;
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
      return super.isEmpty() && ElementUtil
          .isEmpty(language, preferred, modeOfCommunication, communicationProficiency,
              interpreterRequired);
    }

  }
}
