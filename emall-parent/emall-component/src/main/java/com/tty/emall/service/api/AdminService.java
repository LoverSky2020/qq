package com.tty.emall.service.api;

import com.tty.emall.entity.Admin;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-02-11:47
 */
public interface AdminService {

    Admin login(String username, String password);

    List<Admin> getAdminByList();

    void remove(Integer id);

    void saveAdmin(Admin admin);

    boolean checkUsername(Admin admin);

    Admin getAdminById(Integer id);

    void reset(Admin admin);
}
