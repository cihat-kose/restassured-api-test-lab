package stepDefinitions;

import io.restassured.response.Response;
import io.cucumber.java.en.*;
import pages.APIPage;

import static org.hamcrest.Matchers.equalTo;

public class PetstoreAPISteps {

    private APIPage apiPage = new APIPage();
    private Response response;

    @Given("I have the pet ID {int}")
    public void i_have_the_pet_ID(int petId) {
        response = apiPage.getPetById(petId);
    }

    @Given("I have a new pet with ID {int} and name {string}")
    public void i_have_a_new_pet_with_ID_and_name(int id, String name) {
        response = apiPage.addNewPet(id, name, "available");
    }

    @Given("I have an existing pet with ID {int} and status {string}")
    public void i_have_an_existing_pet_with_ID_and_status(int id, String status) {
        response = apiPage.updatePetStatus(id, status);
    }

    @When("I update the pet status to {string}")
    public void i_update_the_pet_status_to(String newStatus) {
        response = apiPage.updatePetStatus(100, newStatus);
    }

    @When("I delete the pet by ID {int}")
    public void i_delete_the_pet_by_ID(int petId) {
        response = apiPage.deletePetById(petId);
    }

    @Then("I should receive a {int} status code")
    public void i_should_receive_a_status_code(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Then("the response should contain the pet ID {int}")
    public void the_response_should_contain_the_pet_ID(int petId) {
        response.then().body("id", equalTo(petId));
    }

    @Then("the response should contain the name {string}")
    public void the_response_should_contain_the_name(String name) {
        response.then().body("name", equalTo(name));
    }

    @Then("the response should contain the status {string}")
    public void the_response_should_contain_the_status(String status) {
        response.then().body("status", equalTo(status));
    }

    @Then("the response should contain the message {string}")
    public void the_response_should_contain_the_message(String message) {
        response.then().body("message", equalTo(message));
    }
}
