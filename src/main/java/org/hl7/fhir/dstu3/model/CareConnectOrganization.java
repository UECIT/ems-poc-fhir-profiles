package org.hl7.fhir.dstu3.model;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.util.ElementUtil;
import java.util.ArrayList;
import java.util.List;

@ResourceDef(name = "Organization", profile = "https://fhir.hl7.org.uk/STU3/StructureDefinition/CareConnect-Organization-1")
public class CareConnectOrganization extends Organization {

  private static final long serialVersionUID = 2984414333509227661L;

  @Child(name = "identifier", type = {
      CareConnectIdentifier.class}, order = Child.REPLACE_PARENT, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(
      shortDefinition = "An identifier for this organization.",
      formalDefinition =
          "Organizations are known by a variety of ids. Some institutions maintain " +
              "several, and most collect identifiers for exchange with other organizations concerning the organization."
  )
  protected List<CareConnectIdentifier> identifier = new ArrayList<>();

  /**
   * @param value MUST be list of type {@link CareConnectIdentifier}
   */
  @Override
  public CareConnectOrganization setIdentifier(List<Identifier> value) {
    this.identifier = new ArrayList<>();
    for (Identifier i : value) {
      this.identifier.add((CareConnectIdentifier) i);
    }
    super.setIdentifier(value);
    return this;
  }

  @Override
  public CareConnectIdentifier addIdentifier() {
    CareConnectIdentifier identifier = new CareConnectIdentifier();
    this.identifier.add(identifier);
    super.addIdentifier(identifier);
    return identifier;
  }

  /**
   * @param value MUST be of type {@link CareConnectIdentifier}
   */
  @Override
  public CareConnectOrganization addIdentifier(Identifier value) {
    this.identifier.add((CareConnectIdentifier) value);
    super.addIdentifier(value);
    return this;
  }

  @Override
  public CareConnectIdentifier getIdentifierFirstRep() {
    if (getIdentifier().isEmpty()) {
      addIdentifier();
    }
    return identifier.get(0);
  }

  @Child(name = "mainLocation", type = {CareConnectLocation.class})
  @Extension(url = "https://fhir.hl7.org.uk/STU3/StructureDefinition/Extension-CareConnect-MainLocation-1", definedLocally = false, isModifier = false)
  @Description(shortDefinition = "The main location of the organization.")
  protected Reference mainLocation;  // CareConnect-Location-1

  public Reference getMainLocation() {
    return mainLocation;
  }

  public CareConnectOrganization setMainLocation(Reference mainLocation) {
    this.mainLocation = mainLocation;
    return this;
  }

  @Child(name = "organization-period")
  @Extension(url = "http://hl7.org/fhir/StructureDefinition/organization-period", definedLocally = false, isModifier = false)
  @Description(shortDefinition = "The date range that this organization should be considered available.")
  protected Period organizationPeriod;

  public Period getOrganizationPeriod() {
    return organizationPeriod;
  }

  public CareConnectOrganization setOrganizationPeriod(Period organizationPeriod) {
    this.organizationPeriod = organizationPeriod;
    return this;
  }

  @Child(name = "partOf", type = {
      CareConnectOrganization.class}, order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = true)
  @Description(
      shortDefinition = "The organization of which this organization forms a part",
      formalDefinition = "The organization of which this organization forms a part."
  )
  protected Reference partOf;

  @Override
  public CareConnectOrganization setPartOf(Reference value) {
    this.partOf = value;
    super.setPartOf(value);
    return this;
  }

  @Override
  public boolean isEmpty() {
    return super.isEmpty() && ElementUtil.isEmpty(mainLocation, organizationPeriod);
  }
}
