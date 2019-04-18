FROM java

# expose default port 4444
EXPOSE 4444

# set release workdir
WORKDIR /app/release
# add
ADD . /app/release

# fox jar with version
ENV FOX=fox-2.3.0-jar-with-dependencies.jar 

# default java options
ENV JAVA_OPTS="-Xmx8G"

# execute jar from env var
CMD java $JAVA_OPTS -cp $FOX org.aksw.fox.FoxRESTful
