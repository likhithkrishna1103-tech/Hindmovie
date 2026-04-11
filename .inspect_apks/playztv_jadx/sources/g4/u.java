package g4;

import android.os.Bundle;
import com.playz.tv.activities.PlayerActivity;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f5226b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f5227c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f5228a;

    public u(PlayerActivity playerActivity, String str, a2.o0 o0Var, aa.j0 j0Var, aa.j0 j0Var2, aa.j0 j0Var3, q9.e eVar, Bundle bundle, Bundle bundle2, h4.z zVar) {
        synchronized (f5226b) {
            HashMap map = f5227c;
            if (map.containsKey(str)) {
                throw new IllegalStateException("Session ID must be unique. ID=".concat(str));
            }
            map.put(str, this);
        }
        this.f5228a = new b0(this, playerActivity, str, o0Var, j0Var, j0Var2, j0Var3, eVar, bundle, bundle2, zVar);
    }

    public final void a() {
        try {
            synchronized (f5226b) {
                f5227c.remove(this.f5228a.i);
            }
            this.f5228a.r();
        } catch (Exception unused) {
        }
    }
}
