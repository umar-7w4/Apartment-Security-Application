package com.cg.asm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.asm.entity.GuardsTraning;
import com.cg.asm.entity.Security;
import com.cg.asm.entity.User;
import com.cg.asm.exception.RecordNotFoundException;
import com.cg.asm.repository.UserDao;

@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public User add(User user) throws RecordNotFoundException {
		userDao.saveAndFlush(user);
		return user;
	}

	@Override
	public User update(User user) throws RecordNotFoundException {
		User bean = null;
		try {
			bean = userDao.findById(user.getUserId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("User details not found!");
		}
		userDao.saveAndFlush(user);
		return bean;
	}

	@Override
	public User delete(User user) throws RecordNotFoundException {
		User bean = null;
		try {
			bean = userDao.findById(user.getUserId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("User details not found!");
		}
		userDao.deleteById(user.getUserId());
		return bean;
	}

	@Override
	public List<User> findByLoginId(String loginId) throws RecordNotFoundException {
		List<User> users = new ArrayList<>();
		try {
			for(User i :userDao.findAll()) {
				if(i.getLoginId().equals(loginId)) {
					users.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFoundException("User details not found!");
		}
		return users;
	}

	@Override
	public User findById(int userId) throws RecordNotFoundException {
		User bean = null;
		try {
			bean = userDao.findById(userId).get();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("User details not found!");
		}
		userDao.deleteById(userId);
		return bean;
	}

	@Override
	public User search(User user) throws RecordNotFoundException {
		User bean = null;
		try {
			bean = userDao.findById(user.getUserId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("User details not found!");
		}
		userDao.deleteById(user.getUserId());
		return bean;
	}

	@Override
	public String authenticate(User user) throws RecordNotFoundException {
		User bean = null;
		try {
			bean = userDao.findById(user.getUserId()).get();
			for(User i : userDao.findAll()) {
				if(bean.getLoginId().equals(i.getLoginId())) {
					if(bean.getPassword().equals(i.getPassword())) {
						return "Authentication Successfull";
					}
					return "User details not found! Invalid details";
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFoundException("User details not found! Invalid details");
		}
		return null;
	}

	@Override
	public boolean changePassword(int userId, String oldPassword, String newPassword) throws RecordNotFoundException {
		User user = null;
		try {
			user = userDao.findById(userId).get();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("User details not found");
		}
		user.setPassword(newPassword);
		return true;
	}

	@Override
	public User registerUser(User user) throws RecordNotFoundException {
		userDao.saveAndFlush(user);
		return user;
	}

	@Override
	public List<User> forgetPassword(String loginId) throws RecordNotFoundException {
		return findByLoginId(loginId);
	}

}
