#!/bin/bash
DOCKER_LINK="https://download.docker.com/linux/ubuntu"
DOCKER_IMAGE_NAME="springboot-opencsv-export-demo"
DOCKER_IMAGE_NAME_TAGGED="springboot-opencsv-docker"

install_docker(){
    sudo apt update
    sudo apt install ca-certificates curl gnupg lsb-release -y
    sudo mkdir -p /etc/apt/keyrings
    curl -fsSL $DOCKER_LINK/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
    echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] $DOCKER_LINK \
        $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
    sudo apt update
    sudo apt install docker-ce docker-ce-cli containerd.io docker-compose-plugin -y
    sudo docker run hello-world
    sudo groupadd docker
    sudo usermod -aG docker $USER
    newgrp docker
    docker run hello-world
    echo -e "Starting docker's services"
    sudo systemctl enable docker.service
    sudo systemctl enable containerd.service
}

echo -e "STEP 1: Verify your Docker installation"
install_docker

echo -e "STEP 2: Build Springboot Project"
mvn clean install -U -DskipTests=true

echoe -e "STEP 3: Building an Springboot Docker image"
docker build -t $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_NAME_TAGGED .

echo -e "STEP 4: Run this image into a Docker Container"
docker run -p 8080:8080 $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_NAME_TAGGED .