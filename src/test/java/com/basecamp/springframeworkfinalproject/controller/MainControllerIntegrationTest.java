package com.basecamp.springframeworkfinalproject.controller;


import com.basecamp.springframeworkfinalproject.SpringFrameworkFinalProjectApplication;
import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.repository.PersonRepository;
import com.basecamp.springframeworkfinalproject.service.PersonService;
import com.basecamp.springframeworkfinalproject.util.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = SpringFrameworkFinalProjectApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MainControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Test
    public void givenURL_whenSaveMchineResult_ThanVerifyResponse() throws Exception {

        ResultActions result = mockMvc.perform((post("/save/{kind}/{state}/{personName}"
                , "vehicle" , "expensive" , "Luke Skywalker")));

                result.andDo(print()).andExpect(status().isCreated())
                        .andExpect(jsonPath("$.id").exists())
                        .andExpect(jsonPath("$.response").exists());
    }

//    @Test
//    public void givenURL_whenGetUUID_ThanVerifyResponse() throws Exception {
//        //prepare
//        TestData.saveToDB(personRepository);
//        List<Person> personList = (List<Person>) personRepository.findAll();
//        Person person = personList.get(0);
//        UUID uuid = person.getUuid();
//                ResultActions result = mockMvc.perform((get("/result/" + uuid)));
//
//        result.andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.uuid").value(uuid))
//                .andExpect(jsonPath("$.result").exists());
//    }

    @Test
    public void givenURL_whenFindPaginated_ThanVerifyResponse() throws Exception {
        Person person = TestData.saveToDB(personRepository);

        ResultActions result = mockMvc.perform((get("/persons" ).param("page" , "0")
                .param("size" , "5")));

        result.andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void giveInvalidKindOfMachineURL_whenSaveMachineResult_ThanVerifyResponse() throws Exception {

        ResultActions result = mockMvc.perform((post("/save/{kind}/{state}/{personName}"
                , "vehiclee" , "expensive" , "Luke Skywalker")));

        result.andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errCode").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.errMessage").exists());
    }

    @Test
    public void giveInvalidStateURL_whenSaveMachineResult_ThanVerifyResponse() throws Exception {

        ResultActions result = mockMvc.perform((post("/save/{kind}/{state}/{personName}"
                , "vehicle" , "expensivee" , "Luke Skywalker")));

        result.andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errCode").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.errMessage").exists());
    }

    @Test
    public void giveInvalidPersonName_whenSaveMachineResult_ThanVerifyResponse() throws Exception {

        ResultActions result = mockMvc.perform((post("/save/{kind}/{state}/{personName}"
                , "vehicle" , "expensive" , "Luke Skywalkerrrrrrr")));

        result.andDo(print()).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errCode").value("NOT_FOUND"))
                .andExpect(jsonPath("$.errMessage").exists());
    }
}
