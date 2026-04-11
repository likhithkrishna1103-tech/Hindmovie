package z2;

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
import y2.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends GLSurfaceView {
    public static final /* synthetic */ int G = 0;
    public final i A;
    public SurfaceTexture B;
    public Surface C;
    public boolean D;
    public boolean E;
    public boolean F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CopyOnWriteArrayList f15161v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SensorManager f15162w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Sensor f15163x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d f15164y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Handler f15165z;

    public k(Context context) {
        super(context, null);
        this.f15161v = new CopyOnWriteArrayList();
        this.f15165z = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        systemService.getClass();
        SensorManager sensorManager = (SensorManager) systemService;
        this.f15162w = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(15);
        this.f15163x = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        i iVar = new i();
        this.A = iVar;
        j jVar = new j(this, iVar);
        View.OnTouchListener lVar = new l(context, jVar);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getClass();
        this.f15164y = new d(windowManager.getDefaultDisplay(), lVar, jVar);
        this.D = true;
        setEGLContextClientVersion(2);
        setRenderer(jVar);
        setOnTouchListener(lVar);
    }

    public final void a() {
        boolean z10 = this.D && this.E;
        Sensor sensor = this.f15163x;
        if (sensor == null || z10 == this.F) {
            return;
        }
        d dVar = this.f15164y;
        SensorManager sensorManager = this.f15162w;
        if (z10) {
            sensorManager.registerListener(dVar, sensor, 0);
        } else {
            sensorManager.unregisterListener(dVar);
        }
        this.F = z10;
    }

    public a getCameraMotionListener() {
        return this.A;
    }

    public u getVideoFrameMetadataListener() {
        return this.A;
    }

    public Surface getVideoSurface() {
        return this.C;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f15165z.post(new pa.c(16, this));
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        this.E = false;
        a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        this.E = true;
        a();
    }

    public void setDefaultStereoMode(int i) {
        this.A.F = i;
    }

    public void setUseSensorRotation(boolean z10) {
        this.D = z10;
        a();
    }
}
