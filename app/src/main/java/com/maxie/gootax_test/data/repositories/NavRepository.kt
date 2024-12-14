package com.maxie.gootax_test.data.repositories

import com.maxie.gootax_test.entities.NavItem

class NavRepository {

    fun fetchNavData(): List<NavItem>{
        return listOf(
            NavItem("Оплата", "Карта *4567"),
            NavItem("Мои адреса"),
            NavItem("Мои заказы"),
            NavItem("Избранное"),
            NavItem("Новости"),
            NavItem("Купоны"),
            NavItem("О нас"),
            NavItem("Пригласить друзей"),
            NavItem("Настройки"),
        )
    }

}