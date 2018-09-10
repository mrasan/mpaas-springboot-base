#!/bin/bash
v_version=$1
mvn package -Dmaven.test.skip=true
docker build -t mpaas-infrastructure-service:v$v_version -f Dockerfile .
docker tag mpaas-infrastructure-service:v$v_version k8s-harbor.smec-cn.com/definesys/mpaas-infrastructure-service:v$v_version
docker push k8s-harbor.smec-cn.com/definesys/mpaas-infrastructure-service:v$v_version