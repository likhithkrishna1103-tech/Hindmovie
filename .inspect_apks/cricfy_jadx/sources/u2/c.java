package u2;

import java.util.ArrayList;
import nc.l;
import ua.f0;
import ua.g0;
import ua.i0;
import ua.p;
import ua.w0;
import ua.z;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final z f12068w = new z(new p(new l(25), w0.f12403w), new p(new l(26), w0.f12404x));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f12069v = new ArrayList();

    @Override // u2.a
    public final i0 a(long j4) {
        ArrayList arrayList = this.f12069v;
        if (!arrayList.isEmpty()) {
            if (j4 >= ((x3.c) arrayList.get(0)).f14293b) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < arrayList.size(); i++) {
                    x3.c cVar = (x3.c) arrayList.get(i);
                    if (j4 >= cVar.f14293b && j4 < cVar.f14295d) {
                        arrayList2.add(cVar);
                    }
                    if (j4 < cVar.f14293b) {
                        break;
                    }
                }
                z0 z0VarR = i0.r(f12068w, arrayList2);
                f0 f0VarJ = i0.j();
                for (int i10 = 0; i10 < z0VarR.f12415y; i10++) {
                    f0VarJ.d(((x3.c) z0VarR.get(i10)).f14292a);
                }
                return f0VarJ.g();
            }
        }
        g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    @Override // u2.a
    public final long b(long j4) {
        int i = 0;
        long jMin = -9223372036854775807L;
        while (true) {
            ArrayList arrayList = this.f12069v;
            if (i >= arrayList.size()) {
                break;
            }
            long j7 = ((x3.c) arrayList.get(i)).f14293b;
            long j10 = ((x3.c) arrayList.get(i)).f14295d;
            if (j4 < j7) {
                jMin = jMin == -9223372036854775807L ? j7 : Math.min(jMin, j7);
            } else {
                if (j4 < j10) {
                    jMin = jMin == -9223372036854775807L ? j10 : Math.min(jMin, j10);
                }
                i++;
            }
        }
        if (jMin != -9223372036854775807L) {
            return jMin;
        }
        return Long.MIN_VALUE;
    }

    @Override // u2.a
    public final long c(long j4) {
        ArrayList arrayList = this.f12069v;
        if (arrayList.isEmpty()) {
            return -9223372036854775807L;
        }
        if (j4 < ((x3.c) arrayList.get(0)).f14293b) {
            return -9223372036854775807L;
        }
        long jMax = ((x3.c) arrayList.get(0)).f14293b;
        for (int i = 0; i < arrayList.size(); i++) {
            long j7 = ((x3.c) arrayList.get(i)).f14293b;
            long j10 = ((x3.c) arrayList.get(i)).f14295d;
            if (j10 > j4) {
                if (j7 > j4) {
                    break;
                }
                jMax = Math.max(jMax, j7);
            } else {
                jMax = Math.max(jMax, j10);
            }
        }
        return jMax;
    }

    @Override // u2.a
    public final void clear() {
        this.f12069v.clear();
    }

    @Override // u2.a
    public final boolean d(x3.c cVar, long j4) {
        long j7 = cVar.f14293b;
        y1.d.b(j7 != -9223372036854775807L);
        y1.d.b(cVar.f14294c != -9223372036854775807L);
        boolean z10 = j7 <= j4 && j4 < cVar.f14295d;
        ArrayList arrayList = this.f12069v;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (j7 >= ((x3.c) arrayList.get(size)).f14293b) {
                arrayList.add(size + 1, cVar);
                return z10;
            }
        }
        arrayList.add(0, cVar);
        return z10;
    }

    @Override // u2.a
    public final void e(long j4) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f12069v;
            if (i >= arrayList.size()) {
                return;
            }
            long j7 = ((x3.c) arrayList.get(i)).f14293b;
            if (j4 > j7 && j4 > ((x3.c) arrayList.get(i)).f14295d) {
                arrayList.remove(i);
                i--;
            } else if (j4 < j7) {
                return;
            }
            i++;
        }
    }
}
