package w1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f13824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f13825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f13826e;
    public f f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f13827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f13828h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j f13829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ByteBuffer f13830k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ShortBuffer f13831l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ByteBuffer f13832m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f13833n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f13834o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f13835p;

    @Override // w1.h
    public final boolean a() {
        if (this.f.f13791a != -1) {
            return Math.abs(this.f13824c - 1.0f) >= 1.0E-4f || Math.abs(this.f13825d - 1.0f) >= 1.0E-4f || this.f.f13791a != this.f13826e.f13791a;
        }
        return false;
    }

    @Override // w1.h
    public final boolean b() {
        if (this.f13835p) {
            j jVar = this.f13829j;
            if (jVar != null) {
                y1.d.g(jVar.f13812m >= 0);
                if (jVar.f13812m * jVar.f13803b * 2 == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // w1.h
    public final ByteBuffer c() {
        j jVar = this.f13829j;
        if (jVar != null) {
            int i = jVar.f13803b;
            y1.d.g(jVar.f13812m >= 0);
            int i10 = jVar.f13812m * i * 2;
            if (i10 > 0) {
                if (this.f13830k.capacity() < i10) {
                    ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i10).order(ByteOrder.nativeOrder());
                    this.f13830k = byteBufferOrder;
                    this.f13831l = byteBufferOrder.asShortBuffer();
                } else {
                    this.f13830k.clear();
                    this.f13831l.clear();
                }
                ShortBuffer shortBuffer = this.f13831l;
                y1.d.g(jVar.f13812m >= 0);
                int iMin = Math.min(shortBuffer.remaining() / i, jVar.f13812m);
                int i11 = iMin * i;
                shortBuffer.put(jVar.f13811l, 0, i11);
                int i12 = jVar.f13812m - iMin;
                jVar.f13812m = i12;
                short[] sArr = jVar.f13811l;
                System.arraycopy(sArr, i11, sArr, 0, i12 * i);
                this.f13834o += (long) i10;
                this.f13830k.limit(i10);
                this.f13832m = this.f13830k;
            }
        }
        ByteBuffer byteBuffer = this.f13832m;
        this.f13832m = h.f13795a;
        return byteBuffer;
    }

    @Override // w1.h
    public final void d() {
        j jVar = this.f13829j;
        if (jVar != null) {
            int i = jVar.f13810k;
            float f = jVar.f13804c;
            float f10 = jVar.f13805d;
            double d10 = f / f10;
            double d11 = jVar.f13806e * f10;
            int i10 = jVar.f13817r;
            int i11 = jVar.f13812m + ((int) ((((((((double) (i - i10)) / d10) + ((double) i10)) + jVar.f13822w) + ((double) jVar.f13814o)) / d11) + 0.5d));
            jVar.f13822w = 0.0d;
            short[] sArr = jVar.f13809j;
            int i12 = jVar.f13808h * 2;
            jVar.f13809j = jVar.c(sArr, i, i12 + i);
            int i13 = 0;
            while (true) {
                int i14 = jVar.f13803b;
                if (i13 >= i12 * i14) {
                    break;
                }
                jVar.f13809j[(i14 * i) + i13] = 0;
                i13++;
            }
            jVar.f13810k = i12 + jVar.f13810k;
            jVar.f();
            if (jVar.f13812m > i11) {
                jVar.f13812m = Math.max(i11, 0);
            }
            jVar.f13810k = 0;
            jVar.f13817r = 0;
            jVar.f13814o = 0;
        }
        this.f13835p = true;
    }

    @Override // w1.h
    public final f e(f fVar) throws g {
        if (fVar.f13793c != 2) {
            throw new g(fVar);
        }
        int i = this.f13823b;
        if (i == -1) {
            i = fVar.f13791a;
        }
        this.f13826e = fVar;
        f fVar2 = new f(i, fVar.f13792b, 2);
        this.f = fVar2;
        this.i = true;
        return fVar2;
    }

    @Override // w1.h
    public final void f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            j jVar = this.f13829j;
            jVar.getClass();
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f13833n += (long) iRemaining;
            int iRemaining2 = shortBufferAsShortBuffer.remaining();
            int i = jVar.f13803b;
            int i10 = iRemaining2 / i;
            short[] sArrC = jVar.c(jVar.f13809j, jVar.f13810k, i10);
            jVar.f13809j = sArrC;
            shortBufferAsShortBuffer.get(sArrC, jVar.f13810k * i, ((i10 * i) * 2) / 2);
            jVar.f13810k += i10;
            jVar.f();
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // w1.h
    public final void flush() {
        if (a()) {
            f fVar = this.f13826e;
            this.f13827g = fVar;
            f fVar2 = this.f;
            this.f13828h = fVar2;
            if (this.i) {
                this.f13829j = new j(fVar.f13791a, fVar.f13792b, this.f13824c, this.f13825d, fVar2.f13791a);
            } else {
                j jVar = this.f13829j;
                if (jVar != null) {
                    jVar.f13810k = 0;
                    jVar.f13812m = 0;
                    jVar.f13814o = 0;
                    jVar.f13815p = 0;
                    jVar.f13816q = 0;
                    jVar.f13817r = 0;
                    jVar.f13818s = 0;
                    jVar.f13819t = 0;
                    jVar.f13820u = 0;
                    jVar.f13821v = 0;
                    jVar.f13822w = 0.0d;
                }
            }
        }
        this.f13832m = h.f13795a;
        this.f13833n = 0L;
        this.f13834o = 0L;
        this.f13835p = false;
    }

    @Override // w1.h
    public final void reset() {
        this.f13824c = 1.0f;
        this.f13825d = 1.0f;
        f fVar = f.f13790e;
        this.f13826e = fVar;
        this.f = fVar;
        this.f13827g = fVar;
        this.f13828h = fVar;
        ByteBuffer byteBuffer = h.f13795a;
        this.f13830k = byteBuffer;
        this.f13831l = byteBuffer.asShortBuffer();
        this.f13832m = byteBuffer;
        this.f13823b = -1;
        this.i = false;
        this.f13829j = null;
        this.f13833n = 0L;
        this.f13834o = 0L;
        this.f13835p = false;
    }
}
