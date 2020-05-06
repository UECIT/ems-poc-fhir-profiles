package org.hl7.fhir.dstu3.model;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.util.ElementUtil;
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
    return this;
  }

  @Override
  public boolean hasSystem() {
    return this.system != null && !this.system.isEmpty();
  }

  @Override
  public String getSystem() {
    return this.system == null ? null : this.system.getValue();
  }

  @Override
  public CareConnectIdentifier setSystemElement(UriType value) {
    this.system = value;
    return this;
  }

  @Override
  public UriType getSystemElement() {
    if (this.system == null) {
      if (Configuration.errorOnAutoCreate()) {
        throw new Error("Attempt to auto-create Identifier.system");
      } else if (Configuration.doAutoCreate()) {
        this.system = new UriType(); // bb
      }
    }
    return this.system;
  }

  @Override
  public boolean hasSystemElement() {
    return this.system != null && !this.system.isEmpty();
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
    return this;
  }

  @Override
  public boolean hasValue() {
    return this.value != null && !this.value.isEmpty();
  }

  @Override
  public String getValue() {
    return this.value == null ? null : this.value.getValue();
  }

  @Override
  public CareConnectIdentifier setValueElement(StringType value) {
    this.value = value;
    return this;
  }

  @Override
  public StringType getValueElement() {
    return this.value;
  }

  @Override
  public boolean hasValueElement() {
    return this.value != null && !this.value.isEmpty();
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
    return this;
  }

  @Override
  public Reference getAssigner() {
    return assigner;
  }

  @Override
  public boolean hasAssigner() {
    return this.assigner != null && !this.assigner.isEmpty();
  }

  @Override
  public boolean isEmpty() {
    return super.isEmpty() && ElementUtil.isEmpty(system, value, assigner);
  }

  @Override
  public boolean equalsDeep(Base other_) {
    if (!super.equalsDeep(other_)) {
      return false;
    }
    if (!(other_ instanceof CareConnectIdentifier)) {
      return false;
    }
    CareConnectIdentifier o = (CareConnectIdentifier) other_;
    return compareDeep(system, o.system, true)
        && compareDeep(value, o.value, true)
        && compareDeep(assigner, o.assigner, true);
  }

  @Override
  public boolean equalsShallow(Base other_) {
    if (!super.equalsShallow(other_)) {
      return false;
    }
    if (!(other_ instanceof CareConnectIdentifier)) {
      return false;
    }
    CareConnectIdentifier o = (CareConnectIdentifier) other_;
    return compareValues(system, o.system, true)
        && compareValues(value, o.value, true);
  }
}
