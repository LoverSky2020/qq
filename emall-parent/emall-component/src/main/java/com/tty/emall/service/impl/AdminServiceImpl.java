package com.tty.emall.service.impl;

import com.tty.emall.entity.Admin;
import com.tty.emall.entity.AdminExample;
import com.tty.emall.mapper.AdminMapper;
import com.tty.emall.service.api.AdminService;
import com.tty.emall.utils.Md5Utils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-02-11:47
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {

        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        String md5PswStr = Md5Utils.md5(password);
        criteria.andPasswordEqualTo(md5PswStr);

        List<Admin> admins = adminMapper.selectByExample(adminExample);

        if (StringUtils.isEmpty(admins) || admins.size() <= 0) {
            return null;
        }

        Admin admin = admins.get(0);

        return admin;
    }

    @Override
    public List<Admin> getAdminByList() {
        List<Admin> admins = adminMapper.selectByExample(null);
        return admins;
    }

    @Override
    public void remove(Integer id) {
        adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveAdmin(Admin admin) {
        String md5PswStr = Md5Utils.md5(admin.getPassword());
        admin.setPassword(md5PswStr);
        adminMapper.insert(admin);
    }

    @Override
    public boolean checkUsername(Admin admin) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameEqualTo(admin.getUsername());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins.size() > 0) {
            return false;
        }
        return true;
    }

    @Override
    public Admin getAdminById(Integer id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        return admin;
    }

    @Override
    public void reset(Admin admin) {
        admin.setPassword(Md5Utils.md5(admin.getPassword()));
        adminMapper.updateByPrimaryKeySelective(admin);
    }
}
