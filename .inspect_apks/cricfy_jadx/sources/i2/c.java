package i2;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.util.SparseArray;
import java.util.Objects;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f5977c = new c(ua.i0.o(b.f5972d));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final z0 f5978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ua.k0 f5979e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f5980a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5981b;

    static {
        Object[] objArr = {2, 5, 6};
        ua.q.b(3, objArr);
        f5978d = ua.i0.i(3, objArr);
        f3.a aVar = new f3.a(4);
        aVar.u(5, 6);
        aVar.u(17, 6);
        aVar.u(7, 6);
        aVar.u(30, 10);
        aVar.u(18, 6);
        aVar.u(6, 8);
        aVar.u(8, 8);
        aVar.u(14, 8);
        f5979e = aVar.c();
    }

    public c(z0 z0Var) {
        for (int i = 0; i < z0Var.f12415y; i++) {
            b bVar = (b) z0Var.get(i);
            this.f5980a.put(bVar.f5973a, bVar);
        }
        int iMax = 0;
        for (int i10 = 0; i10 < this.f5980a.size(); i10++) {
            iMax = Math.max(iMax, ((b) this.f5980a.valueAt(i10)).f5974b);
        }
        this.f5981b = iMax;
    }

    public static z0 a(int[] iArr, int i) {
        ua.f0 f0VarJ = ua.i0.j();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i10 : iArr) {
            f0VarJ.a(new b(i10, i));
        }
        return f0VarJ.g();
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0235  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static i2.c b(android.content.Context r16, android.content.Intent r17, v1.c r18, p6.d r19) {
        /*
            Method dump skipped, instruction units count: 653
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.c.b(android.content.Context, android.content.Intent, v1.c, p6.d):i2.c");
    }

    public static c c(Context context, v1.c cVar, p6.d dVar) {
        return b(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), cVar, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair d(v1.p r17, v1.c r18) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.c.d(v1.p, v1.c):android.util.Pair");
    }

    public final boolean equals(Object obj) {
        boolean zContentEquals;
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                SparseArray sparseArray = cVar.f5980a;
                int i = y1.a0.f14551a;
                SparseArray sparseArray2 = this.f5980a;
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
                if (!zContentEquals || this.f5981b != cVar.f5981b) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode;
        int i = y1.a0.f14551a;
        int i10 = Build.VERSION.SDK_INT;
        SparseArray sparseArray = this.f5980a;
        if (i10 >= 31) {
            iHashCode = sparseArray.contentHashCode();
        } else {
            iHashCode = 17;
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                iHashCode = Objects.hashCode(sparseArray.valueAt(i11)) + ((sparseArray.keyAt(i11) + (iHashCode * 31)) * 31);
            }
        }
        return (iHashCode * 31) + this.f5981b;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f5981b + ", audioProfiles=" + this.f5980a + "]";
    }
}
