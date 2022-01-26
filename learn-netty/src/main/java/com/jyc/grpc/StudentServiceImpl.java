package com.jyc.grpc;

import com.jyc.proto.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("receive client info: " + request.getUsername());
        // 构造结果并返回
        responseObserver.onNext(MyResponse.newBuilder().setRealname("jyc").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("receive client info: " + request.getAge());
        responseObserver.onNext(StudentResponse.newBuilder().setName("jyc").setAge(20).setCity("shenzhen").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("zhangsan").setAge(30).setCity("beijing").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("lisi").setAge(40).setCity("hangzhou").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("wangwu").setAge(50).setCity("shanghai").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("onNext: " + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                StudentResponse studentResponse = StudentResponse.newBuilder().setName("jyc").setAge(18).setCity("xian").build();
                StudentResponse studentResponse2 = StudentResponse.newBuilder().setName("jycoco").setAge(18).setCity("guangzhou").build();
                StudentResponseList studentResponseList = StudentResponseList.newBuilder().
                        addStudentResponse(studentResponse).addStudentResponse(studentResponse2).build();
                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println("onNext: " + value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
