## Docker Setup

Run the following command to start the Docker containers required for your application:

```bash
docker-compose up -d

## Auto-Instrumented Configuration 
 java -javaagent:opentelemetry-javaagent.jar \
     -Dotel.traces.exporter=otlp \
     -Dotel.metrics.exporter=prometheus \
     -Dotel.exporter.prometheus.host=0.0.0.0 \
     -Dotel.exporter.prometheus.port=9464 \
     -Dotel.exporter.prometheus.endpoint=/metrics \
     -Dotel.logs.exporter=logging \
     -Dotel.exporter.otlp.endpoint=http://0.0.0.0:4317 \
     -Dotel.exporter.otlp.protocol=grpc \
     -jar bankapp-0.0.1-SNAPSHOT.jar --server.port=8080

## Manual-Instrumented Configuration
java -javaagent:opentelemetry-javaagent.jar \
     -Dotel.traces.exporter=otlp \
     -Dotel.metrics.exporter=prometheus \
     -Dotel.exporter.prometheus.host=0.0.0.0 \
     -Dotel.exporter.prometheus.port=9465 \
     -Dotel.exporter.prometheus.endpoint=/metrics \
     -Dotel.logs.exporter=logging \
     -Dotel.exporter.otlp.endpoint=http://0.0.0.0:4317 \
     -Dotel.exporter.otlp.protocol=grpc \
     -jar opbeans-0.0.1-SNAPSHOT.jar --server.port=8081
