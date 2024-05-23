package com.lalkalol.notesbackend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer

@Configuration
@EnableRedisHttpSession
class Config : AbstractHttpSessionApplicationInitializer() {
    @Bean
    fun connectionFactory(): LettuceConnectionFactory {
        return LettuceConnectionFactory()
    }
}