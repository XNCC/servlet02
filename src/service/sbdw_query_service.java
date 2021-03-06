package service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dao.sbdw_query;
import dao.table_select_dao;
import entity.bftjdm_en;
import entity.jflydm_en;
import entity.jtfsdm_en;
import entity.ktfxdm_en;
import entity.ktjbdm_en;
import entity.ktlbdm_en;
import entity.ktsxdm_en;
import entity.sbdwdm_en;
import entity.user;
import entity.user_insert;
import entity.xkfldm_en;
import utils.jdbcTem_util;

/**
 * Servlet implementation class table_insert
 */
//@WebServlet("/table_select")
public class sbdw_query_service extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sbdwdm = request.getParameter("sbdwdm1"); /// ʱ��
	    System.out.println("sbdwdm++++"+sbdwdm);
		if (sbdwdm != null ) {
			//request.getSession().setAttribute("start_time", start_time);
			//request.getSession().setAttribute("end_time", end_time);
		}
		sbdw_query sbdw_query = new sbdw_query();
		List<user_insert> users = sbdw_query.select(sbdwdm);
		System.out.println("users++++"+users);
		if (users != null) {
			request.setAttribute("data", users);
			request.getRequestDispatcher("/admin_table_select.jsp").forward(request, response);
		}
		
		
	}

}
