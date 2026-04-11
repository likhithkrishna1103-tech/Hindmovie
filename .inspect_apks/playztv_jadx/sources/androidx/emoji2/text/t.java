package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t implements l {
    public ThreadPoolExecutor A;
    public cf.d B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f1198u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final n0.d f1199v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final lb.e f1200w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f1201x = new Object();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Handler f1202y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ThreadPoolExecutor f1203z;

    public t(Context context, n0.d dVar) {
        cf.l.j(context, "Context cannot be null");
        this.f1198u = context.getApplicationContext();
        this.f1199v = dVar;
        this.f1200w = u.f1204d;
    }

    @Override // androidx.emoji2.text.l
    public final void a(cf.d dVar) {
        synchronized (this.f1201x) {
            this.B = dVar;
        }
        c();
    }

    public final void b() {
        synchronized (this.f1201x) {
            try {
                this.B = null;
                Handler handler = this.f1202y;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f1202y = null;
                ThreadPoolExecutor threadPoolExecutor = this.A;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f1203z = null;
                this.A = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        synchronized (this.f1201x) {
            try {
                if (this.B == null) {
                    return;
                }
                if (this.f1203z == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat", 0));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.A = threadPoolExecutor;
                    this.f1203z = threadPoolExecutor;
                }
                this.f1203z.execute(new a2.a(4, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final n0.i d() {
        try {
            lb.e eVar = this.f1200w;
            Context context = this.f1198u;
            n0.d dVar = this.f1199v;
            eVar.getClass();
            Object[] objArr = {dVar};
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            d4.f fVarA = n0.c.a(context, Collections.unmodifiableList(arrayList));
            int i = fVarA.f3842a;
            if (i != 0) {
                throw new RuntimeException(e6.j.j(i, "fetchFonts failed (", ")"));
            }
            n0.i[] iVarArr = (n0.i[]) fVarA.f3843b.get(0);
            if (iVarArr == null || iVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return iVarArr[0];
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("provider not found", e10);
        }
    }
}
