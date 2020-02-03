package org.hl7.fhir.dstu3.model;

import ca.uhn.fhir.model.api.annotation.Binding;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.util.ElementUtil;
import org.hl7.fhir.instance.model.api.ICompositeType;

@DatatypeDef(name = "identifier")
public class NHSNumberIdentifier extends CareConnectIdentifier implements ICompositeType {

  private static final long serialVersionUID = -3997879541395068454L;

  @Binding(valueSet = "https://fhir.hl7.org.uk/STU3/ValueSet/CareConnect-NHSNumberVerificationStatus-1")
  @Child(name = "nhsNumberVerificationStatus", type = {
      CodeableConcept.class}, modifier = false, summary = true)
  @Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-NHSNumberVerificationStatus-1", definedLocally = false, isModifier = false)
  @Description(shortDefinition = "The verification/tracing status of the NHS number")
  private CodeableConcept nhsNumberVerificationStatus;

  public CodeableConcept getNhsNumberVerificationStatus() {
    return nhsNumberVerificationStatus;
  }

  public NHSNumberIdentifier setNhsNumberVerificationStatus(CodeableConcept value) {
    this.nhsNumberVerificationStatus = value;
    return this;
  }

  @Override
  public boolean isEmpty() {
    return super.isEmpty() && ElementUtil.isEmpty(nhsNumberVerificationStatus);
  }
}
