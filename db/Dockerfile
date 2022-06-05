FROM mysql/mysql-server:8.0.29

MAINTAINER lengleng(wangiegie@gmail.com)

ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY ./trifle.sql /docker-entrypoint-initdb.d

COPY ./trifle_codegen.sql /docker-entrypoint-initdb.d

COPY ./trifle_config.sql /docker-entrypoint-initdb.d

COPY ./trifle_job.sql /docker-entrypoint-initdb.d
