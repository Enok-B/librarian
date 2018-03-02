package com.enokb.librarian.controller;

import com.alibaba.fastjson.JSON;
import com.enokb.librarian.domain.AdminDomain;
import com.enokb.librarian.dto.IdDto;
import com.enokb.librarian.mapper.AdminMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

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
        IdDto id = new IdDto();
        id.setId(7);
        mockMvc.perform(get("/admin").accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(id))).andExpect(status().isOk());
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
