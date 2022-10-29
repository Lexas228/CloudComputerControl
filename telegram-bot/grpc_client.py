import grpc
import userService_pb2
import userService_pb2_grpc


def run():
    with grpc.insecure_channel('todoworld.servicestack.net:5054') as channel:

        client = userService_pb2_grpc.UserServiceStub(channel)
        # response = client.loginUser(UserRequst())
        # print(response.Result)

if __name__ == '__main__':
    run()