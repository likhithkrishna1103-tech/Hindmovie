package q3;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f10609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f10610d;

    public d() {
        this.f10609c = new long[10];
        this.f10610d = new Object[10];
    }

    public synchronized void a(long j5, Object obj) {
        if (this.f10608b > 0) {
            if (j5 <= ((long[]) this.f10609c)[((this.f10607a + r0) - 1) % ((Object[]) this.f10610d).length]) {
                b();
            }
        }
        c();
        int i = this.f10607a;
        int i10 = this.f10608b;
        Object[] objArr = (Object[]) this.f10610d;
        int length = (i + i10) % objArr.length;
        ((long[]) this.f10609c)[length] = j5;
        objArr[length] = obj;
        this.f10608b = i10 + 1;
    }

    public synchronized void b() {
        this.f10607a = 0;
        this.f10608b = 0;
        Arrays.fill((Object[]) this.f10610d, (Object) null);
    }

    public void c() {
        int length = ((Object[]) this.f10610d).length;
        if (this.f10608b < length) {
            return;
        }
        int i = length * 2;
        long[] jArr = new long[i];
        Object[] objArr = new Object[i];
        int i10 = this.f10607a;
        int i11 = length - i10;
        System.arraycopy((long[]) this.f10609c, i10, jArr, 0, i11);
        System.arraycopy((Object[]) this.f10610d, this.f10607a, objArr, 0, i11);
        int i12 = this.f10607a;
        if (i12 > 0) {
            System.arraycopy((long[]) this.f10609c, 0, jArr, i11, i12);
            System.arraycopy((Object[]) this.f10610d, 0, objArr, i11, this.f10607a);
        }
        this.f10609c = jArr;
        this.f10610d = objArr;
        this.f10607a = 0;
    }

    public Object d(boolean z2, long j5) {
        Object objG = null;
        long j8 = Long.MAX_VALUE;
        while (this.f10608b > 0) {
            long j10 = j5 - ((long[]) this.f10609c)[this.f10607a];
            if (j10 < 0 && (z2 || (-j10) >= j8)) {
                break;
            }
            objG = g();
            j8 = j10;
        }
        return objG;
    }

    public synchronized Object e() {
        return this.f10608b == 0 ? null : g();
    }

    public synchronized Object f(long j5) {
        return d(true, j5);
    }

    public Object g() {
        s1.d.g(this.f10608b > 0);
        Object[] objArr = (Object[]) this.f10610d;
        int i = this.f10607a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f10607a = (i + 1) % objArr.length;
        this.f10608b--;
        return obj;
    }

    public synchronized int h() {
        return this.f10608b;
    }

    public d(int i, float[] fArr, float[] fArr2, int i10) {
        this.f10607a = i;
        s1.d.b(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
        this.f10609c = fArr;
        this.f10610d = fArr2;
        this.f10608b = i10;
    }

    public d(d dVar) {
        float[] fArr = (float[]) dVar.f10609c;
        this.f10607a = fArr.length / 3;
        this.f10609c = s1.b.e(fArr);
        this.f10610d = s1.b.e((float[]) dVar.f10610d);
        int i = dVar.f10608b;
        if (i == 1) {
            this.f10608b = 5;
        } else if (i != 2) {
            this.f10608b = 4;
        } else {
            this.f10608b = 6;
        }
    }
}
