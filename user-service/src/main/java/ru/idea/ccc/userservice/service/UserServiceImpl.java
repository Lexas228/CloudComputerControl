package ru.idea.ccc.userservice.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import ru.idea.ccc.userservicegrpc.CreateUserRequest;
import ru.idea.ccc.userservicegrpc.LoginUserRequest;
import ru.idea.ccc.userservicegrpc.ResponseUser;
import ru.idea.ccc.userservicegrpc.UserServiceGrpc;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void createUser(CreateUserRequest request, StreamObserver<ResponseUser> responseObserver) {
        super.createUser(request, responseObserver);
    }

    @Override
    public void loginUser(LoginUserRequest request, StreamObserver<ResponseUser> responseObserver) {
        super.loginUser(request, responseObserver);
    }
}
