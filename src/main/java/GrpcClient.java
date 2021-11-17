import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.techtter.grpc.User;
import net.techtter.grpc.userGrpc;

public class GrpcClient {
    public static void main(String[] args) {
//setup the cahnnle to communicte with grpc server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9001).usePlaintext().build();

        //to call api of grpc server we need stub of proto file of grpc server
      userGrpc.userBlockingStub blockingStub=  userGrpc.newBlockingStub(channel);
       // userGrpc.userStub
     User.LoginRequest request =   User.LoginRequest.newBuilder().setUsername("dastgeer").setPassword("dastgeer11").build();
    User.APIResponse response = blockingStub.login(request);
        System.out.printf("rsponse--->"+response);
    }
}
