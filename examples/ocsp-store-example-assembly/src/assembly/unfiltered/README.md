Deployment in Tomcat
----
1. Copy the sub-folders `webapps` and `xipki` to the tomcat root folder
2. Add the line `org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH=true`
   to the file `conf/catalina.properties` if OCSP over HTTP supported is activated.
3. Start tomcat
  In the tomcat root folder

```sh
  bin/start.sh
```

  Note that the start script of tomcat does not set the working directory to the tomcat root directory, you have to start tomcat as above so that the XiPKI can retrieve files correctly.

4. Shutdown tomcat
   Shutdown tomcat from any folder
```sh
  /path/to/tomcat/bin/shutdown.sh
```

Deployment in Jetty 9
----
1. Copy the sub-folders `webapps` and `xipki` to the jetty root folder.
2. Start jetty
   Start jetty from any folder
```sh
  /path/to/jetty/bin/jetty.sh start
```

3. Shutdown jetty
   Shutdown jetty from any folder
```sh
  /path/to/jetty/bin/jetty.sh stop
```

