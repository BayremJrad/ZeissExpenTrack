package com.expensesmanagementapisdk.http;

import lombok.Getter;

/**
 * Predefined environment configurations for the SDK.
 * Each environment represents a different base URL (e.g., production, staging, development).
 */
@Getter
public enum Environment {
  DEFAULT("https://3053e4c9-717b-4c27-9bdc-30d2c3213f69.mock.pstmn.io"),
  E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69(
    "https://3053e4c9-717b-4c27-9bdc-30d2c3213f69.mock.pstmn.io"
  );

  private final String url;

  Environment(String url) {
    this.url = url;
  }
}
