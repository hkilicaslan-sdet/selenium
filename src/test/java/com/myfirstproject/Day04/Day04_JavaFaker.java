package com.myfirstproject.Day04;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day04_JavaFaker {
/*  Where do you get your test data?
        TEST DATA ; credentials, url, test environment
    1) the best answer is Test Lead
    2) BA; business analyst (who writes Acceptance Criteria)
    3) Team Lead / Tech Lead
    4) Manual Testers may also ==> knows the functionality well
    5) For changing mock data we use Faker
    6) for Api testing Swagger is used
Ahmet Bayram
    TEST DATA : credentials, url, test environment,..
* Where do you get your test data?
* - Test Lead can provide
* - Business Analyst - BA (who wrote the AC-acceptance criteria)
* - Manual Testers - knows the functionality well.
* - Team Lead / Tech Lead
* - If you need a changing mock data then we can use faker
* - for api , i use swagger                 * */


    @Test
    public void test1(){
 // create faker object
        Faker faker =new Faker ();
// use faker obj to generate mock
    // name
        String firstName = faker.name().firstName();
        System.out.println(firstName);
    // lastname
        String lastName= faker.name().lastName();
        System.out.println(lastName);
    // username
        String userName=faker.name().username();
        System.out.println(userName);
    // title
        String title =faker.name().title();
        System.out.println(title);
    // city
        String city =faker.address().city();
        System.out.println(city);
    // state
        String state=faker.address().state();
        System.out.println(state);
    // full mock-up adress
        String fullAdress=faker.address().fullAddress();
        System.out.println(fullAdress);
    // cell-phone
        String cellNum=faker.phoneNumber().cellPhone();
        System.out.println(cellNum);
    // email
        String email =faker.internet().emailAddress();
        System.out.println(email);
    // zip-code
        String zipCode=faker.address().zipCode();
        String zipPre_defined=faker.number().digits(5); // ==> how many digits u need

    }
}
