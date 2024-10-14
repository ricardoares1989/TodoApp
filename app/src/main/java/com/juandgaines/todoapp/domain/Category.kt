package com.juandgaines.todoapp.domain

enum class Category {
    FINANCE,
    FREELANCE,
    SHOPPING,
    WEDDING;

    companion object {
        fun fromOrdinal(ordinal: Int?): Category? {
            return ordinal?.let { entries.getOrNull(it) }
        }
    }
}