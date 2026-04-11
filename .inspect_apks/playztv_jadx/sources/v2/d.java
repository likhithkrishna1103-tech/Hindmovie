package v2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f13182a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f13183b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f13184c = new float[16];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f13185d = new float[3];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Display f13186e;
    public final c[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13187g;

    public d(Display display, c... cVarArr) {
        this.f13186e = display;
        this.f = cVarArr;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i;
        float[] fArr = sensorEvent.values;
        float[] fArr2 = this.f13182a;
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        int rotation = this.f13186e.getRotation();
        float[] fArr3 = this.f13183b;
        if (rotation != 0) {
            int i10 = 129;
            if (rotation != 1) {
                i = 130;
                if (rotation != 2) {
                    if (rotation != 3) {
                        throw new IllegalStateException();
                    }
                    i10 = 130;
                    i = 1;
                }
            } else {
                i = 129;
                i10 = 2;
            }
            System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
            SensorManager.remapCoordinateSystem(fArr3, i10, i, fArr2);
        }
        SensorManager.remapCoordinateSystem(fArr2, 1, 131, fArr3);
        float[] fArr4 = this.f13185d;
        SensorManager.getOrientation(fArr3, fArr4);
        float f = fArr4[2];
        Matrix.rotateM(fArr2, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        boolean z2 = this.f13187g;
        float[] fArr5 = this.f13184c;
        if (!z2) {
            a2.c.d(fArr5, fArr2);
            this.f13187g = true;
        }
        System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
        Matrix.multiplyMM(fArr2, 0, fArr3, 0, fArr5, 0);
        for (int i11 = 0; i11 < 2; i11++) {
            this.f[i11].a(fArr2, f);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
