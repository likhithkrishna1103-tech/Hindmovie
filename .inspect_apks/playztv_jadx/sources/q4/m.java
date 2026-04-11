package q4;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ThreadLocal f10872y = new ThreadLocal();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final c0.i f10873z = new c0.i(4);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f10875v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f10876w;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f10874u = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList f10877x = new ArrayList();

    public static x0 c(RecyclerView recyclerView, int i, long j5) {
        int iL = recyclerView.f1672z.l();
        for (int i10 = 0; i10 < iL; i10++) {
            x0 x0VarM = RecyclerView.M(recyclerView.f1672z.k(i10));
            if (x0VarM.f10964c == i && !x0VarM.f()) {
                return null;
            }
        }
        n0 n0Var = recyclerView.f1666w;
        if (j5 == Long.MAX_VALUE) {
            try {
                if (m0.k.a()) {
                    Trace.beginSection("RV Prefetch forced - needed next frame");
                }
            } catch (Throwable th) {
                recyclerView.U(false);
                Trace.endSection();
                throw th;
            }
        }
        recyclerView.T();
        x0 x0VarK = n0Var.k(i, j5);
        if (x0VarK != null) {
            if (!x0VarK.e() || x0VarK.f()) {
                n0Var.a(x0VarK, false);
            } else {
                n0Var.h(x0VarK.f10962a);
            }
        }
        recyclerView.U(false);
        Trace.endSection();
        return x0VarK;
    }

    public final void a(RecyclerView recyclerView, int i, int i10) {
        if (recyclerView.M) {
            if (RecyclerView.V0 && !this.f10874u.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.f10875v == 0) {
                this.f10875v = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        k kVar = recyclerView.f1673z0;
        kVar.f10860b = i;
        kVar.f10861c = i10;
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
        throw new UnsupportedOperationException("Method not decompiled: q4.m.b(long):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f10874u;
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
                    b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f10876w);
                }
            }
        } finally {
            this.f10875v = 0L;
            Trace.endSection();
        }
    }
}
