package z2;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import pa.o;
import v1.p;
import y1.t;
import y2.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements u, a {
    public int D;
    public SurfaceTexture E;
    public byte[] H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicBoolean f15151v = new AtomicBoolean();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicBoolean f15152w = new AtomicBoolean(true);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g f15153x = new g();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bumptech.glide.l f15154y = new com.bumptech.glide.l();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final o f15155z = new o();
    public final o A = new o();
    public final float[] B = new float[16];
    public final float[] C = new float[16];
    public volatile int F = 0;
    public int G = -1;

    @Override // z2.a
    public final void a(long j4, float[] fArr) {
        ((o) this.f15154y.f2225y).a(j4, fArr);
    }

    public final void b(float[] fArr) {
        Object objD;
        GLES20.glClear(16384);
        try {
            y1.b.c();
        } catch (y1.k e9) {
            y1.b.h("SceneRenderer", "Failed to draw a frame", e9);
        }
        if (this.f15151v.compareAndSet(true, false)) {
            SurfaceTexture surfaceTexture = this.E;
            surfaceTexture.getClass();
            surfaceTexture.updateTexImage();
            try {
                y1.b.c();
            } catch (y1.k e10) {
                y1.b.h("SceneRenderer", "Failed to draw a frame", e10);
            }
            if (this.f15152w.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.B, 0);
            }
            long timestamp = this.E.getTimestamp();
            o oVar = this.f15155z;
            synchronized (oVar) {
                objD = oVar.d(false, timestamp);
            }
            Long l10 = (Long) objD;
            if (l10 != null) {
                com.bumptech.glide.l lVar = this.f15154y;
                float[] fArr2 = this.B;
                float[] fArr3 = (float[]) ((o) lVar.f2225y).f(l10.longValue());
                if (fArr3 != null) {
                    float[] fArr4 = (float[]) lVar.f2224x;
                    float f = fArr3[0];
                    float f10 = -fArr3[1];
                    float f11 = -fArr3[2];
                    float length = Matrix.length(f, f10, f11);
                    if (length != 0.0f) {
                        Matrix.setRotateM(fArr4, 0, (float) Math.toDegrees(length), f / length, f10 / length, f11 / length);
                    } else {
                        Matrix.setIdentityM(fArr4, 0);
                    }
                    if (!lVar.f2222v) {
                        com.bumptech.glide.l.f((float[]) lVar.f2223w, (float[]) lVar.f2224x);
                        lVar.f2222v = true;
                    }
                    Matrix.multiplyMM(fArr2, 0, (float[]) lVar.f2223w, 0, (float[]) lVar.f2224x, 0);
                }
            }
            f fVar = (f) this.A.f(timestamp);
            if (fVar != null) {
                g gVar = this.f15153x;
                gVar.getClass();
                if (g.b(fVar)) {
                    gVar.f15143a = fVar.f15139c;
                    gVar.f15144b = new o(fVar.f15137a.f15136a[0]);
                    if (!fVar.f15140d) {
                        new o(fVar.f15138b.f15136a[0]);
                    }
                }
            }
        }
        Matrix.multiplyMM(this.C, 0, fArr, 0, this.B, 0);
        g gVar2 = this.f15153x;
        int i = this.D;
        float[] fArr5 = this.C;
        o oVar2 = gVar2.f15144b;
        if (oVar2 == null) {
            return;
        }
        int i10 = gVar2.f15143a;
        GLES20.glUniformMatrix3fv(gVar2.f15147e, 1, false, i10 == 1 ? g.f15141j : i10 == 2 ? g.f15142k : g.i, 0);
        GLES20.glUniformMatrix4fv(gVar2.f15146d, 1, false, fArr5, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(gVar2.f15149h, 0);
        try {
            y1.b.c();
        } catch (y1.k e11) {
            Log.e("ProjectionRenderer", "Failed to bind uniforms", e11);
        }
        GLES20.glVertexAttribPointer(gVar2.f, 3, 5126, false, 12, (Buffer) oVar2.f10087c);
        try {
            y1.b.c();
        } catch (y1.k e12) {
            Log.e("ProjectionRenderer", "Failed to load position data", e12);
        }
        GLES20.glVertexAttribPointer(gVar2.f15148g, 2, 5126, false, 8, (Buffer) oVar2.f10088d);
        try {
            y1.b.c();
        } catch (y1.k e13) {
            Log.e("ProjectionRenderer", "Failed to load texture data", e13);
        }
        GLES20.glDrawArrays(oVar2.f10086b, 0, oVar2.f10085a);
        try {
            y1.b.c();
        } catch (y1.k e14) {
            Log.e("ProjectionRenderer", "Failed to render", e14);
        }
    }

    @Override // z2.a
    public final void c() {
        this.f15155z.b();
        com.bumptech.glide.l lVar = this.f15154y;
        ((o) lVar.f2225y).b();
        lVar.f2222v = false;
        this.f15152w.set(true);
    }

    @Override // y2.u
    public final void d(long j4, long j7, p pVar, MediaFormat mediaFormat) {
        int i;
        ArrayList arrayListL;
        int iJ;
        this.f15155z.a(j7, Long.valueOf(j4));
        byte[] bArr = pVar.B;
        int i10 = pVar.C;
        byte[] bArr2 = this.H;
        int i11 = this.G;
        this.H = bArr;
        if (i10 == -1) {
            i10 = this.F;
        }
        this.G = i10;
        if (i11 == i10 && Arrays.equals(bArr2, this.H)) {
            return;
        }
        byte[] bArr3 = this.H;
        f fVar = null;
        if (bArr3 != null) {
            int i12 = this.G;
            t tVar = new t(bArr3);
            try {
                tVar.K(4);
                iJ = tVar.j();
                tVar.J(0);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            if (iJ == 1886547818) {
                tVar.K(8);
                int i13 = tVar.f14610b;
                int i14 = tVar.f14611c;
                while (i13 < i14) {
                    int iJ2 = tVar.j() + i13;
                    if (iJ2 > i13 && iJ2 <= i14) {
                        int iJ3 = tVar.j();
                        if (iJ3 != 2037673328 && iJ3 != 1836279920) {
                            tVar.J(iJ2);
                            i13 = iJ2;
                        }
                        tVar.I(iJ2);
                        arrayListL = a.a.l(tVar);
                        break;
                    }
                    break;
                }
                arrayListL = null;
            } else {
                arrayListL = a.a.l(tVar);
            }
            if (arrayListL != null) {
                int size = arrayListL.size();
                if (size == 1) {
                    e eVar = (e) arrayListL.get(0);
                    fVar = new f(eVar, eVar, i12);
                } else if (size == 2) {
                    fVar = new f((e) arrayListL.get(0), (e) arrayListL.get(1), i12);
                }
            }
        }
        if (fVar == null || !g.b(fVar)) {
            int i15 = this.G;
            float radians = (float) Math.toRadians(180.0f);
            float radians2 = (float) Math.toRadians(360.0f);
            float f = radians / 36;
            float f10 = radians2 / 72;
            float[] fArr = new float[15984];
            float[] fArr2 = new float[10656];
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 36; i16 < i19; i19 = 36) {
                float f11 = radians / 2.0f;
                float f12 = (i16 * f) - f11;
                int i20 = i16 + 1;
                float f13 = (i20 * f) - f11;
                int i21 = 0;
                while (i21 < 73) {
                    int i22 = i20;
                    float f14 = f13;
                    float f15 = radians;
                    int i23 = i17;
                    int i24 = i18;
                    int i25 = 0;
                    int i26 = 2;
                    while (i25 < i26) {
                        float f16 = i25 == 0 ? f12 : f14;
                        float f17 = radians2;
                        float f18 = i21 * f10;
                        float f19 = f12;
                        float f20 = f;
                        double d10 = 50.0f;
                        double d11 = (f18 + 3.1415927f) - (f17 / 2.0f);
                        double d12 = f16;
                        fArr[i23] = -((float) (Math.cos(d12) * Math.sin(d11) * d10));
                        fArr[i23 + 1] = (float) (Math.sin(d12) * d10);
                        int i27 = i23 + 3;
                        fArr[i23 + 2] = (float) (Math.cos(d12) * Math.cos(d11) * d10);
                        fArr2[i24] = f18 / f17;
                        int i28 = i24 + 2;
                        fArr2[i24 + 1] = ((i16 + i25) * f20) / f15;
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
                        radians2 = f17;
                        f12 = f19;
                        f = f20;
                    }
                    i21++;
                    i17 = i23;
                    i18 = i24;
                    i20 = i22;
                    f13 = f14;
                    radians = f15;
                    radians2 = radians2;
                    f = f;
                }
                i16 = i20;
            }
            e eVar2 = new e(new o(0, fArr, fArr2, 1));
            fVar = new f(eVar2, eVar2, i15);
        }
        this.A.a(j7, fVar);
    }

    public final SurfaceTexture e() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            y1.b.c();
            this.f15153x.a();
            y1.b.c();
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            y1.b.c();
            int i = iArr[0];
            y1.b.b(36197, i);
            this.D = i;
        } catch (y1.k e9) {
            y1.b.h("SceneRenderer", "Failed to initialize the renderer", e9);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.D);
        this.E = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: z2.h
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f15150v.f15151v.set(true);
            }
        });
        return this.E;
    }
}
