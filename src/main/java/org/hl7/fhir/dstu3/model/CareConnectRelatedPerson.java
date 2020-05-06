package org.hl7.fhir.dstu3.model;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.util.ElementUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ResourceDef(name="RelatedPerson", profile=CareConnectRelatedPerson.PROFILE)
public class CareConnectRelatedPerson extends RelatedPerson {

	private static final long serialVersionUID = 1L;

	static final String PROFILE = "https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-RelatedPerson-1";

  public CareConnectRelatedPerson() {
    super();
    this.setMeta(new Meta().addProfile(PROFILE));
  }

  /**
   * Identifier for a person within a particular scope.
   */
  @Child(name="identifier", type={CareConnectIdentifier.class}, order=Child.REPLACE_PARENT, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
  @Description(
    shortDefinition="A human identifier for this person",
    formalDefinition="Identifier for a person within a particular scope."
  )
  protected List<CareConnectIdentifier> identifier = new ArrayList<>();

  @Override
  public List<Identifier> getIdentifier() {
    return Collections.unmodifiableList(this.identifier);
  }

  /**
   * @param value MUST be list of type {@link CareConnectIdentifier}
   */
  @Override
  public CareConnectRelatedPerson setIdentifier(List<Identifier> value) {
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
  public CareConnectRelatedPerson addIdentifier(Identifier value) {
    this.identifier.add((CareConnectIdentifier) value);
    return this;
  }

  @Override
  public CareConnectIdentifier addIdentifier() {
    CareConnectIdentifier identifier = new CareConnectIdentifier();
    this.identifier.add(identifier);
    return identifier;
  }

  @Override
  public CareConnectIdentifier getIdentifierFirstRep() {
    if (getIdentifier().isEmpty()) {
      addIdentifier();
    }
    return identifier.get(0);
  }

  /**
   * The patient this person is related to.
   */
  @Child(name="patient", type={CareConnectPatient.class}, order=Child.REPLACE_PARENT, min=0, max=1, modifier=false, summary=true)
  @Description(
    shortDefinition="The patient this person is related to",
    formalDefinition="The patient this person is related to."
  )
  protected Reference patient;

  @Override
  public Reference getPatient() {
    return patient;
  }

  @Override
  public CareConnectRelatedPerson setPatient(Reference patient) {
    this.patient = patient;
    return this;
  }

  @Override
  public boolean isEmpty() {
    return super.isEmpty() && ElementUtil.isEmpty(identifier);
  }
}
