package com.expensesmanagementapisdk.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateAnExpenseRequest {

  @JsonProperty("title")
  private JsonNullable<String> title;

  @JsonProperty("amount")
  private JsonNullable<Double> amount;

  @JsonProperty("category")
  private JsonNullable<String> category;

  @JsonProperty("date")
  private JsonNullable<String> date;

  @JsonProperty("notes")
  private JsonNullable<String> notes;

  // FSM-59: capture unknown JSON fields so they round-trip on re-serialize.
  // @Builder.Default keeps the empty-map default in the Lombok-generated builder; without it the
  // builder would leave the map null and the any-setter would NPE on the first unknown field.
  // Deserialization is wired via the builder's @JsonAnySetter (see the Builder below), NOT here:
  // Lombok @Jacksonized deserializes through the builder and does not copy a field-level
  // @JsonAnySetter across, so unknown fields would be silently dropped if it lived on this field.
  @Builder.Default
  private Map<String, Object> additionalProperties = new HashMap<>();

  // @JsonAnyGetter must sit on the getter (not the field) so Jackson inlines the unknown entries on
  // serialize. On the field it double-registers with the Lombok getter and leaks a literal
  // "additionalProperties" property into every request body and object parameter.
  // Declaring the getter here also stops Lombok @Data from generating its own.
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonIgnore
  public Double getAmount() {
    return amount.orElse(null);
  }

  @JsonIgnore
  public String getCategory() {
    return category.orElse(null);
  }

  @JsonIgnore
  public String getDate() {
    return date.orElse(null);
  }

  @JsonIgnore
  public String getNotes() {
    return notes.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreateAnExpenseRequestBuilder {

    private JsonNullable<String> title = JsonNullable.undefined();

    @JsonProperty("title")
    public CreateAnExpenseRequestBuilder title(String value) {
      this.title = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> amount = JsonNullable.undefined();

    @JsonProperty("amount")
    public CreateAnExpenseRequestBuilder amount(Double value) {
      this.amount = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> category = JsonNullable.undefined();

    @JsonProperty("category")
    public CreateAnExpenseRequestBuilder category(String value) {
      this.category = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> date = JsonNullable.undefined();

    @JsonProperty("date")
    public CreateAnExpenseRequestBuilder date(String value) {
      this.date = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> notes = JsonNullable.undefined();

    @JsonProperty("notes")
    public CreateAnExpenseRequestBuilder notes(String value) {
      this.notes = JsonNullable.of(value);
      return this;
    }

    @JsonAnySetter
    public CreateAnExpenseRequestBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }
  }
}
