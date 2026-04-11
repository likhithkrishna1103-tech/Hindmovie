package o2;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements e1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final aa.c1 f9172u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f9173v;

    public n(List list, List list2) {
        aa.g0 g0VarN = aa.j0.n();
        s1.d.b(list.size() == list2.size());
        for (int i = 0; i < list.size(); i++) {
            g0VarN.a(new m((e1) list.get(i), (List) list2.get(i)));
        }
        this.f9172u = g0VarN.g();
        this.f9173v = -9223372036854775807L;
    }

    @Override // o2.e1
    public final boolean c() {
        int i = 0;
        while (true) {
            aa.c1 c1Var = this.f9172u;
            if (i >= c1Var.f652x) {
                return false;
            }
            if (((m) c1Var.get(i)).f9161u.c()) {
                return true;
            }
            i++;
        }
    }

    @Override // o2.e1
    public final long g() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        while (true) {
            aa.c1 c1Var = this.f9172u;
            if (i >= c1Var.f652x) {
                break;
            }
            long jG = ((m) c1Var.get(i)).f9161u.g();
            if (jG != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jG);
            }
            i++;
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // o2.e1
    public final boolean l(a2.c1 c1Var) {
        boolean zL;
        boolean z2 = false;
        do {
            long jG = g();
            if (jG == Long.MIN_VALUE) {
                return z2;
            }
            int i = 0;
            zL = false;
            while (true) {
                aa.c1 c1Var2 = this.f9172u;
                if (i >= c1Var2.f652x) {
                    break;
                }
                long jG2 = ((m) c1Var2.get(i)).f9161u.g();
                boolean z10 = jG2 != Long.MIN_VALUE && jG2 <= c1Var.f178a;
                if (jG2 == jG || z10) {
                    zL |= ((m) c1Var2.get(i)).f9161u.l(c1Var);
                }
                i++;
            }
            z2 |= zL;
        } while (zL);
        return z2;
    }

    @Override // o2.e1
    public final long r() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        while (true) {
            aa.c1 c1Var = this.f9172u;
            if (i >= c1Var.f652x) {
                break;
            }
            m mVar = (m) c1Var.get(i);
            long jR = mVar.f9161u.r();
            aa.j0 j0Var = mVar.f9162v;
            if ((j0Var.contains(1) || j0Var.contains(2) || j0Var.contains(4)) && jR != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jR);
            }
            if (jR != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jR);
            }
            i++;
        }
        if (jMin != Long.MAX_VALUE) {
            this.f9173v = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j5 = this.f9173v;
        return j5 != -9223372036854775807L ? j5 : jMin2;
    }

    @Override // o2.e1
    public final void v(long j5) {
        int i = 0;
        while (true) {
            aa.c1 c1Var = this.f9172u;
            if (i >= c1Var.f652x) {
                return;
            }
            ((m) c1Var.get(i)).v(j5);
            i++;
        }
    }
}
