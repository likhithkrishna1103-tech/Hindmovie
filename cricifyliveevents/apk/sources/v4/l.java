package v4;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f13296w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f13297x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ThreadLocal f13294z = new ThreadLocal();
    public static final a5.f A = new a5.f(8);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f13295v = new ArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList f13298y = new ArrayList();

    public static x0 c(RecyclerView recyclerView, int i, long j4) {
        int iY = recyclerView.A.y();
        for (int i10 = 0; i10 < iY; i10++) {
            x0 x0VarM = RecyclerView.M(recyclerView.A.x(i10));
            if (x0VarM.f13389c == i && !x0VarM.f()) {
                return null;
            }
        }
        n0 n0Var = recyclerView.f1451x;
        if (j4 == Long.MAX_VALUE) {
            try {
                if (p0.k.a()) {
                    Trace.beginSection("RV Prefetch forced - needed next frame");
                }
            } catch (Throwable th) {
                recyclerView.U(false);
                Trace.endSection();
                throw th;
            }
        }
        recyclerView.T();
        x0 x0VarL = n0Var.l(i, j4);
        if (x0VarL != null) {
            if (!x0VarL.e() || x0VarL.f()) {
                n0Var.a(x0VarL, false);
            } else {
                n0Var.i(x0VarL.f13387a);
            }
        }
        recyclerView.U(false);
        Trace.endSection();
        return x0VarL;
    }

    public final void a(RecyclerView recyclerView, int i, int i10) {
        if (recyclerView.N) {
            if (RecyclerView.W0 && !this.f13295v.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.f13296w == 0) {
                this.f13296w = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        v.g gVar = recyclerView.A0;
        gVar.f12524a = i;
        gVar.f12525b = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r18) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.l.b(long):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f13295v;
        try {
            Trace.beginSection("RV Prefetch");
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f13297x);
                }
            }
        } finally {
            this.f13296w = 0L;
            Trace.endSection();
        }
    }
}
