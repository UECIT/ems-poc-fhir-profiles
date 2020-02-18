package org.hl7.fhir.dstu3.model;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import org.hl7.fhir.instance.model.api.ICompositeType;

@DatatypeDef(name = "identifier")
@Block
public class CareConnectIdentifier extends Identifier implements ICompositeType {

  private static final long serialVersionUID = -8923293192072114074L;

  /**
   * Establishes the namespace for the value - that is, a URL that describes a set values that are
   * unique.
   */
  @Child(name = "system", order = Child.REPLACE_PARENT, min = 1, max = 1, modifier = true, summary = true)
  @Description(
      shortDefinition = "The namespace for the identifier value",
      formalDefinition = "Establishes the namespace for the value - " +
          "that is, a URL that describes a set values that are unique."
  )
  protected UriType system;

  @Override
  public CareConnectIdentifier setSystem(String system) {
    this.system = new UriType(system);
    super.setSystemElement(this.system);
    return this;
  }

  @Override
  public CareConnectIdentifier setSystemElement(UriType value) {
    this.system = value;
    super.setSystemElement(value);
    return this;
  }

  /**
   * The portion of the identifier typically relevant to the user and which is unique within the
   * context of the system.
   */
  @Child(name = "value", order = Child.REPLACE_PARENT, min = 1, max = 1, modifier = true, summary = true)
  @Description(
      shortDefinition = "The value that is unique",
      formalDefinition = "The portion of the identifier typically relevant to the user " +
          "and which is unique within the context of the system."
  )
  protected StringType value;

  @Override
  public CareConnectIdentifier setValue(String value) {
    this.value = new StringType(value);
    super.setValue(value);
    return this;
  }

  @Override
  public CareConnectIdentifier setValueElement(StringType value) {
    this.value = value;
    super.value = value;
    return this;
  }

  /**
   * Organization that issued/manages the identifier.
   */
  @Child(
      name = "assigner", type = {CareConnectOrganization.class},
      order = Child.REPLACE_PARENT, min = 0, max = 1, modifier = false, summary = true
  )
  @Description(
      shortDefinition = "Organization that issued id (may be just text)",
      formalDefinition = "Organization that issued/manages the identifier."
  )
  protected Reference assigner;

  @Override
  public CareConnectIdentifier setAssigner(Reference assigner) {
    this.assigner = assigner;
    super.setAssigner(assigner);
    return this;
  }
}
