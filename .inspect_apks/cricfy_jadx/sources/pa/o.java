package pa;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f10087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f10088d;

    public o() {
        this.f10087c = new long[10];
        this.f10088d = new Object[10];
    }

    public synchronized void a(long j4, Object obj) {
        if (this.f10086b > 0) {
            if (j4 <= ((long[]) this.f10087c)[((this.f10085a + r0) - 1) % ((Object[]) this.f10088d).length]) {
                b();
            }
        }
        c();
        int i = this.f10085a;
        int i10 = this.f10086b;
        Object[] objArr = (Object[]) this.f10088d;
        int length = (i + i10) % objArr.length;
        ((long[]) this.f10087c)[length] = j4;
        objArr[length] = obj;
        this.f10086b = i10 + 1;
    }

    public synchronized void b() {
        this.f10085a = 0;
        this.f10086b = 0;
        Arrays.fill((Object[]) this.f10088d, (Object) null);
    }

    public void c() {
        int length = ((Object[]) this.f10088d).length;
        if (this.f10086b < length) {
            return;
        }
        int i = length * 2;
        long[] jArr = new long[i];
        Object[] objArr = new Object[i];
        int i10 = this.f10085a;
        int i11 = length - i10;
        System.arraycopy((long[]) this.f10087c, i10, jArr, 0, i11);
        System.arraycopy((Object[]) this.f10088d, this.f10085a, objArr, 0, i11);
        int i12 = this.f10085a;
        if (i12 > 0) {
            System.arraycopy((long[]) this.f10087c, 0, jArr, i11, i12);
            System.arraycopy((Object[]) this.f10088d, 0, objArr, i11, this.f10085a);
        }
        this.f10087c = jArr;
        this.f10088d = objArr;
        this.f10085a = 0;
    }

    public Object d(boolean z10, long j4) {
        Object objG = null;
        long j7 = Long.MAX_VALUE;
        while (this.f10086b > 0) {
            long j10 = j4 - ((long[]) this.f10087c)[this.f10085a];
            if (j10 < 0 && (z10 || (-j10) >= j7)) {
                break;
            }
            objG = g();
            j7 = j10;
        }
        return objG;
    }

    public synchronized Object e() {
        return this.f10086b == 0 ? null : g();
    }

    public synchronized Object f(long j4) {
        return d(true, j4);
    }

    public Object g() {
        y1.d.g(this.f10086b > 0);
        Object[] objArr = (Object[]) this.f10088d;
        int i = this.f10085a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f10085a = (i + 1) % objArr.length;
        this.f10086b--;
        return obj;
    }

    public synchronized int h() {
        return this.f10086b;
    }

    public o(int i, float[] fArr, float[] fArr2, int i10) {
        this.f10085a = i;
        y1.d.b(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
        this.f10087c = fArr;
        this.f10088d = fArr2;
        this.f10086b = i10;
    }

    public o(o oVar) {
        float[] fArr = (float[]) oVar.f10087c;
        this.f10085a = fArr.length / 3;
        this.f10087c = y1.b.e(fArr);
        this.f10088d = y1.b.e((float[]) oVar.f10088d);
        int i = oVar.f10086b;
        if (i == 1) {
            this.f10086b = 5;
        } else if (i != 2) {
            this.f10086b = 4;
        } else {
            this.f10086b = 6;
        }
    }
}
