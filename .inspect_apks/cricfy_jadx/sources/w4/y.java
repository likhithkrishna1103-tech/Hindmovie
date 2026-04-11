package w4;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements d5.f, d5.e {
    public static final TreeMap D = new TreeMap();
    public final byte[][] A;
    public final int[] B;
    public int C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f14010v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile String f14011w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long[] f14012x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final double[] f14013y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String[] f14014z;

    public y(int i) {
        this.f14010v = i;
        int i10 = i + 1;
        this.B = new int[i10];
        this.f14012x = new long[i10];
        this.f14013y = new double[i10];
        this.f14014z = new String[i10];
        this.A = new byte[i10][];
    }

    public static final y g(int i, String str) {
        TreeMap treeMap = D;
        synchronized (treeMap) {
            Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
            if (entryCeilingEntry == null) {
                y yVar = new y(i);
                yVar.f14011w = str;
                yVar.C = i;
                return yVar;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            y yVar2 = (y) entryCeilingEntry.getValue();
            yVar2.f14011w = str;
            yVar2.C = i;
            return yVar2;
        }
    }

    @Override // d5.e
    public final void S(int i, byte[] bArr) {
        this.B[i] = 5;
        this.A[i] = bArr;
    }

    @Override // d5.f
    public final void a(d5.e eVar) {
        int i = this.C;
        if (1 > i) {
            return;
        }
        int i10 = 1;
        while (true) {
            int i11 = this.B[i10];
            if (i11 == 1) {
                eVar.b(i10);
            } else if (i11 == 2) {
                eVar.e(i10, this.f14012x[i10]);
            } else if (i11 == 3) {
                eVar.t(i10, this.f14013y[i10]);
            } else if (i11 == 4) {
                String str = this.f14014z[i10];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                eVar.n(i10, str);
            } else if (i11 == 5) {
                byte[] bArr = this.A[i10];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                eVar.S(i10, bArr);
            }
            if (i10 == i) {
                return;
            } else {
                i10++;
            }
        }
    }

    @Override // d5.e
    public final void b(int i) {
        this.B[i] = 1;
    }

    @Override // d5.e
    public final void e(int i, long j4) {
        this.B[i] = 2;
        this.f14012x[i] = j4;
    }

    @Override // d5.e
    public final void n(int i, String str) {
        ge.i.e(str, "value");
        this.B[i] = 4;
        this.f14014z[i] = str;
    }

    public final void q() {
        TreeMap treeMap = D;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f14010v), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                ge.i.d(it, "iterator(...)");
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

    @Override // d5.f
    public final String s() {
        String str = this.f14011w;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // d5.e
    public final void t(int i, double d10) {
        this.B[i] = 3;
        this.f14013y[i] = d10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
