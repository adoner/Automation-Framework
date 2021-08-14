Feature: Test RedBox APIs

  @task1
  Scenario: Get all movies
    When User runs get request
    Then Navigate to movie detail page and validate title name

  @task2
  Scenario: Movie search
    When Navigate to search page
    Then Search movie name and validate title name on movie detail page

  @task3
  Scenario: Search comparison
    When Go to search page
    Then Search movie name and validate search text on search result page

  @task3-2
  Scenario: Auto complete comparison
    When Go to search page
    Then Compare auto complete result vs results on the search results page