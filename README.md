# Elasticsearch Plugin

## Elasticsearch & Kibana
Test environment for elasticsearch plugins. Kibana is query tool for elasticsearch REST api.
```bash
docker-compose up [-d]
```

## Install Custom plugins
* Check if plugin you want to mount is already built.
* plugins folder is mounted at `/usr/shar/elasticsearch/test` in elasticsearch container

The installation process is as follows
1. in container process
```bash
$ docker exec -it <container_id> bash
```
2. install your plugin
```bash
# in docker container
$ bin/elasticsearch-plugin install file:<your plugin path>
```
3. in your host
you must reboot elasticsearch container
```bash
$ docker-compose restart
```
4. querying
* make your own dsl query by using `curl` commands
* use kibana dev tools for dsl querying