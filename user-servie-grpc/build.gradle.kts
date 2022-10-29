import com.google.protobuf.gradle.*
import org.gradle.internal.impldep.org.codehaus.plexus.util.StringUtils.clean

plugins {
    id("java")
    id("com.google.protobuf") version "0.8.19"
    id("idea")
}

group = "ccc"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:3.21.8")
    implementation("io.grpc:grpc-stub:1.50.2")
    implementation("io.grpc:grpc-protobuf:1.50.2")
    implementation("io.grpc:grpc-netty-shaded:1.50.2")


    if (JavaVersion.current().isJava9Compatible()) {
        // Workaround for @javax.annotation.Generated
        // see: https://github.com/grpc/grpc-java/issues/3633
        implementation("javax.annotation:javax.annotation-api:1.3.1")
    }

}


protobuf {
    protoc {
        // The artifact spec for the Protobuf Compiler
        artifact = "com.google.protobuf:protoc:3.6.1"
    }
    generatedFilesBaseDir = "$projectDir/src/generated"
    plugins {
        // Optional: an artifact spec for a protoc plugin, with "grpc" as
        // the identifier, which can be referred to in the "plugins"
        // container of the "generateProtoTasks" closure.
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.15.1"
        }
    }

    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
            }
        }
    }

}

idea {
    module {
        sourceDirs.plusAssign(file("src/generated/main/java"))
        sourceDirs.plusAssign(file("src/generated/main/grpc"))
        generatedSourceDirs.plusAssign(file("src/generated/main/java"))
        generatedSourceDirs.plusAssign(file("src/generated/main/grpc"))
    }
}
