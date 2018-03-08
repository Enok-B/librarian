package com.enokb.librarian.controller;

import com.enokb.librarian.domain.AdminDomain;
import com.enokb.librarian.service.IAdminService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AdminController.class, secure = false)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAdminService iAdminService;

    @Before
    public void before() {
        given(this.iAdminService.selectById(7)).willReturn(initAdmin());
    }

    @Test
    public void queryAdminRightId() throws Exception {
        mockMvc.perform(get("/admin/user?id=7").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.amdimId").value("7"))
                .andExpect(jsonPath("$.data.name").value("Enok"))
                .andExpect(jsonPath("$.data.password").value("password"))
                .andExpect(jsonPath("$.data.permission").value("true"))
                .andExpect(jsonPath("$.data.area").value("1"));
    }

    @Test
    public void queryAdminNullId() throws Exception {
        mockMvc.perform(get("/admin/user?id=").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isBadRequest()).andExpect(jsonPath("$.data").isNotEmpty());
    }

    private AdminDomain initAdmin() {
        AdminDomain admin = new AdminDomain();
        admin.setAmdimId(7);
        admin.setName("Enok");
        admin.setPassword("password");
        admin.setPermission(true);
        admin.setArea(1);
        return admin;
    }

}
