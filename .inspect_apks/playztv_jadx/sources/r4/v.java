package r4;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v implements z4.d, z4.c {
    public static final TreeMap C = new TreeMap();
    public final int[] A;
    public int B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f11503u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile String f11504v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long[] f11505w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final double[] f11506x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String[] f11507y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final byte[][] f11508z;

    public v(int i) {
        this.f11503u = i;
        int i10 = i + 1;
        this.A = new int[i10];
        this.f11505w = new long[i10];
        this.f11506x = new double[i10];
        this.f11507y = new String[i10];
        this.f11508z = new byte[i10][];
    }

    public static final v a(String str, int i) {
        TreeMap treeMap = C;
        synchronized (treeMap) {
            Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
            if (entryCeilingEntry == null) {
                v vVar = new v(i);
                vVar.f11504v = str;
                vVar.B = i;
                return vVar;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            v vVar2 = (v) entryCeilingEntry.getValue();
            vVar2.f11504v = str;
            vVar2.B = i;
            return vVar2;
        }
    }

    @Override // z4.c
    public final void N(int i, long j5) {
        this.A[i] = 2;
        this.f11505w[i] = j5;
    }

    @Override // z4.c
    public final void U(int i, byte[] bArr) {
        this.A[i] = 5;
        this.f11508z[i] = bArr;
    }

    @Override // z4.c
    public final void V(String str, int i) {
        be.h.e(str, "value");
        this.A[i] = 4;
        this.f11507y[i] = str;
    }

    @Override // z4.c
    public final void b(int i) {
        this.A[i] = 1;
    }

    @Override // z4.d
    public final void d(z4.c cVar) {
        int i = this.B;
        if (1 > i) {
            return;
        }
        int i10 = 1;
        while (true) {
            int i11 = this.A[i10];
            if (i11 == 1) {
                cVar.b(i10);
            } else if (i11 == 2) {
                cVar.N(i10, this.f11505w[i10]);
            } else if (i11 == 3) {
                cVar.z(i10, this.f11506x[i10]);
            } else if (i11 == 4) {
                String str = this.f11507y[i10];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                cVar.V(str, i10);
            } else if (i11 == 5) {
                byte[] bArr = this.f11508z[i10];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                cVar.U(i10, bArr);
            }
            if (i10 == i) {
                return;
            } else {
                i10++;
            }
        }
    }

    @Override // z4.d
    public final String v() {
        String str = this.f11504v;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final void x() {
        TreeMap treeMap = C;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f11503u), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                be.h.d(it, "iterator(...)");
                while (true) {
                    int i = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i;
                }
            }
        }
    }

    @Override // z4.c
    public final void z(int i, double d10) {
        this.A[i] = 3;
        this.f11506x[i] = d10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
