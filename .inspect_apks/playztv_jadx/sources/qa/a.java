package qa;

import android.util.Log;
import i7.f;
import java.util.concurrent.atomic.AtomicReference;
import na.p;
import wa.k1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f11163c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f11164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f11165b = new AtomicReference(null);

    public a(p pVar) {
        this.f11164a = pVar;
        pVar.a(new nc.c(4, this));
    }

    public final c a(String str) {
        a aVar = (a) this.f11165b.get();
        return aVar == null ? f11163c : aVar.a(str);
    }

    public final boolean b() {
        a aVar = (a) this.f11165b.get();
        return aVar != null && aVar.b();
    }

    public final boolean c(String str) {
        a aVar = (a) this.f11165b.get();
        return aVar != null && aVar.c(str);
    }

    public final void d(String str, long j5, k1 k1Var) {
        String strM = l4.a.m("Deferring native open session: ", str);
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", strM, null);
        }
        this.f11164a.a(new f(str, j5, k1Var));
    }
}
