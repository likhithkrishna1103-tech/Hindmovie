package p1;

import android.util.Log;
import androidx.fragment.app.r0;
import androidx.fragment.app.y;
import ge.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9883a = b.f9882a;

    public static b a(y yVar) {
        while (yVar != null) {
            if (yVar.p()) {
                yVar.l();
            }
            yVar = yVar.Q;
        }
        return f9883a;
    }

    public static void b(a aVar) {
        if (r0.J(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(aVar.f9881v.getClass().getName()), aVar);
        }
    }

    public static final void c(y yVar, String str) {
        i.e(yVar, "fragment");
        i.e(str, "previousFragmentId");
        b(new a(yVar, "Attempting to reuse fragment " + yVar + " with previous ID " + str));
        a(yVar).getClass();
    }
}
