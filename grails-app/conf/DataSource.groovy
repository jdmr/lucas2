dataSource {
    pooled = true
    driverClassName = "org.postgresql.Driver"
    username = "tomcat"
    password = "tomcat00"
    dbCreate = "update"
    url = 'jdbc:postgresql:lucas'
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
    show_sql=true
}
// environment specific settings
environments {
    development {
        dataSource {
        }
    }
    test {
        dataSource {
        }
    }
    production {
        dataSource {
            dbCreate = 'update'
            url = 'jdbc:postresql://rigel.um.edu.mx/lucas'
            show_sql=false
        }
    }
}
