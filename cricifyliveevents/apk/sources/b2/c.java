package b2;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f1676v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f1677w = new ArrayList(1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1678x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public o f1679y;

    public c(boolean z10) {
        this.f1676v = z10;
    }

    public final void b(int i) {
        o oVar = this.f1679y;
        int i10 = y1.a0.f14551a;
        for (int i11 = 0; i11 < this.f1678x; i11++) {
            h0 h0Var = (h0) this.f1677w.get(i11);
            boolean z10 = this.f1676v;
            w2.g gVar = (w2.g) h0Var;
            synchronized (gVar) {
                z0 z0Var = w2.g.f13851p;
                if (z10 && (oVar.i & 8) != 8) {
                    gVar.i += (long) i;
                }
            }
        }
    }

    public final void c() {
        o oVar = this.f1679y;
        int i = y1.a0.f14551a;
        for (int i10 = 0; i10 < this.f1678x; i10++) {
            h0 h0Var = (h0) this.f1677w.get(i10);
            boolean z10 = this.f1676v;
            w2.g gVar = (w2.g) h0Var;
            synchronized (gVar) {
                try {
                    z0 z0Var = w2.g.f13851p;
                    if (z10 && (oVar.i & 8) != 8) {
                        y1.d.g(gVar.f13863g > 0);
                        gVar.f13861d.getClass();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        int i11 = (int) (jElapsedRealtime - gVar.f13864h);
                        gVar.f13865j += (long) i11;
                        long j4 = gVar.f13866k;
                        long j7 = gVar.i;
                        gVar.f13866k = j4 + j7;
                        if (i11 > 0) {
                            gVar.f.a((int) Math.sqrt(j7), (j7 * 8000.0f) / i11);
                            if (gVar.f13865j >= 2000 || gVar.f13866k >= 524288) {
                                gVar.f13867l = (long) gVar.f.b();
                            }
                            gVar.b(i11, gVar.i, gVar.f13867l);
                            gVar.f13864h = jElapsedRealtime;
                            gVar.i = 0L;
                        }
                        gVar.f13863g--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.f1679y = null;
    }

    @Override // b2.h
    public final void d(h0 h0Var) {
        h0Var.getClass();
        ArrayList arrayList = this.f1677w;
        if (arrayList.contains(h0Var)) {
            return;
        }
        arrayList.add(h0Var);
        this.f1678x++;
    }

    public final void e() {
        for (int i = 0; i < this.f1678x; i++) {
            ((h0) this.f1677w.get(i)).getClass();
        }
    }

    public final void f(o oVar) {
        this.f1679y = oVar;
        for (int i = 0; i < this.f1678x; i++) {
            h0 h0Var = (h0) this.f1677w.get(i);
            boolean z10 = this.f1676v;
            w2.g gVar = (w2.g) h0Var;
            synchronized (gVar) {
                try {
                    z0 z0Var = w2.g.f13851p;
                    if (z10 && (oVar.i & 8) != 8) {
                        if (gVar.f13863g == 0) {
                            gVar.f13861d.getClass();
                            gVar.f13864h = SystemClock.elapsedRealtime();
                        }
                        gVar.f13863g++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // b2.h
    public Map j() {
        return Collections.EMPTY_MAP;
    }
}
