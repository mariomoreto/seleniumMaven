Feature: Uploaded File

  This feature is for upload test, when a user upload file in the system.

  @fileUpload
  Scenario: FileUpload sucess
    Given I visit page
    And I click in FileUpload
    When I select file
    And I press in upload
    Then screen upload sucess appear
