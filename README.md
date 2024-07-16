# EvaluacionKubernetes

## Compilación backend
El backend se encuentra desarrollado como una aplicación de Jakarta. Para publicar el proyecto se debe ingresar a la carpeta `back`, dentro de esta ejecutamos el comando:

```bash
docker build -t villaltajose/backt .
```

Posterior a ello, para probar nuestra aplicación, levantamos la misma con el archivo `docker-compose.yml`.
```bash
docker compose up -d
```

Y nuestro servicio debe estar disponible mediante la URL: `http://localhost:8080/demo63/rs/universidades/list`.

## Kubernetes
Ejecutamos los siguientes comandos:
```bash
kubectl apply -f ./namespace.yml
kubectl apply -f ./microservice-deployment.yaml
kubectl apply -f ./microservice-service.yaml
kubectl apply -f ./database-deployment.yaml
kubectl apply -f ./database-service.yaml
```

Posteriormente levantamos nuestro tunnel en minikube con el comando: `minikube tunnel`.

Nuestro servicio debería estar expuesto en la URL: `http://localhost:8080/demo63/rs/universidades/list`