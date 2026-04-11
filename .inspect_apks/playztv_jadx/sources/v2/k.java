package v2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import java.util.concurrent.CopyOnWriteArrayList;
import u2.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends GLSurfaceView {
    public static final /* synthetic */ int F = 0;
    public SurfaceTexture A;
    public Surface B;
    public boolean C;
    public boolean D;
    public boolean E;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArrayList f13215u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final SensorManager f13216v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Sensor f13217w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d f13218x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Handler f13219y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final i f13220z;

    public k(Context context) {
        super(context, null);
        this.f13215u = new CopyOnWriteArrayList();
        this.f13219y = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        systemService.getClass();
        SensorManager sensorManager = (SensorManager) systemService;
        this.f13216v = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(15);
        this.f13217w = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        i iVar = new i();
        this.f13220z = iVar;
        j jVar = new j(this, iVar);
        View.OnTouchListener lVar = new l(context, jVar);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getClass();
        this.f13218x = new d(windowManager.getDefaultDisplay(), lVar, jVar);
        this.C = true;
        setEGLContextClientVersion(2);
        setRenderer(jVar);
        setOnTouchListener(lVar);
    }

    public final void a() {
        boolean z2 = this.C && this.D;
        Sensor sensor = this.f13217w;
        if (sensor == null || z2 == this.E) {
            return;
        }
        d dVar = this.f13218x;
        SensorManager sensorManager = this.f13216v;
        if (z2) {
            sensorManager.registerListener(dVar, sensor, 0);
        } else {
            sensorManager.unregisterListener(dVar);
        }
        this.E = z2;
    }

    public a getCameraMotionListener() {
        return this.f13220z;
    }

    public u getVideoFrameMetadataListener() {
        return this.f13220z;
    }

    public Surface getVideoSurface() {
        return this.B;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f13219y.post(new nc.b(10, this));
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        this.D = false;
        a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        this.D = true;
        a();
    }

    public void setDefaultStereoMode(int i) {
        this.f13220z.E = i;
    }

    public void setUseSensorRotation(boolean z2) {
        this.C = z2;
        a();
    }
}
