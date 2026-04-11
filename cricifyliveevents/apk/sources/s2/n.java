package s2;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements c1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ua.z0 f11277v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f11278w;

    public n(List list, List list2) {
        ua.f0 f0VarJ = ua.i0.j();
        y1.d.b(list.size() == list2.size());
        for (int i = 0; i < list.size(); i++) {
            f0VarJ.a(new m((c1) list.get(i), (List) list2.get(i)));
        }
        this.f11277v = f0VarJ.g();
        this.f11278w = -9223372036854775807L;
    }

    @Override // s2.c1
    public final boolean a() {
        int i = 0;
        while (true) {
            ua.z0 z0Var = this.f11277v;
            if (i >= z0Var.f12415y) {
                return false;
            }
            if (((m) z0Var.get(i)).f11265v.a()) {
                return true;
            }
            i++;
        }
    }

    @Override // s2.c1
    public final boolean i(g2.s0 s0Var) {
        boolean zI;
        boolean z10 = false;
        do {
            long j4 = j();
            if (j4 == Long.MIN_VALUE) {
                return z10;
            }
            int i = 0;
            zI = false;
            while (true) {
                ua.z0 z0Var = this.f11277v;
                if (i >= z0Var.f12415y) {
                    break;
                }
                long j7 = ((m) z0Var.get(i)).f11265v.j();
                boolean z11 = j7 != Long.MIN_VALUE && j7 <= s0Var.f4897a;
                if (j7 == j4 || z11) {
                    zI |= ((m) z0Var.get(i)).f11265v.i(s0Var);
                }
                i++;
            }
            z10 |= zI;
        } while (zI);
        return z10;
    }

    @Override // s2.c1
    public final long j() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        while (true) {
            ua.z0 z0Var = this.f11277v;
            if (i >= z0Var.f12415y) {
                break;
            }
            long j4 = ((m) z0Var.get(i)).f11265v.j();
            if (j4 != Long.MIN_VALUE) {
                jMin = Math.min(jMin, j4);
            }
            i++;
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // s2.c1
    public final long q() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        while (true) {
            ua.z0 z0Var = this.f11277v;
            if (i >= z0Var.f12415y) {
                break;
            }
            m mVar = (m) z0Var.get(i);
            long jQ = mVar.f11265v.q();
            ua.i0 i0Var = mVar.f11266w;
            if ((i0Var.contains(1) || i0Var.contains(2) || i0Var.contains(4)) && jQ != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jQ);
            }
            if (jQ != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jQ);
            }
            i++;
        }
        if (jMin != Long.MAX_VALUE) {
            this.f11278w = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j4 = this.f11278w;
        return j4 != -9223372036854775807L ? j4 : jMin2;
    }

    @Override // s2.c1
    public final void u(long j4) {
        int i = 0;
        while (true) {
            ua.z0 z0Var = this.f11277v;
            if (i >= z0Var.f12415y) {
                return;
            }
            ((m) z0Var.get(i)).u(j4);
            i++;
        }
    }
}
