package com.example;

import com.expensesmanagementapisdk.ExpensesManagementApiSdk;
import com.expensesmanagementapisdk.exceptions.ApiError;
import com.expensesmanagementapisdk.models.ListAllExpensesParameters;

public class Main {

  public static void main(String[] args) {
    ExpensesManagementApiSdk expensesManagementApiSdk = new ExpensesManagementApiSdk();

    ListAllExpensesParameters requestParameters = ListAllExpensesParameters.builder()
      .category("category")
      .startDate("startDate")
      .endDate("endDate")
      .build();

    try {
      Object response = expensesManagementApiSdk.expensesManagementApiSdk.listAllExpenses(
        requestParameters
      );

      System.out.println(response);
    } catch (ApiError e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}
