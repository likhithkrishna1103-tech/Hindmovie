package v2;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import p1.q;
import u2.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements u, a {
    public int C;
    public SurfaceTexture D;
    public byte[] G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicBoolean f13203u = new AtomicBoolean();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicBoolean f13204v = new AtomicBoolean(true);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final g f13205w = new g();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a2.c f13206x = new a2.c();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final q3.d f13207y = new q3.d();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final q3.d f13208z = new q3.d();
    public final float[] A = new float[16];
    public final float[] B = new float[16];
    public volatile int E = 0;
    public int F = -1;

    @Override // v2.a
    public final void a(long j5, float[] fArr) {
        ((q3.d) this.f13206x.f175x).a(j5, fArr);
    }

    public final void b(float[] fArr) {
        Object objD;
        GLES20.glClear(16384);
        try {
            s1.b.c();
        } catch (s1.k e10) {
            s1.b.h("SceneRenderer", "Failed to draw a frame", e10);
        }
        if (this.f13203u.compareAndSet(true, false)) {
            SurfaceTexture surfaceTexture = this.D;
            surfaceTexture.getClass();
            surfaceTexture.updateTexImage();
            try {
                s1.b.c();
            } catch (s1.k e11) {
                s1.b.h("SceneRenderer", "Failed to draw a frame", e11);
            }
            if (this.f13204v.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.A, 0);
            }
            long timestamp = this.D.getTimestamp();
            q3.d dVar = this.f13207y;
            synchronized (dVar) {
                objD = dVar.d(false, timestamp);
            }
            Long l10 = (Long) objD;
            if (l10 != null) {
                a2.c cVar = this.f13206x;
                float[] fArr2 = this.A;
                float[] fArr3 = (float[]) ((q3.d) cVar.f175x).f(l10.longValue());
                if (fArr3 != null) {
                    float[] fArr4 = (float[]) cVar.f174w;
                    float f = fArr3[0];
                    float f4 = -fArr3[1];
                    float f10 = -fArr3[2];
                    float length = Matrix.length(f, f4, f10);
                    if (length != 0.0f) {
                        Matrix.setRotateM(fArr4, 0, (float) Math.toDegrees(length), f / length, f4 / length, f10 / length);
                    } else {
                        Matrix.setIdentityM(fArr4, 0);
                    }
                    if (!cVar.f172u) {
                        a2.c.d((float[]) cVar.f173v, (float[]) cVar.f174w);
                        cVar.f172u = true;
                    }
                    Matrix.multiplyMM(fArr2, 0, (float[]) cVar.f173v, 0, (float[]) cVar.f174w, 0);
                }
            }
            f fVar = (f) this.f13208z.f(timestamp);
            if (fVar != null) {
                g gVar = this.f13205w;
                gVar.getClass();
                if (g.b(fVar)) {
                    gVar.f13195a = fVar.f13191c;
                    gVar.f13196b = new q3.d(fVar.f13189a.f13188a[0]);
                    if (!fVar.f13192d) {
                        new q3.d(fVar.f13190b.f13188a[0]);
                    }
                }
            }
        }
        Matrix.multiplyMM(this.B, 0, fArr, 0, this.A, 0);
        g gVar2 = this.f13205w;
        int i = this.C;
        float[] fArr5 = this.B;
        q3.d dVar2 = gVar2.f13196b;
        if (dVar2 == null) {
            return;
        }
        int i10 = gVar2.f13195a;
        GLES20.glUniformMatrix3fv(gVar2.f13199e, 1, false, i10 == 1 ? g.f13193j : i10 == 2 ? g.f13194k : g.i, 0);
        GLES20.glUniformMatrix4fv(gVar2.f13198d, 1, false, fArr5, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(gVar2.f13201h, 0);
        try {
            s1.b.c();
        } catch (s1.k e12) {
            Log.e("ProjectionRenderer", "Failed to bind uniforms", e12);
        }
        GLES20.glVertexAttribPointer(gVar2.f, 3, 5126, false, 12, (Buffer) dVar2.f10609c);
        try {
            s1.b.c();
        } catch (s1.k e13) {
            Log.e("ProjectionRenderer", "Failed to load position data", e13);
        }
        GLES20.glVertexAttribPointer(gVar2.f13200g, 2, 5126, false, 8, (Buffer) dVar2.f10610d);
        try {
            s1.b.c();
        } catch (s1.k e14) {
            Log.e("ProjectionRenderer", "Failed to load texture data", e14);
        }
        GLES20.glDrawArrays(dVar2.f10608b, 0, dVar2.f10607a);
        try {
            s1.b.c();
        } catch (s1.k e15) {
            Log.e("ProjectionRenderer", "Failed to render", e15);
        }
    }

    @Override // u2.u
    public final void c(long j5, long j8, q qVar, MediaFormat mediaFormat) {
        int i;
        ArrayList arrayListD;
        int iJ;
        this.f13207y.a(j8, Long.valueOf(j5));
        byte[] bArr = qVar.B;
        int i10 = qVar.C;
        byte[] bArr2 = this.G;
        int i11 = this.F;
        this.G = bArr;
        if (i10 == -1) {
            i10 = this.E;
        }
        this.F = i10;
        if (i11 == i10 && Arrays.equals(bArr2, this.G)) {
            return;
        }
        byte[] bArr3 = this.G;
        f fVar = null;
        if (bArr3 != null) {
            int i12 = this.F;
            s1.u uVar = new s1.u(bArr3);
            try {
                uVar.K(4);
                iJ = uVar.j();
                uVar.J(0);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            if (iJ == 1886547818) {
                uVar.K(8);
                int i13 = uVar.f11710b;
                int i14 = uVar.f11711c;
                while (i13 < i14) {
                    int iJ2 = uVar.j() + i13;
                    if (iJ2 > i13 && iJ2 <= i14) {
                        int iJ3 = uVar.j();
                        if (iJ3 != 2037673328 && iJ3 != 1836279920) {
                            uVar.J(iJ2);
                            i13 = iJ2;
                        }
                        uVar.I(iJ2);
                        arrayListD = com.bumptech.glide.d.D(uVar);
                        break;
                    }
                    break;
                }
                arrayListD = null;
            } else {
                arrayListD = com.bumptech.glide.d.D(uVar);
            }
            if (arrayListD != null) {
                int size = arrayListD.size();
                if (size == 1) {
                    e eVar = (e) arrayListD.get(0);
                    fVar = new f(eVar, eVar, i12);
                } else if (size == 2) {
                    fVar = new f((e) arrayListD.get(0), (e) arrayListD.get(1), i12);
                }
            }
        }
        if (fVar == null || !g.b(fVar)) {
            int i15 = this.F;
            float radians = (float) Math.toRadians(180.0f);
            float radians2 = (float) Math.toRadians(360.0f);
            float f = radians / 36;
            float f4 = radians2 / 72;
            float[] fArr = new float[15984];
            float[] fArr2 = new float[10656];
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 36; i16 < i19; i19 = 36) {
                float f10 = radians / 2.0f;
                float f11 = (i16 * f) - f10;
                int i20 = i16 + 1;
                float f12 = (i20 * f) - f10;
                int i21 = 0;
                while (i21 < 73) {
                    int i22 = i20;
                    float f13 = f12;
                    float f14 = radians;
                    int i23 = i17;
                    int i24 = i18;
                    int i25 = 0;
                    int i26 = 2;
                    while (i25 < i26) {
                        float f15 = i25 == 0 ? f11 : f13;
                        float f16 = radians2;
                        float f17 = i21 * f4;
                        float f18 = f11;
                        float f19 = f;
                        double d10 = 50.0f;
                        double d11 = (f17 + 3.1415927f) - (f16 / 2.0f);
                        double d12 = f15;
                        fArr[i23] = -((float) (Math.cos(d12) * Math.sin(d11) * d10));
                        fArr[i23 + 1] = (float) (Math.sin(d12) * d10);
                        int i27 = i23 + 3;
                        fArr[i23 + 2] = (float) (Math.cos(d12) * Math.cos(d11) * d10);
                        fArr2[i24] = f17 / f16;
                        int i28 = i24 + 2;
                        fArr2[i24 + 1] = ((i16 + i25) * f19) / f14;
                        if ((i21 == 0 && i25 == 0) || (i21 == 72 && i25 == 1)) {
                            System.arraycopy(fArr, i23, fArr, i27, 3);
                            i23 += 6;
                            i = 2;
                            System.arraycopy(fArr2, i24, fArr2, i28, 2);
                            i24 += 4;
                        } else {
                            i = 2;
                            i23 = i27;
                            i24 = i28;
                        }
                        i25++;
                        i26 = i;
                        radians2 = f16;
                        f11 = f18;
                        f = f19;
                    }
                    i21++;
                    i17 = i23;
                    i18 = i24;
                    i20 = i22;
                    f12 = f13;
                    radians = f14;
                    radians2 = radians2;
                    f = f;
                }
                i16 = i20;
            }
            e eVar2 = new e(new q3.d(0, fArr, fArr2, 1));
            fVar = new f(eVar2, eVar2, i15);
        }
        this.f13208z.a(j8, fVar);
    }

    @Override // v2.a
    public final void d() {
        this.f13207y.b();
        a2.c cVar = this.f13206x;
        ((q3.d) cVar.f175x).b();
        cVar.f172u = false;
        this.f13204v.set(true);
    }

    public final SurfaceTexture e() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            s1.b.c();
            this.f13205w.a();
            s1.b.c();
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            s1.b.c();
            int i = iArr[0];
            s1.b.b(36197, i);
            this.C = i;
        } catch (s1.k e10) {
            s1.b.h("SceneRenderer", "Failed to initialize the renderer", e10);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.C);
        this.D = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: v2.h
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f13202u.f13203u.set(true);
            }
        });
        return this.D;
    }
}
