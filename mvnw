#!/bin/sh
# ----------------------------------------------------------------------------
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
# ----------------------------------------------------------------------------

# Maven Wrapper script for Unix-based systems

set -e

# Find the project base directory
if [ -z "$MAVEN_PROJECTBASEDIR" ]; then
  MAVEN_PROJECTBASEDIR="`dirname "$0"`"
fi

# Maven Wrapper JAR location
WRAPPER_JAR="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar"

# Download maven-wrapper.jar if it doesn't exist
if [ ! -r "$WRAPPER_JAR" ]; then
  if [ -z "$MVNW_REPOURL" ]; then
    MVNW_REPOURL="https://repo.maven.apache.org/maven2"
  fi
  wrapperUrl="$MVNW_REPOURL/org/apache/maven/wrapper/maven-wrapper/3.1.0/maven-wrapper-3.1.0.jar"
  echo "Downloading Maven Wrapper from: $wrapperUrl"
  if command -v curl > /dev/null; then
    curl -fsSL "$wrapperUrl" -o "$WRAPPER_JAR"
  elif command -v wget > /dev/null; then
    wget -q "$wrapperUrl" -O "$WRAPPER_JAR"
  else
    echo "Error: Neither curl nor wget is available" >&2
    exit 1
  fi
fi

# Execute Maven Wrapper
exec "$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar" "$@"
