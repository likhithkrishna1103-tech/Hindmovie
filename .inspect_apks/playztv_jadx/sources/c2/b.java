package c2;

import aa.c1;
import aa.l0;
import aa.m0;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.util.SparseArray;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f2243c = new b(aa.j0.v(a.f2238d));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c1 f2244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m0 f2245e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f2246a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2247b;

    static {
        Object[] objArr = {2, 5, 6};
        aa.q.b(3, objArr);
        f2244d = aa.j0.l(3, objArr);
        l0 l0Var = new l0(4);
        l0Var.v(5, 6);
        l0Var.v(17, 6);
        l0Var.v(7, 6);
        l0Var.v(30, 10);
        l0Var.v(18, 6);
        l0Var.v(6, 8);
        l0Var.v(8, 8);
        l0Var.v(14, 8);
        f2245e = l0Var.d();
    }

    public b(c1 c1Var) {
        for (int i = 0; i < c1Var.f652x; i++) {
            a aVar = (a) c1Var.get(i);
            this.f2246a.put(aVar.f2239a, aVar);
        }
        int iMax = 0;
        for (int i10 = 0; i10 < this.f2246a.size(); i10++) {
            iMax = Math.max(iMax, ((a) this.f2246a.valueAt(i10)).f2240b);
        }
        this.f2247b = iMax;
    }

    public static c1 a(int[] iArr, int i) {
        aa.g0 g0VarN = aa.j0.n();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i10 : iArr) {
            g0VarN.a(new a(i10, i));
        }
        return g0VarN.g();
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0234  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static c2.b b(android.content.Context r16, android.content.Intent r17, p1.d r18, wb.c r19) {
        /*
            Method dump skipped, instruction units count: 654
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.b.b(android.content.Context, android.content.Intent, p1.d, wb.c):c2.b");
    }

    public static b c(Context context, p1.d dVar, wb.c cVar) {
        return b(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), dVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair d(p1.q r17, p1.d r18) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.b.d(p1.q, p1.d):android.util.Pair");
    }

    public final boolean equals(Object obj) {
        boolean zContentEquals;
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                SparseArray sparseArray = bVar.f2246a;
                int i = s1.b0.f11647a;
                SparseArray sparseArray2 = this.f2246a;
                if (sparseArray2 != null) {
                    if (sparseArray != null) {
                        if (Build.VERSION.SDK_INT >= 31) {
                            zContentEquals = sparseArray2.contentEquals(sparseArray);
                        } else {
                            int size = sparseArray2.size();
                            if (size == sparseArray.size()) {
                                for (int i10 = 0; i10 < size; i10++) {
                                    if (Objects.equals(sparseArray2.valueAt(i10), sparseArray.get(sparseArray2.keyAt(i10)))) {
                                    }
                                }
                                zContentEquals = true;
                            }
                        }
                    }
                    zContentEquals = false;
                    break;
                } else {
                    if (sparseArray != null) {
                        zContentEquals = false;
                        break;
                    }
                    zContentEquals = true;
                }
                if (!zContentEquals || this.f2247b != bVar.f2247b) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode;
        int i = s1.b0.f11647a;
        int i10 = Build.VERSION.SDK_INT;
        SparseArray sparseArray = this.f2246a;
        if (i10 >= 31) {
            iHashCode = sparseArray.contentHashCode();
        } else {
            iHashCode = 17;
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                iHashCode = Objects.hashCode(sparseArray.valueAt(i11)) + ((sparseArray.keyAt(i11) + (iHashCode * 31)) * 31);
            }
        }
        return (iHashCode * 31) + this.f2247b;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f2247b + ", audioProfiles=" + this.f2246a + "]";
    }
}
