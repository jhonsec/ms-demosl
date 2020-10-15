FROM java:8
LABEL mantainer="Everis Peru" \
      build="docker build --build-arg nombreArtefacto=artefacto -t microservicio:1.0 -f Dockerfile ." \
      run="docker run -dit --restart on-failure:5 --name microservicio -p 8080:8080 microservicio:1.0"
ARG nombreArtefacto=artefacto
ENV nombreArtefacto ${nombreArtefacto}
COPY ${nombreArtefacto} /opt/
WORKDIR /opt/
CMD ["sh", "-c", "java -jar ${nombreArtefacto}"]