package org.usfirst.frc5839.FRC2017Test1;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc5839.FRC2017Test1.commands.releaseClimber;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.cscore.CvSource;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class VisionProcess {
	
	private final Object imgLock = new Object();
	VisionThread visionThread;
	private double centerX1 = 0.0;
	private int heightX1 = 0;
	private double centerX2 = 0.0;
	private int heightX2 = 0;
	
	
	public void runVisionThread() {
//		AxisCamera camera = CameraServer.getInstance().addAxisCamera("10.58.39.20");
//		camera.setResolution(320, 240);
//		CvSource source = CameraServer.getInstance().putVideo("RGBed", 320, 240);
//		CvSource sourceblured = CameraServer.getInstance().putVideo("blured", 320, 240);
//		
//		this.visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
//			try {
//		    	if (!pipeline.filterContoursOutput().isEmpty()) {
//		        	Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
//		        	Rect r1 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));
////		        	source.putFrame(pipeline.rgbThresholdOutput());
////		        	sourceblured.putFrame(pipeline.blurOutput());
//		        	synchronized (imgLock) {
//		        	centerX1 = r.x;
//		        	centerX2 = r1.x;
//		        	heightX1 = r.height;
//		        	heightX2 = r1.height;
//		        	}
//		    	}
//			} catch (Exception e) {
////				DriverStation.reportError(e.toString(), true);
//			}
//
//
//		});
//		visionThread.start();
	}
		
	public double getcenterX1() {
		double x1center;
		synchronized (imgLock) {
			x1center = this.centerX1;
		}
		return x1center;
	}
	
	public int getheightX1() {
		int x1height;
		synchronized (imgLock) {
			x1height = this.heightX1;
		}
		return x1height;
	}
	
	public double getcenterX2() {
		double x2center;
		synchronized (imgLock) {
			x2center = this.centerX2;
		}
		return x2center;
	}
	public int getheightX2() {
		int x2height;
		synchronized (imgLock) {
			x2height = this.heightX2;
		}
		return x2height;
	}
	
	public int getfinalheightx1() {

		heightX1 = getheightX1();
		heightX2 = getheightX2();
		return heightX1; /* heightX1<heightX2?heightX1:heightX2; */
		
	}
	public int getfinalheightx2() {
		
		heightX1 = getheightX1();
		heightX2 = getheightX2();
		return heightX2;/* heightX1<heightX2?heightX2:heightX1;*/
		
	}
	
	public double getfinalcenterx1() {
		
		double centx1,centx2;
		centx1 = getcenterX1();
		centx2 = getcenterX2();
		return centx1<centx2?centx1:centx2;
		
	}
	
	public double getfinalcenterx2() {
		
		double centx1,centx2;
		centx1 = getcenterX1();
		centx2 = getcenterX2();
		return centx1<centx2?centx2:centx1;
		
	}
	

}
