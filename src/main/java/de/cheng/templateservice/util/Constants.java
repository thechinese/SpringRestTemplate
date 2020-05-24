package de.cheng.templateservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {

  public static final int THREAD_POOL_SIZE = 10;

  private static final String AOOIR_PROP_TYPE_OF_OBJECT_OF_INTEREST = "typeOfObjectOfInterest";

  private static final String PP_PROP_PROPERTY_ID = "propertyId";
  private static final String PP_PROP_IS_OWNED_BY = "isOwnedBy";

  public static final String ALL_PROP_ID = "id";
  private static final String ALL_PROP_NAME = "name";
  private static final String ALL_PROP_DESCRIPTION = "description";

  /*
   * Regex patterns for validation.
   * Also exclude static attributes names from dynamic attributes.
   */
  private static final String LETTER_NUMBER = "[A-Za-z][A-Za-z0-9]+$";
  public static final String VALID_UUID = "^[A-Za-z0-9][-A-Za-z0-9]+$";
  public static final String VALID_PP_REL = "^(?!(" + PP_PROP_IS_OWNED_BY + ")$)" + LETTER_NUMBER;
  public static final String VALID_PP_DYN_PROP = "^(?!(" + "uuid" + "|" + ALL_PROP_ID + "|" + ALL_PROP_NAME +
    "|" + PP_PROP_PROPERTY_ID + "|" + PP_PROP_IS_OWNED_BY + ")$)" + LETTER_NUMBER;
  public static final String VALID_AOOIR_DYN_PROP = "^(?!(" + "uuid" + "|" + ALL_PROP_ID + "|" + ALL_PROP_NAME +
    "|" + ALL_PROP_DESCRIPTION + "|" + AOOIR_PROP_TYPE_OF_OBJECT_OF_INTEREST + ")$)" + LETTER_NUMBER;

}
