package ru.topjava.estimate.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import ru.topjava.estimate.security.jwt.JwtAuthenticationException;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@Sql(scripts = "classpath:/data.sql")
class AuthenticationControllerTest {

    private static final CharacterEncodingFilter CHARACTER_ENCODING_FILTER = new CharacterEncodingFilter();
    private final static String URL = "/login";
    private final static String RIGHT_BODY = "{\"email\":\"user@yandex.ru\", \"password\":\"password\"}";
    private final static String WRONG_BODY = "{\"email\":\"wrong@user.ru\", \"password\":\"password\"}";

    static {
        CHARACTER_ENCODING_FILTER.setEncoding("UTF-8");
        CHARACTER_ENCODING_FILTER.setForceEncoding(true);
    }

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @PostConstruct
    private void postConstruct() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilter(CHARACTER_ENCODING_FILTER)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void userGetTokenAndAuthentication() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(RIGHT_BODY))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        String token = response.substring(response.length() - 174, response.length() - 2);

        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants")
                .header("Authorization", "Bearer_" + token))
                .andExpect(status().isOk());
    }

    @Test
    public void nonExistentUserCannotGetToken() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(WRONG_BODY))
                .andExpect(status().isForbidden()).andReturn();
    }

    @Test
    public void userUseInvalidToken() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(RIGHT_BODY))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        String token = response.substring(response.length() - 169, response.length() - 2) + "wrong";

        assertThrows(JwtAuthenticationException.class,
                () -> mockMvc.perform(MockMvcRequestBuilders.get("/restaurants")
                .header("Authorization", "Bearer_" + token)));
    }

    @Test
    public void haveNotPermissionAdminRights() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/prices")
                .content(RIGHT_BODY))
                .andExpect(status().isForbidden()).andReturn();
    }
}