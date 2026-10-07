package com.expensesmanagementapisdk.services;

import com.expensesmanagementapisdk.config.ExpensesManagementApiSdkConfig;
import com.expensesmanagementapisdk.config.RequestConfig;
import com.expensesmanagementapisdk.exceptions.ApiError;
import com.expensesmanagementapisdk.http.Environment;
import com.expensesmanagementapisdk.http.ExpensesManagementApiSdkResponse;
import com.expensesmanagementapisdk.http.HttpMethod;
import com.expensesmanagementapisdk.http.ModelConverter;
import com.expensesmanagementapisdk.http.util.RequestBuilder;
import com.expensesmanagementapisdk.models.CreateACategoryRequest;
import com.expensesmanagementapisdk.models.CreateAnExpenseRequest;
import com.expensesmanagementapisdk.models.ListAllExpensesParameters;
import com.expensesmanagementapisdk.models.UpdateAnExpenseRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ExpensesManagementApiSdkService Service
 */
public class ExpensesManagementApiSdkService extends BaseService {

  private RequestConfig listAllExpensesConfig = RequestConfig.builder()
    .environment(Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69)
    .build();
  private RequestConfig createAnExpenseConfig = RequestConfig.builder()
    .environment(Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69)
    .build();
  private RequestConfig getASingleExpenseConfig = RequestConfig.builder()
    .environment(Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69)
    .build();
  private RequestConfig updateAnExpenseConfig = RequestConfig.builder()
    .environment(Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69)
    .build();
  private RequestConfig deleteAnExpenseConfig = RequestConfig.builder()
    .environment(Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69)
    .build();
  private RequestConfig listAllCategoriesConfig = RequestConfig.builder()
    .environment(Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69)
    .build();
  private RequestConfig createACategoryConfig = RequestConfig.builder()
    .environment(Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69)
    .build();

  /**
   * Constructs a new instance of ExpensesManagementApiSdkService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public ExpensesManagementApiSdkService(
    @NonNull OkHttpClient httpClient,
    ExpensesManagementApiSdkConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code listAllExpenses}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpensesManagementApiSdkService setListAllExpensesConfig(RequestConfig config) {
    this.listAllExpensesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createAnExpense}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpensesManagementApiSdkService setCreateAnExpenseConfig(RequestConfig config) {
    this.createAnExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getASingleExpense}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpensesManagementApiSdkService setGetASingleExpenseConfig(RequestConfig config) {
    this.getASingleExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code updateAnExpense}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpensesManagementApiSdkService setUpdateAnExpenseConfig(RequestConfig config) {
    this.updateAnExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteAnExpense}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpensesManagementApiSdkService setDeleteAnExpenseConfig(RequestConfig config) {
    this.deleteAnExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listAllCategories}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpensesManagementApiSdkService setListAllCategoriesConfig(RequestConfig config) {
    this.listAllCategoriesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createACategory}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpensesManagementApiSdkService setCreateACategoryConfig(RequestConfig config) {
    this.createACategoryConfig = config;
    return this;
  }

  /**
   * Method listAllExpenses
   * GET /expenses
   *
   * @return response of {@code Object}
   */
  public Object listAllExpenses() throws ApiError {
    return this.listAllExpenses(ListAllExpensesParameters.builder().build());
  }

  /**
   * Method listAllExpenses
   * GET /expenses
   *
   * @param requestParameters {@link ListAllExpensesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listAllExpenses(@NonNull ListAllExpensesParameters requestParameters)
    throws ApiError {
    return this.listAllExpenses(requestParameters, null);
  }

  /**
   * Method listAllExpenses
   * GET /expenses
   *
   * @param requestParameters {@link ListAllExpensesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listAllExpenses(
    @NonNull ListAllExpensesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().listAllExpenses(requestParameters, requestConfig).getData();
  }

  /**
   * Method listAllExpenses
   * GET /expenses
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listAllExpensesAsync() throws ApiError {
    return this.listAllExpensesAsync(ListAllExpensesParameters.builder().build());
  }

  /**
   * Method listAllExpenses
   * GET /expenses
   *
   * @param requestParameters {@link ListAllExpensesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listAllExpensesAsync(
    @NonNull ListAllExpensesParameters requestParameters
  ) throws ApiError {
    return this.listAllExpensesAsync(requestParameters, null);
  }

  /**
   * Method listAllExpenses
   * GET /expenses
   *
   * @param requestParameters {@link ListAllExpensesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listAllExpensesAsync(
    @NonNull ListAllExpensesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .listAllExpensesAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListAllExpensesRequest(
    @NonNull ListAllExpensesParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69),
      "expenses"
    )
      .setOptionalQueryParameter("category", requestParameters.getCategory())
      .setOptionalQueryParameter("startDate", requestParameters.getStartDate())
      .setOptionalQueryParameter("endDate", requestParameters.getEndDate())
      .build();
  }

  /**
   * Method createAnExpense
   * POST /expenses
   *
   * @param createAnExpenseRequest {@link CreateAnExpenseRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createAnExpense(@NonNull CreateAnExpenseRequest createAnExpenseRequest)
    throws ApiError {
    return this.createAnExpense(createAnExpenseRequest, null);
  }

  /**
   * Method createAnExpense
   * POST /expenses
   *
   * @param createAnExpenseRequest {@link CreateAnExpenseRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createAnExpense(
    @NonNull CreateAnExpenseRequest createAnExpenseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createAnExpense(createAnExpenseRequest, requestConfig).getData();
  }

  /**
   * Method createAnExpense
   * POST /expenses
   *
   * @param createAnExpenseRequest {@link CreateAnExpenseRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createAnExpenseAsync(
    @NonNull CreateAnExpenseRequest createAnExpenseRequest
  ) throws ApiError {
    return this.createAnExpenseAsync(createAnExpenseRequest, null);
  }

  /**
   * Method createAnExpense
   * POST /expenses
   *
   * @param createAnExpenseRequest {@link CreateAnExpenseRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createAnExpenseAsync(
    @NonNull CreateAnExpenseRequest createAnExpenseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createAnExpenseAsync(createAnExpenseRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateAnExpenseRequest(
    @NonNull CreateAnExpenseRequest createAnExpenseRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69),
      "expenses"
    )
      .setJsonContent(createAnExpenseRequest)
      .build();
  }

  /**
   * Method getASingleExpense
   * GET /expenses/{id}
   *
   * @param id String
   * @return response of {@code Object}
   */
  public Object getASingleExpense(@NonNull String id) throws ApiError {
    return this.getASingleExpense(id, null);
  }

  /**
   * Method getASingleExpense
   * GET /expenses/{id}
   *
   * @param id String
   * @return response of {@code Object}
   */
  public Object getASingleExpense(@NonNull String id, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().getASingleExpense(id, requestConfig).getData();
  }

  /**
   * Method getASingleExpense
   * GET /expenses/{id}
   *
   * @param id String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getASingleExpenseAsync(@NonNull String id) throws ApiError {
    return this.getASingleExpenseAsync(id, null);
  }

  /**
   * Method getASingleExpense
   * GET /expenses/{id}
   *
   * @param id String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getASingleExpenseAsync(
    @NonNull String id,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getASingleExpenseAsync(id, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetASingleExpenseRequest(@NonNull String id, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69),
      "expenses/{id}"
    )
      .setPathParameter("id", id)
      .build();
  }

  /**
   * Method updateAnExpense
   * PUT /expenses/{id}
   *
   * @param id String
   * @param updateAnExpenseRequest {@link UpdateAnExpenseRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateAnExpense(
    @NonNull String id,
    @NonNull UpdateAnExpenseRequest updateAnExpenseRequest
  ) throws ApiError {
    return this.updateAnExpense(id, updateAnExpenseRequest, null);
  }

  /**
   * Method updateAnExpense
   * PUT /expenses/{id}
   *
   * @param id String
   * @param updateAnExpenseRequest {@link UpdateAnExpenseRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateAnExpense(
    @NonNull String id,
    @NonNull UpdateAnExpenseRequest updateAnExpenseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().updateAnExpense(id, updateAnExpenseRequest, requestConfig).getData();
  }

  /**
   * Method updateAnExpense
   * PUT /expenses/{id}
   *
   * @param id String
   * @param updateAnExpenseRequest {@link UpdateAnExpenseRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateAnExpenseAsync(
    @NonNull String id,
    @NonNull UpdateAnExpenseRequest updateAnExpenseRequest
  ) throws ApiError {
    return this.updateAnExpenseAsync(id, updateAnExpenseRequest, null);
  }

  /**
   * Method updateAnExpense
   * PUT /expenses/{id}
   *
   * @param id String
   * @param updateAnExpenseRequest {@link UpdateAnExpenseRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateAnExpenseAsync(
    @NonNull String id,
    @NonNull UpdateAnExpenseRequest updateAnExpenseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateAnExpenseAsync(id, updateAnExpenseRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildUpdateAnExpenseRequest(
    @NonNull String id,
    @NonNull UpdateAnExpenseRequest updateAnExpenseRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69),
      "expenses/{id}"
    )
      .setPathParameter("id", id)
      .setJsonContent(updateAnExpenseRequest)
      .build();
  }

  /**
   * Method deleteAnExpense
   * DELETE /expenses/{id}
   *
   * @param id String
   * @return response of {@code Object}
   */
  public Object deleteAnExpense(@NonNull String id) throws ApiError {
    return this.deleteAnExpense(id, null);
  }

  /**
   * Method deleteAnExpense
   * DELETE /expenses/{id}
   *
   * @param id String
   * @return response of {@code Object}
   */
  public Object deleteAnExpense(@NonNull String id, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().deleteAnExpense(id, requestConfig).getData();
  }

  /**
   * Method deleteAnExpense
   * DELETE /expenses/{id}
   *
   * @param id String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteAnExpenseAsync(@NonNull String id) throws ApiError {
    return this.deleteAnExpenseAsync(id, null);
  }

  /**
   * Method deleteAnExpense
   * DELETE /expenses/{id}
   *
   * @param id String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteAnExpenseAsync(
    @NonNull String id,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .deleteAnExpenseAsync(id, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildDeleteAnExpenseRequest(@NonNull String id, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69),
      "expenses/{id}"
    )
      .setPathParameter("id", id)
      .build();
  }

  /**
   * Method listAllCategories
   * GET /categories
   *
   * @return response of {@code Object}
   */
  public Object listAllCategories() throws ApiError {
    return this.listAllCategories(null);
  }

  /**
   * Method listAllCategories
   * GET /categories
   *
   * @return response of {@code Object}
   */
  public Object listAllCategories(RequestConfig requestConfig) throws ApiError {
    return withRawResponse().listAllCategories(requestConfig).getData();
  }

  /**
   * Method listAllCategories
   * GET /categories
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listAllCategoriesAsync() throws ApiError {
    return this.listAllCategoriesAsync(null);
  }

  /**
   * Method listAllCategories
   * GET /categories
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listAllCategoriesAsync(RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse()
      .listAllCategoriesAsync(requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListAllCategoriesRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69),
      "categories"
    ).build();
  }

  /**
   * Method createACategory
   * POST /categories
   *
   * @param createACategoryRequest {@link CreateACategoryRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createACategory(@NonNull CreateACategoryRequest createACategoryRequest)
    throws ApiError {
    return this.createACategory(createACategoryRequest, null);
  }

  /**
   * Method createACategory
   * POST /categories
   *
   * @param createACategoryRequest {@link CreateACategoryRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createACategory(
    @NonNull CreateACategoryRequest createACategoryRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createACategory(createACategoryRequest, requestConfig).getData();
  }

  /**
   * Method createACategory
   * POST /categories
   *
   * @param createACategoryRequest {@link CreateACategoryRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createACategoryAsync(
    @NonNull CreateACategoryRequest createACategoryRequest
  ) throws ApiError {
    return this.createACategoryAsync(createACategoryRequest, null);
  }

  /**
   * Method createACategory
   * POST /categories
   *
   * @param createACategoryRequest {@link CreateACategoryRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createACategoryAsync(
    @NonNull CreateACategoryRequest createACategoryRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createACategoryAsync(createACategoryRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateACategoryRequest(
    @NonNull CreateACategoryRequest createACategoryRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.E4_C9_717_B_4_C27_9_BDC_30_D2_C3213_F69),
      "categories"
    )
      .setJsonContent(createACategoryRequest)
      .build();
  }

  /**
   * Returns an accessor whose methods mirror this service but return the full HTTP response
   * (status code, headers, and raw body) wrapped alongside the parsed data.
   *
   * @return An accessor exposing raw-response variants of this service's methods
   */
  public WithRawResponse withRawResponse() {
    return new WithRawResponse();
  }

  /**
   * Per-call accessor exposing raw-response variants of {@link ExpensesManagementApiSdkService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * Method listAllExpenses
     * GET /expenses
     *
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> listAllExpenses() throws ApiError {
      return this.listAllExpenses(ListAllExpensesParameters.builder().build());
    }

    /**
     * Method listAllExpenses
     * GET /expenses
     *
     * @param requestParameters {@link ListAllExpensesParameters} Request Parameters Object
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> listAllExpenses(
      @NonNull ListAllExpensesParameters requestParameters
    ) throws ApiError {
      return this.listAllExpenses(requestParameters, null);
    }

    /**
     * Method listAllExpenses
     * GET /expenses
     *
     * @param requestParameters {@link ListAllExpensesParameters} Request Parameters Object
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> listAllExpenses(
      @NonNull ListAllExpensesParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listAllExpensesConfig, requestConfig);
      Request request = buildListAllExpensesRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpensesManagementApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method listAllExpenses
     * GET /expenses
     *
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> listAllExpensesAsync()
      throws ApiError {
      return this.listAllExpensesAsync(ListAllExpensesParameters.builder().build());
    }

    /**
     * Method listAllExpenses
     * GET /expenses
     *
     * @param requestParameters {@link ListAllExpensesParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> listAllExpensesAsync(
      @NonNull ListAllExpensesParameters requestParameters
    ) throws ApiError {
      return this.listAllExpensesAsync(requestParameters, null);
    }

    /**
     * Method listAllExpenses
     * GET /expenses
     *
     * @param requestParameters {@link ListAllExpensesParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> listAllExpensesAsync(
      @NonNull ListAllExpensesParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listAllExpensesConfig, requestConfig);
      Request request = buildListAllExpensesRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpensesManagementApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method createAnExpense
     * POST /expenses
     *
     * @param createAnExpenseRequest {@link CreateAnExpenseRequest} Request Body
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> createAnExpense(
      @NonNull CreateAnExpenseRequest createAnExpenseRequest
    ) throws ApiError {
      return this.createAnExpense(createAnExpenseRequest, null);
    }

    /**
     * Method createAnExpense
     * POST /expenses
     *
     * @param createAnExpenseRequest {@link CreateAnExpenseRequest} Request Body
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> createAnExpense(
      @NonNull CreateAnExpenseRequest createAnExpenseRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createAnExpenseConfig, requestConfig);
      Request request = buildCreateAnExpenseRequest(createAnExpenseRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpensesManagementApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method createAnExpense
     * POST /expenses
     *
     * @param createAnExpenseRequest {@link CreateAnExpenseRequest} Request Body
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> createAnExpenseAsync(
      @NonNull CreateAnExpenseRequest createAnExpenseRequest
    ) throws ApiError {
      return this.createAnExpenseAsync(createAnExpenseRequest, null);
    }

    /**
     * Method createAnExpense
     * POST /expenses
     *
     * @param createAnExpenseRequest {@link CreateAnExpenseRequest} Request Body
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> createAnExpenseAsync(
      @NonNull CreateAnExpenseRequest createAnExpenseRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createAnExpenseConfig, requestConfig);
      Request request = buildCreateAnExpenseRequest(createAnExpenseRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpensesManagementApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method getASingleExpense
     * GET /expenses/{id}
     *
     * @param id String
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> getASingleExpense(@NonNull String id)
      throws ApiError {
      return this.getASingleExpense(id, null);
    }

    /**
     * Method getASingleExpense
     * GET /expenses/{id}
     *
     * @param id String
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> getASingleExpense(
      @NonNull String id,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getASingleExpenseConfig, requestConfig);
      Request request = buildGetASingleExpenseRequest(id, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpensesManagementApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method getASingleExpense
     * GET /expenses/{id}
     *
     * @param id String
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> getASingleExpenseAsync(
      @NonNull String id
    ) throws ApiError {
      return this.getASingleExpenseAsync(id, null);
    }

    /**
     * Method getASingleExpense
     * GET /expenses/{id}
     *
     * @param id String
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> getASingleExpenseAsync(
      @NonNull String id,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getASingleExpenseConfig, requestConfig);
      Request request = buildGetASingleExpenseRequest(id, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpensesManagementApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method updateAnExpense
     * PUT /expenses/{id}
     *
     * @param id String
     * @param updateAnExpenseRequest {@link UpdateAnExpenseRequest} Request Body
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> updateAnExpense(
      @NonNull String id,
      @NonNull UpdateAnExpenseRequest updateAnExpenseRequest
    ) throws ApiError {
      return this.updateAnExpense(id, updateAnExpenseRequest, null);
    }

    /**
     * Method updateAnExpense
     * PUT /expenses/{id}
     *
     * @param id String
     * @param updateAnExpenseRequest {@link UpdateAnExpenseRequest} Request Body
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> updateAnExpense(
      @NonNull String id,
      @NonNull UpdateAnExpenseRequest updateAnExpenseRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateAnExpenseConfig, requestConfig);
      Request request = buildUpdateAnExpenseRequest(id, updateAnExpenseRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpensesManagementApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method updateAnExpense
     * PUT /expenses/{id}
     *
     * @param id String
     * @param updateAnExpenseRequest {@link UpdateAnExpenseRequest} Request Body
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> updateAnExpenseAsync(
      @NonNull String id,
      @NonNull UpdateAnExpenseRequest updateAnExpenseRequest
    ) throws ApiError {
      return this.updateAnExpenseAsync(id, updateAnExpenseRequest, null);
    }

    /**
     * Method updateAnExpense
     * PUT /expenses/{id}
     *
     * @param id String
     * @param updateAnExpenseRequest {@link UpdateAnExpenseRequest} Request Body
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> updateAnExpenseAsync(
      @NonNull String id,
      @NonNull UpdateAnExpenseRequest updateAnExpenseRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateAnExpenseConfig, requestConfig);
      Request request = buildUpdateAnExpenseRequest(id, updateAnExpenseRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpensesManagementApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method deleteAnExpense
     * DELETE /expenses/{id}
     *
     * @param id String
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> deleteAnExpense(@NonNull String id)
      throws ApiError {
      return this.deleteAnExpense(id, null);
    }

    /**
     * Method deleteAnExpense
     * DELETE /expenses/{id}
     *
     * @param id String
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> deleteAnExpense(
      @NonNull String id,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteAnExpenseConfig, requestConfig);
      Request request = buildDeleteAnExpenseRequest(id, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpensesManagementApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method deleteAnExpense
     * DELETE /expenses/{id}
     *
     * @param id String
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> deleteAnExpenseAsync(
      @NonNull String id
    ) throws ApiError {
      return this.deleteAnExpenseAsync(id, null);
    }

    /**
     * Method deleteAnExpense
     * DELETE /expenses/{id}
     *
     * @param id String
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> deleteAnExpenseAsync(
      @NonNull String id,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteAnExpenseConfig, requestConfig);
      Request request = buildDeleteAnExpenseRequest(id, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpensesManagementApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method listAllCategories
     * GET /categories
     *
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> listAllCategories() throws ApiError {
      return this.listAllCategories(null);
    }

    /**
     * Method listAllCategories
     * GET /categories
     *
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> listAllCategories(RequestConfig requestConfig)
      throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listAllCategoriesConfig, requestConfig);
      Request request = buildListAllCategoriesRequest(resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpensesManagementApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method listAllCategories
     * GET /categories
     *
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> listAllCategoriesAsync()
      throws ApiError {
      return this.listAllCategoriesAsync(null);
    }

    /**
     * Method listAllCategories
     * GET /categories
     *
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> listAllCategoriesAsync(
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listAllCategoriesConfig, requestConfig);
      Request request = buildListAllCategoriesRequest(resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpensesManagementApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method createACategory
     * POST /categories
     *
     * @param createACategoryRequest {@link CreateACategoryRequest} Request Body
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> createACategory(
      @NonNull CreateACategoryRequest createACategoryRequest
    ) throws ApiError {
      return this.createACategory(createACategoryRequest, null);
    }

    /**
     * Method createACategory
     * POST /categories
     *
     * @param createACategoryRequest {@link CreateACategoryRequest} Request Body
     * @return response of {@code ExpensesManagementApiSdkResponse<Object>}
     */
    public ExpensesManagementApiSdkResponse<Object> createACategory(
      @NonNull CreateACategoryRequest createACategoryRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createACategoryConfig, requestConfig);
      Request request = buildCreateACategoryRequest(createACategoryRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpensesManagementApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method createACategory
     * POST /categories
     *
     * @param createACategoryRequest {@link CreateACategoryRequest} Request Body
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> createACategoryAsync(
      @NonNull CreateACategoryRequest createACategoryRequest
    ) throws ApiError {
      return this.createACategoryAsync(createACategoryRequest, null);
    }

    /**
     * Method createACategory
     * POST /categories
     *
     * @param createACategoryRequest {@link CreateACategoryRequest} Request Body
     * @return response of {@code CompletableFuture<ExpensesManagementApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpensesManagementApiSdkResponse<Object>> createACategoryAsync(
      @NonNull CreateACategoryRequest createACategoryRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createACategoryConfig, requestConfig);
      Request request = buildCreateACategoryRequest(createACategoryRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpensesManagementApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }
  }
}
