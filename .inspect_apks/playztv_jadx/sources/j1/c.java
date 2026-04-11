package j1;

import android.util.Log;
import androidx.fragment.app.n0;
import androidx.fragment.app.v;
import be.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6667a = b.f6666a;

    public static b a(v vVar) {
        while (vVar != null) {
            if (vVar.p()) {
                vVar.l();
            }
            vVar = vVar.P;
        }
        return f6667a;
    }

    public static void b(a aVar) {
        if (n0.G(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(aVar.f6665u.getClass().getName()), aVar);
        }
    }

    public static final void c(v vVar, String str) {
        h.e(vVar, "fragment");
        h.e(str, "previousFragmentId");
        b(new a(vVar, "Attempting to reuse fragment " + vVar + " with previous ID " + str));
        a(vVar).getClass();
    }
}
