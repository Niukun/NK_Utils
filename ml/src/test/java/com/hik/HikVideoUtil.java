package com.hik;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.*;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.OutputStream;


/**
 * @program: smartpark-exchange
 * @description:
 * @author: dch
 * @create: 2022-05-31 16:37
 **/
@Slf4j
public class HikVideoUtil {

    public static  String rtspUrl = "rtsp://admin:cyhl12345+@192.168.110.18:554/Streaming/Channels/101";

    public static void main(String[] args) {


        System.load("D:\\data\\opencv\\dll\\opencv_java455.dll");
        System.load("D:\\data\\opencv\\dll\\opencv_videoio_ffmpeg455_64.dll");

        VideoCapture vc = new VideoCapture();
        boolean isOpen = vc.open(rtspUrl);

        System.out.println("isOpen="+isOpen);

        Mat mat = new Mat();
        String winName = "云原生办公室监控";
        int height = 600,width = 800;
        HighGui.namedWindow(winName);
        HighGui.resizeWindow(winName, width, height);
        while(vc.read(mat)){
            // 重置大小
            Mat dst = new Mat();
            Imgproc.resize(mat, dst, new Size(width,height));
            // 显示
            HighGui.imshow(winName, mat);
            // waitkey 必须要，否则无法显示
            int key = HighGui.waitKey(1);
            System.out.println("key="+key);
            //esc键退出
            if(key == 27){
                break;
            }
            //拿到了每帧之后要干嘛就是后面逻辑的事情了
            MatToBufferedImage(dst);
            dst.release();

        }
        HighGui.destroyAllWindows();
        vc.release();
    }

    static BufferedImage MatToBufferedImage(Mat frame) {
        int type = 0;
        if (frame == null) return null;

        if (frame.channels() == 1)
            type = BufferedImage.TYPE_BYTE_GRAY;
        else if (frame.channels() == 3)
            type = BufferedImage.TYPE_3BYTE_BGR;

        BufferedImage image = new BufferedImage(frame.width(), frame.height(), type);
        WritableRaster raster = image.getRaster();
        DataBufferByte dataBufferByte = (DataBufferByte) raster.getDataBuffer();
        byte[] data = dataBufferByte.getData();
        frame.get(0, 0, data);
        return image;
    }


    @Setter
    private OutputStream outputStream;

    @Setter
    private String rtspTransportType;

    private FFmpegFrameGrabber grabber;

    private FFmpegFrameRecorder recorder;

    private boolean isStart = false;

    /**
     * 开启获取rtsp流
     */
    public void live(OutputStream outputStream, String transferType, String rtspTransportType) {
        log.info("连接rtsp：" + rtspUrl + ",开始创建grabber");
        boolean isSuccess = createGrabber(rtspUrl);
        if (isSuccess) {
            log.info("创建grabber成功");
        } else {
            log.info("创建grabber失败");
        }
        startCameraPush();
    }

    /**
     * 构造视频抓取器
     *
     * @param rtsp 拉流地址
     * @return 创建成功与否
     */
    private boolean createGrabber(String rtsp) {
        // 获取视频源
        try {
            grabber = FFmpegFrameGrabber.createDefault(rtsp);
            grabber.setOption("rtsp_transport", rtspTransportType);
            grabber.start();
            isStart = true;

            recorder = new FFmpegFrameRecorder(String.valueOf(outputStream), grabber.getImageWidth(), grabber.getImageHeight(), grabber.getAudioChannels());
            //avcodec.AV_CODEC_ID_H264  //AV_CODEC_ID_MPEG4
            recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
            recorder.setFormat("flv");
            recorder.setFrameRate(grabber.getFrameRate());
            recorder.setSampleRate(grabber.getSampleRate());
            recorder.setAudioChannels(grabber.getAudioChannels());
            recorder.setFrameRate(grabber.getFrameRate());
            return true;
        } catch (FrameGrabber.Exception e) {
            log.error("创建解析rtsp FFmpegFrameGrabber 失败");
            log.error("create rtsp FFmpegFrameGrabber exception: ", e);
            stop();
            reset();
            return false;
        }
    }

    /**
     * 推送图片（摄像机直播）
     */
    private void startCameraPush() {
        if (grabber == null) {
            log.info("重试连接rtsp：" + rtspUrl + ",开始创建grabber");
            boolean isSuccess = createGrabber(rtspUrl);
            if (isSuccess) {
                log.info("创建grabber成功");
            } else {
                log.info("创建grabber失败");
            }
        }
        try {
            if (grabber != null) {
                recorder.start();
                Frame frame;
                while (isStart && (frame = grabber.grabFrame()) != null) {
                    recorder.setTimestamp(grabber.getTimestamp());
                    recorder.record(frame);
                }
                stop();
                reset();
            }
        } catch (FrameGrabber.Exception | RuntimeException | FrameRecorder.Exception e) {
            log.error(e.getMessage(), e);
            stop();
            reset();
        }
    }

    private void stop() {
        try {
            if (recorder != null) {
                recorder.stop();
                recorder.release();
            }
            if (grabber != null) {
                grabber.stop();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void reset() {
        recorder = null;
        grabber = null;
        isStart = false;
    }
}
