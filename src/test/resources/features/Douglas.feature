@Douglas
Feature: Douglas

  @Interview
  Scenario Outline: Interview
    Given user is on the Home Page
    Given handle the cookie consent
    When click on "PARFUM" tab
    Then should see the Products Page
    When select on "<producart>" Produktart on Products Page
    When select on "<highlights>" Highlights on Products Page
    When select on "<marke>" Marke on Products Page
    When select on "<geschenkfur>" Geschenk für on Products Page
    When select on "<furWen>" Für Wen on Products Page
    Examples:
      | highlights | marke          | producart     | geschenkfur | furWen   |
      | Sale       | bruno banani   | Eau de Parfum |             | Weiblich |
      | NEU        |                | Eau de Parfum |             | Unisex   |
      | Limitiert  | Acqua di Parma | Duftset       | Weihnachten | Unisex   |