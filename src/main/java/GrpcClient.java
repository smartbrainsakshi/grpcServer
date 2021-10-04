
import com.yrrhelp.grpc.User;
import com.yrrhelp.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();

        // stubs - generate from proto

        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.LoginRequest loginrequest = User.LoginRequest.newBuilder().setUsername("sakshi").setPassword("sakshi").build();

        User.APIResponse response = userStub.login(loginrequest);

        System.out.println(response.getResponsemessage());
    }
}
