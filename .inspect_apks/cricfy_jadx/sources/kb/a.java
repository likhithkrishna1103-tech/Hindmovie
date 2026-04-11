package kb;

import android.util.Log;
import androidx.fragment.app.f1;
import d8.i;
import hb.p;
import java.util.concurrent.atomic.AtomicReference;
import qb.k1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f7392c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f7393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f7394b = new AtomicReference(null);

    public a(p pVar) {
        this.f7393a = pVar;
        pVar.a(new f1(29, this));
    }

    public final c a(String str) {
        a aVar = (a) this.f7394b.get();
        return aVar == null ? f7392c : aVar.a(str);
    }

    public final boolean b() {
        a aVar = (a) this.f7394b.get();
        return aVar != null && aVar.b();
    }

    public final boolean c(String str) {
        a aVar = (a) this.f7394b.get();
        return aVar != null && aVar.c(str);
    }

    public final void d(String str, long j4, k1 k1Var) {
        String strN = q4.a.n("Deferring native open session: ", str);
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", strN, null);
        }
        this.f7393a.a(new i(str, j4, k1Var));
    }
}
