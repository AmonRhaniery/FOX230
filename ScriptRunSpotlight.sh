#!/bin/sh
export MAVEN_OPTS="-Xmx4G -Dlog4j.configuration=file:data/fox/log4j.properties"

cd spotlight

for ln in DE EN ES FR NL PT
do
    ./run${ln}.sh
done

cd ..
