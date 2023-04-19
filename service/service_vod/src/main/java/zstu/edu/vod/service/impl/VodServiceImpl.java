package zstu.edu.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import zstu.edu.servicebase.exceptionhandler.MyException;
import zstu.edu.vod.service.VodService;
import zstu.edu.vod.utils.ConstantVodUtils;
import zstu.edu.vod.utils.InitVodClient;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;


@Service
public class VodServiceImpl implements VodService {

    // 上传视频到阿里云
    @Override
    public String uploadVideoAly(MultipartFile file) {
        /**
         * 上传接口
         * @param accessKeyId  你的阿里云accessKeyId
         * @param accessKeySecret  你的阿里云accessKeySecret
         * @param title  视频标题
         * @param fileName  视频源文件名称，必须包含扩展名
         * @param inputStream  视频源文件输入流
         */
        String accessKey = ConstantVodUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantVodUtils.ACCESS_KEY_SECRET;
        try {
            String title = Objects.requireNonNull(file.getOriginalFilename()).substring(0, file.getOriginalFilename().lastIndexOf("."));
            String fileName = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            UploadStreamRequest request = new UploadStreamRequest(accessKey, accessKeySecret, title, fileName, inputStream);
            /* 是否使用默认水印(可选)，指定模板组ID时，根据模板组配置确定是否使用默认水印*/
            //request.setShowWaterMark(true);
            /* 设置上传完成后的回调URL(可选)，建议通过点播控制台配置消息监听事件，参见文档 https://help.aliyun.com/document_detail/57029.html */
            //request.setCallback("http://callback.sample.com");
            /* 自定义消息回调设置，参数说明参考文档 https://help.aliyun.com/document_detail/86952.html#UserData */
            //request.setUserData(""{\"Extend\":{\"test\":\"www\",\"localId\":\"xxxx\"},\"MessageCallback\":{\"CallbackURL\":\"http://test.test.com\"}}"");
            /* 视频分类ID(可选) */
            //request.setCateId(0);
            /* 视频标签,多个用逗号分隔(可选) */
            //request.setTags("标签1,标签2");
            /* 视频描述(可选) */
            //request.setDescription("视频描述");
            /* 封面图片(可选) */
            //request.setCoverURL("http://cover.sample.com/sample.jpg");
            /* 模板组ID(可选) */
            //request.setTemplateGroupId("8c4792cbc8694e7084fd5330e56a33d");
            /* 工作流ID(可选) */
            //request.setWorkflowId("d4430d07361f0*be1339577859b0177b");
            /* 存储区域(可选) */
            //request.setStorageLocation("in-201703232118266-5sejdln9o.oss-cn-shanghai.aliyuncs.com");
            /* 开启默认上传进度回调 */
            // request.setPrintProgress(true);
            /* 设置自定义上传进度回调 (必须继承 VoDProgressListener) */
            // request.setProgressListener(new PutObjectProgressListener());
            /* 设置应用ID*/
            //request.setAppId("app-1000000");
            /* 点播服务接入点 */
            //request.setApiRegionId("cn-shanghai");
            /* ECS部署区域*/
            // request.setEcsRegionId("cn-shanghai");
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            System.out.print("RequestId=" + response.getRequestId() + "\n");  //请求视频点播服务的请求ID
            String videoId = null;
            if (response.isSuccess()) {
                System.out.print("VideoId=" + response.getVideoId() + "\n");
                videoId = response.getVideoId();
            } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
                System.out.print("VideoId=" + response.getVideoId() + "\n");
                System.out.print("ErrorCode=" + response.getCode() + "\n");
                System.out.print("ErrorMessage=" + response.getMessage() + "\n");
                videoId = response.getVideoId();
            }
            return videoId;

        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(20001, "上传视频失败");
        }
    }

    // 根据视频id删除阿里云视频


    // getPlayUrl
    @Override
    public String getPlayUrl(String videoId) {
        // 根据视频id获取播放地址
        //播放地址
        String url = null;
        try {
            // 初始化对象
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            // 创建获取视频地址request和response
            GetPlayInfoRequest request = new GetPlayInfoRequest();
            GetPlayInfoResponse response = new GetPlayInfoResponse();
            // 向request设置视频id
            request.setVideoId(videoId);
            // 调用初始化对象的方法，传递request，获取数据
            response = client.getAcsResponse(request);
            List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();

            for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
                System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
                url = playInfo.getPlayURL();
            }
            //Base信息
            System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
            //请求视频播放凭证
            System.out.print("RequestId = " + response.getRequestId() + "\n");

        } catch (Exception e) {
            throw new MyException(20001, "获取视频播播放链接失败");
        }
        return url;
    }

    @Override
    public void removeVideo(String id) {
        try {
            // 初始化对象
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            // 删除视频的request对象
            DeleteVideoRequest request = new DeleteVideoRequest();
            // 向request设置视频id
            request.setVideoIds(id);
            // 调用初始化对象的方法实现删除
            client.getAcsResponse(request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(20001, "删除视频失败");
        }
    }

    @Override
    public void removeAlyVideoList(List<String> videoIdList) {
        try {
            // 初始化对象
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            // 删除视频的request对象
            DeleteVideoRequest request = new DeleteVideoRequest();
            // 向request设置视频id
            String videoIds = StringUtils.join(videoIdList.toArray(), ",");
            request.setVideoIds(videoIds);
            // 调用初始化对象的方法实现删除
            client.getAcsResponse(request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(20001, "删除视频失败");
        }
    }


}
