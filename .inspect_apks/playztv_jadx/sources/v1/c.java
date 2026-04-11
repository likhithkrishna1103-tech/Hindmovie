package v1;

import aa.c1;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f13122u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f13123v = new ArrayList(1);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13124w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public m f13125x;

    public c(boolean z2) {
        this.f13122u = z2;
    }

    public final void b(int i) {
        m mVar = this.f13125x;
        int i10 = s1.b0.f11647a;
        for (int i11 = 0; i11 < this.f13124w; i11++) {
            e0 e0Var = (e0) this.f13123v.get(i11);
            boolean z2 = this.f13122u;
            s2.g gVar = (s2.g) e0Var;
            synchronized (gVar) {
                c1 c1Var = s2.g.f11738p;
                if (z2 && (mVar.i & 8) != 8) {
                    gVar.i += (long) i;
                }
            }
        }
    }

    public final void c() {
        m mVar = this.f13125x;
        int i = s1.b0.f11647a;
        for (int i10 = 0; i10 < this.f13124w; i10++) {
            e0 e0Var = (e0) this.f13123v.get(i10);
            boolean z2 = this.f13122u;
            s2.g gVar = (s2.g) e0Var;
            synchronized (gVar) {
                try {
                    c1 c1Var = s2.g.f11738p;
                    if (z2 && (mVar.i & 8) != 8) {
                        s1.d.g(gVar.f11750g > 0);
                        gVar.f11748d.getClass();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        int i11 = (int) (jElapsedRealtime - gVar.f11751h);
                        gVar.f11752j += (long) i11;
                        long j5 = gVar.f11753k;
                        long j8 = gVar.i;
                        gVar.f11753k = j5 + j8;
                        if (i11 > 0) {
                            gVar.f.a((int) Math.sqrt(j8), (j8 * 8000.0f) / i11);
                            if (gVar.f11752j >= 2000 || gVar.f11753k >= 524288) {
                                gVar.f11754l = (long) gVar.f.b();
                            }
                            gVar.b(i11, gVar.i, gVar.f11754l);
                            gVar.f11751h = jElapsedRealtime;
                            gVar.i = 0L;
                        }
                        gVar.f11750g--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.f13125x = null;
    }

    public final void d() {
        for (int i = 0; i < this.f13124w; i++) {
            ((e0) this.f13123v.get(i)).getClass();
        }
    }

    public final void e(m mVar) {
        this.f13125x = mVar;
        for (int i = 0; i < this.f13124w; i++) {
            e0 e0Var = (e0) this.f13123v.get(i);
            boolean z2 = this.f13122u;
            s2.g gVar = (s2.g) e0Var;
            synchronized (gVar) {
                try {
                    c1 c1Var = s2.g.f11738p;
                    if (z2 && (mVar.i & 8) != 8) {
                        if (gVar.f11750g == 0) {
                            gVar.f11748d.getClass();
                            gVar.f11751h = SystemClock.elapsedRealtime();
                        }
                        gVar.f11750g++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // v1.h
    public final void g(e0 e0Var) {
        e0Var.getClass();
        ArrayList arrayList = this.f13123v;
        if (arrayList.contains(e0Var)) {
            return;
        }
        arrayList.add(e0Var);
        this.f13124w++;
    }

    @Override // v1.h
    public Map k() {
        return Collections.EMPTY_MAP;
    }
}
