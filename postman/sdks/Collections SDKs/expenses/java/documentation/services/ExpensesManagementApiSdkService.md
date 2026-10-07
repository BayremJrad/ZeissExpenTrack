# ExpensesManagementApiSdkService

A list of all methods in the `ExpensesManagementApiSdkService` service. Click on the method name to view detailed information about that method.

| Methods                                 | Description |
| :-------------------------------------- | :---------- |
| [listAllExpenses](#listallexpenses)     |             |
| [createAnExpense](#createanexpense)     |             |
| [getASingleExpense](#getasingleexpense) |             |
| [updateAnExpense](#updateanexpense)     |             |
| [deleteAnExpense](#deleteanexpense)     |             |
| [listAllCategories](#listallcategories) |             |
| [createACategory](#createacategory)     |             |

## listAllExpenses

- HTTP Method: `GET`
- Endpoint: `/expenses`

**Parameters**

| Name              | Type                                                                | Required | Description               |
| :---------------- | :------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListAllExpensesParameters](../models/ListAllExpensesParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensesmanagementapisdk.ExpensesManagementApiSdk;
import com.expensesmanagementapisdk.models.ListAllExpensesParameters;

public class Main {

  public static void main(String[] args) {
    ExpensesManagementApiSdk expensesManagementApiSdk = new ExpensesManagementApiSdk();

    ListAllExpensesParameters requestParameters = ListAllExpensesParameters.builder()
      .category("category")
      .startDate("startDate")
      .endDate("endDate")
      .build();

    Object response = expensesManagementApiSdk.expensesManagementApiSdk.listAllExpenses(
      requestParameters
    );

    System.out.println(response);
  }
}

```

## createAnExpense

- HTTP Method: `POST`
- Endpoint: `/expenses`

**Parameters**

| Name                   | Type                                                          | Required | Description  |
| :--------------------- | :------------------------------------------------------------ | :------- | :----------- |
| createAnExpenseRequest | [CreateAnExpenseRequest](../models/CreateAnExpenseRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensesmanagementapisdk.ExpensesManagementApiSdk;
import com.expensesmanagementapisdk.models.CreateAnExpenseRequest;

public class Main {

  public static void main(String[] args) {
    ExpensesManagementApiSdk expensesManagementApiSdk = new ExpensesManagementApiSdk();

    CreateAnExpenseRequest createAnExpenseRequest = CreateAnExpenseRequest.builder()
      .title("Bayrem meeting")
      .amount(45.5D)
      .category("Food")
      .date("2026-10-07")
      .notes("Quarterly team lunch")
      .build();

    Object response = expensesManagementApiSdk.expensesManagementApiSdk.createAnExpense(
      createAnExpenseRequest
    );

    System.out.println(response);
  }
}

```

## getASingleExpense

- HTTP Method: `GET`
- Endpoint: `/expenses/{id}`

**Parameters**

| Name | Type   | Required | Description |
| :--- | :----- | :------- | :---------- |
| id   | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensesmanagementapisdk.ExpensesManagementApiSdk;

public class Main {

  public static void main(String[] args) {
    ExpensesManagementApiSdk expensesManagementApiSdk = new ExpensesManagementApiSdk();

    Object response = expensesManagementApiSdk.expensesManagementApiSdk.getASingleExpense("id");

    System.out.println(response);
  }
}

```

## updateAnExpense

- HTTP Method: `PUT`
- Endpoint: `/expenses/{id}`

**Parameters**

| Name                   | Type                                                          | Required | Description  |
| :--------------------- | :------------------------------------------------------------ | :------- | :----------- |
| id                     | String                                                        | ✅       |              |
| updateAnExpenseRequest | [UpdateAnExpenseRequest](../models/UpdateAnExpenseRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensesmanagementapisdk.ExpensesManagementApiSdk;
import com.expensesmanagementapisdk.models.UpdateAnExpenseRequest;

public class Main {

  public static void main(String[] args) {
    ExpensesManagementApiSdk expensesManagementApiSdk = new ExpensesManagementApiSdk();

    UpdateAnExpenseRequest updateAnExpenseRequest = UpdateAnExpenseRequest.builder()
      .title("Team lunch updated")
      .amount(50D)
      .category("Food")
      .date("2026-10-07")
      .notes("Updated amount")
      .build();

    Object response = expensesManagementApiSdk.expensesManagementApiSdk.updateAnExpense(
      "id",
      updateAnExpenseRequest
    );

    System.out.println(response);
  }
}

```

## deleteAnExpense

- HTTP Method: `DELETE`
- Endpoint: `/expenses/{id}`

**Parameters**

| Name | Type   | Required | Description |
| :--- | :----- | :------- | :---------- |
| id   | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensesmanagementapisdk.ExpensesManagementApiSdk;

public class Main {

  public static void main(String[] args) {
    ExpensesManagementApiSdk expensesManagementApiSdk = new ExpensesManagementApiSdk();

    Object response = expensesManagementApiSdk.expensesManagementApiSdk.deleteAnExpense("id");

    System.out.println(response);
  }
}

```

## listAllCategories

- HTTP Method: `GET`
- Endpoint: `/categories`

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensesmanagementapisdk.ExpensesManagementApiSdk;

public class Main {

  public static void main(String[] args) {
    ExpensesManagementApiSdk expensesManagementApiSdk = new ExpensesManagementApiSdk();

    Object response = expensesManagementApiSdk.expensesManagementApiSdk.listAllCategories();

    System.out.println(response);
  }
}

```

## createACategory

- HTTP Method: `POST`
- Endpoint: `/categories`

**Parameters**

| Name                   | Type                                                          | Required | Description  |
| :--------------------- | :------------------------------------------------------------ | :------- | :----------- |
| createACategoryRequest | [CreateACategoryRequest](../models/CreateACategoryRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensesmanagementapisdk.ExpensesManagementApiSdk;
import com.expensesmanagementapisdk.models.CreateACategoryRequest;

public class Main {

  public static void main(String[] args) {
    ExpensesManagementApiSdk expensesManagementApiSdk = new ExpensesManagementApiSdk();

    CreateACategoryRequest createACategoryRequest = CreateACategoryRequest.builder()
      .name("Travel")
      .description("Business travel expenses")
      .build();

    Object response = expensesManagementApiSdk.expensesManagementApiSdk.createACategory(
      createACategoryRequest
    );

    System.out.println(response);
  }
}

```
