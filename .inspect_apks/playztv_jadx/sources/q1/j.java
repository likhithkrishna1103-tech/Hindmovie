package q1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f10576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f10577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f10578e;
    public e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f10579g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f10580h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i f10581j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ByteBuffer f10582k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ShortBuffer f10583l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ByteBuffer f10584m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f10585n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f10586o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f10587p;

    @Override // q1.g
    public final boolean a() {
        if (this.f.f10543a != -1) {
            return Math.abs(this.f10576c - 1.0f) >= 1.0E-4f || Math.abs(this.f10577d - 1.0f) >= 1.0E-4f || this.f.f10543a != this.f10578e.f10543a;
        }
        return false;
    }

    @Override // q1.g
    public final boolean b() {
        if (this.f10587p) {
            i iVar = this.f10581j;
            if (iVar != null) {
                s1.d.g(iVar.f10564m >= 0);
                if (iVar.f10564m * iVar.f10555b * 2 == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // q1.g
    public final ByteBuffer c() {
        i iVar = this.f10581j;
        if (iVar != null) {
            int i = iVar.f10555b;
            s1.d.g(iVar.f10564m >= 0);
            int i10 = iVar.f10564m * i * 2;
            if (i10 > 0) {
                if (this.f10582k.capacity() < i10) {
                    ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i10).order(ByteOrder.nativeOrder());
                    this.f10582k = byteBufferOrder;
                    this.f10583l = byteBufferOrder.asShortBuffer();
                } else {
                    this.f10582k.clear();
                    this.f10583l.clear();
                }
                ShortBuffer shortBuffer = this.f10583l;
                s1.d.g(iVar.f10564m >= 0);
                int iMin = Math.min(shortBuffer.remaining() / i, iVar.f10564m);
                int i11 = iMin * i;
                shortBuffer.put(iVar.f10563l, 0, i11);
                int i12 = iVar.f10564m - iMin;
                iVar.f10564m = i12;
                short[] sArr = iVar.f10563l;
                System.arraycopy(sArr, i11, sArr, 0, i12 * i);
                this.f10586o += (long) i10;
                this.f10582k.limit(i10);
                this.f10584m = this.f10582k;
            }
        }
        ByteBuffer byteBuffer = this.f10584m;
        this.f10584m = g.f10547a;
        return byteBuffer;
    }

    @Override // q1.g
    public final void d() {
        i iVar = this.f10581j;
        if (iVar != null) {
            int i = iVar.f10562k;
            float f = iVar.f10556c;
            float f4 = iVar.f10557d;
            double d10 = f / f4;
            double d11 = iVar.f10558e * f4;
            int i10 = iVar.f10569r;
            int i11 = iVar.f10564m + ((int) ((((((((double) (i - i10)) / d10) + ((double) i10)) + iVar.f10574w) + ((double) iVar.f10566o)) / d11) + 0.5d));
            iVar.f10574w = 0.0d;
            short[] sArr = iVar.f10561j;
            int i12 = iVar.f10560h * 2;
            iVar.f10561j = iVar.c(sArr, i, i12 + i);
            int i13 = 0;
            while (true) {
                int i14 = iVar.f10555b;
                if (i13 >= i12 * i14) {
                    break;
                }
                iVar.f10561j[(i14 * i) + i13] = 0;
                i13++;
            }
            iVar.f10562k = i12 + iVar.f10562k;
            iVar.f();
            if (iVar.f10564m > i11) {
                iVar.f10564m = Math.max(i11, 0);
            }
            iVar.f10562k = 0;
            iVar.f10569r = 0;
            iVar.f10566o = 0;
        }
        this.f10587p = true;
    }

    @Override // q1.g
    public final void e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            i iVar = this.f10581j;
            iVar.getClass();
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f10585n += (long) iRemaining;
            int iRemaining2 = shortBufferAsShortBuffer.remaining();
            int i = iVar.f10555b;
            int i10 = iRemaining2 / i;
            short[] sArrC = iVar.c(iVar.f10561j, iVar.f10562k, i10);
            iVar.f10561j = sArrC;
            shortBufferAsShortBuffer.get(sArrC, iVar.f10562k * i, ((i10 * i) * 2) / 2);
            iVar.f10562k += i10;
            iVar.f();
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // q1.g
    public final e f(e eVar) throws f {
        if (eVar.f10545c != 2) {
            throw new f(eVar);
        }
        int i = this.f10575b;
        if (i == -1) {
            i = eVar.f10543a;
        }
        this.f10578e = eVar;
        e eVar2 = new e(i, eVar.f10544b, 2);
        this.f = eVar2;
        this.i = true;
        return eVar2;
    }

    @Override // q1.g
    public final void flush() {
        if (a()) {
            e eVar = this.f10578e;
            this.f10579g = eVar;
            e eVar2 = this.f;
            this.f10580h = eVar2;
            if (this.i) {
                this.f10581j = new i(eVar.f10543a, eVar.f10544b, this.f10576c, this.f10577d, eVar2.f10543a);
            } else {
                i iVar = this.f10581j;
                if (iVar != null) {
                    iVar.f10562k = 0;
                    iVar.f10564m = 0;
                    iVar.f10566o = 0;
                    iVar.f10567p = 0;
                    iVar.f10568q = 0;
                    iVar.f10569r = 0;
                    iVar.f10570s = 0;
                    iVar.f10571t = 0;
                    iVar.f10572u = 0;
                    iVar.f10573v = 0;
                    iVar.f10574w = 0.0d;
                }
            }
        }
        this.f10584m = g.f10547a;
        this.f10585n = 0L;
        this.f10586o = 0L;
        this.f10587p = false;
    }

    @Override // q1.g
    public final void reset() {
        this.f10576c = 1.0f;
        this.f10577d = 1.0f;
        e eVar = e.f10542e;
        this.f10578e = eVar;
        this.f = eVar;
        this.f10579g = eVar;
        this.f10580h = eVar;
        ByteBuffer byteBuffer = g.f10547a;
        this.f10582k = byteBuffer;
        this.f10583l = byteBuffer.asShortBuffer();
        this.f10584m = byteBuffer;
        this.f10575b = -1;
        this.i = false;
        this.f10581j = null;
        this.f10585n = 0L;
        this.f10586o = 0L;
        this.f10587p = false;
    }
}
