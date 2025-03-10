package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {
    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> findAllMenus() {
        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenus(sqlSession);

        sqlSession.close();

        return menuList;
    }

    public MenuDTO findMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        MenuDTO menu = menuDAO.selectMenuByMenuCode(sqlSession, menuCode);

        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);

        /* 설명. 성공 실패에 따라 트랜잭션 처리(commit/rollback) */
        if(result == 1) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result == 1? true: false;
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.updateMenu(sqlSession, menu);

        /* 설명. 성공 실패에 따라 트랜잭션 처리(commit/rollback) */
        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result == 1? true: false;
    }

    public boolean removeMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.deleteMenu(sqlSession, menuCode);

        /* 설명. 성공 실패에 따라 트랜잭션 처리(commit/rollback) */
        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result == 1? true: false;
    }
}